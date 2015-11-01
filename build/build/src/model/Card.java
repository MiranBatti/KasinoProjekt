package model;

/**
 * Creates a card with CardValue and Suit.
 * 
 * @author miranbatti, jonasoster
 */
public class Card {
	private Suit suit;
	private CardValue cardValue;

	/**
	 * @param cardValue
	 * @param suit
	 */
	public Card (CardValue cardValue, Suit suit) {
		this.cardValue = cardValue;
		this.suit = suit;
	}
	
	/**
	 * Returns suit.
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Returns suit int value.
	 * @return
	 */
	public int getSuitInt() {
		return suit.getSuit();
	}

	/**
	 * Sets suit with Suit.
	 * @param suit
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	/**
	 * Sets suit with int value.
	 * @param suit
	 */
	public void setSuitInt(int suit) {
		this.suit.setCardSuitInt(suit);
	}

	/**
	 * Returns cardvalue.
	 * @return
	 */
	public CardValue getCardValue() {
		return cardValue;
	}
	
	/**
	 * Returns cardvalue int value.
	 * @return
	 */
	public int getCardValueInt() {
		return cardValue.getCardValue();
	}
	
	/**
	 * Set card value
	 * @param cardValue
	 */
	public void setCardValue(CardValue cardValue) {
		this.cardValue = cardValue;
	}

	/**
	 * Sets cardValue with int value.
	 * @param cardValue
	 */
	public void setCardValueInt(int cardValue) {
		this.cardValue.setCardValueInt(cardValue);
	}

	/**
	 * Returns a string representation of obj.
	 */
	@Override
	public String toString() {
		return "Suit:" + suit + " Card value:" + cardValue.getCardValue();
	}
}
