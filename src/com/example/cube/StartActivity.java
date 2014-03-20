package com.example.cube;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
	private int backbuttonclick =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		final Button button1b  = (Button) findViewById(R.id.button1);
		button1b.setBackgroundResource(R.drawable.backbutton);
		backbuttonclick = 0;

	}
	public void startCube2(View view){
		Intent intent = new Intent(this, MainPageActivity.class);
	    startActivity(intent);
	}
	public void startCube3(View view){
		Intent intent = new Intent(this, Cube3Activity.class);
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		if(backbuttonclick >0){
		   Intent intent = new Intent(Intent.ACTION_MAIN);
		   intent.addCategory(Intent.CATEGORY_HOME);
		   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   startActivity(intent);
		   backbuttonclick =0;
		}else{
			Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
			backbuttonclick+=1;			
		}
	}
}
