package model;

import java.util.ArrayList;

public class Player {
	
	ArrayList<Card> cards;
	
	public Player(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void newCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card) {
		if(card == null){
			throw new NullPointerException("Can't add null card to hand");
		}
		cards.add(card);
	}
	
	public Card cardOnTable(int index) {
		Card card = cards.get(index);
		//skapa en checker som kollar om kortet kan gå ut
		//
		cards.remove(index);
		return card;
	}
	
	public ArrayList<Card> showHand() {
		return cards;
	}
}
