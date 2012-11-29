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



public class ImageMenu extends Activity {
	MediaPlayer ourSong;



	@Override
	protected void onCreate(Bundle AmbarishLoveMango) {
		super.onCreate(AmbarishLoveMango);
		initializeVars();	
		setContentView(R.layout.image_menu);

	}
	
	private void initializeVars() {
		requestWindowFeature(Window.FEATURE_NO_TITLE); //fullScreen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		ourSong = MediaPlayer.create(ImageMenu.this, R.raw.andante);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean musicCheck = getPrefs.getBoolean("checkbox", true);
		if (musicCheck == true) {
			ourSong.start();
		}
			
		
		
	}


	public void gotoMenu(View view){
//	    setContentView(R.layout.main);
		Intent mainMenu = new Intent("com.ambarishkarole.MENU");// action name in AndroidManifest.xml
		startActivity(mainMenu);
	    ourSong.release();
	}
	
	public void gotoEmail(View view){
//	    setContentView(R.layout.main);
		Intent email = new Intent("com.ambarishkarole.EMAIL");// action name in AndroidManifest.xml
		startActivity(email);
	    ourSong.release();
	}
	
	public void gotoPublication(View view){
//	    setContentView(R.layout.main);
		Intent pub = new Intent("com.ambarishkarole.PUBLICATIONS");// action name in AndroidManifest.xml
		startActivity(pub);
	    ourSong.release();
	}
	
	public void gotoBio(View view){

		Intent bio = new Intent("com.ambarishkarole.BIO");// action name in AndroidManifest.xml
		startActivity(bio);
		ourSong.release();

	}	


 
}
	

