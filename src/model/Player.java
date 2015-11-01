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
	
	public void newCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public ArrayList<Card> showHand() {
		return cards;
	}
	
	public void addPointsCard(ArrayList<Card> pointsCard) {
		this.pointsCards = pointsCard;
	}
	
	public ArrayList<Card> getPointsCard() {
		return pointsCards;
	}
}
