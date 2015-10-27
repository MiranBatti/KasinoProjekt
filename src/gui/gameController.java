package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import controller.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;

public class gameController implements Initializable {
	@FXML
	private ImageView playerCardSlot1, playerCardSlot2, playerCardSlot3, playerCardSlot4; // Måste lägga till ID i SceneBuilder i code menyn för att använda GUI objekt i koden
	@FXML
	private ImageView tableCardSlot1, tableCardSlot2, tableCardSlot3, tableCardSlot4, tableCardSlot5;
	ArrayList<ImageView> playerCardSlots;
	ArrayList<ImageView> tableCardSlots;
	
	private Game game;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initArrays();
		game = new Game(App.getInstance().getPlayers());
		playersCards();
		tableCards();
		setListeners();
	}
	
	public void initArrays() {
		playerCardSlots = new ArrayList<ImageView>();
		playerCardSlots.add(playerCardSlot1);
		playerCardSlots.add(playerCardSlot2);
		playerCardSlots.add(playerCardSlot3);
		playerCardSlots.add(playerCardSlot4);
		
		tableCardSlots = new ArrayList<ImageView>();
		tableCardSlots.add(tableCardSlot1);
		tableCardSlots.add(tableCardSlot2);
		tableCardSlots.add(tableCardSlot3);
		tableCardSlots.add(tableCardSlot4);
		tableCardSlots.add(tableCardSlot5);
	}
	
	public void setListeners() {
		for (ImageView imageView : playerCardSlots) {
			imageView.setOnMouseClicked(e -> System.out.println(" ok"));
		}
		for (ImageView imageView : tableCardSlots) {
//			tableCardSlot1.setOnMouseClicked(e -> tableCardSlot1.setImage(null));
//			Image image = new Image(gameController.class.getResourceAsStream("../resources/0_11.png"));
			imageView.setOnMouseClicked(e -> {game.removeCardFromTable(1); this.updateTable(1);});
		}

	}
	
	// Delar ut kort till player, kanske ändrar koden sen
	public void playersCards() {
		ArrayList<Card> hand = game.showPlayerHand();
		
		for (int i = 0; i < hand.size(); i++) {
			
			String cardNameImg = "../resources/" + hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
			playerCardSlots.get(i).setImage(image);
		}
	}
	
	public void tableCards() {
		ArrayList<Card> hand = game.showTableCards();
		
		for (int i = 0; i < hand.size(); i++) {
			String cardNameImg = "../resources/" + hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
			tableCardSlots.get(i).setImage(image);
		}
	}
	
	public void updateTable(int index) {
		ArrayList<Card> hand = game.showTableCards();
		String cardNameImg;
		Image image = null;	
		
		if(hand.get(index).equals(null)) cardNameImg = null;
		tableCardSlots.get(index).setImage(image);
	}
	
	public void layCardOnTable() {
		playerCardSlot1.setOnMouseClicked(e -> System.out.println("b"));
	}

	public void removeCardFromTable() {
		tableCardSlot1.setOnMouseClicked(e -> {tableCardSlot1.setImage(null);System.out.println("empty");});
	}
}
