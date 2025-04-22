package application;
	
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		// Main.fxml 화면파일을 로드
		Parent layout = loadFXML("Main");
		// Main.fxml 화면 레이아웃을 지정하여 Scene 생성
		scene = new Scene(layout, 600, 400);
		stage.setScene(scene);		// stage 에 Scene 등록
		stage.show();				// stage 출력
	}
	
	/*
	 * Scene 의 컨테이너를 불러온 FXML 로 지정하는 메서드
	 */
	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}
	
	/**
	 * FXML 파일을 읽어오는 메서드
	 * @param fxml
	 * @return
	 * @throws IOException
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	
	/**
	 * FXML 화면 이름을 전달받아
	 * loader, root, controller 를 Map 으로 반환하는 메서드
	 * @param fxml
	 * @return
	 * @throws IOException
	 */
	public static Map<String, Object> get(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		Parent root = fxmlLoader.load();
		Object controller = fxmlLoader.getController();
		Map<String, Object> map = new HashMap<>();
		map.put("loader", fxmlLoader);
		map.put("root", root);
		map.put("controller", controller);
		
		return map;
	}
	
	/**
	 * 새로운 화면으로 이동
	 * @param root
	 */
	public static void setRoot(Parent root) throws IOException {
		scene.setRoot(root);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
