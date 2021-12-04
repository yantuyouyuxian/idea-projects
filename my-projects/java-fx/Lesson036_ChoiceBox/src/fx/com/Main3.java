package fx.com;

import java.util.Comparator;

import javafx.application.Application;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main3 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Button button=new Button("µ¹Ðò");
		
		AnchorPane an=new AnchorPane();
		
		ChoiceBox<String> cb1=new ChoiceBox<String>();
		ObservableList <String>list1=FXCollections.observableArrayList();
		list1.addAll("Êý×Ö","×ÖÄ¸");
		cb1.setItems(list1);
		
		
		ChoiceBox<String> cb2=new ChoiceBox<String>(); 
		
		ObservableList <String>list2=FXCollections.observableArrayList();
		list2.addAll("3","1","6","6","5");
		
		ObservableList <String>list3=FXCollections.observableArrayList();
		list3.addAll("a","b","c","d","e");
		
		
		
//		SimpleListProperty<String> slp=new SimpleListProperty<>();
		
	
		
		AnchorPane.setTopAnchor(cb1, 100.0);
		AnchorPane.setTopAnchor(cb2, 300.0);
		
		an.getChildren().addAll(cb1,cb2,button);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		cb1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if(newValue.equals("Êý×Ö")) {
					cb2.setItems(list2);
					cb2.show();
				}else if(newValue.equals("×ÖÄ¸")) {
					cb2.setItems(list3);
					cb2.show();
				}
			}
		});
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				list2.sort(new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						int i1=Integer.valueOf(o1);
						int i2=Integer.valueOf(o2);
						return i2-i1;
						
					}
				});
			}
		});
		
	}

}
