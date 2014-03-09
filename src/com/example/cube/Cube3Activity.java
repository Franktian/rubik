package com.example.cube;

import android.app.Activity;
import android.os.Bundle;

import com.example.cube.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class Cube3Activity extends Activity {
    private GLSurfaceViewCube3 mGLView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_cube3);
        mGLView = new GLSurfaceViewCube3(this);
        setContentView(mGLView);
	}
	

}
