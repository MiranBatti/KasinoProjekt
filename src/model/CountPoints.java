package model;

import java.util.ArrayList;

public class CountPoints {
	private int players;
	private ArrayList<Integer> playersScoreList;

	public CountPoints(int players) {
		this.players = players;
		listPlayersScore();
	}
	
	private void listPlayersScore() {
		for (int i = 0; i < (players -1); i++) {
			playersScoreList.add(0);
		}
	}
}
