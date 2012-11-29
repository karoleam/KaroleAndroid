package com.ambarishkarole;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TickleGorilla extends Activity {
	/** Called when the activity is first created. */
	int counter = 0;
	Button add, sub;
	TextView display;
	MediaPlayer dohSong;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.main);// resource folder (res) > Layout folder > main
		counter = 0;
		add = (Button) findViewById(R.id.bAdd); // button

		display = (TextView) findViewById(R.id.tvDisplay); // the text

		add.setOnClickListener(new View.OnClickListener() {
			
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dohSong = MediaPlayer.create(TickleGorilla.this, R.raw.doh);
				SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				boolean musicCheck = getPrefs.getBoolean("checkbox", true);
				if (musicCheck == true) {
					dohSong.start();
				}	
				counter++;
				Random crazy = new Random();
				display.setTextColor(Color.rgb(crazy.nextInt(265),
						crazy.nextInt(265), crazy.nextInt(265)));

				display.setText("D'oh! and tickle count = " + counter);
				
				
				Thread timer = new Thread() {
					@Override
					public void run() {
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} finally {
							dohSong.release();
						}
					}
				};
				timer.start();
					
				
				
				
			}
		});



	}
}