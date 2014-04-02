package com.onecube;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubmenuActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submenu);
		final Button button1b  = (Button) findViewById(R.id.button1);
		button1b.setBackgroundResource(R.drawable.backback);
		final Button cube2button  = (Button) findViewById(R.id.cube2_button);
		cube2button.setBackgroundResource(R.drawable.cube2back);
		final Button cube3button  = (Button) findViewById(R.id.cube3_button);
		cube3button.setBackgroundResource(R.drawable.cube3back);		
		final Button helpbutton  = (Button) findViewById(R.id.help_button);
		helpbutton.setBackgroundResource(R.drawable.helpback);		

	}
	public void startCube2(View view){
		Intent intent = new Intent(this, MainPageActivity.class);
	    startActivity(intent);
	}
	public void startCube3(View view){
		Intent intent = new Intent(this, Cube3Activity.class);
		startActivity(intent);
	}
	public void backToStart(View view){
		Intent intent = new Intent(this, StartActivity.class);
		startActivity(intent);
	}
	public void startHelp(View view){
		Intent intent = new Intent(this, HelpActivity.class);
		startActivity(intent);
	}
	
	@Override
	public void onBackPressed() {

	}
}
