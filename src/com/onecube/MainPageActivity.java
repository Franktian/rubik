package com.onecube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
	}

    public void backView(View view) {
		Intent intent = new Intent(this, SubmenuActivity.class);
	    startActivity(intent);
    }
	
    @Override
    public void onBackPressed() {
    }
}
