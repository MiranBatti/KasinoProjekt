package junitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Deck;

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
		assertEquals(52, deck.getCards().size()); //kontrollera att vi får 52 kort i kortleken
	}

}
