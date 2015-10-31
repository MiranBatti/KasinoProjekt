package controller;

import java.util.ArrayList;

import model.Card;
import model.CardOnTableComputer;
import model.PlayerComputerEasy;
import model.PlayerComputerHard;
import model.PlayerComputerMedium;
import model.PlayerHuman;
import model.Deck;
import model.Player;
import model.Table;

public class Game {
	private PlayerHuman player;
	private Table table;
	private ArrayList<CardOnTableComputer> computers = new ArrayList<>();
	private Deck deck;
	private int nbrOfPlayers;
	
	public Game(int nbrOfPlayers, int difficulty) {
		deck = new Deck();
		deck.shuffleDeck();
		table = new Table(takeFourCards());
		setNbrOfPlayers(nbrOfPlayers);
		player = new PlayerHuman(takeFourCards(), table);
		createComputers(difficulty);
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
	
	/**
	 * Create Computers to play with
	 * @param difficulty
	 */
	private void createComputers(int difficulty) {
		for (int i = 1; i < nbrOfPlayers; i++) {
			switch (difficulty) {
				case 0:
					computers.add(new PlayerComputerEasy(takeFourCards(), getTable()));
					break;
				case 1:
					computers.add(new PlayerComputerMedium(takeFourCards(), getTable()));
					break;
				case 2:
					computers.add(new PlayerComputerHard(takeFourCards(), getTable()));
					break;
				default:
					computers.add(new PlayerComputerEasy(takeFourCards(), getTable()));
					break;
			}
		}
	}
	
	/**
	 * Every player sould take four cards when it begins
	 * @return
	 */
	private ArrayList<Card> takeFourCards(){
		ArrayList<Card> cardsToDeal = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			cardsToDeal.add(deck.getCards().get(i));
			deck.getCards().remove(i);
		}
		return cardsToDeal;
	}
	
	public void dealNewCards() {
		player.newCards(takeFourCards());
	}
	
	public void layCards(Card card) {
		player.cardOnTable(card);
		for (CardOnTableComputer comp : computers) {
			comp.cardOnTable();
		}
	}
	
	/*

	public void checkPlayerHand() {
		if(player.showHand().isEmpty()) {
			player.newCards(takeFourCards());
		}
	}
	
	public int getNumberOfCardsOnTable() {
		return table.getNumberOfCards();
	}*/
	
	public ArrayList<Card> showTableCards() {
		return table.showCards();
	}
	
	public ArrayList<Card> showPlayerHand() {
		return player.showHand();
	}
	
 	public Deck getDeck() {
 		return deck;
 	}
	
	public Table getTable() {
		return table;
	}
	
	public Player getPlayer() {
		return player;
	}
}
