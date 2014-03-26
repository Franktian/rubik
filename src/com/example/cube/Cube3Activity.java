package com.example.cube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cube.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class Cube3Activity extends Activity {
//	private Button leftButton;
//	private Button rightButton;
//	private Button backButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cube3);
	//	leftButton = (Button) findViewById(R.id.left_button);
	//	rightButton = (Button) findViewById(R.id.right_button);
//		leftButton.setOnClickListener(leftView());
	//	rightButton.setOnClickListener(rightView());
	}
	/*
    private OnClickListener leftView() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
            	GLRendererCube3.myCube3.onRotateLeft();
            //	GLSurfaceViewCube3.mRenderer.;
            }
        };
    }
    
    private OnClickListener rightView() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
            	GLRendererCube3.myCube3.onRotateRight();
            }
        };
    }
*/
    public void backView(View view) {
		Intent intent = new Intent(this, SubmenuActivity.class);
	    startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }
}
