/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
		Data2 d1=new Data2("A", 15, 10, true);
		Data2 d2=new Data2("B", 16, 20, true);
		Data2 d3=new Data2("C", 19, 30, true);
		Data2 d4=new Data2("D", 12, 40, true);
		
		Data2 d5=new Data2("E", 20, 50, true);
		Data2 d6=new Data2("F", 13, 60, true);
		Data2 d7=new Data2("G", 12, 70, true);
		
		Data2 d8=new Data2("H", 46, 80, true);
		Data2 d9=new Data2("I", 39, 90, true);
		Data2 d10=new Data2("J", 52, 100, true);
		Data2 d11=new Data2("K", 52, 95, true);
		Data2 d12=new Data2("L", 52, 85, true);
		
		ObservableList<Data2> list=FXCollections.observableArrayList();
		
		list.addAll(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12);
		
		TableView<Data2> tableview=new TableView<>(list);
		
		tableview.setPlaceholder(new Button("no data"));
		
		tableview.setPrefWidth(600);
		tableview.setPrefHeight(400);
		

		
		
		TableColumn<Data2, String> tc_name=new TableColumn<Data2,String>("姓名");

		tc_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data2,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Data2, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getNameProperty();
			}
		});
		tc_name.setCellFactory(new Callback<TableColumn<Data2,String>, TableCell<Data2,String>>() {
			
			@Override
			public TableCell<Data2, String> call(TableColumn<Data2, String> param) {
				// TODO Auto-generated method stub
				TableCell<Data2, String> cell=new TableCell<Data2, String>() {

					@Override
					protected void updateItem(String item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							
							HBox hbox=new HBox();
							hbox.setStyle("-fx-background-color:yellow");
							hbox.setAlignment(Pos.CENTER);
							Label label=new Label(item);
							hbox.getChildren().add(label);
							this.setGraphic(hbox);
						}
					}
					
				};
				return cell;
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
		
		tc_score.setCellFactory(new Callback<TableColumn<Data2,Number>, TableCell<Data2,Number>>() {
			
			@Override
			public TableCell<Data2, Number> call(TableColumn<Data2, Number> param) {
				// TODO Auto-generated method stub
				TableCell<Data2,Number> cell=new TableCell<Data2,Number>() {

					@Override
					protected void updateItem(Number item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox=new HBox();
//							hbox.setStyle("-fx-background-color:yellow");
							hbox.setAlignment(Pos.CENTER);
							ProgressIndicator pi=new ProgressIndicator(item.doubleValue()/100.0);
							
							hbox.getChildren().add(pi);
							this.setGraphic(hbox);
						}
					}
					
				};
				return cell;
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
		
		tc_is.setCellFactory(new Callback<TableColumn<Data2,Boolean>, TableCell<Data2,Boolean>>() {
			
			@Override
			public TableCell<Data2, Boolean> call(TableColumn<Data2, Boolean> param) {
				// TODO Auto-generated method stub
				TableCell<Data2,Boolean> cell=new TableCell<Data2,Boolean>() {

					@Override
					protected void updateItem(Boolean item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox=new HBox();
							hbox.setAlignment(Pos.CENTER);
							CheckBox cb=new CheckBox();
							cb.setSelected(item);
							if(this.getTableRow() != null) {
								cb.selectedProperty().bindBidirectional(this.getTableView().getItems().get(
										this.getTableRow().getIndex()).getIsProperty());
							}
							hbox.getChildren().add(cb);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
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

		tableview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Data2>() {

			@Override
			public void changed(ObservableValue<? extends Data2> observable, Data2 oldValue, Data2 newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.getIs());
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
		

		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				d1.setScore(50);
			}
		});
		
	}

}

