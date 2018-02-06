package game;

import java.util.Scanner;

public class GameApp {
	Enemies enemies[] = new Enemies[3];
	Scanner sc = new Scanner(System.in);
	HumanPlayer p1;
	String player;

	public static void main(String[] args) {
		// Generate the list of enemies
		GameApp g = new GameApp();
		g.enemyGen();
		g.welcome();
		g.playGame(0);
		g.playGame(1);
		g.playGame(2);
		g.p1.checkWinTally();
		g.playGame(0);
		g.p1.checkWinTally();
		g.playGame(1);
		g.p1.checkWinTally();
		g.playGame(2);
		g.p1.checkWinTally();
		

	}

	// Generate the list of enemies
	public Enemies[] enemyGen() {
		enemies[0] = new Enemies("Robert Brownie JR.", "Brownies");
		enemies[1] = new Enemies("Ho HO dor", "Hostess HoHo's");
		enemies[2] = new Enemies("Count Chocula", "Chocolate Cake");

		return enemies;
	}

	public void welcome() {
		System.out.print("Hello, I'm Baker Bob, What's your name? ");
		player = sc.next();
		p1 = new HumanPlayer(player);
		System.out.println("\nHey " + p1.name + "!!! are you ready for an edible adventure??\n");

		System.out.println("You will be paired with 3 different opponents and enter into an");
		System.out.println("eating competition!\n");
		System.out.println("Players will take turns rolling a die to see how many of those items");
		System.out.println("will be eaten.\n\n");
		System.out.print("Are you ready to begin? (press a 'Y' to continue) ");
		String yesOrNo = sc.next();
		if (yesOrNo.equals("y") || yesOrNo.equals("Y")) {
			System.out.println("\nLet the eat-off begin!!\n");
		} else
			System.out.println("Too Bad, you don't have a choice!!");

	}

	public void playGame(int i) {
		
		p1.diceTotal = 0;
		p1.diceTotal = 0;
		p1.diceTotal = 0;
		p1.diceTotal = 0;
		System.out.println("Your opponent is: " + enemies[i].name);
		

		do {
			System.out.print("Hit 'R' to roll a die. ");
			String rollDice = sc.next();

			int x = p1.rollDice();
			p1.updateDice(x);

			if (p1.didIWin()) {
				System.out.println("\nYou rolled a " + x + ", you ate a total of " + p1.diceTotal + " " + enemies[i].cake + ".");
				System.out.println("\nYou are the winner!!!\n");
				System.out.println("\n---------------------\n");
				p1.winTally += 1;
				 break;

			} else {
				System.out.println("\nYou rolled a " + x + ", you ate a total of " + p1.diceTotal + " " + enemies[i].cake + ".");
			}

			x = enemies[i].rollDice();
			enemies[i].updateDice(x);

			if (enemies[i].didIWin()) {
				System.out.println(enemies[i].name + " rolled a " + x + ", he eats a total of " + enemies[i].diceTotal
						+ " " + enemies[i].cake + ".\n");
				System.out.println(enemies[i].name + " is the winner!!");
				System.out.println("\n---------------------\n");
				break;
			} else {
				System.out.println(enemies[i].name + " rolled a " + x + ", he eats a total of " + enemies[i].diceTotal
						+ " " + enemies[i].cake +".\n");
			}

		} while (p1.didIWin() == false && enemies[i].didIWin() == false);
	}

}
