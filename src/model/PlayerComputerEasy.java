package model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerComputerEasy extends Player{

	public PlayerComputerEasy(ArrayList<Card> cards) {
		super(cards);
	}
	
	public Card cardOnTable() {
		Random rnd = new Random();
		int rndInt = rnd.nextInt(cards.size() - 1);
		Card rndCard = cards.get(rndInt);
		
		cards.remove(rndInt);
		
		return rndCard;
	}

}
