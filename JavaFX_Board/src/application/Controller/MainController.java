package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import application.Util.SceneUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	@FXML private TableView<Board> boardTableView;
	@FXML private TableColumn<Board, Integer> colNo;
	@FXML private TableColumn<Board, String> colTitle;
	@FXML private TableColumn<Board, String> colWriter;
	@FXML private TableColumn<Board, String> colCreDate;
	@FXML private TableColumn<Board, String> colUpdDate;
	@FXML private TableColumn<Board, Boolean> colCbDelete;
	@FXML private CheckBox cbAll;
	Stage stage;
	
	BoardService boardService = new BoardServiceImpl();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 데이터 초기화
		List<Board> boardList = new ArrayList<>();
		boardList = boardService.list();
		
		ObservableList<Board> list = FXCollections.observableArrayList(boardList);
		colNo.setCellValueFactory(new PropertyValueFactory<>("No"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colCreDate.setCellValueFactory(new PropertyValueFactory<>("CreatedAt"));
		colUpdDate.setCellValueFactory(new PropertyValueFactory<>("UpdatedAt"));
		colCbDelete.setCellValueFactory(new PropertyValueFactory<>("CbDelete"));
		
		boardTableView.setItems(list);
		
		cbAll.setSelected(false);
		
		cbAll.setOnMouseClicked(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				CheckBox checkBox = (CheckBox) event.getSource();
				boolean checkAll = checkBox.isSelected();
				boardTableView.getItems().stream().forEach(b -> {
					b.getCbDelete().setSelected(checkAll);
				});
			}
		});
		
		// 테이블뷰 더블 클릭 이벤트
		boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount() == 2 && boardTableView.getSelectionModel().getSelectedItem() != null) {
					int boardNo = boardTableView.getSelectionModel().getSelectedItem().getNo();
					try {
						ReadController readController = (ReadController)SceneUtil.getInstance().getController(UI.READ.getPath());
						readController.read(boardNo);
						
						Parent root = SceneUtil.getInstance().getRoot();
						SceneUtil.getInstance().switchScene(event, UI.READ.getPath(), root);
						
					} catch (IOException e) {
						System.err.println("마우스이벤트 에러");
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public void close(ActionEvent event) {
		SceneUtil.getInstance().close(event);
	}
	
	public void deleteSelected(ActionEvent event) {
		boardTableView.getItems().stream().forEach(b -> {
			CheckBox cbDelete = b.getCbDelete();
			boolean checked = cbDelete.isSelected();
			
			if(checked) {
				int boardNo = b.getNo();
				boardService.delete(boardNo);
				
			}
		});
		initialize(null, null);
	}
	
	public void moveToInsert(ActionEvent event) throws IOException {
		SceneUtil.getInstance().switchScene(event, UI.INSERT.getPath());
	}
	
}
