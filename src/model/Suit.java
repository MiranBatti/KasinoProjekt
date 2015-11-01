package model;

/**
 * Enum with values a suit can have.
 * 
 * @author miranbatti, jonasoster
 */
public enum Suit {
	HEARTS(0),
	DIAMONDS(1),
	SPADES(2),
	CLUBS(3);

	private int suit;

	/**
	 * Sets suit with int value.
	 * @param value
	 */
	private Suit (int value) {
		this.suit = value;
	}

	/**
	 * Returns suit.
	 * @return
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Sets suit with int value.
	 * @param suit
	 */
	public void setCardSuitInt(int suit) {
		this.suit = suit;
	};
}
