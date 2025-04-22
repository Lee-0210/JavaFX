module TableView {
	requires javafx.controls;
	requires javafx.fxml;
	requires lombok;
	requires javafx.base;
	opens application to javafx.base, javafx.graphics, javafx.fxml;
}
