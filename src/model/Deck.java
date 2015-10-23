package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;

	public Deck () {
		this.deck = new ArrayList<Card>();
	    for (CardValue card : CardValue.values()) {
	    	for (Suit suit : Suit.values()) {
				deck.add(new Card(card, suit));
			}
	    }
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	/**
	 * Returns deck with Cards
	 * @return ArrayList
	 */
	public ArrayList<Card> getCards() {
		return deck;
	}
	
}
