package model;

import java.util.ArrayList;

public final class RankCard {
	
	private RankCard() {}
	
	/**
	 * Rank card so computer can check what card to lay on table will result in the best card
	 * @param card
	 * @return
	 */
	public static int rank(Card card) {
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
	 * Ranks a arrayList of cards
	 * @param cards
	 * @return
	 */
	public static int rankAll(ArrayList<Card> cards) {
		int totalValue = 0;
		
		for (Card c : cards) {
			totalValue = rank(c);
		}
		
		return totalValue;
	}
	
}
