/**
 * 
 */
package fx.com;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
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
	
		DataPro d1=new DataPro("And", "25");
		DataPro d2=new DataPro("Black", "21");
		DataPro d3=new DataPro("Cat", "16");
		DataPro d4=new DataPro("Date", "23");
		DataPro d5=new DataPro("Else", "15");
		DataPro d6=new DataPro("False", "16");
		DataPro d7=new DataPro("Good", "21");
		DataPro d8=new DataPro("High", "17");
		DataPro d9=new DataPro("If", "30");
		DataPro d10=new DataPro("Jeep", "19");
		DataPro d11=new DataPro("Kite", "21");
		DataPro d12=new DataPro("Lift", "14");
		
	
		ObservableList<DataPro> list=FXCollections.observableArrayList(new Callback<DataPro, Observable[]>(){

			@Override
			public Observable[] call(DataPro param) {
				// TODO Auto-generated method stub
				SimpleStringProperty [] array=new SimpleStringProperty[] {param.getNameProperty(),param.getAgeProperty()};
				return array;
			}
			
		});
		
		ListView<DataPro> listview=new ListView<DataPro>(list);
		
		ObservableList<DataPro> obslist=listview.getItems();//返回上面设置的list
		
		obslist.addAll(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12);
	

		listview.setPrefWidth(300);
		listview.setPrefHeight(400);
		
		TextField tf=new TextField();
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(tf,bu,listview);
		AnchorPane.setTopAnchor(listview, 50.0);
		
		AnchorPane.setLeftAnchor(bu, 250.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		listview.setEditable(true);
		
		an.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				listview.setItems(obslist);
			}
		});
		
		listview.setCellFactory(TextFieldListCell.forListView(new StringConverter<DataPro>() {

			@Override
			public String toString(DataPro object) {
				// TODO Auto-generated method stub
				return object.getName()+" "+object.getAge();
			}

			@Override
			public DataPro fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}));

		tf.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				FilteredList<DataPro> fl=obslist.filtered(new Predicate<DataPro>() {
					
					@Override
					public boolean test(DataPro t) {
						// TODO Auto-generated method stub
						if(t.getName().contains(newValue)) {
							return true;
						}else {
							return false;
						}
					}
				});
				
				listview.setItems(fl);
				
			}
		});
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				SortedList<DataPro> sl=obslist.sorted(new Comparator<DataPro>() {
					
					@Override
					public int compare(DataPro o1, DataPro o2) {
						// TODO Auto-generated method stub
						int a=Integer.valueOf(o1.getAge());
						int b=Integer.valueOf(o2.getAge());
						return a-b;
					}
				});
				
				listview.setItems(sl);
			}
		});
		
		
	}
}

class DataPro{
	
	private SimpleStringProperty name=new SimpleStringProperty();
	
	private SimpleStringProperty age=new SimpleStringProperty();
	
	public DataPro(String name,String age) {
		this.name.set(name);
		this.age.set(age);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getAge() {
		return age.get();
	}
	
	public void setAge(String age) {
		this.age.set(age);
	}
	
	public SimpleStringProperty getNameProperty() {
		return this.name;
	}
	
	public SimpleStringProperty getAgeProperty() {
		return this.age;
	}
	
	
}
