package com.ambarishkarole;

import android.app.Activity;
import android.os.Bundle;

public class TouchPaper extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.paper1);
		TouchImageView img = (TouchImageView) findViewById(R.id.paper1);
		img.setImageResource(R.drawable.paper1);
		img.setMaxZoom(4f);
	}
}