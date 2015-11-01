package model;

import java.util.ArrayList;

/**
 * Rank a hand for a computer to make sure he takes the best cards.
 * <br>
 */
public class RankCard {
	private int takeCardValue;
	
	/**
	 * Sets takeCardsValue to 5 as standard.
	 */
	public RankCard() {
		takeCardValue = 5;
	}
	
	/**
	 * Sets what value a computer hands sould be to take cards.
	 * @param takeCardValue
	 */
	public RankCard(int takeCardValue) {
		this.takeCardValue = takeCardValue;
	}
	
	/**
	 * Rank card so computer can check what card to lay on table will result in the best card.
	 * @param card
	 * @return value
	 */
	public int rank(Card card) {
		/*
		 * The int values is not random. The value is to make sure if a player sends in a amount of card that the amount with point card always get heigest value
		 */
		int value = 0;
		CardValue cardValue = card.getCardValue();
		Suit suitValue = card.getSuit();
		
		if (cardValue == CardValue.TEN && suitValue == Suit.DIAMONDS)
			value = 100;
		else if (cardValue == CardValue.ACE && suitValue == Suit.SPADES)
			value = 50;
		else if (cardValue == CardValue.TWO && suitValue == Suit.SPADES)
			value = 30;
		else if (cardValue == CardValue.ACE)
			value = 30;
		else if (suitValue == Suit.SPADES)
			value = 3;
		else 
			value = 2;
		
		return value;
	}
	
	/**
	 * Ranks a arrayList of cards.
	 * @param cards
	 * @return
	 */
	public int rankAll(ArrayList<Card> cards) {
		int totalValue = 0;
		
		for (Card c : cards) {
			totalValue = rank(c);
		}
		return totalValue;
	}
	
	/**
	 * Method for a computer to check if he sould take a card.
	 * @param value
	 * @return take
	 */
	public boolean takeCards(int value) {
		boolean take = false;
		if (value >= takeCardValue)
			take = true;
		return take;
	}
}
