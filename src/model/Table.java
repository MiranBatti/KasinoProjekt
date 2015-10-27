package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Table {

	ArrayList<Card> cards;
	ArrayList<Card> returnCards;

	public Table(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	/**
	 * Method to give cards back depending on what cards is a combo of target card or if target card value is on table
	 * @param cards
	 * @param target
	 * @param partial
	 */
	private void addCardRecursive(ArrayList<Card> cards, int target, ArrayList<Card> partial) {
		int sum = 0;
		int cardsLenght = cards.size();

		for (Card c: partial) 
			sum += c.getCardValueInt();
		
		// Sets cards that match target or combo of it to returnCards
		// Also removes returnCards from deck array
		if (sum == target) {
			HashSet<Card> hs = new HashSet<>(partial);
			returnCards.addAll(hs);
			cards.removeAll(hs);
		}

		if (sum >= target)
			return;

		for (int i = 0; i < cardsLenght;i++) {
			ArrayList<Card> remaining = new ArrayList<>();

			for (int j = i+1; j < cardsLenght; j++) 
				remaining.add(cards.get(j));

			ArrayList<Card> partial_rec = new ArrayList<Card>(partial);

			partial_rec.add(cards.get(i));

			// Rescursive, calling same method but with diffrent values since last time
			addCardRecursive(remaining, target, partial_rec);             
		}
	}

	/**
	 * Return cards that player can take to his card stack
	 * @param card
	 * @return
	 */
	public ArrayList<Card> addCard(Card card) {
		returnCards = new ArrayList<Card>();
		int cardValue = card.getCardValueInt();
		addCardRecursive(cards, cardValue, new ArrayList<Card>());
		return returnCards;
	}

	/**
	 * Sort cards in CardValue
	 * @return
	 */
	private ArrayList<Card> sortCards() {
		ArrayList<Card> sortedCards = new ArrayList<Card>();
		int card1;
		int card2;

		for (int i = 0; i < cards.size(); i++) {

			if (i < (cards.size() -1)) {
				card1 = cards.get(i).getCardValueInt();
				card2 = cards.get(i + 1).getCardValueInt();

				if (card1 > card2) {
					sortedCards.add(cards.get(i));
					sortedCards.add(cards.get(i + 1));
				} else {
					sortedCards.add(cards.get(i + 1));
					sortedCards.add(cards.get(i));
				}
			}
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

	public ArrayList<Card> showCards() {
		return cards;
	}

	public int nbrOfCards() {
		return cards.size();
	}
	
	public void removeCardFromTable(int index) {
		try {
			cards.remove(index);			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No more cards to remove");
		}
	}
}

