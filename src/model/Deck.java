package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;

	public Deck () {
		this.deck = new ArrayList<Card>();
		newRound();
	}
	/**
	 * Clear and shuffle the when beginning a new round
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
	
	/**
	 * Prints out all cards. For testing purposes.
	 * Iterate through all cards and when ACE is found
	 * we change its value to 1.
	 */
	public void printAllCards() {
		System.out.println("\n");
		for (Card card : deck) {
			if(card.getCardValue().equals(CardValue.ACE)){
				card.setCardValueInt(1);
			}
			System.out.println(card);
		}
	}
	
	/**
	 * Return amount of cards left in deck
	 * @return
	 */
	public int amountOfCards() {
		return deck.size();
	}
	
}
