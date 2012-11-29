package com.ambarishkarole;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {
	MyBringBackSurface ourSurfaceView;
	float x, y, sX, sY, fX, fY;
	Bitmap test,plus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //fullScreen
		ourSurfaceView = new MyBringBackSurface(this);
		ourSurfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		 test = BitmapFactory.decodeResource(getResources(),R.drawable.red);
//		 test = BitmapFactory.decodeResource(getResources(),R.drawable.plus);

		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY(); 
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
		sX=event.getX();
		sY=event.getY();
		break;
		case MotionEvent.ACTION_UP:
		fX=event.getX();
		fY=event.getY();
		break;
		}
		return true;
	}

	public class MyBringBackSurface extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;

		public MyBringBackSurface(Context context) {
			super(context);
			ourHolder = getHolder();
			ourThread = new Thread(this);
			ourThread.start();
		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		public void run() {
			while (isRunning) {
				if (!ourHolder.getSurface().isValid())
					continue;

				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawRGB(1, 0, 0);
				
				if (x != 0 && y != 0) {

					canvas.drawBitmap(test, x - (test.getWidth() / 2), y
							- (test.getHeight() / 2), null);

				}
				ourHolder.unlockCanvasAndPost(canvas);

			}
		}

	}

}
