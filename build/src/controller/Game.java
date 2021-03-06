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

/**
 * Creates Controller.
 * 
 * @author miranbatti, jonasoster
 */
public class Game {
	private PlayerHuman player;
	private Table table;
	private ArrayList<CardOnTableComputer> computersTable = new ArrayList<>();
	private ArrayList<Player> computersPlayer = new ArrayList<>();
	private Deck deck;
	private int nbrOfPlayers;
	private CountPoints cp;
	
	/**
	 * Difficulty should be between 0-2.
	 * <br>
	 * Number of players sould be between 2-4.
	 * @param nbrOfPlayers
	 * @param difficulty
	 */
	public Game(int nbrOfPlayers, int difficulty) {
		setNbrOfPlayers(nbrOfPlayers);
		deck = new Deck();
		cp = new CountPoints(nbrOfPlayers);
		table = new Table(takeFourCards());
		player = new PlayerHuman(takeFourCards(), table);
		createComputers(difficulty);
	}
	
	/**
	 * Game can have between 2-4 players.
	 * <br>
	 * Method to make sure the value is set correctly.
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
	 * Create Computers to play with.
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
	 * Every player sould take four cards when the game begins.
	 * @return ArrayList<Card>
	 */
	private ArrayList<Card> takeFourCards(){
		ArrayList<Card> cardsToDeal = new ArrayList<Card>();

		if (deck.amountOfCards() >= 4) {
			for (int i = 0; i < 4; i++) {
				cardsToDeal.add(deck.getCards().get(i));
			}
			deck.getCards().removeAll(cardsToDeal);
		}
		return cardsToDeal;
	}
	
	/**
	 * Deals new cards to all players.
	 * @return boolean
	 */
	public boolean dealNewCards() {
		boolean enough = checkEnoughCardsInDeck(getDeckAmountCards());
		
		if (enough == true) {
			player.newCards(takeFourCards());
			for (Player computer : computersPlayer) {
				computer.newCards(takeFourCards());
			}
		}
		return enough;
	}
	
	/**
	 * PlayerHuman sends card he want to lay on table, and computers lays cards automatically.
	 * @param card
	 */
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
	
	/**
	 * Helper class to avoid null when Deck has no cards.
	 * Check if there are cards in the deck.
	 * @param cards
	 * @return boolean
	 */
	private boolean checkEnoughCardsInDeck(int cards) {
		boolean enough = true;
		
		if (nbrOfPlayers == 2 && cards < 8)
			enough = false;
		else if (nbrOfPlayers == 3 && cards < 12)
			enough = false;
		else if (nbrOfPlayers == 4 && cards < 16)
			enough = false;
			
		return enough;
	}
	
	/**
	 * Counts every players card scores and return false if game has ended.
	 * @return boolean
	 */
	public boolean newRound() {
		table.removeCardsFromTable();
		cp.valueCards(0, player.getPointsCard());
		for (int i = 0; i < computersPlayer.size(); i++) {
			cp.valueCards(i + 1, computersPlayer.get(i).getPointsCard());
		}
		cp.roundEnd();
		boolean gameEnded = cp.gameEnded();
	
		if(gameEnded == false) {
			deck.newRound();
			dealNewCards();
		}
		
		if (gameEnded == false) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns amount of cards in deck.
	 * @return int
	 */
	public int getDeckAmountCards() {
		return deck.amountOfCards();
	}
	
	/**
	 * Returns cards on table.
	 * @return ArrayList<Card>
	 */
	public ArrayList<Card> showTableCards() {
		return table.showCards();
	}
	
	/**
	 * Returns HumanPlayer hand
	 * @return ArrayList<Card>
	 */
	public ArrayList<Card> showPlayerHand() {
		return player.showHand();
	}
	
	/**
	 * Returns deck.
	 * @return Deck
	 */
 	public Deck getDeck() {
 		return deck;
 	}
	
 	/**
 	 * Returns table.
 	 * @return Table
 	 */
	public Table getTable() {
		return table;
	}
	
	/**
	 * Return HumanPlayer player.
	 * @return Player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Returns countPoints.
	 * @return CountPoints
	 */
	public CountPoints getCountPoints() {
		return cp;
	}
}
