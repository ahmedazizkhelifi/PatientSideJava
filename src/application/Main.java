package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;

public class Main extends Application {
	
	public Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			// Login scene
			AnchorPane loginRoot= (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene loginScene = new Scene(loginRoot ,1018,604);
			loginScene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
			primaryStage.setTitle("PatientSIDE");
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(loginScene);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
