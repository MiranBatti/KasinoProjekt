package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

public class menuController {
	@FXML
	private ToggleGroup difficultyToggleGrp;
	@FXML
	private ToggleGroup playersToggleGrp;
	@FXML
	private Button startBtn;
	
	
	public void startBtnClick() {
		System.out.println("yo");
	}
}
