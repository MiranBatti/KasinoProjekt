package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	public static void display(String name, String message) {
		Stage endStage = new Stage();
		endStage.initModality(Modality.APPLICATION_MODAL);
		endStage.setTitle(name);
		endStage.setWidth(200);
		
		Label lblMessage = new Label(message);
		Button close = new Button("Close");
		Button newGame = new Button("New Game");
		
		
		close.setOnAction(e -> {
			endStage.close();
		});
		
		newGame.setOnAction(e -> {
			System.out.println("Ok");
		});
		
		HBox layout = new HBox(10);
		layout.getChildren().addAll(close, newGame);
		layout.setAlignment(Pos.CENTER);
		
		VBox mainLayout = new VBox(10);
		mainLayout.getChildren().addAll(lblMessage, layout);
		mainLayout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(mainLayout);
		endStage.setScene(scene);
		endStage.show();
	}
}
