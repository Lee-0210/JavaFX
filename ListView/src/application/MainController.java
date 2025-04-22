package application;

import java.util.Arrays;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private TextField input;

    @FXML
    private Label item;

    @FXML
    private ListView<String> listView;
    
    List<String> todoList = Arrays.asList(
    	"자바 복습", "시험 보기", "폭삭속았수다 정주행", "바람의나라 92렙업"
	);
    
    // 현재 선택한 아이템
    String selectedItem;
    
    @FXML
    public void initialize() {
    	// todoList 데이터를 추가
    	listView.getItems().addAll(todoList);
    	// 리스트뷰의 항목 선택 이벤트
    	listView.getSelectionModel().selectedItemProperty()
    			.addListener(new ChangeListener<String>() {
    				
    				// 선택한 항목이 변경됐을 때 실행되는 메서드
					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						// 선택한 항목을 지정
						selectedItem = listView.getSelectionModel().getSelectedItem();
						// 라벨에 지정
						item.setText(selectedItem);
					}
    				
				});
    	// 리스트뷰의 더블 클릭 이벤트
    	listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				if(e.getClickCount() == 2) {
					System.out.println("더블 클릭");
					selectedItem = listView.getSelectionModel().getSelectedItem();
					System.out.println("선택된 아이템 : " + selectedItem);
					
					// TODO: 상세 화면으로 이동
				}
			}
		});
    }

    @FXML
    void add(ActionEvent event) {
    	
    	String text = input.getText();
    	
    	if(text != null && !text.equals("")) {
    		System.out.println("추가 버튼 클릭!");
    		// 리스트뷰에 입력 추가
    		listView.getItems().add(text);
    		// 입력 후 텍스트 필드 비우기
    		input.clear();
    	} else {
    		System.err.println("추가할 문장을 입력해주세요");
    	}
    }
    
    @FXML
    void delete(ActionEvent event) {
    	System.out.println("삭제 버튼 클릭!");
    	if(selectedItem == null || selectedItem.equals("")) {
    		System.err.println("선택한 항목이 없습니다.");
    		return;
    	}
    	listView.getItems().remove(selectedItem);
    	selectedItem = null;
    	item.setText("");
    	
    	// 선택 해제
    	listView.getSelectionModel().clearSelection();
    }

}
