package application;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	private ListView<String> listview;
	
	@FXML
	private Button button;
	
	public Controller() {
		
	}
	
	@FXML
	private void initialize() {
		
//		ObservableList<String> obslist =FXCollections.observableArrayList();
//		obslist.add("A");
//		obslist.add("B");
//		obslist.add("C");
//		listview.setItems(obslist);
		
		listview.getItems().addAll("a","b");
		
		listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
	}

	public Button getButton() {
		return button;
	}
	
	@FXML
	private void action() {
		try {
			FXMLLoader fl2=new FXMLLoader();
			fl2.setLocation(fl2.getClassLoader().getResource("fxml/main2.fxml"));
			AnchorPane an2= (AnchorPane)fl2.load();
			
			Stage stage=new Stage();
			Scene scene=new Scene(an2);
			stage.setHeight(600);
			stage.setWidth(1000);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
