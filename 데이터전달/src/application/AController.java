package application;

import java.io.IOException;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AController {

    @FXML
    private Button button;

    @FXML
    private TextField input;

    @FXML
    void toB(ActionEvent event) throws IOException {
    	Map<String, Object> map = Main.get("B");
    	BController bController = (BController)map.get("controller");
    	String data = input.getText();		// 입력 데이터
    	bController.passData(data);			// B화면으로 데이터 전달
    	
    	// B 화면으로 이동
    	Parent root = (Parent) map.get("root");
    	Main.setRoot(root);
    }
}
