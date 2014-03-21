package com.example.cube;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SettingActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
	}
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(this, StartActivity.class);
		startActivity(intent);
	}
}
