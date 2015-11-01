package junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.CardValue;
import model.CountPoints;
import model.Suit;
import model.Table;

public class CountPointsTest {
	
	CountPoints cp2;
	Table table;

	@Before
	public void setUp() throws Exception {
		table = new Table(new ArrayList<Card>());
		cp2 = new CountPoints(2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountTwoPlayers() {
		ArrayList<Card> pointCards1 = new ArrayList<>();
		pointCards1.add(new Card(CardValue.ACE, Suit.SPADES));
		pointCards1.add(new Card(CardValue.ACE, Suit.DIAMONDS));
		pointCards1.add(new Card(CardValue.ACE, Suit.HEARTS));
		
		ArrayList<Card> pointCards2 = new ArrayList<>();
		pointCards2.add(new Card(CardValue.TWO, Suit.SPADES));
		pointCards2.add(new Card(CardValue.ACE, Suit.CLUBS));
		pointCards2.add(new Card(CardValue.TEN, Suit.DIAMONDS));
		pointCards2.add(new Card(CardValue.QUEEN, Suit.SPADES));
		pointCards2.add(new Card(CardValue.JACK, Suit.SPADES));
		
		cp2.valueCards(0, pointCards1);
		cp2.valueCards(1, pointCards2);
		cp2.roundEnd();
		assertEquals(3, cp2.playerPoints(0));
		assertEquals(7, cp2.playerPoints(1));
		// Check if game ended
		assertEquals(false, cp2.gameEnded());
		// New round
		cp2.valueCards(0, pointCards2);
		cp2.valueCards(1, pointCards1);
		cp2.roundEnd();
		assertEquals(10, cp2.playerPoints(0));
		assertEquals(10, cp2.playerPoints(1));
		cp2.addOnePoint(0);
		cp2.addOnePoint(0);
		cp2.addOnePoint(0);
		cp2.addOnePoint(0);
		cp2.addOnePoint(0);
		// Check if game ended
		assertEquals(true, cp2.gameEnded());
	}

}
