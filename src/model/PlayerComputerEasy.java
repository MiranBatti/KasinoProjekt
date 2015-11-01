package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Easy player to play against.
 */
public class PlayerComputerEasy extends Player implements CardOnTableComputer {
	private Table table;

	/**
	 * Give a list with cards and the table the game uses.
	 * @param cards
	 * @param table
	 */
	public PlayerComputerEasy(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	/**
	 * Lay a random card on table.
	 */
	public void cardOnTable() {
		Random rnd = new Random();
		int rndInt = 0;
		
		if (cards.size() > 0) {
			rnd.nextInt(cards.size());
			Card rndCard = cards.get(rndInt);
			pointsCards.addAll(table.addCard(rndCard, false));
			cards.remove(rndInt);
		}
	}
}
