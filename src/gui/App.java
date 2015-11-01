package gui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *  Start point for Application when using GUI.
 */
public class App extends Application {
	
	private static App instance;
	private int players;
	private int difficulty;

	/**
	 * Construktor.
	 */
    public App() {
        instance = this;
    }

    /**
     * Return App instance.
     * <br>
     * purpose of this method is to use the instace to get number of players and difficulty level.
     * @return
     */
    public static App getInstance() {
        return instance;
    }
	
	/**
	 * Setup JavaFx Application.
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
	 * Start application.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Get numbers of players.
	 * @return
	 */
	public int getPlayers() {
		return players;
	}

	/**
	 * Set numnbers of players.
	 * @param players
	 */
	public void setPlayers(int players) {
		this.players = players;
	}
	
	/**
	 * Get difficulty level.
	 * @return
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Set difficulty level.
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
}
