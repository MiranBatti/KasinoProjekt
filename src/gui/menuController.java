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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class menuController implements Initializable{
	@FXML
	private ToggleGroup difficultyToggleGrp;
	@FXML
	private ToggleGroup playersToggleGrp;
	@FXML
	private Button startBtn;
	@FXML
	private RadioButton players2;
	@FXML
	private RadioButton players3;
	@FXML
	private RadioButton players4;
	
	public int nbrOfPlayers;
	
	/**
	 * Init values/listeners
	 * Can't use a Construktor for JavaFx Controller
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nbrOfPlayers = 2; // Must have alteast 2 players
		players2.setOnAction(e -> nbrOfPlayers = 2);
		players3.setOnAction(e -> nbrOfPlayers = 3);
		players4.setOnAction(e -> nbrOfPlayers = 4);
	}
	
	public void startBtnClick(ActionEvent event) {
		try {
			App.getInstance().setPlayers(nbrOfPlayers);
			
			Parent gameParent = FXMLLoader.load(getClass().getResource("game.fxml"));
			Scene gameScene = new Scene(gameParent);
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			primaryStage.hide();
			primaryStage.setScene(gameScene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
