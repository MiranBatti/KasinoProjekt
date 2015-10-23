package test;

import model.*;

public class Test {
	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("Player hand: " + game.showPlayerHand());
		game.getDeck().printAllCards();
	}
}
