package com.onecube;

public class Face3 {

	private String color;
	private Face3 up;
	private Face3 down;
	private Face3 left;
	private Face3 right;
	private String id;

	public Face3(){
		this.id = null;
		this.color = null;
		
	}

	public Face3(String id,String color){
		this.id = id;
		this.color = color;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
	}

	public String getID(){
		return this.id;		
	}
	public Face3 getLeft(){
		return this.left;
	}
	public Face3 getRight(){
		return this.right;
	}
	public Face3 getDown(){
		return this.down;
	}
	public Face3 getUp(){
		return this.up;
	}
	public void setColor(String newcolor){
		this.color = newcolor;
	}
	public String getColor(){
		return this.color;
	}
	public void rotateLeft(){
		String temp = this.getColor();
		String originID = this.getID();
		Face3 current = this;
		do {			
			current.setColor(current.getRight().getColor());
			current = current.getRight();
		} while(current.getID() != originID);
		current.getLeft().setColor(temp);
	}
	public void rotateRight(){
		String temp = this.color;
		String originID = this.id;
		Face3 current = this;
		do {
			current.setColor(current.getLeft().getColor());
			current = current.getLeft();
			System.out.println(current.getID());
		} while(current.id != originID);
		current.getRight().setColor(temp);
	}
	public void rotateUp(){
		String temp = this.color;
		String originID = this.id;
		Face3 current = this;
		do {
			current.setColor(current.getDown().getColor());
			current = current.getDown();
		} while(current.id != originID);
		current.getUp().setColor(temp);
	}

	public void rotateDown(){
		String temp = this.color;
		String originID = this.id;
		Face3 current = this;
		do {
			current.setColor(current.getUp().getColor());
			current = current.getUp();
		} while(current.id != originID);
		current.getDown().setColor(temp);
	}

	public void setAdj(Face3 up, Face3 down, Face3 left, Face3 right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
}
