package com.ambarishkarole;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

public class DerezzedDiamonds extends Activity {

	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle AmbarishLoveMango) {
		// TODO Auto-generated method stub
		super.onCreate(AmbarishLoveMango);
		//fullScreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// setContentView(R.layout.splash);
		GifWebView view = new GifWebView(this,"file:///android_asset/brokenDiamonds.gif");
//		GifWebView view = new GifWebView(this,"http://www.skillnetinc.com/");
		
		
		setContentView(view);

		ourSong = MediaPlayer.create(DerezzedDiamonds.this, R.raw.derezzed);

		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean musicCheck = getPrefs.getBoolean("checkbox", true);
		if (musicCheck == true) {
			ourSong.start();
		}

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(500000);// 5 seconds 5000
					// ourSong.release();

				} catch (InterruptedException e) {
					e.printStackTrace();

				} finally {
					Intent openStartingPoint = new Intent(
							"com.ambarishkarole.MENU");// action name in
														// AndroidManifest.xml
					startActivity(openStartingPoint);

				}
			}
		};
		timer.start();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
		ourSong.release();
	}

}
