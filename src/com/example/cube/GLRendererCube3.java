
package com.example.cube;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

public class GLRendererCube3 implements GLSurfaceView.Renderer {

    private static final String TAG = "GLRendererCube3";

    //Cube 2
    private Square3_Top_One mSquare3_Top_One;
    private Square3_Top_Two mSquare3_Top_Two;
    private Square3_Top_Three mSquare3_Top_Three;
    private Square3_Top_Four mSquare3_Top_Four;
    private Square3_Top_Five mSquare3_Top_Five;
    private Square3_Top_Six mSquare3_Top_Six;
    private Square3_Top_Seven mSquare3_Top_Seven;
    private Square3_Top_Eight mSquare3_Top_Eight;
    private Square3_Top_Nine mSquare3_Top_Nine;

    private Square3_Left_One mSquare3_Left_One;
    private Square3_Left_Two mSquare3_Left_Two;
    private Square3_Left_Three mSquare3_Left_Three;
    private Square3_Left_Four mSquare3_Left_Four;
    private Square3_Left_Five mSquare3_Left_Five;
    private Square3_Left_Six mSquare3_Left_Six;
    private Square3_Left_Seven mSquare3_Left_Seven;
    private Square3_Left_Eight mSquare3_Left_Eight;
    private Square3_Left_Nine mSquare3_Left_Nine;

    private Square3_Right_One mSquare3_Right_One;
    private Square3_Right_Two mSquare3_Right_Two;
    private Square3_Right_Three mSquare3_Right_Three;
    private Square3_Right_Four mSquare3_Right_Four;
    private Square3_Right_Five mSquare3_Right_Five;
    private Square3_Right_Six mSquare3_Right_Six;
    private Square3_Right_Seven mSquare3_Right_Seven;
    private Square3_Right_Eight mSquare3_Right_Eight;
    private Square3_Right_Nine mSquare3_Right_Nine;


    
    // mMVPMatrix is an abbreviation for "Model View Projection Matrix"
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
//    private final float[] mRotationMatrix = new float[16];
    private final float red[] = { 0.769f, 0.118f, 0.227f, 1.0f };
    private final float green[] = { 0.0f, 0.62f, 0.376f, 1.0f };
    private final float blue[] = { 0.0f, 0.318f, 0.729f, 1.0f };
    private final float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    private final float yellow[] = { 1.0f, 0.835f, 0.0f, 1.0f };
    private final float orange[] = { 1.0f, 0.345f, 0.0f, 1.0f };
    public static Cube3 myCube3 = new Cube3();

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
    private float top_five_color[] = null;
    private float left_five_color[] = null;
    private float right_five_color[] = null;      
    private float top_six_color[] = null;
    private float left_six_color[] = null;
    private float right_six_color[] = null;  
    private float top_seven_color[] = null;
    private float left_seven_color[] = null;
    private float right_seven_color[] = null;  
    private float top_eight_color[] = null;
    private float left_eight_color[] = null;
    private float right_eight_color[] = null;  
    private float top_nine_color[] = null;
    private float left_nine_color[] = null;
    private float right_nine_color[] = null;  
    
    @Override
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        // Set the background frame color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        
        mSquare3_Top_One = new Square3_Top_One();
        mSquare3_Top_Two = new Square3_Top_Two();
        mSquare3_Top_Three = new Square3_Top_Three();
        mSquare3_Top_Four = new Square3_Top_Four();
        mSquare3_Top_Five = new Square3_Top_Five();
        mSquare3_Top_Six = new Square3_Top_Six();
        mSquare3_Top_Seven = new Square3_Top_Seven();
        mSquare3_Top_Eight = new Square3_Top_Eight();        
        mSquare3_Top_Nine = new Square3_Top_Nine();        
        
        mSquare3_Left_One = new Square3_Left_One();
        mSquare3_Left_Two = new Square3_Left_Two();
        mSquare3_Left_Three = new Square3_Left_Three();
        mSquare3_Left_Four = new Square3_Left_Four();
        mSquare3_Left_Five = new Square3_Left_Five();
        mSquare3_Left_Six = new Square3_Left_Six();
        mSquare3_Left_Seven = new Square3_Left_Seven();
        mSquare3_Left_Eight = new Square3_Left_Eight();
        mSquare3_Left_Nine = new Square3_Left_Nine();
        
        
        mSquare3_Right_One = new Square3_Right_One();
        mSquare3_Right_Two = new Square3_Right_Two();
        mSquare3_Right_Three = new Square3_Right_Three();
        mSquare3_Right_Four = new Square3_Right_Four();
        mSquare3_Right_Five = new Square3_Right_Five();
        mSquare3_Right_Six = new Square3_Right_Six();
        mSquare3_Right_Seven = new Square3_Right_Seven();
        mSquare3_Right_Eight = new Square3_Right_Eight();        
        mSquare3_Right_Nine = new Square3_Right_Nine();        

        
		myCube3.front1 = new Face3("front1", "white");
		myCube3.front2 = new Face3("front2", "white");
		myCube3.front3 = new Face3("front3", "white");
		myCube3.front4 = new Face3("front4", "white");
		myCube3.front5 = new Face3("front5", "white");
		myCube3.front6 = new Face3("front6", "white");
		myCube3.front7 = new Face3("front7", "white");
		myCube3.front8 = new Face3("front8", "white");
		myCube3.front9 = new Face3("front9", "white");

		myCube3.back1 = new Face3("back1", "yellow");
		myCube3.back2 = new Face3("back2", "yellow");
		myCube3.back3 = new Face3("back3", "yellow");
		myCube3.back4 = new Face3("back4", "yellow");
		myCube3.back5 = new Face3("back5", "yellow");
		myCube3.back6 = new Face3("back6", "yellow");
		myCube3.back7 = new Face3("back7", "yellow");
		myCube3.back8 = new Face3("back8", "yellow");
		myCube3.back9 = new Face3("back9", "yellow");

		myCube3.left1 = new Face3("left1", "orange");
		myCube3.left2 = new Face3("left2", "orange");
		myCube3.left3 = new Face3("left3", "orange");
		myCube3.left4 = new Face3("left4", "orange");
		myCube3.left5 = new Face3("left5", "orange");
		myCube3.left6 = new Face3("left6", "orange");
		myCube3.left7 = new Face3("left7", "orange");
		myCube3.left8 = new Face3("left8", "orange");
		myCube3.left9 = new Face3("left9", "orange");

		myCube3.right1 = new Face3("right1", "red");
		myCube3.right2 = new Face3("right2", "red");
		myCube3.right3 = new Face3("right3", "red");
		myCube3.right4 = new Face3("right4", "red");
		myCube3.right5 = new Face3("right5", "red");
		myCube3.right6 = new Face3("right6", "red");
		myCube3.right7 = new Face3("right7", "red");
		myCube3.right8 = new Face3("right8", "red");
		myCube3.right9 = new Face3("right9", "red");

		myCube3.up1 = new Face3("up1", "blue");
		myCube3.up2 = new Face3("up2", "blue");
		myCube3.up3 = new Face3("up3", "blue");
		myCube3.up4 = new Face3("up4", "blue");
		myCube3.up5 = new Face3("up5", "blue");
		myCube3.up6 = new Face3("up6", "blue");
		myCube3.up7 = new Face3("up7", "blue");
		myCube3.up8 = new Face3("up8", "blue");
		myCube3.up9 = new Face3("up9", "blue");

		myCube3.down1 = new Face3("down1", "green");
		myCube3.down2 = new Face3("down2", "green");
		myCube3.down3 = new Face3("down3", "green");
		myCube3.down4 = new Face3("down4", "green");
		myCube3.down5 = new Face3("down5", "green");
		myCube3.down6 = new Face3("down6", "green");
		myCube3.down7 = new Face3("down7", "green");
		myCube3.down8 = new Face3("down8", "green");
		myCube3.down9 = new Face3("down9", "green");
		
		Face3 [] face_array = {
				myCube3.front1,myCube3.back1,myCube3.left1,myCube3.right1,myCube3.up1,myCube3.down1,
				myCube3.front2,myCube3.back2,myCube3.left2,myCube3.right2,myCube3.up2,myCube3.down2,
				myCube3.front3,myCube3.back3,myCube3.left3,myCube3.right3,myCube3.up3,myCube3.down3,
				myCube3.front4,myCube3.back4,myCube3.left4,myCube3.right4,myCube3.up4,myCube3.down4,
				myCube3.front5,myCube3.back5,myCube3.left5,myCube3.right5,myCube3.up5,myCube3.down5,
				myCube3.front6,myCube3.back6,myCube3.left6,myCube3.right6,myCube3.up6,myCube3.down6,
				myCube3.front7,myCube3.back7,myCube3.left7,myCube3.right7,myCube3.up7,myCube3.down7,
				myCube3.front8,myCube3.back8,myCube3.left8,myCube3.right8,myCube3.up8,myCube3.down8,
				myCube3.front9,myCube3.back9,myCube3.left9,myCube3.right9,myCube3.up9,myCube3.down9
			};
		myCube3.initialize(face_array);
    	on_change_horizontal_cube3();

    }

    @Override
    public void onDrawFrame(GL10 unused) {
        float[] scratch = new float[16];

        
        top_one_color = getColor(myCube3.up1.getColor());
        top_two_color = getColor(myCube3.up2.getColor());
        top_three_color = getColor(myCube3.up3.getColor());
        top_four_color = getColor(myCube3.up4.getColor());
        top_five_color = getColor(myCube3.up5.getColor());
        top_six_color = getColor(myCube3.up6.getColor());
        top_seven_color = getColor(myCube3.up7.getColor());
        top_eight_color = getColor(myCube3.up8.getColor());
        top_nine_color = getColor(myCube3.up9.getColor());

        left_one_color = getColor(myCube3.front1.getColor());//
        left_two_color = getColor(myCube3.front2.getColor());
        left_three_color = getColor(myCube3.front3.getColor());//
        left_four_color = getColor(myCube3.front4.getColor());
        left_five_color = getColor(myCube3.front5.getColor());
        left_six_color = getColor(myCube3.front6.getColor());
        left_seven_color = getColor(myCube3.front7.getColor());
        left_eight_color = getColor(myCube3.front8.getColor());
        left_nine_color = getColor(myCube3.front9.getColor());

        right_one_color = getColor(myCube3.right1.getColor());//
        right_two_color = getColor(myCube3.right2.getColor());
        right_three_color = getColor(myCube3.right3.getColor());//
        right_four_color = getColor(myCube3.right4.getColor());
        right_five_color = getColor(myCube3.right5.getColor());
        right_six_color = getColor(myCube3.right6.getColor());
        right_seven_color = getColor(myCube3.right7.getColor());
        right_eight_color = getColor(myCube3.right8.getColor());
        right_nine_color = getColor(myCube3.right9.getColor());
		
        // Draw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        // Set the camera position (View matrix)
        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        // Calculate the projection and view transformation
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        // Draw square

        mSquare3_Top_Seven.draw(mMVPMatrix, top_seven_color);

      
		mSquare3_Top_One.draw(mMVPMatrix, top_one_color);
		mSquare3_Top_Two.draw(mMVPMatrix, top_two_color);
		mSquare3_Top_Three.draw(mMVPMatrix, top_three_color);
		mSquare3_Top_Four.draw(mMVPMatrix, top_four_color);
        mSquare3_Top_Five.draw(mMVPMatrix, top_five_color);
       
        mSquare3_Top_Six.draw(mMVPMatrix, top_six_color);
        mSquare3_Top_Eight.draw(mMVPMatrix, top_eight_color);
        mSquare3_Top_Nine.draw(mMVPMatrix, top_nine_color);
             
        mSquare3_Left_One.draw(mMVPMatrix, left_one_color);
        mSquare3_Left_Two.draw(mMVPMatrix, left_two_color);
        mSquare3_Left_Three.draw(mMVPMatrix, left_three_color);
        mSquare3_Left_Four.draw(mMVPMatrix, left_four_color);
        mSquare3_Left_Five.draw(mMVPMatrix, left_five_color);
        mSquare3_Left_Six.draw(mMVPMatrix, left_six_color);
        mSquare3_Left_Seven.draw(mMVPMatrix, left_seven_color);
        mSquare3_Left_Eight.draw(mMVPMatrix, left_eight_color);
        mSquare3_Left_Nine.draw(mMVPMatrix, left_nine_color);       
		
        
        mSquare3_Right_One.draw(mMVPMatrix, right_one_color);
        mSquare3_Right_Two.draw(mMVPMatrix, right_two_color);
        mSquare3_Right_Three.draw(mMVPMatrix, right_three_color);
        mSquare3_Right_Four.draw(mMVPMatrix, right_four_color);
        mSquare3_Right_Five.draw(mMVPMatrix, right_five_color);
        mSquare3_Right_Six.draw(mMVPMatrix, right_six_color);
        mSquare3_Right_Seven.draw(mMVPMatrix, right_seven_color);
        mSquare3_Right_Eight.draw(mMVPMatrix, right_eight_color);
        mSquare3_Right_Nine.draw(mMVPMatrix, right_nine_color);     
 		

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
    	top_one_color = color;
    	top_two_color = color;
    	top_three_color = color;
    	top_four_color = color;
    	top_five_color = color;
    	top_six_color = color;
    	top_seven_color = color;
    	top_eight_color = color;
    	top_nine_color = color;
    }

    public void setLeft(float color[]){
    	left_one_color = color;
    	left_two_color = color;
    	left_three_color = color;
    	left_four_color = color;
    	left_five_color = color;
    	left_six_color = color;
    	left_seven_color = color;
    	left_eight_color = color;
    	left_nine_color = color;
    }
    
    public void setRight(float color[]){
    	top_one_color = color;
    	top_two_color = color;
    	top_three_color = color;
    	top_four_color = color;
    	top_five_color = color;
    	top_six_color = color;
    	top_seven_color = color;
    	top_eight_color = color;
    	top_nine_color = color;
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
    
    public void rotateRightHalf3() {
    	myCube3.rotateRightHalf();
    }
    public void rotateLeftHalf3() {
    	myCube3.rotateLeftHalf();
    }
    public void random3 () {
    	myCube3.random();
    }
    public void rotateUpViewLeft3() {
    	myCube3.rotateUpViewLeft();
    }
    public void rotateDownViewLeft3() {
    	myCube3.rotateDownViewLeft();
    }
    public void rotateUpViewRight3() {
    	myCube3.rotateUpViewRight();
    }
    public void rotateDownViewRight3() {
    	myCube3.rotateDownViewRight();
    }
    public void rotateRightCube3(String faceToRotate){
    	myCube3.rotateRight(faceToRotate);
    }

    public void rotateLeftCube3(String faceToRotate){
    	myCube3.rotateLeft(faceToRotate);
    }

    public void rotateUpCube3(String faceToRotate){
    	myCube3.rotateUp(faceToRotate);
    }

    public void rotateDownCube3(String faceToRotate){
    	myCube3.rotateDown(faceToRotate);
    }

    public void on_change_vertical_cube3(){
		// myCube3.front
		myCube3.front1.setAdj(myCube3.up1, myCube3.front4, myCube3.left3, myCube3.front2);
		myCube3.front2.setAdj(myCube3.up4, myCube3.front5, myCube3.front1, myCube3.front3);
		myCube3.front3.setAdj(myCube3.up7, myCube3.front6, myCube3.front2, myCube3.right1);
		myCube3.front4.setAdj(myCube3.front1, myCube3.front7, myCube3.left6, myCube3.front5);
		myCube3.front5.setAdj(myCube3.front2, myCube3.front8, myCube3.front4, myCube3.front6);  // center piece
		myCube3.front6.setAdj(myCube3.front3, myCube3.front9, myCube3.front5, myCube3.right4);
		myCube3.front7.setAdj(myCube3.front4, myCube3.down1, myCube3.left9, myCube3.front8);
		myCube3.front8.setAdj(myCube3.front5, myCube3.down4, myCube3.front7, myCube3.front9);
		myCube3.front9.setAdj(myCube3.front6, myCube3.down7, myCube3.front8, myCube3.right7);

		//myCube3.back
		myCube3.back1.setAdj(myCube3.back4, myCube3.up9, myCube3.right3, myCube3.back2);
		myCube3.back2.setAdj(myCube3.back5, myCube3.up6, myCube3.back1, myCube3.back3);
		myCube3.back3.setAdj(myCube3.back6, myCube3.up3, myCube3.back2, myCube3.left1);
		myCube3.back4.setAdj(myCube3.back7, myCube3.back1, myCube3.right6, myCube3.back5);
		myCube3.back5.setAdj(myCube3.back8, myCube3.back2, myCube3.back4, myCube3.back6);  // center piece
		myCube3.back6.setAdj(myCube3.back9, myCube3.back3, myCube3.back5, myCube3.left4);
		myCube3.back7.setAdj(myCube3.down9, myCube3.back4, myCube3.right9, myCube3.back8);
		myCube3.back8.setAdj(myCube3.down6, myCube3.back5, myCube3.back7, myCube3.back9);
		myCube3.back9.setAdj(myCube3.down3, myCube3.back6, myCube3.back8, myCube3.left7);

		//myCube3.left
		myCube3.left1.setAdj(myCube3.left4, myCube3.up3, myCube3.back3, myCube3.left2);
		myCube3.left2.setAdj(myCube3.left5, myCube3.up2, myCube3.left1, myCube3.left3);
		myCube3.left3.setAdj(myCube3.left6, myCube3.up1, myCube3.left2, myCube3.front1);
		myCube3.left4.setAdj(myCube3.left7, myCube3.left1, myCube3.back6, myCube3.left5);
		myCube3.left5.setAdj(myCube3.left8, myCube3.left2, myCube3.left4, myCube3.left6);  // center piece
		myCube3.left6.setAdj(myCube3.left9, myCube3.left3, myCube3.left5, myCube3.front4);
		myCube3.left7.setAdj(myCube3.down3, myCube3.left4, myCube3.back9, myCube3.left8);
		myCube3.left8.setAdj(myCube3.down2, myCube3.left5, myCube3.left7, myCube3.left9);
		myCube3.left9.setAdj(myCube3.down1, myCube3.left6, myCube3.left8, myCube3.front7);

		//myCube3.right
		myCube3.right1.setAdj(myCube3.up7, myCube3.right4, myCube3.front3, myCube3.right2);
		myCube3.right2.setAdj(myCube3.up8, myCube3.right5, myCube3.right1, myCube3.right3);
		myCube3.right3.setAdj(myCube3.up9, myCube3.right6, myCube3.right2, myCube3.back1);
		myCube3.right4.setAdj(myCube3.right1, myCube3.right7, myCube3.front6, myCube3.right5);
		myCube3.right5.setAdj(myCube3.right2, myCube3.right8, myCube3.right4, myCube3.right6);  // center piece
		myCube3.right6.setAdj(myCube3.right3, myCube3.right9, myCube3.right5, myCube3.back4);
		myCube3.right7.setAdj(myCube3.right4, myCube3.down7, myCube3.front9, myCube3.right8);
		myCube3.right8.setAdj(myCube3.right5, myCube3.down8, myCube3.right7, myCube3.right9);
		myCube3.right9.setAdj(myCube3.right6, myCube3.down9, myCube3.right8, myCube3.back7);

		myCube3.up1.setAdj(myCube3.up2, myCube3.front1, myCube3.front1, myCube3.up2);
		myCube3.up2.setAdj(myCube3.up3, myCube3.up1, myCube3.up1, myCube3.up3);
		myCube3.up3.setAdj(myCube3.back3, myCube3.up2, myCube3.up2, myCube3.back3);
		myCube3.up4.setAdj(myCube3.up5, myCube3.front2, myCube3.front2, myCube3.up5);
		myCube3.up5.setAdj(myCube3.up6, myCube3.up4, myCube3.up4, myCube3.up6);  // center piece
		myCube3.up6.setAdj(myCube3.back2, myCube3.up5, myCube3.up5, myCube3.back2);
		myCube3.up7.setAdj(myCube3.up8, myCube3.front3, myCube3.front3, myCube3.up8);
		myCube3.up8.setAdj(myCube3.up9, myCube3.up7, myCube3.up7, myCube3.up9);
		myCube3.up9.setAdj(myCube3.back1, myCube3.up8, myCube3.up8, myCube3.back1);

		myCube3.down1.setAdj(myCube3.front7, myCube3.down2, myCube3.front7, myCube3.down2);
		myCube3.down2.setAdj(myCube3.down1, myCube3.down3, myCube3.down1, myCube3.down3);
		myCube3.down3.setAdj(myCube3.down2, myCube3.back9, myCube3.down2, myCube3.back9);
		myCube3.down4.setAdj(myCube3.front8, myCube3.down5, myCube3.front8, myCube3.down5);
		myCube3.down5.setAdj(myCube3.down4, myCube3.down6, myCube3.down4, myCube3.down6);
		myCube3.down6.setAdj(myCube3.down5, myCube3.back8, myCube3.down5, myCube3.back8);
		myCube3.down7.setAdj(myCube3.front9, myCube3.down8, myCube3.front9, myCube3.down8);
		myCube3.down8.setAdj(myCube3.down7, myCube3.down9, myCube3.down7, myCube3.down9);
		myCube3.down9.setAdj(myCube3.down8, myCube3.back7, myCube3.down8, myCube3.back7);

    }

    public void on_change_horizontal_cube3(){
		// myCube3.front
		myCube3.front1.setAdj(myCube3.up1, myCube3.front4, myCube3.left3, myCube3.front2);
		myCube3.front2.setAdj(myCube3.up4, myCube3.front5, myCube3.front1, myCube3.front3);
		myCube3.front3.setAdj(myCube3.up7, myCube3.front6, myCube3.front2, myCube3.right1);
		myCube3.front4.setAdj(myCube3.front1, myCube3.front7, myCube3.left6, myCube3.front5);
		myCube3.front5.setAdj(myCube3.front2, myCube3.front8, myCube3.front4, myCube3.front6);  // center piece
		myCube3.front6.setAdj(myCube3.front3, myCube3.front9, myCube3.front5, myCube3.right4);
		myCube3.front7.setAdj(myCube3.front4, myCube3.down1, myCube3.left9, myCube3.front8);
		myCube3.front8.setAdj(myCube3.front5, myCube3.down4, myCube3.front7, myCube3.front9);
		myCube3.front9.setAdj(myCube3.front6, myCube3.down7, myCube3.front8, myCube3.right7);

		//myCube3.back
		myCube3.back1.setAdj(myCube3.back4, myCube3.up9, myCube3.right3, myCube3.back2);
		myCube3.back2.setAdj(myCube3.back5, myCube3.up6, myCube3.back1, myCube3.back3);
		myCube3.back3.setAdj(myCube3.back6, myCube3.up3, myCube3.back2, myCube3.left1);
		myCube3.back4.setAdj(myCube3.back7, myCube3.back1, myCube3.right6, myCube3.back5);
		myCube3.back5.setAdj(myCube3.back8, myCube3.back2, myCube3.back4, myCube3.back6);  // center piece
		myCube3.back6.setAdj(myCube3.back9, myCube3.back3, myCube3.back5, myCube3.left4);
		myCube3.back7.setAdj(myCube3.down9, myCube3.back4, myCube3.right9, myCube3.back8);
		myCube3.back8.setAdj(myCube3.down6, myCube3.back5, myCube3.back7, myCube3.back9);
		myCube3.back9.setAdj(myCube3.down3, myCube3.back6, myCube3.back8, myCube3.left7);

		//myCube3.left
		myCube3.left1.setAdj(myCube3.left4, myCube3.up3, myCube3.back3, myCube3.left2);
		myCube3.left2.setAdj(myCube3.left5, myCube3.up2, myCube3.left1, myCube3.left3);
		myCube3.left3.setAdj(myCube3.left6, myCube3.up1, myCube3.left2, myCube3.front1);
		myCube3.left4.setAdj(myCube3.left7, myCube3.left1, myCube3.back6, myCube3.left5);
		myCube3.left5.setAdj(myCube3.left8, myCube3.left2, myCube3.left4, myCube3.left6);  // center piece
		myCube3.left6.setAdj(myCube3.left9, myCube3.left3, myCube3.left5, myCube3.front4);
		myCube3.left7.setAdj(myCube3.down3, myCube3.left4, myCube3.back9, myCube3.left8);
		myCube3.left8.setAdj(myCube3.down2, myCube3.left5, myCube3.left7, myCube3.left9);
		myCube3.left9.setAdj(myCube3.down1, myCube3.left6, myCube3.left8, myCube3.front7);

		//myCube3.right
		myCube3.right1.setAdj(myCube3.up7, myCube3.right4, myCube3.front3, myCube3.right2);
		myCube3.right2.setAdj(myCube3.up8, myCube3.right5, myCube3.right1, myCube3.right3);
		myCube3.right3.setAdj(myCube3.up9, myCube3.right6, myCube3.right2, myCube3.back1);
		myCube3.right4.setAdj(myCube3.right1, myCube3.right7, myCube3.front6, myCube3.right5);
		myCube3.right5.setAdj(myCube3.right2, myCube3.right8, myCube3.right4, myCube3.right6);  // center piece
		myCube3.right6.setAdj(myCube3.right3, myCube3.right9, myCube3.right5, myCube3.back4);
		myCube3.right7.setAdj(myCube3.right4, myCube3.down7, myCube3.front9, myCube3.right8);
		myCube3.right8.setAdj(myCube3.right5, myCube3.down8, myCube3.right7, myCube3.right9);
		myCube3.right9.setAdj(myCube3.right6, myCube3.down9, myCube3.right8, myCube3.back7);

		//myCube3.up
		myCube3.up1.setAdj(myCube3.left3, myCube3.up4, myCube3.front1, myCube3.up2);
		myCube3.up2.setAdj(myCube3.left2, myCube3.up5, myCube3.up1, myCube3.up3);
		myCube3.up3.setAdj(myCube3.left1, myCube3.up6, myCube3.up2, myCube3.back3);
		myCube3.up4.setAdj(myCube3.up1, myCube3.up7, myCube3.front2, myCube3.up5);
		myCube3.up5.setAdj(myCube3.up2, myCube3.up8, myCube3.up4, myCube3.up6);  // center piece
		myCube3.up6.setAdj(myCube3.up3, myCube3.up9, myCube3.up5, myCube3.back2);
		myCube3.up7.setAdj(myCube3.up4, myCube3.right1, myCube3.front3, myCube3.up8);
		myCube3.up8.setAdj(myCube3.up5, myCube3.right2, myCube3.up7, myCube3.up9);
		myCube3.up9.setAdj(myCube3.up6, myCube3.right3, myCube3.up8, myCube3.back1);

		//myCube3.down
		myCube3.down1.setAdj(myCube3.down4, myCube3.left9, myCube3.front7, myCube3.down2);
		myCube3.down2.setAdj(myCube3.down5, myCube3.left8, myCube3.down1, myCube3.down3);
		myCube3.down3.setAdj(myCube3.down6, myCube3.left7, myCube3.down2, myCube3.back9);
		myCube3.down4.setAdj(myCube3.down7, myCube3.down1, myCube3.front8, myCube3.down5);
		myCube3.down5.setAdj(myCube3.down8, myCube3.down2, myCube3.down4, myCube3.down6);
		myCube3.down6.setAdj(myCube3.down9, myCube3.down3, myCube3.down5, myCube3.back8);
		myCube3.down7.setAdj(myCube3.right7, myCube3.down4, myCube3.front9, myCube3.down8);
		myCube3.down8.setAdj(myCube3.right8, myCube3.down5, myCube3.down7, myCube3.down9);
		myCube3.down9.setAdj(myCube3.right9, myCube3.down6, myCube3.down8, myCube3.back7);

    }

}