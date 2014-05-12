package com.onecube;
import java.util.Stack;

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
	
	public Stack<String[]> moves;
	
	public Cube3(){
		this.moves = new Stack<String[]>();
	}
	
	public void recordMoves (String facdId, String direction) {
		String [] record = {facdId, direction};
		this.moves.push(record);
	}
	public void clear(){
		while (!this.moves.empty()) {
			 this.moves.pop();
		}				
	}
	public String[] getTop () {
		if (!this.moves.empty()) {
			return this.moves.pop();
		}
		return null;
	}
	public void backToPrevious (String[] currentMove) {
		if (currentMove[1].equals("left")) {
			this.rotateRight(currentMove[0]);
			
		} else if (currentMove[1].equals("right")) {
			this.rotateLeft(currentMove[0]);
			
		} else if (currentMove[1].equals("up")) {
			this.rotateDown(currentMove[0]);
			
		} else if (currentMove[1].equals("down")){
			this.rotateUp(currentMove[0]);
		}
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
	
	public void horizontalrandom(int count){
		//rotate left or Right
		// rotate up or down "right"
		if(count<=0){
			return;
		}else{
			int index = (int) Math.floor(Math.random()*12);
			switch(index){
			case 0:
				this.rotateLeft("right1");
				break;
			case 1:
				this.rotateLeft("right4");
				break;
			case 2:
				this.rotateLeft("right7");
				break;
			case 3:
				this.rotateRight("right1");
				break;
			case 4:
				this.rotateRight("right4");
				break;
			case 5:
				this.rotateRight("right7");
				break;
			case 6:
				this.rotateUp("right1");
				break;
			case 7:
				this.rotateUp("right2");
				break;
			case 8:
				this.rotateUp("right3");
				break;
			case 9:
				this.rotateDown("right1");
				break;
			case 10:
				this.rotateDown("right2");
				break;
			case 11:
				this.rotateDown("right3");
				break;
			}
			horizontalrandom(--count);
		}
		
	}
	
	public void verticalrandom(int count){
		if(count<=0){
			return;
		}else{
			int index = (int) Math.floor(Math.random()*12);
			switch(index){
			case 0:
				this.rotateUp("front1");
				break;
			case 1:
				this.rotateUp("front2");
				break;
			case 2:
				this.rotateUp("front3");
				break;
			case 3:
				this.rotateDown("front1");
				break;
			case 4:
				this.rotateDown("front2");
				break;
			case 5:
				this.rotateDown("front3");
				break;
			}
			verticalrandom(--count);
		}
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
	
	public void rotateRightHalf() {
		String temp1 = this.right1.getColor();
		this.right1.setColor(this.right9.getColor());
		
		String temp2 = this.right2.getColor();
		this.right2.setColor(this.right8.getColor());
		
		String temp3 = this.right3.getColor();
		this.right3.setColor(this.right7.getColor());
		
		String temp6 = this.right6.getColor();
		this.right6.setColor(this.right4.getColor());
		
		this.right9.setColor(temp1);
		
		this.right8.setColor(temp2);
		
		this.right7.setColor(temp3);
		
		this.right4.setColor(temp6);
	}
	
	public void rotateLeftHalf() {
		String temp1 = this.left1.getColor();
		this.left1.setColor(this.left9.getColor());
		
		String temp2 = this.left2.getColor();
		this.left2.setColor(this.left8.getColor());
		
		String temp3 = this.left3.getColor();
		this.left3.setColor(this.left7.getColor());
		
		String temp6 = this.left6.getColor();
		this.left6.setColor(this.left4.getColor());
		
		this.left9.setColor(temp1);
		
		this.left8.setColor(temp2);
		
		this.left7.setColor(temp3);
		
		this.left4.setColor(temp6);
	}
}
