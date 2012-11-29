package com.ambarishkarole;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
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

public class Speaker extends Activity {
	MediaPlayer pastrySong;

	@Override
	protected void onCreate(Bundle AmbarishLoveMango) {
		// TODO Auto-generated method stub
		super.onCreate(AmbarishLoveMango);
		// fullScreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.speakers);

		pastrySong = MediaPlayer.create(Speaker.this, R.raw.andante);

		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean musicCheck = getPrefs.getBoolean("checkbox", true);
		if (musicCheck == true) {
			pastrySong.start();
		}

		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter
				.getDefaultAdapter();
		if (mBluetoothAdapter == null) {
			// Device does not support Bluetooth
		} else {

		}

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);// 5 seconds 5000
					// ourSong.release();

				} catch (InterruptedException e) {
					e.printStackTrace();

				}
				// finally {
				// Intent openStartingPoint = new Intent(
				// "com.ambarishkarole.MENU");// action name in
				// // AndroidManifest.xml
				// startActivity(openStartingPoint);
				//
				// }
			}
		};
		timer.start();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
		pastrySong.release();
	}

}
