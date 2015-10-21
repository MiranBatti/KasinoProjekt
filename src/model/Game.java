package model;

public class Game {
	private Player player;
	private Table table;
	private Deck deck;
	
	public Game() {
		deck = new Deck();
		deck.shuffleDeck();
	}
	
	public void dealCardsToPlayer() {
		
	}
	
	public void dealCardsToTable() {
		
	}
}
