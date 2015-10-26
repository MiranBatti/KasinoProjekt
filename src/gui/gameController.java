package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;
import model.Game;

public class gameController implements Initializable {
	@FXML
	private ImageView playerCardSlot1, playerCardSlot2, playerCardSlot3, playerCardSlot4; // Måste lägga till ID i SceneBuilder i code menyn för att använda GUI objekt i koden
	
	ArrayList<ImageView> playerCardSlots;
	
	private Game game;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initArrays();
		game = new Game(App.getInstance().getPlayers());
		playersCards();
		setListeners();
	}
	
	public void initArrays() {
		playerCardSlots = new ArrayList<>();
		playerCardSlots.add(playerCardSlot1);
		playerCardSlots.add(playerCardSlot2);
		playerCardSlots.add(playerCardSlot3);
		playerCardSlots.add(playerCardSlot4);
	}
	
	public void setListeners() {
		for (ImageView imageView : playerCardSlots) {
			imageView.setOnMouseClicked(e -> System.out.println(" ok"));
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
	
	public void layCardOnTable() {
		playerCardSlot1.setOnMouseClicked(e -> System.out.println(""));
	}

}
