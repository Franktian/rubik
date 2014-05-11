
package com.onecube;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private static final String TAG = "MyGLRenderer";
    //	1*1 Cube
//    private Square_Top   mSquare_Top;
//    private Square_Left  mSquare_Left;
//    private Square_Right mSquare_Right;

    //Cube 2
    private Square_Top_One mSquare_Top_One;
    private Square_Top_Two mSquare_Top_Two;
    private Square_Top_Three mSquare_Top_Three;
    private Square_Top_Four mSquare_Top_Four;
 
    private Square_Left_One mSquare_Left_One;
    private Square_Left_Two mSquare_Left_Two;
    private Square_Left_Three mSquare_Left_Three;
    private Square_Left_Four mSquare_Left_Four;

    private Square_Right_One mSquare_Right_One;
    private Square_Right_Two mSquare_Right_Two;
    private Square_Right_Three mSquare_Right_Three;
    private Square_Right_Four mSquare_Right_Four;
    
    
    //Cube 2
    
    // border
    private Border1 mBorder1;
	private Border2 mBorder2;
	private Border3 mBorder3;
	private Border4 mBorder4;
	private Border5 mBorder5;
	private Border6 mBorder6;
	private Border7 mBorder7;
	private Border8 mBorder8;
    private Border9 mBorder9;
	private Border10 mBorder10;
	private Border11 mBorder11;
	private Border12 mBorder12;
	private Border13 mBorder13;
	private Border14 mBorder14;
	private Border15 mBorder15;
	private Border16 mBorder16;
	private Border17 mBorder17;
	private Border18 mBorder18;
	private Border19 mBorder19;
	private Border20 mBorder20;
	private Border21 mBorder21;
	private Border22 mBorder22;
	private Border23 mBorder23;
	private Border24 mBorder24;
	private Border25 mBorder25;
	private Border26 mBorder26;
	private Border27 mBorder27;
    
    // mMVPMatrix is an abbreviation for "Model View Projection Matrix"
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
//    private final float[] mRotationMatrix = new float[16];
    private final float red[] = { 0.769f, 0.118f, 0.227f, 0.8f };
    private final float green[] = { 0.0f, 0.62f, 0.376f, 0.8f };
    private final float blue[] = { 0.0f, 0.318f, 0.729f, 0.8f };
    private final float white[] = { 0.898f, 0.898f, 0.898f, 0.8f };
    private final float yellow[] = { 1.0f, 0.835f, 0.0f, 0.8f };
    private final float orange[] = { 1.0f, 0.345f, 0.0f, 0.8f };
    private  Cube myCube = new Cube();
    //Cube 2
    private Cube2 myCube2 = new Cube2();
/*
    private float top_color[] = null;
    private float left_color[] = null;
    private float right_color[] = null;
*/
    //Cube 2
    private float top_one_color[] = null;
    private float left_one_color[] = null;
    private float right_one_color[] = null;
    private float top_two_color[] = null;
    private float left_two_color[] = null;
    private float right_two_color[] = null;
    private float top_three_color[] = null;
    private float left_three_color[] = null;
    private float right_three_color[] = null;    
    private float top_four_color[] = null;
    private float left_four_color[] = null;
    private float right_four_color[] = null;    
    
    @Override
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {

        // Set the background frame color
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        //mSquare_Top   = new Square_Top();
        
        mSquare_Top_One = new Square_Top_One();
        mSquare_Top_Two = new Square_Top_Two();
        mSquare_Top_Three = new Square_Top_Three();
        mSquare_Top_Four = new Square_Top_Four();
        
        //mSquare_Left   = new Square_Left();
        
        mSquare_Left_One = new Square_Left_One();
        mSquare_Left_Two = new Square_Left_Two();
        mSquare_Left_Three = new Square_Left_Three();
        mSquare_Left_Four = new Square_Left_Four();

        //mSquare_Right   = new Square_Right();
        
        mSquare_Right_One = new Square_Right_One();
        mSquare_Right_Two = new Square_Right_Two();
        mSquare_Right_Three = new Square_Right_Three();
        mSquare_Right_Four = new Square_Right_Four();
        
        mBorder1 = new Border1();
        mBorder2 = new Border2();
        mBorder3 = new Border3();
        mBorder4 = new Border4();
        mBorder5 = new Border5();
        mBorder6 = new Border6();
        mBorder7 = new Border7();
        mBorder8 = new Border8();
        mBorder9 = new Border9();
        mBorder10 = new Border10();
        mBorder11 = new Border11();
        mBorder12 = new Border12();
        mBorder13 = new Border13();
        mBorder14 = new Border14();
        mBorder15 = new Border15();
        mBorder16 = new Border16();
        mBorder17 = new Border17();
        mBorder18 = new Border18();
        mBorder19 = new Border19();
        mBorder20 = new Border20();
        mBorder21 = new Border21();
        mBorder22 = new Border22();
        mBorder23 = new Border23();
        mBorder24 = new Border24();
        mBorder25 = new Border25();
        mBorder26 = new Border26();
        mBorder27 = new Border27();

        myCube2.a1 = new Face3("a1", "white");
		myCube2.a2 = new Face3("a2", "white");
		myCube2.a3 = new Face3("a3", "white");
		myCube2.a4 = new Face3("a4", "white");

		myCube2.b1 = new Face3("b1","red");
		myCube2.b2 = new Face3("b2","red");
		myCube2.b3 = new Face3("b3","red");
		myCube2.b4 = new Face3("b4","red");

		myCube2.c1 = new Face3("c1", "blue");
		myCube2.c2 = new Face3("c2", "blue");
		myCube2.c3 = new Face3("c3", "blue");
		myCube2.c4 = new Face3("c4", "blue");
		
		myCube2.d1 = new Face3("d1", "orange");
		myCube2.d2 = new Face3("d2", "orange");
		myCube2.d3 = new Face3("d3", "orange");
		myCube2.d4 = new Face3("d4", "orange");
		
		myCube2.e1 = new Face3("e1", "yellow");
		myCube2.e2 = new Face3("e2", "yellow");
		myCube2.e3 = new Face3("e3", "yellow");
		myCube2.e4 = new Face3("e4", "yellow");

		myCube2.f1 = new Face3("f1","green");
		myCube2.f2 = new Face3("f2","green");
		myCube2.f3 = new Face3("f3","green");
		myCube2.f4 = new Face3("f4","green");
		Face3 [] face_array = {
				myCube2.a1,myCube2.b1,myCube2.c1,myCube2.d1,myCube2.e1,myCube2.f1,
				myCube2.a2,myCube2.b2,myCube2.c2,myCube2.d2,myCube2.e2,myCube2.f2,
				myCube2.a3,myCube2.b3,myCube2.c3,myCube2.d3,myCube2.e3,myCube2.f3,
				myCube2.a4,myCube2.b4,myCube2.c4,myCube2.d4,myCube2.e4,myCube2.f4
			};
		myCube2.initialize(face_array);

		int rand = (int) Math.floor(Math.random()*100);
    	on_change_vertical_cube2();
    	myCube2.verticalrandom(rand);
    	rand = (int) Math.floor(Math.random()*100);
    	on_change_horizontal_cube2();
    	myCube2.horizontalrandom(rand);
		
    }

    @Override
    public void onDrawFrame(GL10 unused) {
       // float[] scratch = new float[16];
        //1*1 Cube
/*		top_color = getColor(myCube.c.getColor());
        left_color = getColor(myCube.a.getColor());
        right_color = getColor(myCube.b.getColor());
*/
        
        top_one_color = getColor(myCube2.c3.getColor());//
        top_two_color = getColor(myCube2.c1.getColor());
        top_three_color = getColor(myCube2.c4.getColor());//
        top_four_color = getColor(myCube2.c2.getColor());

        left_one_color = getColor(myCube2.a1.getColor());
        left_two_color = getColor(myCube2.a2.getColor());
        left_three_color = getColor(myCube2.a3.getColor());
        left_four_color = getColor(myCube2.a4.getColor());

        right_one_color = getColor(myCube2.b1.getColor());
        right_two_color = getColor(myCube2.b2.getColor());
        right_three_color = getColor(myCube2.b3.getColor());
        right_four_color = getColor(myCube2.b4.getColor());
		
        // Draw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        // Set the camera position (View matrix)
        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        // Calculate the projection and view transformation
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        // Draw square
        //mSquare_Top.draw(mMVPMatrix, top_color);    
        
        mSquare_Top_One.draw(mMVPMatrix, top_one_color);
        mSquare_Top_Two.draw(mMVPMatrix, top_two_color);
        mSquare_Top_Three.draw(mMVPMatrix, top_three_color);
        mSquare_Top_Four.draw(mMVPMatrix, top_four_color);
        
        //mSquare_Left.draw(mMVPMatrix, left_color);    	
        
        mSquare_Left_One.draw(mMVPMatrix, left_one_color);
        mSquare_Left_Two.draw(mMVPMatrix, left_two_color);
        mSquare_Left_Three.draw(mMVPMatrix, left_three_color);
        mSquare_Left_Four.draw(mMVPMatrix, left_four_color);       
		
        //mSquare_Right.draw(mMVPMatrix, right_color);    	
        
        mSquare_Right_One.draw(mMVPMatrix, right_one_color);
        mSquare_Right_Two.draw(mMVPMatrix, right_two_color);
        mSquare_Right_Three.draw(mMVPMatrix, right_three_color);
        mSquare_Right_Four.draw(mMVPMatrix, right_four_color);    
        
        final float [] border_color = { 0.0f, 0.0f, 0.0f, 0.0f }; 
        mBorder1.draw(mMVPMatrix,border_color);
        //mBorder2.draw(mMVPMatrix,border_color);
        //mBorder3.draw(mMVPMatrix,border_color);
        mBorder4.draw(mMVPMatrix,border_color);
        //mBorder5.draw(mMVPMatrix,border_color);
	    //mBorder6.draw(mMVPMatrix,border_color);
	    mBorder7.draw(mMVPMatrix,border_color);
	    mBorder8.draw(mMVPMatrix,border_color);
	    mBorder9.draw(mMVPMatrix,border_color);
	    //mBorder10.draw(mMVPMatrix,border_color);
	    //mBorder11.draw(mMVPMatrix,border_color);
	    //mBorder12.draw(mMVPMatrix,border_color);
	    //mBorder13.draw(mMVPMatrix,border_color);
        mBorder14.draw(mMVPMatrix,border_color);
        mBorder15.draw(mMVPMatrix,border_color);
        mBorder16.draw(mMVPMatrix,border_color);
        mBorder17.draw(mMVPMatrix,border_color);
        
        // This four are the top inside four
        //mBorder18.draw(mMVPMatrix,border_color);
        //mBorder19.draw(mMVPMatrix,border_color);
	    //mBorder20.draw(mMVPMatrix,border_color);
		//mBorder21.draw(mMVPMatrix,border_color);
        
        mBorder22.draw(mMVPMatrix,border_color);
		mBorder23.draw(mMVPMatrix,border_color);
		mBorder24.draw(mMVPMatrix,border_color);
		mBorder25.draw(mMVPMatrix,border_color);
		mBorder26.draw(mMVPMatrix,border_color);
		mBorder27.draw(mMVPMatrix,border_color);
    }

    @Override
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        // Adjust the viewport based on geometry changes,
        // such as screen rotation
        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;

        // this projection matrix is applied to object coordinates
        // in the onDrawFrame() method
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);

    }

    /**
     * Utility method for compiling a OpenGL shader.
     *
     * <p><strong>Note:</strong> When developing shaders, use the checkGlError()
     * method to debug shader coding errors.</p>
     *
     * @param type - Vertex or fragment shader type.
     * @param shaderCode - String containing the shader code.
     * @return - Returns an id for the shader.
     */
    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    /**
    * Utility method for debugging OpenGL calls. Provide the name of the call
    * just after making it:
    *
    * <pre>
    * mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
    * MyGLRenderer.checkGlError("glGetUniformLocation");</pre>
    *
    * If the operation is not successful, the check throws an error.
    *
    * @param glOperation - Name of the OpenGL call to check.
    */
    public static void checkGlError(String glOperation) {
        int error;
        while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
            Log.e(TAG, glOperation + ": glError " + error);
            throw new RuntimeException(glOperation + ": glError " + error);
        }
    }

    public void setTop(float color[]){
    	//top_color = color; 
    	top_one_color = color;
    	top_two_color = color;
    	top_three_color = color;
    	top_four_color = color;
    }

    public void setLeft(float color[]){
    	//left_color = color;
    	left_one_color = color;
    	left_two_color = color;
    	left_three_color = color;
    	left_four_color = color;
    }
    
    public void setRight(float color[]){
    	//right_color = color;
    	right_one_color = color;
    	right_two_color = color;
    	right_three_color = color;
    	right_four_color = color;
    }
    
    public float[] getColor(String color){
    	if(color.equals("green"))
    		return green;
    	else if(color.equals("white"))
    		return white;
    	else if(color.equals("red"))
    		return red;
    	else if(color.equals("blue"))
    		return blue;
    	else if(color.equals("orange"))
    		return orange;
    	else if(color.equals("yellow"))
    		return yellow;
    	else 
    		return null;
    }
    
    public void rotateRight(char faceToRotate){
    	myCube.rotateRight(faceToRotate);
    }

    public void rotateLeft(char faceToRotate){
    	myCube.rotateLeft(faceToRotate);
    }

    public void rotateUp(char faceToRotate){
    	myCube.rotateUp(faceToRotate);
    }

    public void rotateDown(char faceToRotate){
    	myCube.rotateDown(faceToRotate);
    }

    public void rotateRightCube2(String faceToRotate){
    	myCube2.rotateRight(faceToRotate);
    }

    public void rotateLeftCube2(String faceToRotate){
    	myCube2.rotateLeft(faceToRotate);
    }

    public void rotateUpCube2(String faceToRotate){
    	myCube2.rotateUp(faceToRotate);
    }

    public void rotateDownCube2(String faceToRotate){
    	myCube2.rotateDown(faceToRotate);
    }
    
    public void rotateUpViewLeft2 () {
    	myCube2.rotateUpViewLeft();
    }
    
    public void rotateDownViewLeft2 () {
    	myCube2.rotateDownViewLeft();
    }
    
    public void rotateUpViewRight2 () {
    	myCube2.rotateUpViewRight();
    }
    
    public void rotateDownViewRight2 () {
    	myCube2.rotateDownViewRight();
    }
    
    public void onRotateLeft2 () {
    	this.on_change_horizontal_cube2();
    	for (int i = 0; i < 2; i++) {
    		this.rotateLeftCube2("b1");
    		this.rotateLeftCube2("b3");
    	}
    	this.rotateUpViewLeft2();
    	this.rotateDownViewLeft2();
    }
    
    public void onRotateRight2 () {
    	this.on_change_horizontal_cube2();
    	for (int i = 0; i < 2; i++) {
    		this.rotateRightCube2("b1");
    		this.rotateRightCube2("b3");
    	}
    	this.rotateUpViewRight2();
    	this.rotateDownViewRight2();
    }
    public void rotateRightHalf2 () {
    	myCube2.rotateRightHalf();
    }
    public void rotateLeftHalf2 () {
    	myCube2.rotateLeftHalf();
    }
    public void onRotateUpView2 () {
    	this.on_change_vertical_cube2();
    	for (int i = 0; i < 4; i++) {
    		this.rotateUpCube2("a1");
    		this.rotateUpCube2("a2");
    	}
    	this.rotateRightHalf2();
    	this.rotateLeftHalf2();
    	this.onRotateRight2();
    }
    
    public void on_change_vertical_left(){
    	myCube.a.setAdj(myCube.c, myCube.f, myCube.d, myCube.b); // white
    	myCube.b.setAdj(myCube.f, myCube.c, myCube.e, myCube.a); // red
    	myCube.c.setAdj(myCube.e, myCube.a, myCube.d, myCube.b); // blue
    	myCube.d.setAdj(myCube.f, myCube.c, myCube.a, myCube.e); // orange
    	myCube.e.setAdj(myCube.f, myCube.c, myCube.d, myCube.b); // yellow
    	myCube.f.setAdj(myCube.a, myCube.e, myCube.d, myCube.b); // green    	
    }

    public void on_change_horizontal(){
        myCube.a.setAdj(myCube.f, myCube.c, myCube.b, myCube.d); // white
        myCube.b.setAdj(myCube.f, myCube.c, myCube.e, myCube.a); // red
        myCube.c.setAdj(myCube.b, myCube.d, myCube.e, myCube.a); // blue
        myCube.d.setAdj(myCube.c, myCube.f, myCube.a, myCube.e); // orange
        myCube.e.setAdj(myCube.c, myCube.f, myCube.d, myCube.b); // yellow
        myCube.f.setAdj(myCube.d, myCube.b, myCube.e, myCube.a); // green
    }
    
    public void on_change_vertical_cube2(){
		myCube2.a1.setAdj(myCube2.c1, myCube2.a3, myCube2.d2, myCube2.a2); // white
		myCube2.a2.setAdj(myCube2.c3, myCube2.a4, myCube2.a1, myCube2.b1); // white
		myCube2.a3.setAdj(myCube2.a1, myCube2.f1, myCube2.d4, myCube2.a4); // white
		myCube2.a4.setAdj(myCube2.a2, myCube2.f3, myCube2.a3, myCube2.b3); // white
		
		myCube2.b1.setAdj(myCube2.c3, myCube2.b3, myCube2.a2, myCube2.b2); // red
		myCube2.b2.setAdj(myCube2.c4, myCube2.b4, myCube2.b1, myCube2.e1); // red
		myCube2.b3.setAdj(myCube2.b1, myCube2.f3, myCube2.a4, myCube2.b4); // red
		myCube2.b4.setAdj(myCube2.b2, myCube2.f4, myCube2.b3, myCube2.e3); // red
		
		myCube2.c1.setAdj(myCube2.c2, myCube2.a1, myCube2.a1, myCube2.c2); // blue
		myCube2.c2.setAdj(myCube2.e2, myCube2.c1, myCube2.c1, myCube2.e2); // blue
		myCube2.c3.setAdj(myCube2.c4, myCube2.a2, myCube2.a2, myCube2.c4); // blue
		myCube2.c4.setAdj(myCube2.e1, myCube2.c3, myCube2.c3, myCube2.e1); // blue

		myCube2.d1.setAdj(myCube2.d3, myCube2.c2, myCube2.e2, myCube2.d2); // orange
		myCube2.d2.setAdj(myCube2.d4, myCube2.c1, myCube2.d1, myCube2.a1); // orange
		myCube2.d3.setAdj(myCube2.f2, myCube2.d1, myCube2.e4, myCube2.d4); // orange
		myCube2.d4.setAdj(myCube2.f1, myCube2.d2, myCube2.d3, myCube2.a3); // orange
		
		myCube2.e1.setAdj(myCube2.e3, myCube2.c4, myCube2.b2, myCube2.e2); // yellow
		myCube2.e2.setAdj(myCube2.e4, myCube2.c2, myCube2.e1, myCube2.d1); // yellow
		myCube2.e3.setAdj(myCube2.f4, myCube2.e1, myCube2.b4, myCube2.e4); // yellow
		myCube2.e4.setAdj(myCube2.f2, myCube2.e2, myCube2.e3, myCube2.d3); // yellow

		myCube2.f1.setAdj(myCube2.a3, myCube2.f2, myCube2.f2, myCube2.a3); // green
		myCube2.f2.setAdj(myCube2.f1, myCube2.e4, myCube2.e4, myCube2.f1); // green
		myCube2.f3.setAdj(myCube2.a4, myCube2.f4, myCube2.f4, myCube2.a4); // green
		myCube2.f4.setAdj(myCube2.f3, myCube2.e3, myCube2.e3, myCube2.f3); // green	
    }

    public void on_change_horizontal_cube2(){
		myCube2.a1.setAdj(myCube2.c1, myCube2.a3, myCube2.d2, myCube2.a2); // white
		myCube2.a2.setAdj(myCube2.c3, myCube2.a4, myCube2.a1, myCube2.b1); // white
		myCube2.a3.setAdj(myCube2.a1, myCube2.f1, myCube2.d4, myCube2.a4); // white
		myCube2.a4.setAdj(myCube2.a2, myCube2.f3, myCube2.a3, myCube2.b3); // white
		
		myCube2.b1.setAdj(myCube2.c3, myCube2.b3, myCube2.a2, myCube2.b2); // red
		myCube2.b2.setAdj(myCube2.c4, myCube2.b4, myCube2.b1, myCube2.e1); // red
		myCube2.b3.setAdj(myCube2.b1, myCube2.f3, myCube2.a4, myCube2.b4); // red
		myCube2.b4.setAdj(myCube2.b2, myCube2.f4, myCube2.b3, myCube2.e3); // red
		
		myCube2.c1.setAdj(myCube2.d2, myCube2.c3, myCube2.a1, myCube2.c2); // blue
		myCube2.c2.setAdj(myCube2.d1, myCube2.c4, myCube2.c1, myCube2.e2); // blue
		myCube2.c3.setAdj(myCube2.c1, myCube2.b1, myCube2.a2, myCube2.c4); // blue
		myCube2.c4.setAdj(myCube2.c2, myCube2.b2, myCube2.c3, myCube2.e1); // blue

		myCube2.d1.setAdj(myCube2.d3, myCube2.c2, myCube2.e2, myCube2.d2); // orange
		myCube2.d2.setAdj(myCube2.d4, myCube2.c1, myCube2.d1, myCube2.a1); // orange
		myCube2.d3.setAdj(myCube2.f2, myCube2.d1, myCube2.e4, myCube2.d4); // orange
		myCube2.d4.setAdj(myCube2.f1, myCube2.d2, myCube2.d3, myCube2.a3); // orange
		
		myCube2.e1.setAdj(myCube2.e3, myCube2.c4, myCube2.b2, myCube2.e2); // yellow
		myCube2.e2.setAdj(myCube2.e4, myCube2.c2, myCube2.e1, myCube2.d1); // yellow
		myCube2.e3.setAdj(myCube2.f4, myCube2.e1, myCube2.b4, myCube2.e4); // yellow
		myCube2.e4.setAdj(myCube2.f2, myCube2.e2, myCube2.e3, myCube2.d3); // yellow

		myCube2.f1.setAdj(myCube2.f3, myCube2.d4, myCube2.f2, myCube2.a3); // green
		myCube2.f2.setAdj(myCube2.f4, myCube2.d3, myCube2.e4, myCube2.f1); // green
		myCube2.f3.setAdj(myCube2.b3, myCube2.f1, myCube2.f4, myCube2.a4); // green
		myCube2.f4.setAdj(myCube2.b4, myCube2.f2, myCube2.e3, myCube2.f3); // green
    }

}