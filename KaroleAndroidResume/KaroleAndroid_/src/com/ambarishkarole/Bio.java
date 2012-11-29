package com.ambarishkarole;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Bio extends Activity {



	@Override
	protected void onCreate(Bundle AmbarishLoveMango) {
		super.onCreate(AmbarishLoveMango);
		initializeVars();	
		setContentView(R.layout.bio);

	}
	
	private void initializeVars() {

			
		
		
	}


	public void gotoNYU(View view){
		GifWebView siteView = new GifWebView(this,"http://www.poly.edu/");
		setContentView(view);
		
		
		
		
//	    setContentView(R.layout.main);
//		Intent mainMenu = new Intent("com.ambarishkarole.MENU");// action name in AndroidManifest.xml
//		startActivity(mainMenu);
//	    ourSong.release();
	}



 
}
	

