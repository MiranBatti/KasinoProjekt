package model;

import java.util.ArrayList;

/**
 * Hard player to play against.
 */
public class PlayerComputerHard extends Player implements CardOnTableComputer {
	private Table table;
	private RankCard rankCard;

	/**
	 * Give a list with cards and the table the game uses.
	 * @param cards
	 * @param table
	 */
	public PlayerComputerHard(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
		rankCard = new RankCard();
	}
	
	/**
	 * Lay the card that gives most valuable cards to computers point cards.
	 */
	public void cardOnTable() {
		int hegiestRanked = 0;
		int hegiestIndex = 0;
		
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			ArrayList<Card> cardsReturned = table.addCard(card, true);
			int rankAllCards = rankCard.rankAll(cardsReturned);
			
			if (rankAllCards > hegiestRanked) {
				hegiestIndex = i;
				hegiestRanked = rankAllCards;
			}
		}
		pointsCards = table.addCard(cards.get(hegiestIndex), false);
		cards.remove(hegiestIndex);
	}
}
