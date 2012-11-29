package com.ambarishkarole;

import android.app.Activity;
import android.os.Bundle;

public class TouchPaper2 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.paper2);
		TouchImageView img = (TouchImageView) findViewById(R.id.paper2);
		img.setImageResource(R.drawable.paper2);
		img.setMaxZoom(4f);
	}
}