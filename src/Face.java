
public class Face {

	private String color;
	private Face up;
	private Face down;
	private Face left;
	private Face right;
	private String id;
	public Face(){
		this.id = null;
		this.color = null;
		
	}
	public Face(String id,String color){
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
	public Face getLeft(){
		return this.left;
	}
	public Face getRight(){
		return this.right;
	}
	public Face getDown(){
		return this.down;
	}
	public Face getUp(){
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
		Face current = this;
		do{			
			current.setColor(current.getRight().getColor());
			current = current.getRight();
		}while(current.getID() != originID);
		current.getLeft().setColor(temp);
	}
	public void rotateRight(){
		String temp = this.color;
		String originID = this.id;
		Face current = this;
		do{
			current.setColor(current.getLeft().getColor());
			current = current.getLeft();
		}while(current.id != originID);
		current.getRight().setColor(temp);
	}
	public void rotateUp(){
		String temp = this.color;
		String originID = this.id;
		Face current = this;
		do{
			current.setColor(current.getDown().getColor());
			current = current.getDown();
		}while(current.id != originID);
		current.getUp().setColor(temp);
	}
	public void rotateDown(){
		String temp = this.color;
		String originID = this.id;
		Face current = this;
		do{
			current.setColor(current.getUp().getColor());
			current = current.getUp();
		}while(current.id != originID);
		current.getDown().setColor(temp);
	}
	
	public void setAdj(Face up, Face down, Face left, Face right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
}
