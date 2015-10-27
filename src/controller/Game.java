package controller;

import java.util.ArrayList;

import model.Card;
import model.ComputerSimple;
import model.Deck;
import model.Player;
import model.Table;

public class Game {
	private Player player;
	private Table table;
	private ComputerSimple computerSimple;
	private Deck deck;
	private int nbrOfPlayers;
	
	public Game(int nbrOfPlayers) {
		setNbrOfPlayers(nbrOfPlayers);
		deck = new Deck();
		deck.shuffleDeck();
		player = new Player(takeFourCards());
		table = new Table(takeFourCards());
		computerSimple = new ComputerSimple(takeFourCards()); // kommer behöva ändras när vi vill ha fler/mindre spelare
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
	
	/**
	 * Checks player hand, if player has no cards
	 * give 4 new cards to player.
	 */
	public void checkPlayerHand() {
		if(player.showHand().isEmpty()) {
			player.newCards(takeFourCards());
		}
	}
	
	public ArrayList<Card> showPlayerHand() {
		return player.showHand();
	}
	
	public ArrayList<Card> showTableCards() {
		return table.showCards();
	}
	
	public int getNumberOfCardsOnTable() {
		return table.getNumberOfCards();
	}
	
 	public Deck getDeck() {
 		return deck;
 	}
 	
 	public void removeCardFromTable(int index) {
 		table.removeCardFromTable(index);
 	}
}
