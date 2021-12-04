/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	
		ListView<String> listview=new ListView<>();
		ObservableList<String> obslist=listview.getItems();
		obslist.add("data-a");
		obslist.add("data-b");
		obslist.add("data-c");
		obslist.add("data-d");
		obslist.add("data-e");

		listview.setPrefWidth(500);
		listview.setPrefHeight(300);
		listview.setFixedCellSize(50);//设置单元格大小
		
		Button bu=new Button("button");
//		bu.setFocusTraversable(false);//无法获得焦点
		
		
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
		
		
//		listview.getSelectionModel().select(0);
		
		
//		listview.requestFocus();
//		listview.getFocusModel().focus(3);
//		System.out.println(listview.getFocusModel().getFocusedItem());
	
		listview.getFocusModel().focusedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				listview.requestFocus();
				listview.getFocusModel().focus(3);
			}
		});
	
	}

}
