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
public class GLSurfaceViewCube3 extends GLSurfaceView {

    private final GLRendererCube3 mRenderer;
    private final float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
    private final float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
    private final float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };
    private final float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    private final float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
    private final float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f };
    
    public GLSurfaceViewCube3(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new GLRendererCube3();
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
                
                if (mPreviousY > 500.0f &&dx > 100 && dy < 100 && dy > -100 && mPreviousY <633.3f) {//First Move Right
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateRightCube3("right1");
                }
                
                if (mPreviousY > 633.3f &&dx > 100 && dy < 100 && dy > -100 && mPreviousY <766.6f) {//Second Move Right
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateRightCube3("right4");
                }
                if (mPreviousY > 766.6f &&dx > 100 && dy < 100 && dy > -100 && mPreviousY <900.0f) {//Third Move Right
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateRightCube3("right7");
                }
                
                if (mPreviousY > 500.0f &&dx < -100 && dy < 100 && dy >-100 && mPreviousY <633.3f) {//First Move Left
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateLeftCube3("right1");
                }

                if (mPreviousY > 633.3f &&dx < -100 && dy < 100 && dy > -100 && mPreviousY <766.6f) {//Second Move Left
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateLeftCube3("right4");
                }
                if (mPreviousY > 766.6f &&dx < -100 && dy < 100 && dy > -100 && mPreviousY <900.0f) {//Third Move Left
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateLeftCube3("right7");
                }
                
                //First right Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 && mPreviousX < getWidth()/2 + 100.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){   
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateDownCube3("right1");
                }
                //Second right Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 + 100.0f && mPreviousX < getWidth()/2 + 200.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateDownCube3("right2");
                }
                //Third right Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 + 200.0f  && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateDownCube3("right3");
                }
                //First right Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 && mPreviousX < getWidth()/2 + 100.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateUpCube3("right1");
                }
                //Second right Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 + 100.0f && mPreviousX < getWidth()/2 + 200.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){   
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateUpCube3("right2");
                }
                //Third right Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 + 200.0f  && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateUpCube3("right3");
                }
                

                //Third left Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2-100.0f && mPreviousX < getWidth()/2 && mPreviousY < 900.0f && mPreviousY > 200.0f){   
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateDownCube3("front3");
                }
                //Second left Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 - 200.0f && mPreviousX < getWidth()/2 - 100.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateDownCube3("front2");
                }
                //First left Move Down	
                if(dy > 100 && mPreviousX < getWidth()/2 - 200.0f  && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateDownCube3("front1");
                }
                //First left Move Up	
                if(dy < -100 && mPreviousX < getWidth()/2 - 200.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateUpCube3("front1");
                }
                //Second left Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 - 200.0f && mPreviousX < getWidth()/2 - 100.0f && mPreviousY < 900.0f && mPreviousY > 200.0f){   
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateUpCube3("front2");
                }
                //Third left Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 - 100.0f && mPreviousX < getWidth()/2 && mPreviousY < 900.0f && mPreviousY > 200.0f){    
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateUpCube3("front3");
                }
                
                
                
                requestRender();
                break;
        }

    	return true;
    }
    

}
