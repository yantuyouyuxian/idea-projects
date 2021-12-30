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
	
		Data d1=new Data("A", "20");
		Data d2=new Data("B", "21");
		Data d3=new Data("C", "22");
		Data d4=new Data("D", "23");
	
		
		
		ListView<Data> listview=new ListView<Data>();
		
		ObservableList<Data> obslist=listview.getItems();//返回上面设置的list
		
		obslist.addAll(d1,d2,d3,d4);
	

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
		
		listview.setCellFactory(TextFieldListCell.forListView(new StringConverter<Data>() {

			@Override
			public String toString(Data object) {
				// TODO Auto-generated method stub
				return object.getName()+" "+object.getAge();
			}

			@Override
			public Data fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}));

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				obslist.add(new Data("E","30"));
//				obslist.set(0, new Data(obslist.get(0).getName(), "100"));
				
				d1.setAge("100");
				listview.refresh();
			}
		});	
		
		obslist.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				ObservableList<Data> data=(ObservableList)observable;
//				data.forEach(new Consumer<Data>() {
//
//					@Override
//					public void accept(Data t) {
//						// TODO Auto-generated method stub
//						System.out.println(t.getName());
//					}
//				});
				
				data.forEach(t -> {
					System.out.println(t.getName());
				});
			}
		});
		
		obslist.addListener(new ListChangeListener<Data>() {

			@Override
			public void onChanged(Change<? extends Data> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println(c);
				}
			}
			
		});
		
	}
}

class Data{
	
	private String name;
	
	private String age;
	
	public Data(String name,String age) {
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
