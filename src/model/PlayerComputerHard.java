package model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerComputerHard extends Player {
	private Table table;

	public PlayerComputerHard(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	public Card cardOnTable() {
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
		cards.remove(index);
		
		return cards.get(index);
	}

}
