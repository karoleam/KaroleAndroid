package com.ambarishkarole;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements View.OnClickListener {

	EditText sendET;
	Button start, startFor;
	TextView gotAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//fullScreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.get);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		sendET = (EditText) findViewById(R.id.etSend);
		start = (Button) findViewById(R.id.bSA);
		startFor = (Button) findViewById(R.id.bSAFR);
		gotAnswer = (TextView) findViewById(R.id.tvGot);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSA:
			String bread = sendET.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);
			Intent a = new Intent(Data.this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		case R.id.bSAFR:
			Intent i = new Intent(Data.this, OpenedClass.class);
			
			startActivityForResult(i, 0);
			break;

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle basket = data.getExtras();
			String s = basket.getString("answer");
			gotAnswer.setText(s);

		}
	}

}
