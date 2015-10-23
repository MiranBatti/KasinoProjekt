package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Table {
	
	ArrayList<Card> cards;
	
	public Table(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	
	public ArrayList<Card> addCard(int cardValuePlayer) {
		
	}
	
	/**
	 * Sort cards in CardValue
	 * @return
	 */
	private ArrayList<Card> sortCards() {
		ArrayList<Card> sortedCards = new ArrayList<Card>();
		
		for (int i = 0; i < cards.size(); i++) {
			
			
			int card1 = cards.get(i).getCardValueInt();
			int card2 = cards.get(i + 1).getCardValueInt();
		}
		
		return sortedCards;
	}
	
	/**
	 * Checks if table is empty to determinate if "tabe"
	 * @return
	 */
	public boolean isTableEmpty() {
		int size = cards.size();
		boolean empty = true;
		
		if (size > 0) {
			empty = false;
		}
		return empty;
	}
}

