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
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * A view container where OpenGL ES graphics can be drawn on screen.
 * This view can also be used to capture touch events, such as a user
 * interacting with drawn objects.
 */
public class GLSurfaceViewCube3 extends GLSurfaceView {

    public static GLRendererCube3 mRenderer;
    //private final float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
    //private final float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
    //private final float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };
    //private final float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    //private final float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
    //private final float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f };
    
    public GLSurfaceViewCube3(Context context, AttributeSet attrs) {
        super(context,attrs);
        
        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new GLRendererCube3();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    
    //private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float originX;
    private float originY;
    //private float mPreviousX;
    //private float mPreviousY;
    
    
    /*public double d0 = 100/Math.sqrt(3);
    public Boundary left1 = new Boundary(
    		new Point((double)60.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()),  //upLeft
    		new Point((double)160.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), //upRight
    		new Point((double)60.0f/720*getWidth(), (633.3f - 3*d0)/1280*getHeight()),  //botomLeft
    		new Point((double)160.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()));//bottomRight
    
    public Boundary left2 = new Boundary(
    		new Point((double)160.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // upLeft
    		new Point((double)260.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()), // upRight
    		new Point((double)160.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()),  // bottomLeft
    		new Point((double)260.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()));// bottomRight 
    
    public Boundary left3 = new Boundary(
    		new Point((double)260.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()), // upLeft
    		new Point((double)360.0f/720*getWidth(), ((double)500.0f)/1280*getHeight()), // upRight
    		new Point((double)260.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()),  // bottomLeft
    		new Point((double)360.0f/720*getWidth(), ((double)633.3f)/1280*getHeight()));// bottomRight*/
    
    
    
    
    
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

    	
        switch (e.getAction()) {
        	case MotionEvent.ACTION_DOWN:
        		originX = e.getX();
        		originY = e.getY();
        		if(originX >290.0f/720*getWidth() && originX < 420.0f/720*getWidth() && originY > 31.0f/1280*getHeight() && originY < 128.0f/1280*getHeight()){
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateLeftCube3("right1");                		
                    requestRender();
        		}   
        		break;
        	case MotionEvent.ACTION_MOVE:        		
                float dx = e.getX() - originX;
                float dy = e.getY() - originY;
                double d0 = 40.0;
             
                Point test = new Point((double)originX, (double)originY);
                
                Boundary left1 = new Boundary(
                		new Point((double)60.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()),  //upLeft
                		new Point((double)160.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), //upRight
                		new Point((double)160.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()),
                		new Point((double)60.0f/720*getWidth(), (633.3f - 3*d0)/1280*getHeight())  //botomLeft
                		);//bottomRight
                Boundary left2 = new Boundary(
                		new Point((double)160.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // upLeft
                		new Point((double)260.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()), // upRight
                		new Point((double)260.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()),
                		new Point((double)160.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight 
                Boundary left3 = new Boundary(
                		new Point((double)260.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()), // upLeft
                		new Point((double)360.0f/720*getWidth(), ((double)500.0f)/1280*getHeight()), // upRight
                		new Point((double)360.0f/720*getWidth(), ((double)633.3f)/1280*getHeight()),
                		new Point((double)260.0f/720*getWidth(), (633.3f - d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right1 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), ((double)500.0f)/1280*getHeight()), // upLeft
                		new Point((double)460.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()), // upRight
                		new Point((double)460.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), ((double)633.3f)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right2 = new Boundary(
                		new Point((double)460.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()), // upLeft
                		new Point((double)560.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // upRight
                		new Point((double)560.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()),
                		new Point((double)460.0f/720*getWidth(), (633.3f - d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right3 = new Boundary(
                		new Point((double)560.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // upLeft
                		new Point((double)660.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()), // upRight
                		new Point((double)660.0f/720*getWidth(), (633.3f - 3*d0)/1280*getHeight()),
                		new Point((double)560.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                
                
                
                Boundary left4 = new Boundary(
                		new Point((double)60.0f/720*getWidth(), (633.3f - 3*d0)/1280*getHeight()),  //upLeft
                		new Point((double)160.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()), //upRight
                		new Point((double)160.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight()),
                		new Point((double)60.0f/720*getWidth(), (766.6f - 3*d0)/1280*getHeight())  //botomLeft
                		);//bottomRight
                Boundary left5 = new Boundary(
                		new Point((double)160.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()), // upLeft
                		new Point((double)260.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()), // upRight
                		new Point((double)260.0f/720*getWidth(), (766.6f - d0)/1280*getHeight()),
                		new Point((double)160.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary left6 = new Boundary(
                		new Point((double)260.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()), // upLeft
                		new Point((double)360.0f/720*getWidth(), ((double)633.3f)/1280*getHeight()), // upRight
                		new Point((double)360.0f/720*getWidth(), ((double)766.6f)/1280*getHeight()),
                		new Point((double)260.0f/720*getWidth(), (766.6f - d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right4 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), ((double)633.3f)/1280*getHeight()), // upLeft
                		new Point((double)460.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()), // upRight
                		new Point((double)460.0f/720*getWidth(), (766.6f - d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), ((double)766.6f)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right5 = new Boundary(
                		new Point((double)460.0f/720*getWidth(), (633.3f - d0)/1280*getHeight()), // upLeft
                		new Point((double)560.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()), // upRight
                		new Point((double)560.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight()),
                		new Point((double)460.0f/720*getWidth(), (766.6f - d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right6 = new Boundary(
                		new Point((double)560.0f/720*getWidth(), (633.3f - 2*d0)/1280*getHeight()), // upLeft
                		new Point((double)660.0f/720*getWidth(), (633.3f - 3*d0)/1280*getHeight()), // upRight
                		new Point((double)660.0f/720*getWidth(), (766.6f - 3*d0)/1280*getHeight()),
                		new Point((double)560.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                
                
                
                Boundary left7 = new Boundary(
                		new Point((double)60.0f/720*getWidth(), (766.6f - 3*d0)/1280*getHeight()),  //upLeft
                		new Point((double)160.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight()), //upRight
                		new Point((double)160.0f/720*getWidth(), (900.0f - 2*d0)/1280*getHeight()),
                		new Point((double)60.0f/720*getWidth(), (900.0f - 3*d0)/1280*getHeight())  //botomLeft
                		);//bottomRight
                Boundary left8 = new Boundary(
                		new Point((double)160.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight()), // upLeft
                		new Point((double)260.0f/720*getWidth(), (766.6f - d0)/1280*getHeight()), // upRight
                		new Point((double)260.0f/720*getWidth(), (900.0f - d0)/1280*getHeight()),
                		new Point((double)160.0f/720*getWidth(), (900.0f - 2*d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary left9 = new Boundary(
                		new Point((double)260.0f/720*getWidth(), (766.6f - d0)/1280*getHeight()), // upLeft
                		new Point((double)360.0f/720*getWidth(), ((double)766.6f)/1280*getHeight()), // upRight
                		new Point((double)360.0f/720*getWidth(), ((double)900.0f)/1280*getHeight()),
                		new Point((double)260.0f/720*getWidth(), (900.0f - d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right7 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), ((double)766.6f)/1280*getHeight()), // upLeft
                		new Point((double)460.0f/720*getWidth(), (766.6f - d0)/1280*getHeight()), // upRight
                		new Point((double)460.0f/720*getWidth(), (900.9f - d0)/1280*getHeight()),
                		new Point((double)360.0f/720*getWidth(), ((double)900.0f)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right8 = new Boundary(
                		new Point((double)460.0f/720*getWidth(), (766.6f - d0)/1280*getHeight()), // upLeft
                		new Point((double)560.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight()), // upRight
                		new Point((double)560.0f/720*getWidth(), (900.0f - 2*d0)/1280*getHeight()),
                		new Point((double)460.0f/720*getWidth(), (900.0f - d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                Boundary right9 = new Boundary(
                		new Point((double)560.0f/720*getWidth(), (766.6f - 2*d0)/1280*getHeight()), // upLeft
                		new Point((double)660.0f/720*getWidth(), (766.6f - 3*d0)/1280*getHeight()), // upRight
                		new Point((double)660.0f/720*getWidth(), (900.0f - 3*d0)/1280*getHeight()),
                		new Point((double)560.0f/720*getWidth(), (900.0f - 2*d0)/1280*getHeight())  // bottomLeft
                		);// bottomRight
                
                
                
                Boundary top1 = new Boundary(
                		new Point((double)160.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()),  // upLeft
                		new Point((double)260.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()), // upRight
                		new Point((double)160.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),
                		new Point((double)60.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()) // bottomLeft
                		);// bottomRight
                Boundary top2 = new Boundary(
                		new Point((double)260.0f/720*getWidth(), (500.0f - 5*d0)/1280*getHeight()), // upLeft
                		new Point((double)360.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()), // upRight
                		new Point((double)260.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()),
                		new Point((double)160.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()) // bottomLeft
                		);// bottomRight
                Boundary top3 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), (500.0f - 6*d0)/1280*getHeight()), // upLeft
                		new Point((double)460.0f/720*getWidth(), (500.0f - 5*d0)/1280*getHeight()), // upRight
                		new Point((double)360.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()),
                		new Point((double)260.0f/720*getWidth(), (500.0f - 5*d0)/1280*getHeight()) // bottomLeft
                		);// bottomRight
                Boundary top4 = new Boundary(
                		new Point((double)260.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()), // upLeft
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // upRight
                		new Point((double)260.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),  // bottomRight
                		new Point((double)160.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()) // bottomLeft
                		);
                Boundary top5 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()), // upLeft
                		new Point((double)460.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()), // upRight
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // bottomRight
                		new Point((double)260.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()) // bottomLeft
                		);
                Boundary top6 = new Boundary(
                		new Point((double)460.0f/720*getWidth(), (500.0f - 5*d0)/1280*getHeight()), // upLeft
                		new Point((double)560.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()), // upRight
                		new Point((double)460.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()), // bottomRight
                		new Point((double)360.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()) // bottomLeft
                		);
                Boundary top7 = new Boundary(
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // upLeft
                		new Point((double)460.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()), // upRight
                		new Point((double)360.0f/720*getWidth(), (500.0f)/1280*getHeight()), // bottomRight
                		new Point((double)260.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()) // bottomLeft
                		);
                Boundary top8 = new Boundary(
                		new Point((double)460.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()), // upLeft
                		new Point((double)560.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()), // upRight
                		new Point((double)460.0f/720*getWidth(), (500.0f - d0)/1280*getHeight()),  // bottomRight
                		new Point((double)360.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()) // bottomLeft
                		);
                Boundary top9 = new Boundary(
                		new Point((double)560.0f/720*getWidth(), (500.0f - 4*d0)/1280*getHeight()),  // upLeft
                		new Point((double)660.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()), // upRight
                		new Point((double)560.0f/720*getWidth(), (500.0f - 2*d0)/1280*getHeight()),
                		new Point((double)460.0f/720*getWidth(), (500.0f - 3*d0)/1280*getHeight()) // bottomLeft
                		);// bottomRight
                
                if (top1.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			originX = e.getX();
            			originY = e.getY();
            			mRenderer.rotateDownCube3("right1");
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front1");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -20 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front1");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -20 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right1");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                
                if (top2.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right2");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front1");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front1");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right2");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                
                if (top3.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right3");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front1");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front1");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right3");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                
                if (top4.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right1");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front2");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front2");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right1");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                
                if (top5.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right2");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front2");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front2");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right2");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                
                if (top6.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right3");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front2");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front2");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right3");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                
                if (top7.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right1");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front3");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front3");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right1");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                if (top8.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right2");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front3");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front3");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right2");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                
                if (top9.contains(test)) {
                	if (dx > 30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateDownCube3("right3");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx > 30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateUpCube3("front3");
            			originX = e.getX();
            			originY = e.getY();
            		}
                	if (dx < -30 && dy > 0 && dy < 100) {
            			mRenderer.on_change_vertical_cube3();
            			mRenderer.rotateDownCube3("front3");
            			originX = e.getX();
            			originY = e.getY();
            		}
            		if (dx < -30 && dy < 0 && dy > -100) {
            			mRenderer.on_change_horizontal_cube3();
            			mRenderer.rotateUpCube3("right3");
            			originX = e.getX();
            			originY = e.getY();
            		}
                }
                //left1 
                //if( 60.0f/720*getWidth() < originX && originX < 160.0f/720*getWidth() && originY > (500.0f - 2.3*d0)/1280*getHeight() && originY < (633.3f - 2.7*d0) /1280*getHeight()){
                if (left1.contains(test)) {
                	//Rotate right
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right1");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right1");
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -10 && dx < 50){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front1");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front1");                		
                	}
                }
                //left2 
                if (left2.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right1");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right1");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -10 && dx< 50){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front2");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front2");                		
                	}
              }
                //left3 
                if (left3.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy > -100 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right1");
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right1");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -10 && dx< 50){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front3");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front3");                		
                	}
              }
                //right1
                if (right1.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right1");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -100 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right1");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx < 10 && dx > -50){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right1");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right1");                		
                	}
              }                
                //right2                
                if (right2.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right1");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right1");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx < 10 && dx > -50){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right2");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right2");                		
                	}
              }
                //right3                
                if (right3.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right1");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right1");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx < 10 && dx > -50){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right3");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right3");                		
                	}
              }  

                
                
                
                
                
                
                
                
                
                //left4 
                if (left4.contains(test)) {
                	//Rotate right
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right4");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right4");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front1");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front1");                		
                	}
                }
                //left5 
                if (left5.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right4");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right4");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front2");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front2");                		
                	}
               }
                //left6 
                if (left6.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy > -100 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right4");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right4");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front3");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front3");                		
                	}
              }
                //right4
                if (right4.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right4");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -100 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right4");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right1");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right1");                		
                	}
              }                
                //right5                
                if (right5.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right4");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right4");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right2");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right2");                		
                	}
               }
                //right6                
                if (right6.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right4");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right4");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right3");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right3");                		
                	}
              }  
                
                

                
                
                //Round 3
                
                //left7 
                if (left7.contains(test)) {
                	//Rotate right
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right7");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right7");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front1");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front1");                		
                	}
             }
                //left8 
                if(left8.contains(test)){
                	//Rotate Right
                	if(dx > 50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right7");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right7");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front2");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front2");                		
                	}
               }
                //left9 
                if (left9.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy > -100 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateRightCube3("right7");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right7");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("front3");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_vertical_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("front3");                		
                	}
             }
                //right7
                if (right7.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right7");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -100 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right7");                		
                	}
                	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right1");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right1");                		
                	}
               }                
                //right8                
                if (right8.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right7");                		
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right7");                		
                	}
                  	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right2");                		
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right2");                		
                	}
                }
                //right9                
                if (right9.contains(test)) {
                	//Rotate Right
                	if(dx > 50 && dy < 10 && dy > -100){
                    	mRenderer.on_change_horizontal_cube3();
                		originX = e.getX();
                		originY = e.getY();
                    	mRenderer.rotateRightCube3("right7");
                	}
                	//Rotate left
                	if(dx < -50 && dy > -10 && dy < 100){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateLeftCube3("right7");
                	}
                  	//Rotate Up
                	if(dy <-50 && dx > -20 && dx < 20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateUpCube3("right3");
                	}
                	//Rotate Down
                	if(dy > 50 && dx < 20 && dx > -20){
                    	mRenderer.on_change_horizontal_cube3();
                    	originX = e.getX();
                    	originY = e.getY();
                    	mRenderer.rotateDownCube3("right3");
                	}
                }
                
                
                /*
                if (mPreviousY > 500.0f/1280*getHeight() &&dx > 100 && dy < 100 && dy > -100 && mPreviousY <633.3f/1280*getHeight()) {//First Move Right
                	mRenderer.on_change_horizontal_cube3();
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.rotateRightCube3("right1");
                }
                
                if (mPreviousY > 633.3f/1280*getHeight() &&dx > 100 && dy < 100 && dy > -100 && mPreviousY <766.6f/1280*getHeight()) {//Second Move Right
                	mRenderer.on_change_horizontal_cube3();
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.rotateRightCube3("right4");
                }
                if (mPreviousY > 766.6f/1280*getHeight() &&dx > 100 && dy < 100 && dy > -100 && mPreviousY <900.0f/1280*getHeight()) {//Third Move Right
                	mRenderer.on_change_horizontal_cube3();
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.rotateRightCube3("right7");
                }
                
                if (mPreviousY > 500.0f/1280*getHeight() &&dx < -100 && dy < 100 && dy >-100 && mPreviousY <633.3f/1280*getHeight()) {//First Move Left
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateLeftCube3("right1");
                }

                if (mPreviousY > 633.3f/1280*getHeight() &&dx < -100 && dy < 100 && dy > -100 && mPreviousY <766.6f/1280*getHeight()) {//Second Move Left
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateLeftCube3("right4");
                }
                if (mPreviousY > 766.6f/1280*getHeight() &&dx < -100 && dy < 100 && dy > -100 && mPreviousY <900.0f/1280*getHeight()) {//Third Move Left
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateLeftCube3("right7");
                }
                
                //First right Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 && mPreviousX < getWidth()/2 + 100.0f/720*getWidth() && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){   
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateDownCube3("right1");
                }
                //Second right Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 + 100.0f/720*getWidth() && mPreviousX < getWidth()/2 + 200.0f/720*getWidth() && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateDownCube3("right2");
                }
                //Third right Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 + 200.0f/720*getWidth()  && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateDownCube3("right3");
                }
                //First right Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 && mPreviousX < getWidth()/2 + 100.0f/720*getWidth() && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateUpCube3("right1");
                }
                //Second right Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 + 100.0f/720*getWidth() && mPreviousX < getWidth()/2 + 200.0f/720*getWidth() && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){   
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateUpCube3("right2");
                }
                //Third right Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 + 200.0f/720*getWidth()  && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_horizontal_cube3();
                	mRenderer.rotateUpCube3("right3");
                }
                

                //Third left Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2-100.0f/720*getWidth() && mPreviousX < getWidth()/2 && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){   
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateDownCube3("front3");
                }
                //Second left Move Down	
                if(dy > 100 && mPreviousX > getWidth()/2 - 200.0f/720*getWidth() && mPreviousX < getWidth()/2 - 100.0f/720*getWidth() && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateDownCube3("front2");
                }
                //First left Move Down	
                if(dy > 100 && mPreviousX < getWidth()/2 - 200.0f/720*getWidth()  && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateDownCube3("front1");
                }
                //First left Move Up	
                if(dy < -100 && mPreviousX < getWidth()/2 - 200.0f/720*getWidth() && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateUpCube3("front1");
                }
                //Second left Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 - 200.0f/720*getWidth() && mPreviousX < getWidth()/2 - 100.0f && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){   
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateUpCube3("front2");
                }
                //Third left Move Up	
                if(dy < -100 && mPreviousX > getWidth()/2 - 100.0f/720*getWidth() && mPreviousX < getWidth()/2 && mPreviousY < 900.0f/1280*getHeight() && mPreviousY > 200.0f/1280*getHeight()){    
                	mPreviousX = e.getX();
                	mPreviousY = e.getY();
                	mRenderer.on_change_vertical_cube3();
                	mRenderer.rotateUpCube3("front3");
                }*/
                if(originY >900.0f/1280*getHeight() && dx < -100 && dy < 100){
                	originX = e.getX();
                	originY = e.getY();
                	onRotateLeft();
                }
                if(originY > 900.0f/1280*getHeight() && dx >100 && dy < 100){
                	originX = e.getX();
                	originY = e.getY();
                	onRotateRight();
                }
                if(originY > 900.0f/1280*getHeight() && dy < -100 && dx<100 && dx>-100){
                	originX = e.getX();
                	originY = e.getY();
                	onRotateUpView();
                }

                requestRender();
                break;
        }

    	return true;
    }

    public void onRotateLeft() {
    	mRenderer.on_change_horizontal_cube3();
    	for (int i = 0; i < 3; i++) {
    		// Rotate the colors on the side
    		mRenderer.rotateLeftCube3("right1");
    		mRenderer.rotateLeftCube3("right4");
    		mRenderer.rotateLeftCube3("right7");
    	}
    	mRenderer.rotateUpViewLeft3();
    	mRenderer.rotateDownViewLeft3();
    }
    
    public void onRotateRight() {
    	mRenderer.on_change_horizontal_cube3();
    	for (int i = 0; i < 3; i++) {
    		// Rotate the colors on the side
    		mRenderer.rotateRightCube3("right1");
    		mRenderer.rotateRightCube3("right4");
    		mRenderer.rotateRightCube3("right7");
    	}
    	mRenderer.rotateUpViewRight3();
    	mRenderer.rotateDownViewRight3();
    }

    
    public void onRandom() {
    	mRenderer.on_change_horizontal_cube3();
    	mRenderer.random3();
    	
    }
    
    public void onRotateUpView () {
    	mRenderer.on_change_vertical_cube3();
    	for (int i = 0; i < 6; i++) {
    		mRenderer.rotateUpCube3("front1");
    		mRenderer.rotateUpCube3("front2");
    		mRenderer.rotateUpCube3("front3");
    	}
    	mRenderer.rotateRightHalf3();
    	mRenderer.rotateLeftHalf3();
    	
    	onRotateRight();
    }
}
