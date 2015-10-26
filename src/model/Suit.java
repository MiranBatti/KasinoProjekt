package model;

public enum Suit {
	HEARTS(0),
	DIAMONDS(1),
	SPADES(2),
	CLUBS(3);
	
	private int suit;
	 
	private Suit (int value) {
		this.suit = value;
	}
	 
	public int getSuit() {
		return suit;
	}
	
	public void setCardSuitInt(int suit) {
		this.suit = suit;
	};
}
