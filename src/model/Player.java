package model;

import java.util.ArrayList;

public abstract class Player {
	
	// only Access to sub-classes
	ArrayList<Card> cards;
	ArrayList<Card> pointsCards;
	
	public Player(ArrayList<Card> cards) {
		this.cards = cards;
		pointsCards = new ArrayList<Card>();
	}
	/**
	 * Deal new cards to player
	 * @param cards
	 */
	public void newCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	/**
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		cards.add(card);
	}
	/**
	 * Show player cards
	 * @return
	 */
	public ArrayList<Card> showHand() {
		return cards;
	}
	/**
	 * Give points to player
	 * @param pointsCard
	 */
	public void addPointsCard(ArrayList<Card> pointsCard) {
		this.pointsCards = pointsCard;
	}
	/**
	 * Return points the card is worth
	 * @return
	 */
	public ArrayList<Card> getPointsCard() {
		return pointsCards;
	}
}
