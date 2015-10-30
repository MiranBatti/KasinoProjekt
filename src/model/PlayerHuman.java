package model;

import java.util.ArrayList;

public class PlayerHuman extends Player {
	private Table table;

	public PlayerHuman(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	public Card cardOnTable(Card card) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.contains(card)) {
				cards.remove(i);
				cards.addAll(table.addCard(cards.get(i), false));
			}
		}
		return card;
	}

}