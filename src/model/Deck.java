package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates a deck with 52 cards.
 */
public class Deck {
	private ArrayList<Card> deck;

	/**
	 * Creates a shuffled deck.
	 */
	public Deck () {
		this.deck = new ArrayList<Card>();
		newRound();
	}
	
	/**
	 * Clear and shuffle the when beginning a new round.
	 */
	public void newRound() {
		deck.clear();
		
		for (CardValue card : CardValue.values()) {
	    	for (Suit suit : Suit.values()) {
				deck.add(new Card(card, suit));
			}
	    }
		shuffleDeck();
	}
	
	/**
	 * Shuffles the deck.
	 */
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	/**
	 * Returns deck with Cards.
	 * @return ArrayList
	 */
	public ArrayList<Card> getCards() {
		return deck;
	}
	
	/**
	 * Return amount of cards left in deck.
	 * @return
	 */
	public int amountOfCards() {
		return deck.size();
	}
}
