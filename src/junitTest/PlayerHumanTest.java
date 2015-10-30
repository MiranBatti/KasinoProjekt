package junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Deck;
import model.PlayerHuman;
import model.Card;

public class PlayerHumanTest {
	PlayerHuman player;
	Deck deck;
	ArrayList<Card> hand;
	int nbrOfCardsInHand;

	@Before
	public void setUp() throws Exception {
		deck = new Deck();
		hand = new ArrayList<Card>();
		nbrOfCardsInHand = 4;
		for (int i = 0; i < nbrOfCardsInHand; i++) {
			hand.add(deck.getCards().get(i));
		}
		//player = new PlayerHuman(hand, table); gjort om
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNbrOfCards() {
		assertEquals(nbrOfCardsInHand, player.showHand().size());
	}

}
