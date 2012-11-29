package com.ambarishkarole;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String[] classes = { "DerezzedDiamonds","TickleGorilla", "Camera","GFXSurface","SQLiteExample" };// same
																					// name
																					// as
																					// other
																					// classes


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//fullScreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));//

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {// this
																				// is
																				// taken
																				// from
																				// the
																				// input
																				// which
																				// is
																				// given
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		try {
			Class ourClass = Class.forName("com.ambarishkarole." + cheese); // real
																			// path
																			// of
																			// class
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
//		menu.add(0, MENU_QUIT, 0, "Quit").setIcon(R.drawable.pastry);
//		menu.add("test").setIcon(R.drawable.pastry);s
		super.onCreateOptionsMenu(menu);
		
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.layout.cool_menu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUS:
			Intent i = new Intent("com.ambarishkarole.ABOUT");
			startActivity(i);

			break;
		case R.id.preferences:
			Intent p = new Intent("com.ambarishkarole.PREFS");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;
		
		}
		return false;
	}

}
