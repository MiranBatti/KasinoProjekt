package model;

import java.util.ArrayList;

public class PlayerComputerHard extends Player implements CardOnTableComputer {
	private Table table;
	private RankCard rankCard;

	public PlayerComputerHard(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
		rankCard = new RankCard();
	}
	
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
