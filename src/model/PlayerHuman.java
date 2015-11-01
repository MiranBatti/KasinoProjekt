package model;

import java.util.ArrayList;

/**
 * Player for user.
 * 
 * @author miranbatti, jonasoster
 */
public class PlayerHuman extends Player {
	private Table table;

	/**
	 * Give a list with cards and the table the game uses.
	 * @param cards
	 * @param table
	 */
	public PlayerHuman(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	/**
	 * Lay a card on table and takes point cards if possible.
	 * @param card
	 */
	public void cardOnTable(Card card) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).toString().equals(card.toString())) {
				pointsCards.addAll(table.addCard(cards.get(i), false));
				cards.remove(i);
			}
		}
	}
}
