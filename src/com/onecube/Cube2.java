package com.onecube;
import java.util.*;
public class Cube2 {
	public Face3 a1 = new Face3();
	public Face3 b1 = new Face3();
	public Face3 c1 = new Face3();
	public Face3 d1 = new Face3();
	public Face3 e1 = new Face3();
	public Face3 f1 = new Face3();

	public Face3 a2 = new Face3();
	public Face3 b2 = new Face3();
	public Face3 c2 = new Face3();
	public Face3 d2 = new Face3();
	public Face3 e2 = new Face3();
	public Face3 f2 = new Face3();

	public Face3 a3 = new Face3();
	public Face3 b3 = new Face3();
	public Face3 c3 = new Face3();
	public Face3 d3 = new Face3();
	public Face3 e3 = new Face3();
	public Face3 f3 = new Face3();	

	public Face3 a4 = new Face3();
	public Face3 b4 = new Face3();
	public Face3 c4 = new Face3();
	public Face3 d4 = new Face3();
	public Face3 e4 = new Face3();
	public Face3 f4 = new Face3();	
	
	public Cube2(){
		
	}
	
	public void initialize(Face3[] face_array){
		this.a1 = face_array[0];
		this.b1 = face_array[1];
		this.c1 = face_array[2];
		this.d1 = face_array[3];
		this.e1 = face_array[4];
		this.f1 = face_array[5];

		this.a2 = face_array[6];
		this.b2 = face_array[7];
		this.c2 = face_array[8];
		this.d2 = face_array[9];
		this.e2 = face_array[10];
		this.f2 = face_array[11];

		this.a3 = face_array[12];
		this.b3 = face_array[13];
		this.c3 = face_array[14];
		this.d3 = face_array[15];
		this.e3 = face_array[16];
		this.f3 = face_array[17];

		this.a4 = face_array[18];
		this.b4 = face_array[19];
		this.c4 = face_array[20];
		this.d4 = face_array[21];
		this.e4 = face_array[22];
		this.f4 = face_array[23];

	}
	
	public void verticalrandom(int count){
		if(count<=0){
			return;
		}else{
			int index = (int) Math.floor(Math.random()*4);
			switch(index){
			case 0:
				this.rotateUp("a1");
				break;
			case 1:
				this.rotateUp("a2");
				break;
			case 2:
				this.rotateDown("a1");
				break;
			case 3:
				this.rotateDown("a2");
				break;
			}
			verticalrandom(--count);
		}		
	}
	public void horizontalrandom(int count){
		if(count<=0){
			return;
		}else{
			int index = (int) Math.floor(Math.random()*8);
			switch(index){
			case 0:
				this.rotateLeft("b1");
				break;
			case 1:
				this.rotateLeft("b3");
				break;
			case 2:
				this.rotateRight("b1");
				break;
			case 3:
				this.rotateRight("b3");
				break;
			case 4:
				this.rotateUp("b1");
				break;
			case 5:
				this.rotateUp("b2");
				break;
			case 6:
				this.rotateDown("b1");
				break;
			case 7:
				this.rotateDown("b2");
				break;
			}
			horizontalrandom(--count);
		}		
	}
	
	public void rotateLeft(String faceToRotate){
		if(faceToRotate.equals("b3"))
			this.b3.rotateLeft();
		else if(faceToRotate.equals("b1"))
			this.b1.rotateLeft();
	}
	public void rotateRight(String faceToRotate){
		if(faceToRotate.equals("b3"))
			this.b3.rotateRight();		
		else if(faceToRotate.equals("b1"))
			this.b1.rotateRight();	
	}
	
	public void rotateUp(String faceToRotate){
		if(faceToRotate.equals("a1"))
			this.a1.rotateUp();
		else if(faceToRotate.equals("b1"))
			this.b1.rotateUp();
		else if(faceToRotate.equals("b2"))
			this.b2.rotateUp();
		else if(faceToRotate.equals("a2"))
			this.a2.rotateUp();
	}
	public void rotateDown(String faceToRotate){
		if(faceToRotate.equals("a1"))
			this.a1.rotateDown();
		else if(faceToRotate.equals("b1"))
			this.b1.rotateDown();	
		else if(faceToRotate.equals("b2"))
			this.b2.rotateDown();	
		else if(faceToRotate.equals("a2"))
			this.a2.rotateDown();
	}
	public void rotateUpViewLeft () {
		String temp1 = this.c1.getColor();
		this.c1.setColor(this.c3.getColor());
		
		String temp2 = this.c2.getColor();
		this.c2.setColor(temp1);
		
		String temp4 = this.c4.getColor();
		this.c4.setColor(temp2);
		
		this.c3.setColor(temp4);
	}
	public void rotateDownViewLeft () {
		String temp1 = this.f1.getColor();
		this.f1.setColor(this.f3.getColor());
		
		String temp2 = this.f2.getColor();
		this.f2.setColor(temp1);
		
		String temp4 = this.f4.getColor();
		this.f4.setColor(temp2);
		
		this.f3.setColor(temp4);
	}
	public void rotateUpViewRight () {
		String temp1 = this.c1.getColor();
		this.c1.setColor(this.c2.getColor());
		
		String temp3 = this.c3.getColor();
		this.c3.setColor(temp1);
		
		String temp4 = this.c4.getColor();
		this.c4.setColor(temp3);
		
		this.c2.setColor(temp4);
	}
	public void rotateDownViewRight () {
		String temp1 = this.f1.getColor();
		this.f1.setColor(this.f2.getColor());
		
		String temp3 = this.f3.getColor();
		this.f3.setColor(temp1);
		
		String temp4 = this.f4.getColor();
		this.f4.setColor(temp3);
		
		this.f2.setColor(temp4);
	}
	public void rotateLeftHalf () {
		String temp1 = this.b1.getColor();
		this.b1.setColor(this.b4.getColor());
		
		String temp2 = this.b2.getColor();
		this.b2.setColor(this.b3.getColor());
		
		this.b4.setColor(temp1);
		
		this.b3.setColor(temp2);
	}
	public void rotateRightHalf () {
		String temp1 = this.d1.getColor();
		this.d1.setColor(this.d4.getColor());
		
		String temp2 = this.d2.getColor();
		this.d2.setColor(this.d3.getColor());
		
		this.d4.setColor(temp1);
		
		this.d3.setColor(temp2);
	}

}

