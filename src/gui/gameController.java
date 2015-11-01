package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Card;
import model.CardValue;
import model.Suit;

/**
 * Controller for game.fxml
 */
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
	private ImageView computer2CardSlot1;
	@FXML
	private ImageView computer2CardSlot2;
	@FXML
	private ImageView computer2CardSlot3;
	@FXML
	private ImageView computer2CardSlot4;
	@FXML
	private ImageView computer3CardSlot1;
	@FXML
	private ImageView computer3CardSlot2;
	@FXML
	private ImageView computer3CardSlot3;
	@FXML
	private ImageView computer3CardSlot4;
	@FXML
	private HBox hboxCenter;
	@FXML
	private HBox hboxTop;
	@FXML
	private VBox vboxRight;
	@FXML
	private VBox vboxLeft;
	@FXML
	private Label lblPlayer;
	@FXML
	private Label lblComputer1;
	@FXML
	private Label lblComputer2;
	@FXML
	private Label lblComputer3;
	
	private ArrayList<ImageView> playerCardSlots;
	private ArrayList<ImageView> computer1CardSlots;
	private ArrayList<ImageView> computer2CardSlots;
	private ArrayList<ImageView> computer3CardSlots;
	private int players;
	private Game game;
	private ArrayList<Card> playerHand;

	/**
	 * Sets every component needed.
	 * <br>
	 * Can't use a Construktor for JavaFx Controller
	 */
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
	
	/**
	 * Init ArrayLists to make it easier to controll the GUI.
	 */
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
		
		computer2CardSlots = new ArrayList<ImageView>();
		computer2CardSlots.add(computer2CardSlot1);
		computer2CardSlots.add(computer2CardSlot2);
		computer2CardSlots.add(computer2CardSlot3);
		computer2CardSlots.add(computer2CardSlot4);
		
		computer3CardSlots = new ArrayList<ImageView>();
		computer3CardSlots.add(computer3CardSlot1);
		computer3CardSlots.add(computer3CardSlot2);
		computer3CardSlots.add(computer3CardSlot3);
		computer3CardSlots.add(computer3CardSlot4);
	}
	
	/**
	 * Sets listener for click event on HumanPlayer cards and what will happend on event.
	 */
	public void setListeners() {	
		for (ImageView imageView : playerCardSlots) {
			imageView.setOnMouseClicked(e -> {
				String card = imageView.getId();
				if (card != "ignore") {
					int iend = card.indexOf("_");
					int cardSuit = Integer.parseInt(card.substring(0, iend));
					int cardValue = Integer.parseInt(card.substring(iend + 1, card.length()));
					game.layCards(new Card(CardValue.values()[cardValue - 2], Suit.values()[cardSuit]));
					tableCards();
					changeComputerCards(game.showPlayerHand().size());
					playerHand = game.showPlayerHand();
					
					if (playerHand.isEmpty()) {
						boolean newCards = game.dealNewCards();
						if(newCards == true) {
							newCardsComputer();
						} else {  
							boolean round = game.newRound();
							addScore();
							if (round == true) {
								newCardsComputer();
								tableCards();
							} else {
								gameEnded();
							}
						}
					}
					playersCards();
				}
			});
		}
	}
	
	/**
	 * Add score to labels in the application.
	 */
	public void addScore() {
		hboxCenter.getChildren().clear();
		
		lblPlayer.setText("Score: " + game.getCountPoints().playerPoints(0));
		lblComputer1.setText("Score: " + game.getCountPoints().playerPoints(1));
		if (players == 3)
			lblComputer2.setText("Score: " + game.getCountPoints().playerPoints(2));
		else if (players == 4)
			lblComputer3.setText("Score: " + game.getCountPoints().playerPoints(3));
	}
	
	/**
	 * Adds every card player has on hand.
	 */
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
	
	/**
	 * Adds every card table has.
	 */
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
	
	/**
	 * Takes away unnecessary cards.
	 */
	public void setComputersCard() {
		if (players == 2) {
			vboxRight.getChildren().clear();
			vboxLeft.getChildren().clear();
		}		
		else if (players == 3) {
			vboxLeft.getChildren().clear();
		}	
	}
	
	/**
	 * Every computer gets new cards.
	 */
	public void newCardsComputer() {
		for (int i = 0; i < 4; i++) {
			computer1CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/0.png")));
			if (players == 3)
				computer2CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/0.png")));
			else if (players == 4)
				computer2CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/0.png")));
				computer3CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/0.png")));
		}
	}
	
	/**
	 * Hides card images that are not in play.
	 * @param cards
	 */
	public void changeComputerCards(int cards) {
		int hideCards = 4 - cards;
		for (int i = 0; i < hideCards; i++) {
			computer1CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
			if (players == 3)
				computer2CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
			else if (players == 4)
				computer2CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
				computer3CardSlots.get(i).setImage(new Image(gameController.class.getResourceAsStream("../resources/transparent.png")));
		}
	}
	
	/**
	 * Shows a confirm box when game has ended to close program and show the winner.
	 */
	public void gameEnded() {
		ArrayList<Integer> winner = game.getCountPoints().getPlayerHigestPoints();
		String winnerString = "";
		
		for (Integer w : winner) {
			switch (w) {
			case 0:
				winnerString += "You, ";
				break;
			case 1:
				winnerString += "Computer 1, ";
				break;
			case 2:
				winnerString += "Computer 2, ";
				break;
			case 3:
				winnerString += "Computer 3, ";
				break;
			}
		}
		winnerString += "WON!";
		
		Stage endStage = new Stage();
		endStage.initModality(Modality.APPLICATION_MODAL);
		endStage.setTitle("Game ended");
		endStage.setWidth(200);
		
		Label lblMessage = new Label(winnerString);
		Button closeGame = new Button("Close");
		closeGame.getStyleClass().add("button-checkbox");
		Button closeWindow = new Button("Ok");
		
		
		closeGame.setOnAction(e -> {
			Platform.exit();
			System.exit(0);
		});
		
		closeWindow.setOnAction(e -> {
			e.consume();
			endStage.close();
		});
		
		HBox layout = new HBox(10);
		layout.getChildren().addAll(closeGame, closeWindow);
		layout.setAlignment(Pos.CENTER);
		
		VBox mainLayout = new VBox(10);
		mainLayout.getChildren().addAll(lblMessage, layout);
		mainLayout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(mainLayout);
		endStage.setScene(scene);
		endStage.show();
	}
}
