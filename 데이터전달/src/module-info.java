module 데이터전달 {
	requires javafx.controls;
	requires javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
