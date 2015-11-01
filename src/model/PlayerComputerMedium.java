package model;

import java.util.ArrayList;

public class PlayerComputerMedium extends Player implements CardOnTableComputer {
	private Table table;

	public PlayerComputerMedium(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	public void cardOnTable() {
		int index = 0;

		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			ArrayList<Card> cardsReturned = table.addCard(card, true);
			int rankAllCards = RankCard.rankAll(cardsReturned);
			
			if (rankAllCards > 0) {
				index = i;
				break;
			}
		}
		pointsCards = table.addCard(cards.get(index), false);
		cards.remove(index);
	}

}
