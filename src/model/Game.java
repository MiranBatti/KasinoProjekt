package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {
	private Player player;
	private Table table;
	private Deck deck;
	
	public Game() {
		deck = new Deck();
		deck.shuffleDeck();
	}
	
	public ArrayList<Card> takeFourCards(){
		ArrayList<Card> cardsToDeal = new ArrayList<Card>();
		Iterator<Card> cardIterator = deck.getCards().iterator();
		for (int i = 0; i < 4; i++) {
			cardsToDeal.add(cardIterator.next());
		}
		return cardsToDeal;
	}
	
	public void dealCardsToPlayer() {
		
	}
	
	public void dealCardsToTable() {
		
	}
}
