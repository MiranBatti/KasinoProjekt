package junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Deck;
import model.PlayerHuman;
import model.Table;
import model.Card;

public class PlayerHumanTest {
	PlayerHuman player;
	Deck deck;
	ArrayList<Card> hand;
	ArrayList<Card> tableCards;
	Table table;
	int nbrOfCardsInHand;

	@Before
	public void setUp() throws Exception {
		deck = new Deck();
		hand = new ArrayList<Card>();
		tableCards = new ArrayList<Card>();
		nbrOfCardsInHand = 4;
		for (int i = 0; i < nbrOfCardsInHand; i++) {
			hand.add(deck.getCards().get(i));
			tableCards.add(deck.getCards().get(i+1));
		}
		table = new Table(tableCards);		
		player = new PlayerHuman(hand, table);		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNbrOfCards() {
		assertEquals(nbrOfCardsInHand, player.showHand().size());
	}
	
	@Test
	public void putCardOnTable() {
		player.cardOnTable(hand.get(0));
		assertEquals(3, player.showHand().size());
	}

}
