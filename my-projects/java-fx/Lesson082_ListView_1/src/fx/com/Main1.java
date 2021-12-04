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
		ObservableList<String> obslist=FXCollections.observableArrayList();
		obslist.add("data-a");
		obslist.add("data-b");
		obslist.add("data-c");
		obslist.add("data-d");
		obslist.add("data-e");
		obslist.add("data-f");
		obslist.add("data-g");
		obslist.add("data-h");
		
		
		ListView<String> listview=new ListView<>(obslist);
		listview.setPlaceholder(new Label("无数据"));
		listview.setPrefWidth(250);
		listview.setPrefHeight(150);
		
		listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listview.getSelectionModel().select(0);
		
		listview.getItems().add("get add");
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(listview,bu);
		AnchorPane.setLeftAnchor(listview, 100.0);
		AnchorPane.setTopAnchor(listview, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		listview.requestFocus();
//		listview.scrollTo(5);
		listview.setEditable(true);
		//listview可编辑
		listview.setCellFactory(TextFieldListCell.forListView());
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				obslist.add("bu add");
//				obslist.remove(0);
				listview.scrollTo(5);
				
//				System.out.println(listview.getSelectionModel().getSelectedItem());
			}
		});
		
		listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
		listview.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
		listview.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
			
			@Override
			public void handle(ScrollToEvent<Integer> event) {
				// TODO Auto-generated method stub
				System.out.println(event.getScrollTarget());
			}
		});
	}

}
