package model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerComputerEasy extends Player{
	private Table table;

	public PlayerComputerEasy(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	public Card cardOnTable() {
		Random rnd = new Random();
		int rndInt = rnd.nextInt(cards.size() - 1);
		Card rndCard = cards.get(rndInt);
		cards.remove(rndInt);
		cards.addAll(table.addCard(rndCard, false));
		
		return rndCard;
	}

}
