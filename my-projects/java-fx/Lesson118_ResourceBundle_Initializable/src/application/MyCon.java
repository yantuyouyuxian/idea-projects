package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class MyCon implements Initializable{

	public MyCon() {
		System.out.println("MyCon()");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//location:fxml�ļ�
		//resources:language
		System.out.println("initialize");
	}

}
