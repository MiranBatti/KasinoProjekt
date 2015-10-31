package model;

public class Card {
	private Suit suit;
	private CardValue cardValue;
	 
	public Card (CardValue cardValue, Suit suit) {
	    this.cardValue = cardValue;
	    this.suit = suit;
	}
	
	public Card(int cardValueInt, int suitInt) {
		this.cardValue = CardValue.fromInteger(cardValueInt);
		this.suit = Suit.values()[suitInt];
	}
	 
	public Suit getSuit() {
		return suit;
	}
	
	public int getSuitInt() {
		return suit.getSuit();
	}
	 
	public void setSuit(Suit suit) {
	    this.suit = suit;
	}
	
	public void setSuitInt(int suit) {
	    this.suit.setCardSuitInt(suit);
	}
	
	public CardValue getCardValue() {
	    return cardValue;
	}
	
	public int getCardValueInt() {
		return cardValue.getCardValue();
	}
	 
	public void setCardValue(CardValue cardValue) {
	    this.cardValue = cardValue;
	}
	
	public void setCardValueInt(int cardValue) {
	    this.cardValue.setCardValueInt(cardValue);
	}
	
	@Override
	public String toString() {
		return "Suit:" + suit + " Card value:" + cardValue.getCardValue();
	}
}
