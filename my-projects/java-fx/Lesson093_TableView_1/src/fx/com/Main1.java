/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

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
		Data d1=new Data("A", 15, 69, true);
		Data d2=new Data("B", 16, 75, true);
		Data d3=new Data("C", 19, 88.8, true);
		Data d4=new Data("D", 12, 93.2, true);
		
		ObservableList<Data> list=FXCollections.observableArrayList();
		list.addAll(d1,d2,d3,d4);
		
		TableView<Data> tableview=new TableView<>(list);
		
		TableColumn<Data, String> tc_name=new TableColumn<Data,String>("姓名");
		tc_name.setCellValueFactory(new PropertyValueFactory<Data,String>("name"));//调用get方法
		
//		tc_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data,String>, ObservableValue<String>>() {
//			
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<Data, String> param) {
//				// TODO Auto-generated method stub
//				SimpleStringProperty name=new SimpleStringProperty(param.getValue().getName());
//				return name;
//			}
//		});
		
		TableColumn<Data, Number> tc_age=new TableColumn<Data,Number>("年龄");
		tc_age.setCellValueFactory(new PropertyValueFactory<Data,Number>("age"));
		
//		tc_age.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data,Number>, ObservableValue<Number>>() {
//			
//			@Override
//			public ObservableValue<Number> call(CellDataFeatures<Data, Number> param) {
//				// TODO Auto-generated method stub
//				SimpleIntegerProperty age=new SimpleIntegerProperty(param.getValue().getAge());
//				return age;
//			}
//		});
		
		TableColumn<Data, Number> tc_score=new TableColumn<Data,Number>("分数");
		tc_score.setCellValueFactory(new PropertyValueFactory<Data,Number>("score"));
		
//		tc_score.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data,Number>, ObservableValue<Number>>() {
//			
//			@Override
//			public ObservableValue<Number> call(CellDataFeatures<Data, Number> param) {
//				// TODO Auto-generated method stub
//				SimpleDoubleProperty score=new SimpleDoubleProperty(param.getValue().getScore());
//				return score;
//			}
//		});
		
		TableColumn<Data, Boolean> tc_is=new TableColumn<Data,Boolean>("IS");
		tc_is.setCellValueFactory(new PropertyValueFactory<Data,Boolean>("is"));
		
//		tc_is.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data,Boolean>, ObservableValue<Boolean>>() {
//			
//			@Override
//			public ObservableValue<Boolean> call(CellDataFeatures<Data, Boolean> param) {
//				// TODO Auto-generated method stub
//				SimpleBooleanProperty is=new SimpleBooleanProperty(param.getValue().getIs());
//				return is;
//			}
//		});
		
		tableview.getColumns().add(tc_name);
		tableview.getColumns().add(tc_age);
		tableview.getColumns().add(tc_score);
		tableview.getColumns().add(tc_is);
		
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
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				tableview.getItems().add(new Data("E", 23, 79.3, true));
				
//				d1.setName("new");
//				tableview.refresh();
			}
		});
		
	}

}
