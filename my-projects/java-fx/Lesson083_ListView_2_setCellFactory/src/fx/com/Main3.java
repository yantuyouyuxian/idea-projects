/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
public class Main3 extends Application{

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
	
//		ListView<String> listview=new ListView<>();
//		ObservableList<String> obslist=listview.getItems();
//		obslist.add("a");
//		obslist.add("b");
//		obslist.add("c");
//		obslist.add("d");
//		obslist.add("e");

		
//		listview.setCellFactory(TextFieldListCell.forListView());
//		Callback<ListView<String>,ListCell<String>> call=TextFieldListCell.forListView(new StringConverter<String>() {
//
//			@Override
//			public String toString(String object) {
//				// TODO Auto-generated method stub
//				return object;
//			}
//
//			
//			@Override
//			public String fromString(String string) {
//				// TODO Auto-generated method stub
//				return string+"(new)";
//			}});
//		listview.setCellFactory(call);
		
		
		Data d1=new Data("A");
		Data d2=new Data("B");
		Data d3=new Data("C");
	
		ListView<Data> listview=new ListView<Data>();
		ObservableList<Data> obslist=listview.getItems();
		obslist.addAll(d1,d2,d3);
		
//		listview.setCellFactory(TextFieldListCell.forListView(new StringConverter<Data>() {
//
//			@Override
//			public String toString(Data object) {
//				// TODO Auto-generated method stub
//				return object.getName();
//			}
//
//			@Override
//			public Data fromString(String string) {
//				// TODO Auto-generated method stub
//				return new Data(string);
//			}
//		}));
		
//		listview.setCellFactory(ComboBoxListCell.forListView(new StringConverter<Data>() {
//
//			@Override
//			public String toString(Data object) {
//				// TODO Auto-generated method stub
//				return object.getName();
//			}
//
//			@Override
//			public Data fromString(String string) {
//				// TODO Auto-generated method stub
//				return new Data(string);
//			}
//			
//		}, new Data("D"),new Data("E")));
		
//		listview.setCellFactory(ChoiceBoxListCell.forListView(new StringConverter<Data>() {
//
//			@Override
//			public String toString(Data object) {
//				// TODO Auto-generated method stub
//				return object.getName();
//			}
//
//			@Override
//			//有输入才调用
//			public Data fromString(String string) {
//				// TODO Auto-generated method stub
//				return new Data(string);
//			}
//
//		}, new Data("D"), new Data("E")));
//		
		Callback<ListView<Data>,ListCell<Data>> call=CheckBoxListCell.forListView(new Callback<Data, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(Data param) {
				// TODO Auto-generated method stub
				if(param.getName().equals("B")) {
					return new SimpleBooleanProperty(false);
				}
				return new SimpleBooleanProperty(true);
			}
		}, new StringConverter<Data>() {

			@Override
			public String toString(Data object) {
				// TODO Auto-generated method stub
				return object.getName();
			}

			@Override
			public Data fromString(String string) {
				// TODO Auto-generated method stub
				return new Data(string);
			}
		});
		listview.setCellFactory(call);
		
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
				listview.edit(2);
			}
		});
		
		listview.setOnEditStart(new EventHandler<ListView.EditEvent<Data>>() {
			
			@Override
			public void handle(EditEvent<Data> event) {
				// TODO Auto-generated method stub
				System.out.println("start edit");
				System.out.println(event.getIndex());
				System.out.println(event.getNewValue());
			}
		});
		
		listview.setOnEditCancel(new EventHandler<ListView.EditEvent<Data>>() {
			
			@Override
			public void handle(EditEvent<Data> event) {
				// TODO Auto-generated method stub
				System.out.println("cancel edit");
			}
		});
		
		listview.setOnEditCommit(new EventHandler<ListView.EditEvent<Data>>() {
			
			@Override
			public void handle(EditEvent<Data> event) {
				// TODO Auto-generated method stub
				System.out.println("commit edit");
				System.out.println(event.getIndex());
				System.out.println(event.getNewValue().getName());
				
				obslist.set(event.getIndex(), event.getNewValue());
			}
		});
	
	}

}


