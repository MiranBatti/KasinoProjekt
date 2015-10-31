package model;

import java.util.ArrayList;

public class PlayerComputerMedium extends Player implements CardOnTableComputer {
	private Table table;

	public PlayerComputerMedium(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	public void cardOnTable() {
		int hegiestRanked = 0;
		int hegiestIndex = 0;
		
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			ArrayList<Card> cardsReturned = table.addCard(card, true);
			int rankAllCards = RankCard.rankAll(cardsReturned);
			
			if (rankAllCards > hegiestRanked) {
				hegiestIndex = i;
				hegiestRanked = rankAllCards;
			}
		}
		cards.remove(hegiestIndex);
	}

}
