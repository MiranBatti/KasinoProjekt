package model;

import java.util.ArrayList;

/**
 * Easy Medium to play against.
 * 
 * @author miranbatti, jonasoster
 */
public class PlayerComputerMedium extends Player implements CardOnTableComputer {
	private Table table;
	private RankCard rankCard;

	/**
	 * Give a list with cards and the table the game uses.
	 * @param cards
	 * @param table
	 */
	public PlayerComputerMedium(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
		rankCard = new RankCard();
	}
	
	/**
	 * Lay the card that gives cards back if possble to computers point cards.
	 */
	public void cardOnTable() {
		int index = 0;

		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			ArrayList<Card> cardsReturned = table.addCard(card, true);
			int rankAllCards = rankCard.rankAll(cardsReturned);
			
			if (rankAllCards > 0) {
				index = i;
				break;
			}
		}
		pointsCards = table.addCard(cards.get(index), false);
		cards.remove(index);
	}
}
