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
		player = new Player(takeFourCards());
	}
	
	private ArrayList<Card> takeFourCards(){
		ArrayList<Card> cardsToDeal = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			cardsToDeal.add(deck.getCards().get(i));
			deck.getCards().remove(i);
		}
		return cardsToDeal;
	}
	
	public void dealCardsToPlayer() {
		player.newCards(takeFourCards());
	}
	
	public void dealCardsToComputer() {
		
	}
	
	public void dealCardsToTable() {
		
	}
	
	public ArrayList<Card> showPlayerHand() {
		return player.showHand();
	}
	
 	public Deck getDeck() {
 		return deck;
 	}
}
