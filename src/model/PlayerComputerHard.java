package model;

import java.util.ArrayList;

/**
 * Hard player to play against.
 * 
 * @author miranbatti, jonasoster
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
		int highestRanked = 0;
		int highestIndex = 0;
		
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			ArrayList<Card> cardsReturned = table.addCard(card, true);
			int rankAllCards = rankCard.rankAll(cardsReturned);
			
			if (rankAllCards > highestRanked) {
				highestIndex = i;
				highestRanked = rankAllCards;
			}
		}
		pointsCards = table.addCard(cards.get(highestIndex), false);
		cards.remove(highestIndex);
	}
}
