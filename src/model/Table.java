package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Table {

	ArrayList<Card> cards;
	ArrayList<Card> returnCards;
	HashSet<Card> hs;

	public Table(ArrayList<Card> cards) {
		this.cards = cards;
	}

	/**
	 * Method to give cards back depending on what cards is a combo of target card or if target card value is on table
	 * Could also send in a test boolean to check what hand gives best card
	 * @param cards
	 * @param target
	 * @param partial
	 */
	private void addCardRecursive(ArrayList<Card> remaining, int target, ArrayList<Card> partial, boolean test) {
		// Fixa om kort är Ess
		// Gör ess till ett
		// Retunera alla ess
		int sum = 0;

		for (Card c : partial) 
			sum += c.getCardValueInt();
		
		/*for (Card c : remaining) {
			if (c.getCardValue() == CardValue.ACE)
				c.setCardValueInt(1);
		}*/


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
		System.out.println(card);
		returnCards = new ArrayList<Card>();
		hs = new HashSet<>();
		int cardValue = card.getCardValueInt();
		addCardRecursive(cards, cardValue, new ArrayList<Card>(), test);
		returnCards.addAll(hs);
		
		if (returnCards.isEmpty())
			cards.add(card);
		else
			returnCards.add(card);
		
		/*for(Card c : returnCards) {
			if (c.getCardValue() == CardValue.ACE) {
				c.setCardValueInt(14);
			}
		}*/
		
		System.out.println(returnCards);
		
		return returnCards;
	}

	/**
	 * Returns number of cards on table
	 * @return
	 */
	public int getNumberOfCards() {
		return cards.size();
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
	
	public void removeCardsFromTable() {
		cards.clear();
	}
}

