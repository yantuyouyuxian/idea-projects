/**
 * 
 */
package fx.com;

import java.util.Comparator;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
	
	
		ListView<String> listview=new ListView<String>();
		ObservableList<String> obslist=listview.getItems();
		obslist.addAll("data_a","data_b","data_c","data_d","data_e");
	

		listview.setPrefWidth(500);
		listview.setPrefHeight(300);
		
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,listview);
		AnchorPane.setLeftAnchor(listview, 100.0);
		AnchorPane.setTopAnchor(listview, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		listview.setEditable(true);

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				obslist.add("abc add");
				obslist.sort(new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						return o2.compareTo(o1);//µ¹Ðò
					}
				});
			}
		});	
		
		obslist.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				ObservableList<String> data=(ObservableList)observable;
				System.out.println(data);
			}
		});
		
		obslist.addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(Change<? extends String> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println(c);
				}
			}
			
		});
		
	}
}


