package ganzebord;

public class Player {
	private int position = 0;
	private int lastThrow = 0;

	public void moveThrow() {
		this.position += this.lastThrow; 
	}

	public int getPosition() {
		return position;		
	}
	
	public void setLastThrow(int lastThrow) {
		this.lastThrow = lastThrow;
	}
	
	public int getLastThrow() {
		return lastThrow;
	}
}
