package junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Card;
import model.Deck;
import model.Table;

public class TableTest {
	Table table;
	Deck deck;
	ArrayList<Card> tableCards;
	int nbrOfCardsOnTable;

	@Before
	public void setUp() throws Exception {
		deck = new Deck();
		tableCards = new ArrayList<Card>();
		nbrOfCardsOnTable = 4;
		for (int i = 0; i < nbrOfCardsOnTable; i++) {
			tableCards.add(deck.getCards().get(i));
		}
		table = new Table(tableCards);		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNbrOfCards() {
		assertEquals(nbrOfCardsOnTable, table.showCards().size());
	}
	
	@Test
	public void testRemoveCard() {
		table.removeCardFromTable(0);
		assertEquals(nbrOfCardsOnTable -1, table.showCards().size());
	}
	
	public void testRemoveAllCards() {
		table.removeCardsFromTable();
		assertEquals(0, table.showCards().size());
	}

}
