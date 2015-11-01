package model;

import java.util.ArrayList;

public class PlayerComputerMedium extends Player implements CardOnTableComputer {
	private Table table;
	private RankCard rankCard;

	public PlayerComputerMedium(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
		rankCard = new RankCard();
	}
	
	public void cardOnTable() {
		int index = 0;

		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			ArrayList<Card> cardsReturned = table.addCard(card, true);
			int rankAllCards = rankCard.rankAll(cardsReturned);
			
			// Takes cards if hand values over 5
			if (rankCard.takeCards(rankAllCards)) {
				index = i;
				break;
			}
		}
		pointsCards = table.addCard(cards.get(index), false);
		cards.remove(index);
	}

}
