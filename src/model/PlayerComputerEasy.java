package model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerComputerEasy extends Player implements CardOnTableComputer {
	private Table table;

	public PlayerComputerEasy(ArrayList<Card> cards, Table table) {
		super(cards);
		this.table = table;
	}
	
	public void cardOnTable() {
		Random rnd = new Random();
		int rndInt = 0;
		
		if (cards.size() > 0) {
			rnd.nextInt(cards.size());
			Card rndCard = cards.get(rndInt);
			pointsCard.addAll(table.addCard(rndCard, false));
			cards.remove(rndInt);
		}
	}

}
