package com.example.cube;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class HelpActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(this, SubmenuActivity.class);
		startActivity(intent);
	}
}
