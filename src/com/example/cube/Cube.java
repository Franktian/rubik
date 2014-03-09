package com.example.cube;

public class Cube {
	public Face3 a = new Face3();
	public Face3 b = new Face3();
	public Face3 c = new Face3();
	public Face3 d = new Face3();
	public Face3 e = new Face3();
	public Face3 f = new Face3();
	
	public Cube(){
		
	}
	
	public void initialize(Face3 a, Face3 b, Face3 c, Face3 d, Face3 e, Face3 f){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}

	
	public void rotateLeft(char faceToRotate){
		switch(faceToRotate) {
			case 'a':
				this.a.rotateLeft();
				break;
			case 'b':
				this.b.rotateLeft();
				break;
			case 'c':
				this.c.rotateLeft();
				break;
			case 'd':
				this.d.rotateLeft();
				break;
			case 'e':
				this.e.rotateLeft();
				break;
			case 'f':
				this.f.rotateLeft();
				break;
		}
	}
	public void rotateRight(char faceToRotate){
		switch(faceToRotate) {
			case 'a':
				this.a.rotateRight();
				break;
			case 'b':
				this.b.rotateRight();
				break;
			case 'c':
				this.c.rotateRight();
				break;
			case 'd':
				this.d.rotateRight();
				break;
			case 'e':
				this.e.rotateRight();
				break;
			case 'f':
				this.f.rotateRight();
				break;
		}
	}
	public void rotateUp(char faceToRotate){
		switch(faceToRotate) {
			case 'a':
				this.a.rotateUp();
				break;
			case 'b':
				this.b.rotateUp();
				break;
			case 'c':
				this.c.rotateUp();
				break;
			case 'd':
				this.d.rotateUp();
				break;
			case 'e':
				this.e.rotateUp();
				break;
			case 'f':
				this.f.rotateUp();
				break;
		}
	}	
	public void rotateDown(char faceToRotate){
		switch(faceToRotate) {
			case 'a':
				this.a.rotateDown();
				break;
			case 'b':
				this.b.rotateDown();
				break;
			case 'c':
				this.c.rotateDown();
				break;
			case 'd':
				this.d.rotateDown();
				break;
			case 'e':
				this.e.rotateDown();
				break;
			case 'f':
				this.f.rotateDown();
				break;
		}
	}	
	public void display(){
		System.out.println(this.a.getColor());
		System.out.println(this.b.getColor());
		System.out.println(this.c.getColor());
		System.out.println(this.d.getColor());
		System.out.println(this.e.getColor());
		System.out.println(this.f.getColor());
		
	}
	
	/*
	public static void main(String []args){
		Cube cube = new Cube();
		Face a = new Face("a", "white");
		Face b = new Face("b","red");
		Face c = new Face("c", "blue");
		Face d = new Face("d", "orange");
		Face e = new Face("e", "yellow");
		Face f = new Face("f","green");
		
		
		// This set works for white
		a.setAdj(f, c, b, d); // white
		b.setAdj(f, c, e, a); // red
		c.setAdj(a, e, b, d); // blue
		d.setAdj(f, c, a, e); // orange
		e.setAdj(c, f, d, b); // yellow
		f.setAdj(e, a, b, d); // green
		
		// This set works for red
		a.setAdj(f, c, b, d); // white
		b.setAdj(f, c, e, a); // red
		c.setAdj(b, d, e, a); // blue
		d.setAdj(c, f, a, e); // orange
		e.setAdj(c, f, d, b); // yellow
		f.setAdj(d, b, e, a); // green

		// This set works for green
		a.setAdj(f, c, b, d); // white
		b.setAdj(e, a, c, f); // red
		c.setAdj(a, e, d, b); // blue
		d.setAdj(e, a, f, c); // orange
		e.setAdj(c, f, d, b); // yellow
		f.setAdj(e, a, b, d); // green		
		
		cube.initialize(a, b, c, d, e, f);
		cube.display();
		cube.rotateUp('f');
		System.out.println("**********");
		cube.display();
		cube.rotateDown('f');
		System.out.println("**********");
		cube.display();		
 
		//		System.out.println("Yea");
	}
	*/
}
