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
	
		Data d1=new Data("A");
		Data d2=new Data("B");
		Data d3=new Data("C");
	
		ListView<Data> listview=new ListView<Data>();
		ObservableList<Data> obslist=listview.getItems();
		obslist.addAll(d1,d2,d3);
	
		
		Callback<ListView<Data>,ListCell<Data>> call=CheckBoxListCell.forListView(new Callback<Data, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(Data param) {
				// TODO Auto-generated method stub
				if(param.getName().equals("B")) {
					param.setIsChecked(false);
					return param.getIsCheckedProperty();
				}
				param.setIsChecked(true);
				return param.getIsCheckedProperty();
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
		
		listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Data>() {

			@Override
			public void changed(ObservableValue<? extends Data> observable, Data oldValue, Data newValue) {
				// TODO Auto-generated method stub
				System.out.println("name:"+newValue.getName()+" ischecked:"+newValue.getIsChecked());
			}
		});
		
		
	}
}

class Data{
	private String name;
	private SimpleBooleanProperty isChecked=new SimpleBooleanProperty();
	public Data(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SimpleBooleanProperty getIsCheckedProperty() {
		return isChecked;
	}
	
	public void setIsChecked(boolean isChecked) {
		this.isChecked.set(isChecked);
	}
	public boolean getIsChecked() {
		return this.isChecked.get();
	}
}
