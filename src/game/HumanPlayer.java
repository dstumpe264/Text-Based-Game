package game;

public class HumanPlayer extends GameCharacter {
	protected int winTally = 0;
	

	public HumanPlayer() {
		
	}

	public HumanPlayer(String name) {
		super(name);
		this.winTally = 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HumanPlayer [name=");
		builder.append(name);
		builder.append(", diceTotal=");
		builder.append(diceTotal);
		builder.append("]");
		return builder.toString();
	}
	
	public void checkWinTally() {
		if(this.winTally == 3) {
			System.out.println(this.name + " is the winner!!!");
			System.out.println("You have won an all inclusive entry as a contestant of \"The Biggest Loser\". "
					+ "\nCongratulations now go lose all that weight you just gained.");
			System.out.print("Play Again?? ");
			System.exit('n');;
			
		} 
	}
	

}
