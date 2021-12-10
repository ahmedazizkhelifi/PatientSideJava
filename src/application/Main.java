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
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Medecin.fxml"));
			Scene scene = new Scene(root,1175,767);
			scene.getStylesheets().add(getClass().getResource("Medecin.css").toExternalForm());
			System.out.print(root.getChildren().get(2));//723
			primaryStage.setTitle("Médecin | PatientSIDE");
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
