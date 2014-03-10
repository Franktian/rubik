/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cube;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;

/**
 * A view container where OpenGL ES graphics can be drawn on screen.
 * This view can also be used to capture touch events, such as a user
 * interacting with drawn objects.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;
    private final float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
    private final float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
    private final float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };
    private final float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    private final float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
    private final float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f };
    
    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    
    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;
    
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.


        switch (e.getAction()) {
        	case MotionEvent.ACTION_DOWN:
        		mPreviousX = e.getX();
        		mPreviousY = e.getY();
        		break;
        	case MotionEvent.ACTION_UP:        		
                float dx = e.getX() - mPreviousX;
                float dy = e.getY() - mPreviousY;
                
                if (mPreviousY > 700.0f &&dx > 100 && dy < 100 && dy > -100 && mPreviousY <900.0f) {//Move Right
              //  	mRenderer.on_change_horizontal();
        		//	mRenderer.rotateLeft('b');
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateRightCube2("b3");
                }

                if (mPreviousY > 700.0f &&dx < -100 && dy < 100 && dy >-100 && mPreviousY <900.0f) {//Move Left
               // 	mRenderer.on_change_horizontal();
                //	mRenderer.rotateRight('b');		
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateLeftCube2("b3");
                }

                if (mPreviousY > 500.0f &&dx > 100 && dy < 100  && dy > -100 && mPreviousY <700.0f) {//Move Right
              //  	mRenderer.on_change_horizontal();
        		//	mRenderer.rotateLeft('b');
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateRightCube2("b1");
                }

                if (mPreviousY > 500.0f &&dx < -100 && dy <100 && dy > -100 && mPreviousY <700.0f) {//Move Left
               // 	mRenderer.on_change_horizontal();
                //	mRenderer.rotateRight('b');		
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateLeftCube2("b1");
                }
                
                if(dy > 100 && mPreviousX > 500.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){    //On right Move Down right
               // 	mRenderer.on_change_horizontal();
                //	mRenderer.rotateUp('c');	
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateDownCube2("b2");
                }
                if(dy < -100 && mPreviousX > 500.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){	//On right Move Up right 
               //  	mRenderer.on_change_horizontal();
               // 	mRenderer.rotateDown('c');		 
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateUpCube2("b2");
                }
                if((dy > 100 && mPreviousX < 500.0f && mPreviousX > getWidth()/2 && mPreviousY < 900.0f && mPreviousY > 300.0f)){    //On right Move Down
               // 	mRenderer.on_change_horizontal();
                //	mRenderer.rotateUp('c');	
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateDownCube2("b1");
                }
                if(dy < -100 && mPreviousX < 500.0f && mPreviousX > getWidth()/2 && mPreviousY < 900.0f && mPreviousY > 300.0f){	//On right Move Up
               //  	mRenderer.on_change_horizontal();
               // 	mRenderer.rotateDown('c');		 
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateUpCube2("b1");
                }
                
                if(dy > 100 && mPreviousX < 200.0f  && mPreviousY < 900.0f && mPreviousY > 200.0f){	//On Left Move Up
                //	mRenderer.on_change_vertical_left();
               // 	mRenderer.rotateDown('a');		 
                	mRenderer.on_change_vertical_cube2();
                	mRenderer.rotateDownCube2("a1");
                }
                if(dy < -100 && mPreviousX < 200.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){ //On Left Move Down
             //    	mRenderer.on_change_vertical_left();
              //  	mRenderer.rotateUp('a');	
                	mRenderer.on_change_vertical_cube2();
                	mRenderer.rotateUpCube2("a1");
                }
               
                if(dy > 100 && mPreviousX < getWidth()/2 && mPreviousX > 200.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){	//On Left Move Up
                //	mRenderer.on_change_vertical_left();
               // 	mRenderer.rotateDown('a');		 
                	mRenderer.on_change_vertical_cube2();
                	mRenderer.rotateDownCube2("a2");
                }
                if(dy < -100 && mPreviousX < getWidth()/2 && mPreviousX > 200.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){ //On Left Move Down
             //    	mRenderer.on_change_vertical_left();
              //  	mRenderer.rotateUp('a');	
                	mRenderer.on_change_vertical_cube2();
                	mRenderer.rotateUpCube2("a2");
                } 
				
                requestRender();
                break;
        }

    	return true;
    }
    
    public void onRotateLeft () {
    	for (int i = 0; i < 2; i++) {
    		mRenderer.rotateLeftCube2("a1");
    		mRenderer.rotateLeftCube2("a3");
    	}
    	mRenderer.rotateUpViewLeft2();
    	mRenderer.rotateDownViewLeft2();
    }
    
    public void onRotateRight () {
    	for (int i = 0; i < 2; i++) {
    		mRenderer.rotateRightCube2("a1");
    		mRenderer.rotateRightCube2("a3");
    	}
    	mRenderer.rotateUpViewRight2();
    	mRenderer.rotateUpViewRight2();
    }
    

}
