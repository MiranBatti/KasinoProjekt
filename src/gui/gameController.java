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

public class gameController implements Initializable {
	@FXML
	private ImageView playerCardSlot1, playerCardSlot2, playerCardSlot3, playerCardSlot4; // Måste lägga till ID i SceneBuilder i code menyn för att använda GUI objekt i koden
	@FXML
	private ArrayList<ImageView> playerCardSlots;
	
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
	}
	
	// Ha alla listerns här
	public void setListeners() {
		
		for (ImageView imageView : playerCardSlots) {
			System.out.println(((ImageView)playerCardSlot1).getImage());
			imageView.setOnMouseClicked(e -> {
				String card = imageView.getId();
				int iend = card.indexOf("_");
				String cardSuit = card.substring(0, iend);
				String cardRank = card.substring(iend + 1, card.length());
				System.out.println(cardSuit + " "  + cardRank);
				//game.layCards(card);
				Card c = new Card(Integer.parseInt(cardRank), Integer.parseInt(cardSuit)); // borde ändra så card hämtas från game istället
				System.out.println(c.toString());
				game.layCards(c);
				
				//this.updateHand(this.playerCardSlots.indexOf(this.playerCardSlot1));
				//Lägg klickat kort
				//Lägg kort för motspelare
				//Ta bort kort som har lagt / Hide
				//Uppdatera table bordet
				//Nya kort om playern har slut / koll om spelet är slut isåfall metod för att skriva ut vinaren 
			});
		}

	}
	
	// Delar ut kort till player, kanske ändrar koden sen
	public void playersCards() {
		ArrayList<Card> hand = game.showPlayerHand();
		
		for (int i = 0; i < hand.size(); i++) {
			String cardNameImg = "../resources/" + hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
			playerCardSlots.get(i).setImage(image);
			playerCardSlots.get(i).setId(hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt());
		}
	}
	
	public void tableCards() {
		ArrayList<Card> hand = game.showTableCards();
		
		for (int i = 0; i < hand.size(); i++) {
			String cardNameImg = "../resources/" + hand.get(i).getSuitInt() + "_" + hand.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
		}
	}
	
	/*public void updateTable(int index) {
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
