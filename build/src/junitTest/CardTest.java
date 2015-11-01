package junitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.CardValue;
import model.Suit;

public class CardTest {
	Card card;

	@Before
	public void setUp() throws Exception {
		card = new Card(CardValue.EIGHT, Suit.DIAMONDS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCardValues() {
		assertEquals(8, card.getCardValueInt());
		assertEquals(Suit.DIAMONDS.getSuit(), card.getSuitInt());;
	}

}
