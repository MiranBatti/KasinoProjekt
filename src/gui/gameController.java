package gui;

import java.net.URL;
import java.util.ArrayList;
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
	private ImageView[] playerCardSlot = new ImageView[]{playerCardSlot1, playerCardSlot2, playerCardSlot3, playerCardSlot4};
	
	private Game game;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		game = new Game(App.getInstance().getPlayers());
		playersCards();
	}
	
	// Försöker få controllern att dela ut kort till spelaren när gamet startar
	public void playersCards() {
		/*ArrayList<Card> hand = game.showPlayerHand();
		
		for (int i = 0; i < hand.size(); i++) {
			String cardNameImg = hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt();
			playerCardSlot[i].setImage(new Image("../resources/" + cardNameImg + ".png"));
		}*/
	}

}
