package test;

import model.*;

public class Test {
	public static void main(String[] args) {
		Game game = new Game(2);
		System.out.println("Player hand: " + game.showPlayerHand());
		game.getDeck().printAllCards();
	}
}
