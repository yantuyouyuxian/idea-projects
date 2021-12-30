package fx.com;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController {
	
	@FXML
	private Button fxmlbutton;//Ѱ�Ҹ�id��button
	
	@FXML
	private Label fxmllabel;
	
	public MyController() {
		
	}
	
	@FXML
	private void initialize() {
		System.out.println(fxmlbutton.getText());
		System.out.println(fxmllabel.getText());
	}
	
	public Button getFxmlbutton() {
		return fxmlbutton;
	}

	public Label getFxmllabel() {
		return fxmllabel;
	}

	@FXML
	private void action() {
		System.out.println("action");
	}
	
}
