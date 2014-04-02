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
package com.onecube;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * A view container where OpenGL ES graphics can be drawn on screen.
 * This view can also be used to capture touch events, such as a user
 * interacting with drawn objects.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;
    
    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context,attrs);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    
   // private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
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
        		if(mPreviousX >290.0f/720*getWidth()  && mPreviousY < 130.0f/1280*getHeight() && mPreviousY >34.0f/1280*getHeight()){
                	mRenderer.on_change_horizontal_cube2();
                	mRenderer.rotateLeftCube2("b1");        			
                    requestRender();
        		}
        		break;
        	case MotionEvent.ACTION_MOVE:        		
                float dx = e.getX() - mPreviousX;
                float dy = e.getY() - mPreviousY;
                double d0 = 60.0;
                
                Point test = new Point((double)mPreviousX, mPreviousY);
                
                Boundary left1 = new Boundary(
                		new Point((double)60.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),  // upLeft
                		new Point((double)210.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),   // upRight
                		new Point((double)210.0f/720*getWidth(), (700.0f - d0)/1280*getHeight()),   // bottomRight
                		new Point((double)60.0f/720*getWidth(), (700.0f - 2*d0)/1280*getHeight())); // bottomLeft
                Boundary left2 = new Boundary(
                		new Point((double)210.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),  // upLeft
                		new Point((double)360.0f/720*getWidth(), ((double)500.0f)/1280*getHeight()),   // upRight
                		new Point((double)360.0f/720*getWidth(), ((double)700.0f)/1280*getHeight()),   // bottomRight
                		new Point((double)210.0f/720*getWidth(), (700.0f - d0)/1280*getHeight())); // bottomLeft
                Boundary left3 = new Boundary(
                		new Point((double)60.0f/720*getWidth(), (700.0f - 2*d0)/1280*getHeight()),  // upLeft
                		new Point((double)210.0f/720*getWidth(), (700.0f - d0)/1280*getHeight()),   // upRight
                		new Point((double)210.0f/720*getWidth(), (900.0f - d0)/1280*getHeight()),   // bottomRight
                		new Point((double)60.0f/720*getWidth(), (900.0f - 2*d0)/1280*getHeight())); // bottomLeft
                Boundary left4 = new Boundary(
                		new Point((double)210.0f/720*getWidth(), (700.0f - d0)/1280*getHeight()),  // upLeft
                		new Point((double)360.0f/720*getWidth(), ((double)700.0f)/1280*getHeight()),   // upRight
                		new Point((double)360.0f/720*getWidth(), ((double)900.0f)/1280*getHeight()),   // bottomRight
                		new Point((double)210.0f/720*getWidth(), (900.0f - d0)/1280*getHeight())); // bottomLeft
                
                
                Boundary right1 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), ((double)500.0f)/1280*getHeight()),  // upLeft
                		new Point((double)510.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),   // upRight
                		new Point((double)510.0f/720*getWidth(), (700.0f - d0)/1280*getHeight()),   // bottomRight
                		new Point((double)360.0f/720*getWidth(), ((double)700.0f)/1280*getHeight())); // bottomLeft
                Boundary right2 = new Boundary(
                		new Point((double)510.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),  // upLeft
                		new Point((double)660.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),   // upRight
                		new Point((double)660.0f/720*getWidth(), (700.0f - 2*d0)/1280*getHeight()),   // bottomRight
                		new Point((double)510.0f/720*getWidth(), (700.0f - d0)/1280*getHeight())); // bottomLeft
                Boundary right3 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), ((double)700.0f)/1280*getHeight()),  // upLeft
                		new Point((double)510.0f/720*getWidth(), (700.0f - d0)/1280*getHeight()),   // upRight
                		new Point((double)510.0f/720*getWidth(), (900.0f - d0)/1280*getHeight()),   // bottomRight
                		new Point((double)360.0f/720*getWidth(), ((double)900.0f)/1280*getHeight())); // bottomLeft
                Boundary right4 = new Boundary(
                		new Point((double)510.0f/720*getWidth(), (700.0f - d0)/1280*getHeight()),  // upLeft
                		new Point((double)660.0f/720*getWidth(), (700.0f - 2*d0)/1280*getHeight()),   // upRight
                		new Point((double)660.0f/720*getWidth(), (900.0f - 2*d0)/1280*getHeight()),   // bottomRight
                		new Point((double)510.0f/720*getWidth(), (900.0f - d0)/1280*getHeight())); // bottomLeft
                
                Boundary top1 = new Boundary(
                		new Point((double)60.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),
                		new Point((double)210.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),
                		new Point((double)210.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()));
                Boundary top2 = new Boundary(
                		new Point((double)210.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()),
                		new Point((double)510.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()));
                Boundary top3 = new Boundary(
                		new Point((double)210.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),
                		new Point((double)510.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), ((double)500.0f)/1280*getHeight()));
                Boundary top4 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),
                		new Point((double)510.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()),
                		new Point((double)660.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),
                		new Point((double)510.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()));
                if (left1.contains(test)) {
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b1");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b1");
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -10 && dx < 50){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("a1");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("a1");                		
                	}
                }
                if (left2.contains(test)) {
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b1");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b1");
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -10 && dx < 50){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("a2");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("a2");                		
                	}
                }
                if (left3.contains(test)) {
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b3");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b3");
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -10 && dx < 50){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("a1");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("a1");                		
                	}
                }
                if (left4.contains(test)) {
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b3");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b3");
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -10 && dx < 50){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("a2");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("a2");                		
                	}
                }
                if (right1.contains(test)) {
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b1");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b1");
                	}
                	//Rotate Up
                	if(dy < -50 && dx < 10 && dx > -50){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("b1");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                		mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("b1");                		
                	}
                }
                if (right2.contains(test)) {
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b1");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b1");
                	}
                	//Rotate Up
                	if(dy < -50 && dx < 10 && dx > -50){
                		mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("b2");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                		mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("b2");                		
                	}
                }
                if (right3.contains(test)) {
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b3");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b3");
                	}
                	//Rotate Up
                	if(dy < -50 && dx < 20 && dx > -20){
                		mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("b1");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                		mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("b1");                		
                	}
                }
                if (right4.contains(test)) {
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateRightCube2("b3");           		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateLeftCube2("b3");
                	}
                	//Rotate Up
                	if(dy < -50 && dx < 20 && dx > -20){
                		mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateUpCube2("b2");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                		mRenderer.on_change_horizontal_cube2();
                    	mPreviousX = e.getX();
                    	mPreviousY = e.getY();
                    	mRenderer.rotateDownCube2("b2");                		
                	}
                }
                if (top1.contains(test)) {
                	if (dx > 50 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube2();
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            			mRenderer.rotateDownCube2("b1");
            		}
            		if (dx > 50 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateUpCube2("a1");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
                	if (dx < -40 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateDownCube2("a1");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
            		if (dx < -40 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube2();
            			mRenderer.rotateUpCube2("b1");
            			mPreviousX = e.getX();
            			mPreviousX = e.getY();
            		}
                }
                if (top2.contains(test)) {
                	if (dx > 50 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube2();
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            			mRenderer.rotateDownCube2("b2");
            		}
            		if (dx > 50 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateUpCube2("a1");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
                	if (dx < -50 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateDownCube2("a1");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
            		if (dx < -50 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube2();
            			mRenderer.rotateUpCube2("b2");
            			mPreviousX = e.getX();
            			mPreviousX = e.getY();
            		}
                }
                if (top3.contains(test)) {
                	if (dx > 40 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube2();
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            			mRenderer.rotateDownCube2("b1");
            		}
            		if (dx > 50 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateUpCube2("a2");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
                	if (dx < -40 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateDownCube2("a2");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
            		if (dx < -50 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube2();
            			mRenderer.rotateUpCube2("b1");
            			mPreviousX = e.getX();
            			mPreviousX = e.getY();
            		}
                }
                if (top4.contains(test)) {
                	if (dx > 40 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube2();
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            			mRenderer.rotateDownCube2("b2");
            		}
            		if (dx > 50 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateUpCube2("a2");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
                	if (dx < -50 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube2();
            			mRenderer.rotateDownCube2("a2");
            			mPreviousX = e.getX();
            			mPreviousY = e.getY();
            		}
            		if (dx < -50 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube2();
            			mRenderer.rotateUpCube2("b2");
            			mPreviousX = e.getX();
            			mPreviousX = e.getY();
            		}
                }
                
                if(mPreviousY > 900.0f/1280*getHeight() && dx < -100 && dy < 100){
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	onRotateLeft();
                }
                if(mPreviousY > 900.0f/1280*getHeight() && dx >100 && dy < 100){
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	onRotateRight();
                }
                if(mPreviousY > 900.0f/1280*getHeight() && dy < -100 && dx < 100 && dx >-100){
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	onRotateUpView();
                }
                requestRender();
                break;
        }

    	return true;
    }
    
    public void onRotateLeft () {
    	mRenderer.onRotateLeft2();
    }
    
    
    public void onRotateRight () {
    	mRenderer.onRotateRight2();
    }
    
    public void onRotateUpView () {
    	mRenderer.onRotateUpView2();
    }
}
