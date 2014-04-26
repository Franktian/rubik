package com.onecube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.onecube.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainPageActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_page);
		final Button backbutton  = (Button) findViewById(R.id.back_button);
		backbutton.setBackgroundResource(R.drawable.backtomenu);
		final Button settingbutton  = (Button) findViewById(R.id.setting_button);
		settingbutton.setBackgroundResource(R.drawable.settingplaying);
	}

    public void backView(View view) {
		Intent intent = new Intent(this, SubmenuActivity.class);
	    startActivity(intent);
    }
	public void startSetting(View view){
		Intent intent = new Intent(this, SettingActivity.class);
	    startActivity(intent);		
	}
	
    @Override
    public void onBackPressed() {
    }
}
