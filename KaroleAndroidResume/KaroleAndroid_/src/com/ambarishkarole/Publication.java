package com.ambarishkarole;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Publication extends Activity {
	Button paper1,paper2;



	@Override
	protected void onCreate(Bundle AmbarishLoveMango) {
		super.onCreate(AmbarishLoveMango);
		initializeVars();	
		setContentView(R.layout.publications);

	}
	
	private void initializeVars() {

		
		paper1 = (Button) findViewById(R.id.bpaper1);
		paper2 = (Button) findViewById(R.id.bpaper2);
//		paper1.getBackground().setAlpha(45);
//		paper2.getBackground().setAlpha(45);
//		paper1.getBackground().setColorFilter(0xff343434, PorterDuff.Mode.MULTIPLY);// color button		
//		paper2.getBackground().setColorFilter(0xffcdcdcd, PorterDuff.Mode.MULTIPLY);// color button					
		
		
	}


	public void gotoPaper1(View view){

		Intent p1 = new Intent("com.ambarishkarole.TOUCHPAPER");// action name in AndroidManifest.xml
		startActivity(p1);

	}
	
	public void gotoPaper2(View view){

		Intent p2 = new Intent("com.ambarishkarole.TOUCHPAPER2");// action name in AndroidManifest.xml
		startActivity(p2);
//	    ourSong.release();
	}


 
}