package junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.Deck;
import model.PlayerComputerHard;
import model.Table;

public class PlayerComputerHardTest {
	PlayerComputerHard player;
	Deck deck;
	ArrayList<Card> hand;
	ArrayList<Card> tableCards;
	Table table;
	int nbrOfCardsInHand;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNbrOfCards() {
		assertEquals(nbrOfCardsInHand, player.showHand().size());
	}

	@Test
	public void putRandomCardOnTable() {
		player.cardOnTable();
		assertEquals(3, player.showHand().size());
	}

}
