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
		ArrayList<Card> deckWithCards = deck.getCards();
		for (int i = 0; i < 4; i++) {
			cardsToDeal.add(deckWithCards.get(i));
		}
		return cardsToDeal;
	}
	
	public void dealCardsToPlayer() {
		
	}
	
	public void dealCardsToComputer() {
		
	}
	
	public void dealCardsToTable() {
		
	}
}
