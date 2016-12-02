package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FxTestenController {
	@FXML
	private TextField txt;

	public FxTestenController() {
	}

	public void test() {
		txt.setText("Hello World");
	}
}
