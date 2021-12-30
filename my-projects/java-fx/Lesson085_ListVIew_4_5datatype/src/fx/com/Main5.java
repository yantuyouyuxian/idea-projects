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
public class Main5 extends Application{

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
	
		DataPro2 d1=new DataPro2("A", "20");
		DataPro2 d2=new DataPro2("B", "21");
		DataPro2 d3=new DataPro2("C", "22");
		DataPro2 d4=new DataPro2("D", "23");
	
		ObservableList<DataPro2> list=FXCollections.observableArrayList(new Callback<DataPro2, Observable[]>(){

			@Override
			public Observable[] call(DataPro2 param) {
				// TODO Auto-generated method stub
				SimpleStringProperty [] array=new SimpleStringProperty[] {param.getAgeProperty()};
				return array;
			}
			
		});
		
		ListView<DataPro2> listview=new ListView<DataPro2>(list);
		
		ObservableList<DataPro2> obslist=listview.getItems();//返回上面设置的list
		
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
		
		listview.setCellFactory(TextFieldListCell.forListView(new StringConverter<DataPro2>() {

			@Override
			public String toString(DataPro2 object) {
				// TODO Auto-generated method stub
				return object.getName()+" "+object.getAge();
			}

			@Override
			public DataPro2 fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}));

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				d1.setName("setname");
				d1.setAge("setage");
			}
		});	
		
		obslist.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				ObservableList<DataPro2> data=(ObservableList)observable;
				
				data.forEach(t -> {
					System.out.println(t.getName());
				});
			}
		});
		
		obslist.addListener(new ListChangeListener<DataPro2>() {

			@Override
			public void onChanged(Change<? extends DataPro2> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println(c);
				}
			}
			
		});
		
	}
}

class DataPro2{
	
	
	
	private String name;
	
	private SimpleStringProperty age=new SimpleStringProperty();
	
	public DataPro2(String name,String age) {
		this.name=name;
		this.age.set(age);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getAge() {
		return age.get();
	}
	
	public void setAge(String age) {
		this.age.set(age);
	}
	
	
	public SimpleStringProperty getAgeProperty() {
		return this.age;
	}
	
	
}
