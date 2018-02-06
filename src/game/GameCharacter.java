package game;

public abstract class GameCharacter {
	protected String name;
	protected int diceTotal;
	
	//no-args constructor
	public GameCharacter() {
		
	}
	
	public GameCharacter(String name) {
		super();
		this.name = name;
	}
	
	public int rollDice() {
		return (1 + (int)(Math.random()*6));
	}
	public int updateDice(int dice) {
		
		return diceTotal += dice;
	}
	public boolean didIWin() {
		if(diceTotal < 20) {
			return false;
		}
		
		return true;	
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameCharacter [name=");
		builder.append(name);
		builder.append(", diceTotal=");
		builder.append(diceTotal);
		builder.append("]");
		return builder.toString();
	}
	
	


}
