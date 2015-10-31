package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to count points in a casino game
 */
public class CountPoints {
	private int[] playersScoreList;
	private int[] amountOfCards;
	private int[] amountOfSpades;
	private int players;
	private int gameEnd;

	/**
	 * Construktor
	 * @param players
	 * @param gameEnd
	 */
	public CountPoints(int players, int gameEnd) {
		this.players = players;
		this.gameEnd = gameEnd;
		playersScoreList = new int[players];
		amountOfCards = new int[players];
		amountOfSpades = new int[players];
	}
	
	/**
	 * Construktor
	 * @param players
	 */
	public CountPoints(int players) {
		this.players = players;
		gameEnd = 15; // Standard points to count to
		playersScoreList = new int[players];
		amountOfCards = new int[players];
		amountOfSpades = new int[players];
	}
	
	/**
	 * A sequence method to end round with every player hand counted for
	 * Returns true if game is over
	 * @param allPlayersCard
	 * @return 
	 */
	public boolean endRoundCountEverything(ArrayList<ArrayList<Card>> allPlayersCard) {
		for (int i = 0; i < players; i++)
			valueCards(i, allPlayersCard.get(i));
		roundEnd();
		return gameEnded();
	}
	
	/**
	 * Checks who has most spades and cards which equals one point for both
	 * Also gives one extra point if a player wins both
	 */
	public boolean roundEnd() {
		ArrayList<Integer> mostCards = givePointToHighest(amountOfCards);
		ArrayList<Integer> mostSpades = givePointToHighest(amountOfSpades);
		
		// Check if player did win both spades and games
		for (Integer i : mostCards)
			if (mostSpades.contains(i))
				addOnePoint(i);		

		// New round 
		amountOfCards = new int[players];
		amountOfSpades = new int[players];
		
		return gameEnded();
	}
	
	/**
	 * Check if a game has ended
	 * @return
	 */
	public boolean gameEnded() {
		boolean end = false;
		
		for (int score : playersScoreList)
			if (score >= gameEnd)
				end = true;
		
		return end;
	}
	
	/**
	 * Returns player/players with hegiest score
	 * @return
	 */
	public ArrayList<Integer> heigestPoints() {
		return givePointToHighest(playersScoreList);
	}
	
	/**
	 * Check hegiest ints value in array
	 * Also return a ArrayList with what index hegiest ints was at
	 * @param array
	 * @return
	 */
	private ArrayList<Integer> givePointToHighest(int[] array) {
		int[] cloneArray = array.clone();
		Arrays.sort(cloneArray);
		int mostCardsValue = cloneArray[players -1];
		
		ArrayList<Integer> mostCards = new ArrayList<>();
		
		for (int i = 0; i < cloneArray.length; i++) {
			if (cloneArray[i] == mostCardsValue) {
				addOnePoint(i);
				mostCards.add(i);
			}
		}
		return mostCards;
	}
	
	/**
	 * Method used to add one point to the score for a player
	 * Use case: "tabe", most spades & most cards
	 * Returns true if game is over
	 * @param player
	 * @return
	 */
	public boolean addOnePoint(int player) {
		System.out.println("Ok");
		System.out.println(playersScoreList);
		int playerScore = playersScoreList[player];
		playersScoreList[player] = playerScore + 1;
		return gameEnded();
	}
	
	/**
	 * A player send in hand to calculate all points from hand when round has ended
	 * @param player
	 * @param cards
	 */
	public void valueCards(int player, ArrayList<Card> cards) {
		for (int i = 0; i < cards.size(); i++) {
			playersScoreList[player] = playersScoreList[player] + valueCard(cards.get(i));
			amountOfCards[player] += 1;
			amountOfSpades[player] = amountOfSpades[player] + isCardSpade(cards.get(i));
		}
	}
	
	/**
	 * Add points if card was a point card
	 * @param card
	 * @return
	 */
	private int valueCard(Card card) {
		int value = 0;
		
		if (card.getCardValue() == CardValue.ACE)
			value = 1;
		else if (card.getCardValue() == CardValue.TWO && card.getSuit() == Suit.SPADES)
			value = 1;
		else if (card.getCardValue() == CardValue.TEN && card.getSuit() == Suit.DIAMONDS)
			value = 2;
		
		return value;
	}

	/**
	 * Checks if card is of type spades
	 * Returns one if card is spade, else returns zero
	 * @param card
	 * @return
	 */
	private int isCardSpade(Card card) {
		int value = 0;
		
		if (card.getSuit() == Suit.SPADES)
			value = 1;
		
		return value;
	}
	
}
