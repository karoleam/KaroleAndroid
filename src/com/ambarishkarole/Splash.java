package com.ambarishkarole;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Splash extends Activity {

	MediaPlayer ourSong;
	Button next;

	@Override
	protected void onCreate(Bundle AmbarishLoveMango) {
		super.onCreate(AmbarishLoveMango);
		initializeVars();	
		setContentView(R.layout.splash);

	}
	
	private void initializeVars() {
		requestWindowFeature(Window.FEATURE_NO_TITLE); //fullScreen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.andante);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean musicCheck = getPrefs.getBoolean("checkbox", true);
		if (musicCheck == true) {
			ourSong.start();
		}		
		
	}

//	@Override
//	protected void onPause() {
//		// TODO Auto-generated method stub
//		super.onPause();
//		finish();
//		ourSong.release();
//	}
	public void changelayout(View view){
//	    setContentView(R.layout.main);
		Intent openStartingPoint = new Intent("com.ambarishkarole.IMAGEMENU");// action name in AndroidManifest.xml
		startActivity(openStartingPoint);
	    ourSong.release();
	}


 
}
	
