package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;
import model.CardValue;
import model.Suit;

public class gameController implements Initializable {
	@FXML
	private ImageView playerCardSlot1, playerCardSlot2, playerCardSlot3, playerCardSlot4;
	@FXML
	private ArrayList<ImageView> playerCardSlots;
	@FXML
	private ImageView tableCardSlot1, tableCardSlot2, tableCardSlot3, tableCardSlot4;
	@FXML
	private ArrayList<ImageView> tableCardSlots;
	
	private Game game;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initArrays();
		game = new Game(App.getInstance().getPlayers(), App.getInstance().getDifficulty());
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
	}
	
	// Ha alla listerns här
	public void setListeners() {
		
		for (ImageView imageView : playerCardSlots) {
			System.out.println(((ImageView)playerCardSlot1).getImage());
			imageView.setOnMouseClicked(e -> {
				String card = imageView.getId();
				if (card != "ignore") {
					int iend = card.indexOf("_");
					int cardSuit = Integer.parseInt(card.substring(0, iend));
					int cardValue = Integer.parseInt(card.substring(iend + 1, card.length()));
					System.out.println(cardSuit + " " + cardValue);
					game.layCards(new Card(CardValue.values()[cardValue - 2], Suit.values()[cardSuit]));
					playersCards();
					tableCards();
					//Ta bort kort som har lagt / Hide
					//Uppdatera table bordet
					//Nya kort om playern har slut / koll om spelet är slut isåfall metod för att skriva ut vinaren 
				}
			});
		}

	}
	
	// Delar ut kort till player, kanske ändrar koden sen
	public void playersCards() {
		ArrayList<Card> hand = game.showPlayerHand();
		
		for(ImageView view : playerCardSlots) {
			view.setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
			view.setId("ignore");
		}
			
		for (int i = 0; i < hand.size(); i++) {
			String cardNameImg = "../resources/" + hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
			playerCardSlots.get(i).setImage(image);
			playerCardSlots.get(i).setId(hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt());
		}
	}
	
	public void tableCards() {
		ArrayList<Card> table = game.showTableCards();
		
		for(ImageView view : tableCardSlots) {
			view.setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
		}
		
		for (int i = 0; i < table.size(); i++) {
			String cardNameImg = "../resources/" + table.get(i).getSuitInt() + "_" + table.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
			tableCardSlots.get(i).setImage(image);
		}
	}
	
	/*public void updateTable() {
		ArrayList<Card> hand = game.showTableCards();
		String cardNameImg;
		Image image = null;	
		
		if(hand.get(index).equals(null)) cardNameImg = null;
		tableCardSlots.get(index).setImage(image);
	}
	
	public void updateHand(int index) {
		ArrayList<Card> hand = game.showPlayerHand();
		String cardNameImg;
		Image image = null;	
		if(hand.get(index).equals(null)) cardNameImg = null;
		playerCardSlots.get(index).setImage(image);
	}*/

	/*public void removeCardFromTable() {
		tableCardSlot1.setOnMouseClicked(e -> {tableCardSlot1.setImage(null);System.out.println("empty");});
	}*/
}
