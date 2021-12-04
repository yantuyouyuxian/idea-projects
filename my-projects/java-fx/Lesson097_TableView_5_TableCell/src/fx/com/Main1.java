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
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView.ResizeFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
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
		Data2 d1=new Data2("A", 15, 0, true);
		Data2 d2=new Data2("B", 16, 1, true);
		Data2 d3=new Data2("C", 19, 0.2, true);
		Data2 d4=new Data2("D", 12, 1, true);
		
		Data2 d5=new Data2("E", 20, 0.3, true);
		Data2 d6=new Data2("F", 13, 0.4, true);
		Data2 d7=new Data2("G", 12, 1, true);
		
		Data2 d8=new Data2("H", 46, 1, true);
		Data2 d9=new Data2("I", 39, 0.5, true);
		Data2 d10=new Data2("J", 52, 0.6, true);
		Data2 d11=new Data2("K", 52, 0.7, true);
		Data2 d12=new Data2("L", 52, 1, true);
		
		ObservableList<Data2> list=FXCollections.observableArrayList();
		
		list.addAll(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12);
		
		TableView<Data2> tableview=new TableView<>(list);
		
		tableview.setPlaceholder(new Button("no data"));
		
		tableview.setPrefWidth(500);
		tableview.setPrefHeight(300);
		
		
//		tableview.setTableMenuButtonVisible(true);
		
		
		
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
		
		TableColumn<Data2, Double> tc_score=new TableColumn<Data2,Double>("分数");

		tc_score.setCellValueFactory(new PropertyValueFactory<Data2,Double>("score"));//这种写法修改属性不影响界面
		
//		tc_score.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data2,Number>, ObservableValue<Number>>() {
//			
//			@Override
//			public ObservableValue<Number> call(CellDataFeatures<Data2, Number> param) {
//				// TODO Auto-generated method stub
//				return param.getValue().getScoreProperty();
//			}
//		});
		
		TableColumn<Data2, Boolean> tc_is=new TableColumn<Data2,Boolean>("IS");

		tc_is.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data2,Boolean>, ObservableValue<Boolean>>() {
			
			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Data2, Boolean> param) {
				// TODO Auto-generated method stub
				return param.getValue().getIsProperty();
			}
		});
		
		tableview.getColumns().add(tc_name);
		tableview.getColumns().add(tc_age);
		tableview.getColumns().add(tc_score);
		tableview.getColumns().add(tc_is);
		
		double width=tableview.getPrefWidth()/tableview.getColumns().size();
		
		tableview.getColumns().forEach(item ->{
			item.setPrefWidth(width);
		});	
		
//		tableview.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		
//		tableview.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
//			
//			@Override
//			public void handle(ScrollToEvent<Integer> event) {
//				// TODO Auto-generated method stub
//				System.out.println(event.getTarget());
//			}
//		});
		
		
		
		tableview.setEditable(true);
		
		tc_name.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tc_age.setCellFactory(ChoiceBoxTableCell.forTableColumn(new StringConverter<Number>() {

			@Override
			public String toString(Number object) {
				// TODO Auto-generated method stub
				return String.valueOf(object);
			}

			@Override
			public Number fromString(String string) {
				// TODO Auto-generated method stub
				return Integer.valueOf(string);
			}
			
		}, 10,20,30));
		
//		tc_is.setCellFactory(ComboBoxTableCell.forTableColumn(new StringConverter<Boolean>() {
//
//			@Override
//			public String toString(Boolean object) {
//				// TODO Auto-generated method stub
//				return object.toString();
//			}
//
//			@Override
//			public Boolean fromString(String string) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		}, true,false));
		
		tc_is.setCellFactory(CheckBoxTableCell.forTableColumn(tc_is));
		
		tc_score.setCellFactory(ProgressBarTableCell.forTableColumn());
		
		MyService ms=new MyService();
		ms.setDelay(Duration.seconds(0));
		ms.setPeriod(Duration.seconds(1));
		ms.valueProperty().addListener(new ChangeListener<Double>() {

			@Override
			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
				// TODO Auto-generated method stub
				if(newValue!=null) {
					if(newValue>1.0) {
						ms.cancel();
					}
					d1.setScore(newValue);
					tableview.refresh();
				}
			}
		});
		
		
		
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
		

//		tableview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Data2>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Data2> observable, Data2 oldValue, Data2 newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue.getIs());
//			}
//		});
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				tableview.scrollTo(5);
				ms.start();
			}
		});
		
	}

}

class MyService extends ScheduledService<Double>{

	double value=0;
	@Override
	protected Task<Double> createTask() {
		// TODO Auto-generated method stub
		return new Task<Double>() {
			
			@Override
			protected Double call() throws Exception {
				// TODO Auto-generated method stub
//				if(value>1) {
//					MyService.this.cancel();
//				}
				value=value+0.1;
				return value;
			}
		};
	}
	
}
