package com.onecube;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
	private int backbuttonclick =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		final Button rankbutton  = (Button) findViewById(R.id.rank_button);
		rankbutton.setBackgroundResource(R.drawable.rankback);
		final Button infobutton  = (Button) findViewById(R.id.info_button);
		infobutton.setBackgroundResource(R.drawable.infoback);
		final Button playbutton  = (Button) findViewById(R.id.play_button);
		playbutton.setBackgroundResource(R.drawable.playback);		
		final Button settingbutton  = (Button) findViewById(R.id.setting_button);
		settingbutton.setBackgroundResource(R.drawable.settingback);		
		backbuttonclick = 0;

	}
	public void play(View view){
		Intent intent = new Intent(this, SubmenuActivity.class);
	    startActivity(intent);
	}
	public void startSetting(View view){
		Intent intent = new Intent(this, SettingActivity.class);
	    startActivity(intent);		
	}
	public void startInfo(View view){
		Intent intent = new Intent(this, InfoActivity.class);
	    startActivity(intent);		
	}
	public void startRank(View view){
		Intent intent = new Intent(this, RankActivity.class);
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
