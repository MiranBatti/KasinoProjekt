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
		
		if (cards.get(0) != null) {
			//rndInt = 0;
					//rnd.nextInt(cards.size() - 1);
			//Card rndCard = cards.get(rndInt);
			//cards.remove(rndInt);
			//cards.addAll(table.addCard(rndCard, false));
			//System.out.println(rndInt);
		}
	}

}
