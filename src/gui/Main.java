package gui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *  Start point for Application when using GUI
 */
public class Main extends Application {
	
	/**
	 * Setup JavaFx Application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Casino");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Start application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
