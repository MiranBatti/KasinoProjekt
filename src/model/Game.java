package model;

import java.util.ArrayList;

public class Game {
	private Player player;
	private Table table;
	private Deck deck;
	private int nbrOfPlayers;
	
	public Game(int nbrOfPlayers) {
		setNbrOfPlayers(nbrOfPlayers);
		deck = new Deck();
		deck.shuffleDeck();
		player = new Player(takeFourCards());
		table = new Table(takeFourCards());
	}
	
	/**
	 * Game can have between 2-4 players
	 * Method to make sure the value is set correctly
	 * @param nbrOfPlayers
	 */
	private void setNbrOfPlayers(int nbrOfPlayers) {
		if (nbrOfPlayers < 2) {
			this.nbrOfPlayers = 2;
		} else if (nbrOfPlayers > 4) {
			this.nbrOfPlayers = 4;
		} else {
			this.nbrOfPlayers = nbrOfPlayers;
		}
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
