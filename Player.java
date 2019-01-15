package ganzebord;

public class Player {
	private int position = 0;
	private int lastThrow = 0;
	private boolean inPut = false;
	private int turnsToWait = 0;
	private String playerName;
	
	public Player(int i) {
		playerName = "Player " + (i + 1); 
	}
	
	public String getName() {
		return playerName;
	}

	public int getTurnsToWait() {
		return turnsToWait;
	}
	
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

	public void setPosition(int newPosition) {
		this.position = newPosition;
	}

	public void waitTurn(int i) {
		this.turnsToWait = i;	
	}

	public void waitTurn() {
		this.turnsToWait -= 1;
	}

	public void setInPut() {
		this.inPut = true;
	}
	
	public boolean isInPut() {
		return inPut;
	}

	public void uitPut() {
		this.inPut = false;
		
	}
}
