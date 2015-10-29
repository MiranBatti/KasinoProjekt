package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class menuController implements Initializable {
	
	@FXML
	private Button startBtn;
	@FXML
	private RadioButton players2, players3, players4;	
	@FXML
	private RadioButton difficultyEasy;
	@FXML
	private RadioButton difficultyMedium;
	@FXML
	private RadioButton difficultyHard;
	
	private int nbrOfPlayers;
	private int difficulty;
	
	/**
	 * Init values/listeners
	 * Can't use a Construktor for JavaFx Controller
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		players2.setOnAction(e -> nbrOfPlayers = 2);
		players3.setOnAction(e -> nbrOfPlayers = 3);
		players4.setOnAction(e -> nbrOfPlayers = 4);
		difficultyEasy.setOnAction(e -> difficulty = 0);
		difficultyMedium.setOnAction(e -> difficulty = 1);
		difficultyHard.setOnAction(e -> difficulty = 2);
	}
	
	/**
	 * Change Scene to game scene
	 * @param event
	 */
	public void startBtnClick(ActionEvent event) {
		try {
			App.getInstance().setPlayers(nbrOfPlayers);
			App.getInstance().setDifficulty(difficulty);
			
			Parent gameParent = FXMLLoader.load(getClass().getResource("game.fxml"));
			Scene gameScene = new Scene(gameParent, 1200, 700);
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			primaryStage.hide();
			primaryStage.setScene(gameScene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
