package com.ambarishkarole;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.PorterDuff;

public class Email extends Activity implements View.OnClickListener {
	EditText personsEmail, intro, subject;
	String emailAdd="karoleam@gmail.com", beginning, name, subjectString;

	Button sendEmail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
		sendEmail.getBackground().setColorFilter(0xff800000, PorterDuff.Mode.MULTIPLY);// red color button

	}
	private void initializeVars() {

//		personsEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etIntro);
		subject = (EditText) findViewById(R.id.etSubject);
//		personsName = (EditText) findViewById(R.id.etName);
//		stupidThings = (EditText) findViewById(R.id.etThings);
//		hatefulAction = (EditText) findViewById(R.id.etAction);
//		outro = (EditText) findViewById(R.id.etOutro);
		sendEmail = (Button) findViewById(R.id.bSentEmail);
//		sendEmail.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
	}
	public void onClick(View v) {
		convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
		String emailAddress[] = { emailAdd };
		String message = beginning;
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subjectString);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
	}
	private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
		
//		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		subjectString = subject.getText().toString();
//		name = personsName.getText().toString();
//		stupidAction = stupidThings.getText().toString();
//		hatefulAct = hatefulAction.getText().toString();
//		out = outro.getText().toString();
	}
	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
}
