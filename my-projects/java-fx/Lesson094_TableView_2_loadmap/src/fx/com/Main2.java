/**
 * 
 */
package fx.com;

import java.util.HashMap;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

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
		Data2 d1=new Data2("A", 15, 69, true);
		Data2 d2=new Data2("B", 16, 75, true);
		Data2 d3=new Data2("C", 19, 88.8, true);
		Data2 d4=new Data2("D", 12, 93.2, true);
		
		HashMap<String, SimpleStringProperty> map1=new HashMap<String, SimpleStringProperty>();
		map1.put("name", new SimpleStringProperty("A"));
		map1.put("age", new SimpleStringProperty("18"));
		map1.put("boolean", new SimpleStringProperty("true"));
		
		HashMap<String, SimpleStringProperty> map2=new HashMap<String, SimpleStringProperty>();
		map2.put("name", new SimpleStringProperty("B"));
		map2.put("age", new SimpleStringProperty("17"));
		map2.put("boolean", new SimpleStringProperty("false"));
		
		ObservableList<HashMap<String, SimpleStringProperty>> list=FXCollections.observableArrayList();
		
		list.add(map1);
		list.add(map2);
		
		TableView<HashMap<String, SimpleStringProperty>> tableview=new TableView<HashMap<String, SimpleStringProperty>>(list);
		
		
		TableColumn<HashMap<String, SimpleStringProperty>, String> tc_name=new TableColumn<HashMap<String, SimpleStringProperty>,String>("–’√˚");

		tc_name.setCellValueFactory(new MapValueFactory("name"));
		
//		tc_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap<String,SimpleStringProperty>,String>, ObservableValue<String>>() {
//			
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<HashMap<String, SimpleStringProperty>, String> param) {
//				// TODO Auto-generated method stub
//				return param.getValue().get("name");
//			}
//		});
		
		TableColumn<HashMap<String, SimpleStringProperty>, String> tc_age=new TableColumn<HashMap<String, SimpleStringProperty>,String>("ƒÍ¡‰");

		tc_age.setCellValueFactory(new MapValueFactory("age"));
		
//		tc_age.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap<String,SimpleStringProperty>,String>, ObservableValue<String>>() {
//			
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<HashMap<String, SimpleStringProperty>, String> param) {
//				// TODO Auto-generated method stub
//				return param.getValue().get("age");
//			}
//		});
		
		
		TableColumn<HashMap<String, SimpleStringProperty>, String> tc_boolean=new TableColumn<HashMap<String, SimpleStringProperty>,String>("boolean");

		tc_boolean.setCellValueFactory(new MapValueFactory("boolean"));
		
//		tc_boolean.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap<String,SimpleStringProperty>,String>, ObservableValue<String>>() {
//			
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<HashMap<String, SimpleStringProperty>, String> param) {
//				// TODO Auto-generated method stub
//				return param.getValue().get("boolean");
//			}
//		});
		
		tableview.getColumns().add(tc_name);
		tableview.getColumns().add(tc_age);
		tableview.getColumns().add(tc_boolean);

		

		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,tableview);
		
		AnchorPane.setTopAnchor(tableview, 50.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {}
		});
		
	}

}
