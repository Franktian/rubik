package com.example.cube;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_start);
	}
	public void startCube2(View view){
		Intent intent = new Intent(this, MainPageActivity.class);
	    startActivity(intent);
	}
	public void startCube3(View view){
		Intent intent = new Intent(this, Cube3Activity.class);
		startActivity(intent);
	}

}
