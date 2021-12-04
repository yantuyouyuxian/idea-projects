/**
 * 
 */
package fx.com;

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
		Data2 d1=new Data2("A", 15, 69, true);
		Data2 d2=new Data2("B", 16, 75, true);
		Data2 d3=new Data2("C", 19, 88.8, true);
		Data2 d4=new Data2("D", 12, 93.2, true);
		
		ObservableList<Data2> list=FXCollections.observableArrayList();
		
		
		
		list.addAll(d1,d2,d3,d4);
		
		TableView<Data2> tableview=new TableView<>(list);
		
		TableColumn<Data2, String> tc_name=new TableColumn<Data2,String>("姓名");

		tc_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data2,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Data2, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getNameProperty();
			}
		});
		
		
		TableColumn<Data2, Number> tc_age=new TableColumn<Data2,Number>("年龄");

		tc_age.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data2,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<Data2, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getAgeProperty();
			}
		});
		
		TableColumn<Data2, Number> tc_score=new TableColumn<Data2,Number>("分数");

		tc_score.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data2,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<Data2, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getScoreProperty();
			}
		});
		
		TableColumn<Data2, Boolean> tc_is=new TableColumn<Data2,Boolean>("IS");

		tc_is.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data2,Boolean>, ObservableValue<Boolean>>() {
			
			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Data2, Boolean> param) {
				// TODO Auto-generated method stub
				return param.getValue().getIsProperty();
			}
		});
		
		TableColumn<Data2, Object> group=new TableColumn<Data2, Object>("信息");
		
		group.getColumns().add(tc_name);
		group.getColumns().add(tc_age);
		group.getColumns().add(tc_score);
		tableview.getColumns().add(group);
		
//		tableview.getColumns().add(tc_name);
//		tableview.getColumns().add(tc_age);
//		tableview.getColumns().add(tc_score);
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
		
		list.addListener(new ListChangeListener<Data2>() {

			@Override
			public void onChanged(Change<? extends Data2> c) {
				// TODO Auto-generated method stub
				System.out.println("listener");
				while(c.next()) {
					System.out.println(c);
				}
			}
			
		});
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				tableview.getItems().add(new Data2("E", 23, 79.3, true));
				
				d1.setName("new");
//				tableview.refresh();
		
			}
		});
		
	}

}
