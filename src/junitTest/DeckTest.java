package junitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Deck;
import model.Suit;

public class DeckTest {
	Deck deck;
	
	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeckSize() {
		assertEquals(52, deck.getCards().size());
	}
	
	@Test
	public void testCardValue() {
		int expValue = 4;
		for (int i = 0; i < deck.getCards().size(); i++) {
			if(deck.getCards().get(i).getCardValueInt() == 4)
				assertEquals(expValue, deck.getCards().get(i).getCardValueInt());
		}
	}
	
	@Test
	public void testCardSuit() {
		Suit cardSuitExp = Suit.DIAMONDS;
		for (int i = 0; i < deck.getCards().size(); i++) {
			if(deck.getCards().get(i).getSuitInt() == cardSuitExp.getSuit()) {
				assertEquals(cardSuitExp.getSuit(), deck.getCards().get(i).getSuitInt());
			}
		}
	}

}
