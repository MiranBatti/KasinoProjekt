package junitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.CardValue;
import model.RankCard;
import model.Suit;

public class TestRankCard {
	RankCard cardRank;
	Card card;
	int expCardRank;
	
	@Before
	public void setUp() throws Exception {
		cardRank = new RankCard();
		card = new Card(CardValue.EIGHT, Suit.CLUBS);
		expCardRank = 2;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCardRank() {
		assertEquals(expCardRank, cardRank.rank(card));
	}

}
