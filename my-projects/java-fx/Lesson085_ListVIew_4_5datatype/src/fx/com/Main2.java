/**
 * 
 */
package fx.com;

import java.util.Comparator;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
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
public class Main2 extends Application{

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
	
		SimpleStringProperty s1=new SimpleStringProperty("A");
		SimpleStringProperty s2=new SimpleStringProperty("B");
		SimpleStringProperty s3=new SimpleStringProperty("C");
		SimpleStringProperty s4=new SimpleStringProperty("D");
		SimpleStringProperty s5=new SimpleStringProperty("E");
	
		ObservableList<SimpleStringProperty> list=FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>(){

			@Override
			public Observable[] call(SimpleStringProperty param) {
				// TODO Auto-generated method stub
				System.out.println("callback "+param.get());
				SimpleStringProperty[] array=new SimpleStringProperty[] {param};
				return array;
			}
			
		});//触发更新操作
		
		ListView<SimpleStringProperty> listview=new ListView<SimpleStringProperty>(list);
		
		ObservableList<SimpleStringProperty> obslist=listview.getItems();//返回上面设置的list
		
		obslist.addAll(s1,s2,s3,s4,s5);
	

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
		
		listview.setCellFactory(TextFieldListCell.forListView(new StringConverter<SimpleStringProperty>() {

			@Override
			public String toString(SimpleStringProperty object) {
				// TODO Auto-generated method stub
				return object.get();
			}

			@Override
			public SimpleStringProperty fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}));

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				obslist.add(new SimpleStringProperty("add"));
//				obslist.set(0, new SimpleStringProperty("new ssp"));
				
//				obslist.get(0).set("get 0 set");
				s1.set("s1 set");
//				listview.refresh();
			}
		});	
		
		obslist.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				ObservableList<SimpleStringProperty> data=(ObservableList)observable;
//				data.forEach(new Consumer<SimpleStringProperty>() {
//
//					@Override
//					public void accept(SimpleStringProperty t) {
//						// TODO Auto-generated method stub
//						t.get();
//					}
//				});
				
				data.forEach(t -> {
					System.out.println(t.get());
				});
			}
		});
		
		obslist.addListener(new ListChangeListener<SimpleStringProperty>() {

			@Override
			public void onChanged(Change<? extends SimpleStringProperty> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println(c);
				}
			}
			
		});
		
	}
}


