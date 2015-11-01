package model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Cards that players lay on table.
 * 
 * @author miranbatti, jonasoster
 */
public class Table {
	private ArrayList<Card> cards;
	private ArrayList<Card> returnCards;
	private HashSet<Card> hs;

	/**
	 * Give table start cards.
	 * @param cards
	 */
	public Table(ArrayList<Card> cards) {
		this.cards = cards;
	}

	/**
	 * Method to give cards back depending on what cards is a combo of target card or if target card value is on table.
	 * <br>
	 * Could also send in a test boolean to check what hand gives best card.
	 * @param cards
	 * @param target
	 * @param partial
	 */
	private void addCardRecursive(ArrayList<Card> remaining, int target, ArrayList<Card> partial, boolean test) {
		int sum = 0;

		for (Card c : partial) 
			sum += c.getCardValueInt();
		
		for (Card c : remaining) {
			if (c.getCardValue() == CardValue.ACE)
			c.setCardValueInt(1);
		}


		// Sets cards that match target or combo of it to returnCards
		if (sum == target) {
			hs.addAll(partial);

			if (test == false) {
				ArrayList<Card> deleteCards = new ArrayList<>();
				for (int i = 0; i < cards.size(); i++) {
					for (Card targetCard : hs) {
						if (cards.get(i).getCardValueInt() == targetCard.getCardValueInt()) {
							deleteCards.add(cards.get(i));
						}
					}
				}
				cards.removeAll(deleteCards);
			}
		}

		if (sum >= target)
			return;

		for (int i = 0; i < remaining.size() ;i++) {
			ArrayList<Card> newRemaining = new ArrayList<>();

			Card n = remaining.get(i);

			for (int j = i + 1; j < remaining.size(); j++) 
				newRemaining.add(remaining.get(j));

			ArrayList<Card> partial_rec = new ArrayList<Card>(partial);

			partial_rec.add(n);

			// Rescursive, calling same method but with diffrent values since last time
			addCardRecursive(newRemaining, target, partial_rec, test);             
		}
	}

	/**
	 * Return cards that player can take to his card stack
	 * @param card
	 * @return
	 */
	public ArrayList<Card> addCard(Card card, boolean test) {
		returnCards = new ArrayList<Card>();
		hs = new HashSet<>();
		int cardValue = card.getCardValueInt();
		addCardRecursive(cards, cardValue, new ArrayList<Card>(), test);
		returnCards.addAll(hs);
		
		if (returnCards.isEmpty())
			cards.add(card);
		else
			returnCards.add(card);
		
		for(Card c : returnCards) {
			if (c.getCardValue() == CardValue.ACE) {
				c.setCardValueInt(14);
			}
		}
		
		for(Card c : cards) {
			if (c.getCardValue() == CardValue.ACE) {
				c.setCardValueInt(14);
			}
		}
		
		return returnCards;
	}

	/**
	 * Returns number of cards on table
	 * @return
	 */
	public int getNumberOfCards() {
		return cards.size();
	}

	/**
	 * Returns all cards on table.
	 * @return
	 */
	public ArrayList<Card> showCards() {
		return cards;
	}

	/**
	 * Remove a card from table at specific index.
	 * @param index
	 */
	public void removeCardFromTable(int index) {
		if (cards.size() > 0) {
			cards.remove(index);			
		}
	}
	
	/**
	 * Removes all cards from table.
	 */
	public void removeCardsFromTable() {
		cards.clear();
	}
}

