module JavaFX_Board {
	requires lombok;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires java.desktop;
	opens application to javafx.graphics, javafx.fxml;
	opens application.Controller to javafx.fxml;
	opens application.DTO to javafx.base;
	exports application;
}
  