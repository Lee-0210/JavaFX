package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	private static Scene scene;
	
	@Override
	public void start(Stage stage) throws IOException {
		Parent layout = FXMLLoader.load(getClass().getResource("Main.fxml"));
		scene = new Scene(layout, 880, 600);
		stage.setScene(scene);
//		Image icon = new Image("icon.png");
//		stage.getIcons().add(icon);
		stage.setTitle("게시판");
		stage.setResizable(false);
		stage.show();
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
