package model;

import java.util.ArrayList;
import java.util.Random;

public class ComputerSimple {
	
	ArrayList<Card> cards;
	
	public ComputerSimple(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void newCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Card cardOnTable() {
		Random rnd = new Random();
		int rndInt = rnd.nextInt(cards.size() - 1);
		Card rndCard = cards.get(rndInt);
		
		cards.remove(rndInt);
		
		return rndCard;
	}
	
}
