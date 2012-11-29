package com.ambarishkarole;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {

	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i; // declare an intent and set it for our camera app
	final static int cameraData = 0;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//fullScreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.photo);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.click_a_pic);
		bmp = BitmapFactory.decodeStream(is);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById(R.id.ivReturnedPic);
		ib = (ImageButton) findViewById(R.id.ibTakePic);
		b = (Button) findViewById(R.id.bSetWall);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSetWall:
			// set the wall paper of the phone to this captured image
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.ibTakePic:
			// open an intent and set it for our camera app
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);// camera data is put into the
													// int variable cameraData

			break;

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}

}
