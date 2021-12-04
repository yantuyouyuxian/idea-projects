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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView.ResizeFeatures;
import javafx.scene.control.TablePosition;
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
		Data2 d1=new Data2("A", 15, 69, true);
		Data2 d2=new Data2("B", 16, 75, true);
		Data2 d3=new Data2("C", 19, 88.8, true);
		Data2 d4=new Data2("D", 12, 93.2, true);
		
		Data2 d5=new Data2("E", 20, 57, true);
		Data2 d6=new Data2("F", 13, 83.8, true);
		Data2 d7=new Data2("G", 12, 93.2, true);
		
		Data2 d8=new Data2("H", 46, 77, true);
		Data2 d9=new Data2("I", 39, 88, true);
		Data2 d10=new Data2("J", 52, 93, true);
		Data2 d11=new Data2("K", 52, 93, true);
		Data2 d12=new Data2("L", 52, 93, true);
		
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
		
		tableview.getColumns().add(tc_name);
		tableview.getColumns().add(tc_age);
		tableview.getColumns().add(tc_score);
		tableview.getColumns().add(tc_is);
		
		double width=tableview.getPrefWidth()/tableview.getColumns().size();
		
		tableview.getColumns().forEach(item ->{
			item.setPrefWidth(width);
		});
//		tableview.setFixedCellSize(30);
		
//		tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

//		tableview.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
//			
//			@Override
//			public Boolean call(ResizeFeatures param) {
//				// TODO Auto-generated method stub
//				System.out.println(param.getDelta());
//				if(param.getColumn()!=null) {
////					double w=param.getDelta();
////					param.getColumn().setwi
//				}
//				return true;//无法拖拽改变列宽
//			}
//		});
		
//		tc_name.setSortable(true);
		
		
//		tableview.getSortOrder().addAll(tc_name,tc_age);
		
//		tableview.setSortPolicy(new Callback<TableView<Data2>, Boolean>() {
//			
//			@Override
//			public Boolean call(TableView<Data2> param) {
//				// TODO Auto-generated method stub
//				param.getColumns().forEach(new Consumer<TableColumn>() {
//
//					@Override
//					public void accept(TableColumn t) {
//						// TODO Auto-generated method stub
//						if(t.getText().equals("姓名") && t.getSortType()== SortType.ASCENDING) {
//							t.setSortNode(new Label("升序"));
//							
//							param.getItems().sort(new Comparator<Data2>() {
//
//								@Override
//								public int compare(Data2 o1, Data2 o2) {
//									// TODO Auto-generated method stub
//									return o1.getName().compareTo(o2.getName());
//								}
//							});
//						}else if(t.getText().equals("姓名") && t.getSortType()== SortType.DESCENDING) {
//							t.setSortNode(new Label("降序"));
//							param.getItems().sort(new Comparator<Data2>() {
//
//								@Override
//								public int compare(Data2 o1, Data2 o2) {
//									// TODO Auto-generated method stub
//									return o2.getName().compareTo(o1.getName());
//								}
//							});
//						}
//					}
//				});
//				return true;//false禁用排序
//			}
//		});
		
		
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
		
//		tc_name.setComparator(new Comparator<String>() {
//			
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o2.compareTo(o1);
//			}
//		});
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				tc_name.setSortType(SortType.DESCENDING);
				
			}
		});
		
	}

}
