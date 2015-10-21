package model;

import java.util.ArrayList;

public class Table {
	
	ArrayList<Card> cards;
	
	public Table(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public ArrayList<Card> addCard(int cardValuePlayer) {
		
		ArrayList<Card> returnCards = new ArrayList<Card>();
		
		for (int i = 0; i < 0; i++) {
			int cardValueDeck = 1;//cards.get(i).getCardValue();
			
			if (cardValuePlayer < cardValueDeck) {
				for(int j = 0; j < 0; i++) {
					
				}
			}
			
			
			if (cardValueDeck == 14) {
			}
		}
		
		return null;
	}
}

