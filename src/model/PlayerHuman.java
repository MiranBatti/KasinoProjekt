package model;

import java.util.ArrayList;


public class PlayerHuman extends Player {
	private Table table;

	public PlayerHuman(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	public void cardOnTable(Card card) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).toString().equals(card.toString())) {
				pointsCards.addAll(table.addCard(cards.get(i), false));
				cards.remove(i);
			}
		}
	}
}
