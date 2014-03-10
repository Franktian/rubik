package com.example.cube;
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
		
		String temp3 = this.c3.getColor();
		this.c3.setColor(temp2);
		
		this.c4.setColor(temp3);
	}
	public void rotateDownViewLeft () {
		String temp1 = this.f1.getColor();
		this.f1.setColor(this.f3.getColor());
		
		String temp2 = this.f2.getColor();
		this.f2.setColor(temp1);
		
		String temp3 = this.f3.getColor();
		this.f3.setColor(temp2);
		
		this.f4.setColor(temp3);
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
	public void random () {
		Random generator = new Random();
		
		int random = generator.nextInt(3);
		switch (random) {
		case 0:
			// up
			for (int i = 0; i < 2; i++) {
				this.a1.rotateUp();
			}
			break;
		case 1:
			//down
			for (int i = 0; i < 2; i++) {
				this.a1.rotateDown();
			}
			break;
		case 2:
			// left
			for (int i = 0; i < 2; i++) {
				this.a1.rotateLeft();
			}
			break;
		case 3:
			// right
			for (int i = 0; i < 2; i++) {
				this.a1.rotateRight();
			}
			break;
		}
		
		random = generator.nextInt(3);
		switch (random) {
		case 0:
			// up
			for (int i = 0; i < 2; i++) {
				this.a2.rotateUp();
			}
			break;
		case 1:
			//down
			for (int i = 0; i < 2; i++) {
				this.a2.rotateDown();
			}
			break;
		case 2:
			// left
			for (int i = 0; i < 2; i++) {
				this.a2.rotateLeft();
			}
			break;
		case 3:
			// right
			for (int i = 0; i < 2; i++) {
				this.a2.rotateRight();
			}
			break;
		}
		
		random = generator.nextInt(3);
		switch (random) {
		case 0:
			// up
			for (int i = 0; i < 2; i++) {
				this.a3.rotateUp();
			}
			break;
		case 1:
			//down
			for (int i = 0; i < 2; i++) {
				this.a3.rotateDown();
			}
			break;
		case 2:
			// left
			for (int i = 0; i < 2; i++) {
				this.a3.rotateLeft();
			}
			break;
		case 3:
			// right
			for (int i = 0; i < 2; i++) {
				this.a3.rotateRight();
			}
			break;
		}
		
		random = generator.nextInt(3);
		switch (random) {
		case 0:
			// up
			for (int i = 0; i < 2; i++) {
				this.a4.rotateUp();
			}
			break;
		case 1:
			//down
			for (int i = 0; i < 2; i++) {
				this.a4.rotateDown();
			}
			break;
		case 2:
			// left
			for (int i = 0; i < 2; i++) {
				this.a4.rotateLeft();
			}
			break;
		case 3:
			// right
			for (int i = 0; i < 2; i++) {
				this.a4.rotateRight();
			}
			break;
		}
	}
	/*

	public void display(){
		System.out.println("a");
		System.out.print(this.a1.getColor() + "  ");
		System.out.println(this.a2.getColor());
		System.out.print(this.a3.getColor() + "  ");
		System.out.println(this.a4.getColor());
		System.out.println("=======================");		

		System.out.println("b");
		System.out.print(this.b1.getColor() + "  ");
		System.out.println(this.b2.getColor());
		System.out.print(this.b3.getColor() + "  ");
		System.out.println(this.b4.getColor());
		System.out.println("=======================");	

		System.out.println("c");
		System.out.print(this.c1.getColor() + "  ");
		System.out.println(this.c2.getColor());
		System.out.print(this.c3.getColor() + "  ");
		System.out.println(this.c4.getColor());
		System.out.println("=======================");	
		
		System.out.println("d");
		System.out.print(this.d1.getColor() + "  ");
		System.out.println(this.d2.getColor());
		System.out.print(this.d3.getColor() + "  ");
		System.out.println(this.d4.getColor());
		System.out.println("=======================");	
		
		System.out.println("e");
		System.out.print(this.e1.getColor() + "  ");
		System.out.println(this.e2.getColor());
		System.out.print(this.e3.getColor() + "  ");
		System.out.println(this.e4.getColor());
		System.out.println("=======================");	
		
		System.out.println("f");
		System.out.print(this.f1.getColor() + "  ");
		System.out.println(this.f2.getColor());
		System.out.print(this.f3.getColor() + "  ");
		System.out.println(this.f4.getColor());
		System.out.println("=======================");			
	}
	
	public static void main(String []args){
		Cube2 cube = new Cube2();
		Face a1 = new Face("a1", "white");
		Face a2 = new Face("a2", "white");
		Face a3 = new Face("a3", "white");
		Face a4 = new Face("a4", "white");

		Face b1 = new Face("b1","red");
		Face b2 = new Face("b2","red");
		Face b3 = new Face("b3","red");
		Face b4 = new Face("b4","red");

		Face c1 = new Face("c1", "blue");
		Face c2 = new Face("c2", "blue");
		Face c3 = new Face("c3", "blue");
		Face c4 = new Face("c4", "blue");
		
		Face d1 = new Face("d1", "orange");
		Face d2 = new Face("d2", "orange");
		Face d3 = new Face("d3", "orange");
		Face d4 = new Face("d4", "orange");
		
		Face e1 = new Face("e1", "yellow");
		Face e2 = new Face("e2", "yellow");
		Face e3 = new Face("e3", "yellow");
		Face e4 = new Face("e4", "yellow");

		Face f1 = new Face("f1","green");
		Face f2 = new Face("f2","green");
		Face f3 = new Face("f3","green");
		Face f4 = new Face("f4","green");
		
		
		//Horizontal 
		a1.setAdj(c1, a3, d2, a2); // white
		a2.setAdj(c3, a4, a1, b1); // white
		a3.setAdj(a1, f1, d4, a4); // white
		a4.setAdj(a2, f3, a3, b3); // white
		
		b1.setAdj(c3, b3, a2, b2); // red
		b2.setAdj(c4, b4, b1, e1); // red
		b3.setAdj(b1, f3, a4, b4); // red
		b4.setAdj(b2, f4, b3, e3); // red
		
		c1.setAdj(d2, c3, a1, c2); // blue
		c2.setAdj(d1, c4, c1, e2); // blue
		c3.setAdj(c1, b1, a2, c4); // blue
		c4.setAdj(c2, b2, c3, e1); // blue

		d1.setAdj(d3, c2, e2, d2); // orange
		d2.setAdj(d4, c1, d1, a1); // orange
		d3.setAdj(f2, d1, e4, d4); // orange
		d4.setAdj(f1, d2, d3, a3); // orange
		
		e1.setAdj(e3, c4, b2, e2); // yellow
		e2.setAdj(e4, c2, e1, d1); // yellow
		e3.setAdj(f4, e1, b4, e4); // yellow
		e4.setAdj(f2, e2, e3, d3); // yellow

		f1.setAdj(f3, d4, f2, a3); // green
		f2.setAdj(f4, d3, e4, f1); // green
		f3.setAdj(b3, f1, f4, a4); // green
		f4.setAdj(b4, f2, e3, f3); // green

		
		
		
		//Vertical
		c1.setAdj(c2, a1, a1, c2); // blue
		c2.setAdj(e2, c1, c1, e2); // blue
		c3.setAdj(c4, a2, a2, c4); // blue
		c4.setAdj(e1, c3, c3, e1); // blue

		f1.setAdj(a3, f2, f2, a3); // green
		f2.setAdj(f1, e4, e4, f1); // green
		f3.setAdj(a4, f4, f4, a4); // green
		f4.setAdj(f3, e3, e3, f3); // green		
		
		
		
		Face [] face_array = {
			a1,b1,c1,d1,e1,f1,
			a2,b2,c2,d2,e2,f2,
			a3,b3,c3,d3,e3,f3,
			a4,b4,c4,d4,e4,f4
		};
		
		cube.initialize(face_array);
		
		cube.display();
		cube.rotateUp("aa");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		cube.display();
		cube.rotateDown("aa");
		cube.display();
	
		cube.rotateUp("f");
		System.out.println("**********");
		cube.display();
		cube.rotateDown("f");
		System.out.println("**********");
		cube.display();		
		//		System.out.println("Yea");
	}

	*/
}

