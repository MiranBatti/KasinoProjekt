package model;

/**
 * Enum with values a card can have.
 */
public enum CardValue {
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13),
	ACE(14);

	private int cardValue;

	private CardValue (int value) {
		this.cardValue = value;
	}
	
	/**
	 * Returns int value of CardValue.
	 * @return
	 */
	public int getCardValue() {
		return cardValue;
	}

	/**
	 * Returns int value of CardValue.
	 * @param cardValue
	 */
	public void setCardValueInt(int cardValue) {
		this.cardValue = cardValue;
	}
}
