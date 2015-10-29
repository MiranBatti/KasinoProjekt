package model;

import java.util.ArrayList;

public abstract class Player {
	
	ArrayList<Card> cards;
	ArrayList<Card> pointsCard;
	
	public Player(ArrayList<Card> cards) {
		this.cards = cards;
		pointsCard = new ArrayList<Card>();
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
		this.pointsCard = pointsCard;
	}
	
	public ArrayList<Card> getPointsCard() {
		return pointsCard;
	}
}
