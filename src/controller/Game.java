package controller;

import java.util.ArrayList;

import model.Card;
import model.CardOnTableComputer;
import model.CountPoints;
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
	private ArrayList<CardOnTableComputer> computersTable = new ArrayList<>();
	private ArrayList<Player> computersPlayer = new ArrayList<>();
	private Deck deck;
	private int nbrOfPlayers;
	private CountPoints cp;
	
	public Game(int nbrOfPlayers, int difficulty) {
		deck = new Deck();
		cp = new CountPoints(nbrOfPlayers);
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
					PlayerComputerEasy pce = new PlayerComputerEasy(takeFourCards(), getTable());
					computersTable.add(pce);
					computersPlayer.add(pce);
					break;
				case 1:
					PlayerComputerMedium pcm = new PlayerComputerMedium(takeFourCards(), getTable());
					computersTable.add(pcm);
					computersPlayer.add(pcm);
					break;
				case 2:
					PlayerComputerHard pch = new PlayerComputerHard(takeFourCards(), getTable());
					computersTable.add(pch);
					computersPlayer.add(pch);
					break;
				default:
					PlayerComputerEasy pced = new PlayerComputerEasy(takeFourCards(), getTable());
					computersTable.add(pced);
					computersPlayer.add(pced);
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
		System.out.println(deck.amountOfCards());
		
		System.out.println(deck.amountOfCards());
		System.out.println(deck.amountOfCards());
		System.out.println(deck.amountOfCards());
		System.out.println(deck.amountOfCards());
		if (deck.amountOfCards() >= 4) {
			for (int i = 0; i < 4; i++) {
				cardsToDeal.add(deck.getCards().get(i));
				deck.getCards().remove(i);
			}
		}
		return cardsToDeal;
	}
	
	public boolean dealNewCards() {
		boolean enought = CheckEnoughtCardsDeck(getDeckAmountCards());
		
		if (enought == true) {
			player.newCards(takeFourCards());
			for (Player computer : computersPlayer) {
				computer.newCards(takeFourCards());
			}
		}
		
		return enought;
	}
	
	public void layCards(Card card) {
		player.cardOnTable(card);
		if (table.getNumberOfCards() == 0) {
			cp.addOnePoint(0);
		}
		
		for (int i = 0; i < computersTable.size(); i++) {
			computersTable.get(i).cardOnTable();
			if (table.getNumberOfCards() == 0) {
				// Player has index 0
				cp.addOnePoint(i + 1);
			}
		}
	}
	
	private boolean CheckEnoughtCardsDeck(int cards) {
		boolean enought = true;
		
		if (nbrOfPlayers == 2 && cards < 8)
			enought = false;
		else if (nbrOfPlayers == 3 && cards < 12)
			enought = false;
		else if (nbrOfPlayers == 4 && cards < 16)
			enought = false;
			
		return enought;
	}
	
	public boolean newRound() {
		cp.valueCards(0, player.getPointsCard());
		for (int i = 1; i < nbrOfPlayers; i++) {
			cp.valueCards(i, computersPlayer.get(i).getPointsCard());
		}
		cp.roundEnd();
		
		return cp.gameEnded();
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
	
	public int getDeckAmountCards() {
		return deck.amountOfCards();
	}
	
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
