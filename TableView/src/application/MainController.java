package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnList;

    @FXML
    void exit(ActionEvent event) {
    	
    }

    @FXML
    void toList(ActionEvent event) throws IOException {
    	Main.setRoot("List");
    }

}
