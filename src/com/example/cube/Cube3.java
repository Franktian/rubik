package com.example.cube;

public class Cube3 {
	public Face3 front1 = new Face3();
	public Face3 back1 = new Face3();
	public Face3 left1 = new Face3();
	public Face3 right1 = new Face3();
	public Face3 up1 = new Face3();
	public Face3 down1 = new Face3();

	public Face3 front2 = new Face3();
	public Face3 back2 = new Face3();
	public Face3 left2 = new Face3();
	public Face3 right2 = new Face3();
	public Face3 up2 = new Face3();
	public Face3 down2 = new Face3();

	public Face3 front3 = new Face3();
	public Face3 back3 = new Face3();
	public Face3 left3 = new Face3();
	public Face3 right3 = new Face3();
	public Face3 up3 = new Face3();
	public Face3 down3 = new Face3();

	public Face3 front4 = new Face3();
	public Face3 back4 = new Face3();
	public Face3 left4 = new Face3();
	public Face3 right4 = new Face3();
	public Face3 up4 = new Face3();
	public Face3 down4 = new Face3();

	public Face3 front5 = new Face3();
	public Face3 back5 = new Face3();
	public Face3 left5 = new Face3();
	public Face3 right5 = new Face3();
	public Face3 up5 = new Face3();
	public Face3 down5 = new Face3();

	public Face3 front6 = new Face3();
	public Face3 back6 = new Face3();
	public Face3 left6 = new Face3();
	public Face3 right6 = new Face3();
	public Face3 up6 = new Face3();
	public Face3 down6 = new Face3();

	public Face3 front7 = new Face3();
	public Face3 back7 = new Face3();
	public Face3 left7 = new Face3();
	public Face3 right7 = new Face3();
	public Face3 up7 = new Face3();
	public Face3 down7 = new Face3();

	public Face3 front8 = new Face3();
	public Face3 back8 = new Face3();
	public Face3 left8 = new Face3();
	public Face3 right8 = new Face3();
	public Face3 up8 = new Face3();
	public Face3 down8 = new Face3();

	public Face3 front9 = new Face3();
	public Face3 back9 = new Face3();
	public Face3 left9 = new Face3();
	public Face3 right9 = new Face3();
	public Face3 up9 = new Face3();
	public Face3 down9 = new Face3();
	
	public Cube3(){
		
	}
	
	public void initialize(Face3[] face_array){
		this.front1 = face_array[0];
		this.back1 = face_array[1];
		this.left1 = face_array[2];
		this.right1 = face_array[3];
		this.up1 = face_array[4];
		this.down1 = face_array[5];

		this.front2 = face_array[6];
		this.back2 = face_array[7];
		this.left2 = face_array[8];
		this.right2 = face_array[9];
		this.up2 = face_array[10];
		this.down2 = face_array[11];

		this.front3 = face_array[12];
		this.back3 = face_array[13];
		this.left3 = face_array[14];
		this.right3 = face_array[15];
		this.up3 = face_array[16];
		this.down3 = face_array[17];

		this.front4 = face_array[18];
		this.back4 = face_array[19];
		this.left4 = face_array[20];
		this.right4 = face_array[21];
		this.up4 = face_array[22];
		this.down4 = face_array[23];

		this.front5 = face_array[24];
		this.back5 = face_array[25];
		this.left5 = face_array[26];
		this.right5 = face_array[27];
		this.up5 = face_array[28];
		this.down5 = face_array[29];

		this.front6 = face_array[30];
		this.back6 = face_array[31];
		this.left6 = face_array[32];
		this.right6 = face_array[33];
		this.up6 = face_array[34];
		this.down6 = face_array[35];

		this.front7 = face_array[36];
		this.back7 = face_array[37];
		this.left7 = face_array[38];
		this.right7 = face_array[39];
		this.up7 = face_array[40];
		this.down7 = face_array[41];

		this.front8 = face_array[42];
		this.back8 = face_array[43];
		this.left8 = face_array[44];
		this.right8 = face_array[45];
		this.up8 = face_array[46];
		this.down8 = face_array[47];

		this.front9 = face_array[48];
		this.back9 = face_array[49];
		this.left9 = face_array[50];
		this.right9 = face_array[51];
		this.up9 = face_array[52];
		this.down9 = face_array[53];

	}
	
	public void rotateLeft(String faceToRotate){
		if(faceToRotate.equals("right1"))
			this.right1.rotateLeft();
		else if(faceToRotate.equals("right4"))
			this.right4.rotateLeft();
		else if(faceToRotate.equals("right7"))
			this.right7.rotateLeft();
	}
	public void rotateRight(String faceToRotate){
		if(faceToRotate.equals("right1"))
			this.right1.rotateRight();
		else if(faceToRotate.equals("right4"))
			this.right4.rotateRight();
		else if(faceToRotate.equals("right7"))
			this.right7.rotateRight();
		
	}
	
	public void rotateUp(String faceToRotate){
		if(faceToRotate.equals("right1"))
			this.right1.rotateUp();
		else if(faceToRotate.equals("right2"))
			this.right2.rotateUp();
		else if(faceToRotate.equals("right3"))
			this.right3.rotateUp();
		else if(faceToRotate.equals("front1"))
			this.front1.rotateUp();
		else if(faceToRotate.equals("front2"))
			this.front2.rotateUp();
		else if(faceToRotate.equals("front3"))
			this.front3.rotateUp();
	}
	public void rotateDown(String faceToRotate){
		if(faceToRotate.equals("right1"))
			this.right1.rotateDown();
		else if(faceToRotate.equals("right2"))
			this.right2.rotateDown();
		else if(faceToRotate.equals("right3"))
			this.right3.rotateDown();
		else if(faceToRotate.equals("front1"))
			this.front1.rotateDown();
		else if(faceToRotate.equals("front2"))
			this.front2.rotateDown();
		else if(faceToRotate.equals("front3"))
			this.front3.rotateDown();
	}
	
	public void rotateUpViewLeft () {
		String temp1 = this.up1.getColor();
		this.up1.setColor(this.up7.getColor());
		
		String temp2 = this.up2.getColor();
		this.up2.setColor(this.up4.getColor());
		
		String temp3 = this.up3.getColor();
		this.up3.setColor(temp1);
		
		String temp6 = this.up6.getColor();
		this.up6.setColor(temp2);
		
		String temp9 = this.up9.getColor();
		this.up9.setColor(temp3);
		
		String temp8 = this.up8.getColor();
		this.up8.setColor(temp6);
		
		this.up7.setColor(temp9);
		
		this.up4.setColor(temp8);
	}
	
	public void rotateDownViewLeft () {
		String temp1 = this.down1.getColor();
		this.down1.setColor(this.down7.getColor());
		
		String temp2 = this.down2.getColor();
		this.down2.setColor(this.down4.getColor());
		
		String temp3 = this.down3.getColor();
		this.down3.setColor(temp1);
		
		String temp6 = this.down6.getColor();
		this.down6.setColor(temp2);
		
		String temp9 = this.down9.getColor();
		this.down9.setColor(temp3);
		
		String temp8 = this.down8.getColor();
		this.down8.setColor(temp6);
		
		this.down7.setColor(temp9);
		
		this.down4.setColor(temp8);
	}
	
	public void rotateUpViewRight () {
		String temp1 = this.up1.getColor();
		this.up1.setColor(this.up3.getColor());
		
		String temp4 = this.up4.getColor();
		this.up4.setColor(this.up2.getColor());
		
		String temp7 = this.up7.getColor();
		this.up7.setColor(temp1);
		
		String temp8 = this.up8.getColor();
		this.up8.setColor(temp4);
		
		String temp9 = this.up9.getColor();
		this.up9.setColor(temp7);
		
		String temp6 = this.up6.getColor();
		this.up6.setColor(temp8);

		this.up3.setColor(temp9);

		this.up2.setColor(temp6);
	}
	
	public void rotateDownViewRight () {
		String temp1 = this.down1.getColor();
		this.down1.setColor(this.down3.getColor());
		
		String temp4 = this.down4.getColor();
		this.down4.setColor(this.down2.getColor());
		
		String temp7 = this.down7.getColor();
		this.down7.setColor(temp1);
		
		String temp8 = this.down8.getColor();
		this.down8.setColor(temp4);
		
		String temp9 = this.down9.getColor();
		this.down9.setColor(temp7);
		
		String temp6 = this.down6.getColor();
		this.down6.setColor(temp8);

		this.down3.setColor(temp9);

		this.down2.setColor(temp6);
	}

	
	/*
	public static void main(String []args){
		Cube3 cube = new Cube3();

		Face3 front1 = new Face3("front1", "white");
		Face3 front2 = new Face3("front2", "white");
		Face3 front3 = new Face3("front3", "white");
		Face3 front4 = new Face3("front4", "white");
		Face3 front5 = new Face3("front5", "white");
		Face3 front6 = new Face3("front6", "white");
		Face3 front7 = new Face3("front7", "white");
		Face3 front8 = new Face3("front8", "white");
		Face3 front9 = new Face3("front9", "white");

		Face3 back1 = new Face3("back1", "yellow");
		Face3 back2 = new Face3("back2", "yellow");
		Face3 back3 = new Face3("back3", "yellow");
		Face3 back4 = new Face3("back4", "yellow");
		Face3 back5 = new Face3("back5", "yellow");
		Face3 back6 = new Face3("back6", "yellow");
		Face3 back7 = new Face3("back7", "yellow");
		Face3 back8 = new Face3("back8", "yellow");
		Face3 back9 = new Face3("back9", "yellow");

		Face3 left1 = new Face3("left1", "orange");
		Face3 left2 = new Face3("left2", "orange");
		Face3 left3 = new Face3("left3", "orange");
		Face3 left4 = new Face3("left4", "orange");
		Face3 left5 = new Face3("left5", "orange");
		Face3 left6 = new Face3("left6", "orange");
		Face3 left7 = new Face3("left7", "orange");
		Face3 left8 = new Face3("left8", "orange");
		Face3 left9 = new Face3("left9", "orange");

		Face3 right1 = new Face3("right1", "red");
		Face3 right2 = new Face3("right2", "red");
		Face3 right3 = new Face3("right3", "red");
		Face3 right4 = new Face3("right4", "red");
		Face3 right5 = new Face3("right5", "red");
		Face3 right6 = new Face3("right6", "red");
		Face3 right7 = new Face3("right7", "red");
		Face3 right8 = new Face3("right8", "red");
		Face3 right9 = new Face3("right9", "red");

		Face3 up1 = new Face3("up1", "blue");
		Face3 up2 = new Face3("up2", "blue");
		Face3 up3 = new Face3("up3", "blue");
		Face3 up4 = new Face3("up4", "blue");
		Face3 up5 = new Face3("up5", "blue");
		Face3 up6 = new Face3("up6", "blue");
		Face3 up7 = new Face3("up7", "blue");
		Face3 up8 = new Face3("up8", "blue");
		Face3 up9 = new Face3("up9", "blue");

		Face3 down1 = new Face3("down1", "green");
		Face3 down2 = new Face3("down2", "green");
		Face3 down3 = new Face3("down3", "green");
		Face3 down4 = new Face3("down4", "green");
		Face3 down5 = new Face3("down5", "green");
		Face3 down6 = new Face3("down6", "green");
		Face3 down7 = new Face3("down7", "green");
		Face3 down8 = new Face3("down8", "green");
		Face3 down9 = new Face3("down9", "green");

		// Set pointer

		// front
		front1.setAdj(up1, front4, left3, front2);
		front2.setAdj(up4, front5, front1, front3);
		front3.setAdj(up7, front6, front2, right1);
		front4.setAdj(front1, front7, left6, front5);
		front5.setAdj(front2, front8, front4, front6);  // center piece
		front6.setAdj(front3, front9, front5, right4);
		front7.setAdj(front4, down1, left9, front8);
		front8.setAdj(front5, down4, front7, front9);
		front9.setAdj(front6, down7, front8, right7);

		//back
		back1.setAdj(back4, up9, right3, back2);
		back2.setAdj(back5, up6, back1, back3);
		back3.setAdj(back6, up3, back2, left1);
		back4.setAdj(back7, back1, right6, back5);
		back5.setAdj(back8, back2, back4, back6);  // center piece
		back6.setAdj(back9, back3, back5, left4);
		back7.setAdj(down9, back4, right9, back8);
		back8.setAdj(down6, back5, back7, back9);
		back9.setAdj(down3, back6, back8, left7);

		//left
		left1.setAdj(left4, up3, back3, left2);
		left2.setAdj(left5, up2, left1, left3);
		left3.setAdj(left6, up1, left2, front1);
		left4.setAdj(left7, left1, back6, left5);
		left5.setAdj(left8, left2, left4, left6);  // center piece
		left6.setAdj(left9, left3, left5, front4);
		left7.setAdj(down3, left4, back9, left8);
		left8.setAdj(down2, left5, left7, left9);
		left9.setAdj(down1, left6, left8, front7);

		//right
		right1.setAdj(up7, right4, front3, right2);
		right2.setAdj(up8, right5, right1, right3);
		right3.setAdj(up9, right6, right2, back1);
		right4.setAdj(right1, right7, front6, right5);
		right5.setAdj(right2, right8, right4, right6);  // center piece
		right6.setAdj(right3, right9, right5, back4);
		right7.setAdj(right4, down7, front9, right8);
		right8.setAdj(right5, down8, right7, right9);
		right9.setAdj(right6, down9, right8, back7);

		//up
		up1.setAdj(left3, up4, front1, up2);
		up2.setAdj(left2, up5, up1, up3);
		up3.setAdj(left1, up6, up2, back3);
		up4.setAdj(up1, up7, front2, up5);
		up5.setAdj(up2, up8, up4, up6);  // center piece
		up6.setAdj(up3, up9, up5, back2);
		up7.setAdj(up4, right1, front3, up8);
		up8.setAdj(up5, right2, up7, up9);
		up9.setAdj(up6, right3, up8, back1);

		//down
		down1.setAdj(down4, left9, front7, down2);
		down2.setAdj(down5, left8, down1, down3);
		down3.setAdj(down6, left7, down2, back9);
		down4.setAdj(down7, down1, front8, down5);
		down5.setAdj(down8, down2, down4, down6);
		down6.setAdj(down9, down3, down5, back8);
		down7.setAdj(right7, down4, front9, down8);
		down8.setAdj(right8, down5, down7, down9);
		down9.setAdj(right9, down6, down8, back7);

		// reset //vertical
		up1.setAdj(up2, front1, front1, up2);
		up2.setAdj(up3, up1, up1, up3);
		up3.setAdj(back3, up2, up2, back3);
		up4.setAdj(up5, front2, front2, up5);
		up5.setAdj(up6, up4, up4, up6);  // center piece
		up6.setAdj(back2, up5, up5, back2);
		up7.setAdj(up8, front3, front3, up8);
		up8.setAdj(up9, up7, up7, up9);
		up9.setAdj(back1, up8, up8, back1);

		down1.setAdj(front7, down2, front7, down2);
		down2.setAdj(down1, down3, down1, down3);
		down3.setAdj(down2, back9, down2, back9);
		down4.setAdj(front8, down5, front8, down5);
		down5.setAdj(down4, down6, down4, down6);
		down6.setAdj(down5, back8, down5, back8);
		down7.setAdj(front9, down8, front9, down8);
		down8.setAdj(down7, down9, down7, down9);
		down9.setAdj(down8, back7, down8, back7);

		Face3 [] face_array = {
			front1,back1,left1,right1,up1,down1,
			front2,back2,left2,right2,up2,down2,
			front3,back3,left3,right3,up3,down3,
			front4,back4,left4,right4,up4,down4,
			front5,back5,left5,right5,up5,down5,
			front6,back6,left6,right6,up6,down6,
			front7,back7,left7,right7,up7,down7,
			front8,back8,left8,right8,up8,down8,
			front9,back9,left9,right9,up9,down9
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

	}
	*/
}
