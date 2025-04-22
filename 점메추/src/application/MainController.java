package application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MainController {

    @FXML
    private Button button;

    @FXML
    private ImageView image;

    @FXML
    private Label menu;
    
    @FXML 
    private TextArea textArea;
    

    // 메뉴 리스트
    private static List<Menu> MENU_LIST;
    
    // 0.05초마다 동작하는 타임라인 객체
    private Timeline timeline = null;
    // 3초 뒤에 중지시키는 타임라인 객체
    private Timeline stop = null;
    
    /**
     * FXML 이 로딩될 때 초기화하는 메서드
     * * 데이터 초기화
     * * 이벤트 등록
     */
    @FXML
    public void initialize() {
    	// 데이터 초기화
    	setData();
    	// 타이머 세팅
    	setTimer();
    }
    
    void setData() {
    	MENU_LIST = new ArrayList<>();
    	List<String> nameList = Arrays.asList(
    			"김치찌개","닭볶음탕", "돈까스", "떡볶이", "라멘",
    			"마라탕", "보쌈", "불고기", "비빔밥", "뼈해장국",
    			"순대국", "순두부찌개", "오므라이스", "우동", "제육볶음",
    			"짜장면", "초밥", "추어탕", "크림파스타", "햄버거"
    			);
    	List<String> imgList = Arrays.asList(
    			"김치찌개.png","닭볶음탕.png", "돈까스.png", "떡볶이.png", "라멘.png",
    			"마라탕.png", "보쌈.png", "불고기.png", "비빔밥.png", "뼈해장국.png",
    			"순대국.png", "순두부찌개.png", "오므라이스.png", "우동.png", "제육볶음.png",
    			"짜장면.png", "초밥.png", "추어탕.png", "크림파스타.png", "햄버거.png"
    			);
    	for(int i = 0; i < 20; i++) {
    		MENU_LIST.add(new Menu(nameList.get(i), imgList.get(i)));
    	}
    }
    
    void setMenu() {
    	// TODO: 20개의 메뉴 요소들 중, 랜덤으로 하나 선택
    	int index = (int)(Math.random()*20);
    	// 랜덤(추천) 메뉴
    	Menu randomMenu = MENU_LIST.get(index);
    	String menuName = randomMenu.getName();
    	String menuImg = randomMenu.getImage();
    	
    	// 랜덤으로 뽑힌 메뉴명 라벨에 지정
    	menu.setText(menuName);
    	// 랜덤 메뉴 이미지 지정
    	String filePath = getClass().getResource("/img/" + menuImg).toExternalForm();
    	image.setImage(new Image(filePath));
    	textArea.appendText(menuName + "\n");
    }
    
    /**
     * 애니메이션을 위한 타임라인 객체 생성
     */
    void setTimer() {
    	// TextArea 초기화
    	textArea.setText("");
    	
    	// 애니메이션 적용
    	// Timeline 주기적으로 처리할 수 있도록 하는 애니메이션 클래스
    	timeline = new Timeline(
    			// KeyFrame(시간, 이벤트)
    			// : 지정한 시간마다 익명함수 호출
    			// * Duration.mullis(밀리초) - 0.05ch
    			new KeyFrame(Duration.millis(50), e -> {
    				setMenu();	// 랜덤 메뉴 세팅
    			})
		);
    	
    	// 애니메이션 반복 횟수 설정 - Timeline.INDEFINITE (무한 반복)
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	
    	// 3초 뒤에 애니메이션 멈춤
    	stop = new Timeline(
    			// 3초마다 동작하는 애니메이션 지정
    			new KeyFrame(Duration.millis(3000), e -> {
    				timeline.stop();
    			})
		);
    	stop.setCycleCount(1);
    }
    
    /**
     * 버튼 클릭 이벤트
     * @param event
     */
    @FXML
    void random(ActionEvent event) {
    	// 이전 애니메이션 중지
    	timeline.stop();
    	stop.stop();
    	
    	// 애니메이션 시작
    	timeline.play();
    	stop.play();
    }
    
}
