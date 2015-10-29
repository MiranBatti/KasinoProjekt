package model;

import java.util.ArrayList;

public class PlayerHuman extends Player {

	public PlayerHuman(ArrayList<Card> cards) {
		super(cards);
	}
	
	public Card cardOnTable(int index) {
		Card card = cards.get(index);
		cards.remove(index);
		return card;
	}

}
