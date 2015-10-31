package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import model.Card;
import model.CardValue;
import model.Suit;

public class gameController implements Initializable {
	@FXML
	private ImageView playerCardSlot1, playerCardSlot2, playerCardSlot3, playerCardSlot4;
	@FXML
	private ImageView computer1CardSlot1;
	@FXML
	private ImageView computer1CardSlot2;
	@FXML
	private ImageView computer1CardSlot3;
	@FXML
	private ImageView computer1CardSlot4;
	@FXML
	private ImageView computer2Slot1, computer2Slot2, computer2Slot3, computer2Slot4;
	@FXML
	private ImageView computer3Slot1, computer3Slot2, computer3Slot3, computer3Slot4;
	@FXML
	private HBox hboxCenter;
	@FXML
	private HBox hboxTop;
	@FXML
	private VBox vboxRight;
	@FXML
	private VBox vboxLeft;
	
	private ArrayList<ImageView> playerCardSlots;
	private ArrayList<ImageView> computer1CardSlots;
	private ArrayList<ImageView> computer2CardSlots;
	private ArrayList<ImageView> computer3CardSlots;
	private int players;
	private Game game;
	private ArrayList<Card> playerHand;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		players = App.getInstance().getPlayers();
		initArrays();
		game = new Game(players, App.getInstance().getDifficulty());
		playersCards();
		tableCards();
		setListeners();
		setComputersCard();
	}
	
	public void initArrays() {
		playerCardSlots = new ArrayList<ImageView>();
		playerCardSlots.add(playerCardSlot1);
		playerCardSlots.add(playerCardSlot2);
		playerCardSlots.add(playerCardSlot3);
		playerCardSlots.add(playerCardSlot4);
		
		computer1CardSlots = new ArrayList<ImageView>();
		computer1CardSlots.add(computer1CardSlot1);
		computer1CardSlots.add(computer1CardSlot2);
		computer1CardSlots.add(computer1CardSlot3);
		computer1CardSlots.add(computer1CardSlot4);
	}
	
	// Ha alla listerns här
	public void setListeners() {	
		for (ImageView imageView : playerCardSlots) {
			imageView.setOnMouseClicked(e -> {
				String card = imageView.getId();
				if (card != "ignore") {
					int iend = card.indexOf("_");
					int cardSuit = Integer.parseInt(card.substring(0, iend));
					int cardValue = Integer.parseInt(card.substring(iend + 1, card.length()));
					System.out.println(cardSuit + " " + cardValue);
					game.layCards(new Card(CardValue.values()[cardValue - 2], Suit.values()[cardSuit]));
					tableCards();
					changeComputerCards(game.showPlayerHand().size());
					playerHand = game.showPlayerHand();
					System.out.println(playerHand);
					
					if (playerHand.isEmpty()) {
						boolean newCards = game.dealNewCards();
						if(newCards == true) {
							newCardsComputer();
						} else {  
							boolean round = game.newRound();
							if (round == false) {
								gameEnded();
							}
						}
					}
					playersCards();
				}
			});
		}
	}
	
	/*public void newRound() {
		
	}*/
	
	public void gameEnded() {
		System.out.println("SLUT");
	}
	
	// Delar ut kort till player, kanske ändrar koden sen
	public void playersCards() {
		ArrayList<Card> playerHand = game.showPlayerHand();
		
		for(ImageView view : playerCardSlots) {
			view.setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
			view.setId("ignore");
		}
			
		for (int i = 0; i < playerHand.size(); i++) {
			String cardNameImg = "../resources/" + playerHand.get(i).getSuitInt() + "_" + playerHand.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
			playerCardSlots.get(i).setImage(image);
			playerCardSlots.get(i).setId(playerHand.get(i).getSuitInt() + "_" + playerHand.get(i).getCardValueInt());
		}
	}
	
	public void tableCards() {
		ArrayList<Card> table = game.showTableCards();
		hboxCenter.getChildren().clear();
		
		for (int i = 0; i < table.size(); i++) {
			String cardNameImg = "../resources/" + table.get(i).getSuitInt() + "_" + table.get(i).getCardValueInt() + ".png";
			Image image = new Image(gameController.class.getResourceAsStream(cardNameImg));
			
			ImageView view = new ImageView();
			view.fitWidthProperty().bind(image.widthProperty());
			view.setImage(image);
			
			hboxCenter.getChildren().add(view);
		}
	}
	
	public void setComputersCard() {
		if (players == 2) {
			vboxRight.getChildren().clear();
			vboxLeft.getChildren().clear();
		}		
		else if (players == 3) {
			vboxLeft.getChildren().clear();
		}	
	}
	
	public void newCardsComputer() {
		for (int i = 0; i < 4; i++) {
			computer1CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/0.png")));
			if (players == 3)
				computer2CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/0.png")));
			else if (players == 4)
				computer3CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/0.png")));
		}
	}
	
	public void changeComputerCards(int cards) {
		int hideCards = 4 - cards;
		for (int i = 0; i < hideCards; i++) {
			computer1CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
			if (players == 3)
				computer2CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
			else if (players == 4)
				computer3CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
		}
	}
}
