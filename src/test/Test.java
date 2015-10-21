package test;

import java.util.ArrayList;

import model.*;

public class Test {
	public static void main(String[] args) {
		Game game = new Game();
		ArrayList<Card> t = new ArrayList<Card>();
		t = game.takeFourCards();
		for (Card card : t) {
			System.out.println(t);
		}
	}
}
