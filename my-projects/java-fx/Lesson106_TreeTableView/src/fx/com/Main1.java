/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTablePosition;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
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
	
		Data d1=new Data("A", 12, true);
		Data d2=new Data("B", 16, false);
		Data d3=new Data("C", 18, true);
		Data d4=new Data("D", 20, false);
		
		TreeTableView<Data> ttv=new TreeTableView<Data>();
		
		TreeItem<Data> root=new TreeItem<Data>(d1);
		root.setExpanded(true);
		
		TreeItem<Data> it1=new TreeItem<Data>(d2);
		TreeItem<Data> it2=new TreeItem<Data>(d3);
		TreeItem<Data> it3=new TreeItem<Data>(d4);
		
		root.getChildren().add(it1);
		root.getChildren().add(it2);
		root.getChildren().add(it3);
	
		ttv.setRoot(root);
		
		TreeTableColumn<Data, String> name_col=new TreeTableColumn<Data, String>("姓名");
		TreeTableColumn<Data, Number> age_col=new TreeTableColumn<Data, Number>("年龄");
		TreeTableColumn<Data, Boolean> is_col=new TreeTableColumn<Data, Boolean>("boolean");
		
		ttv.getColumns().add(name_col);
		ttv.getColumns().add(age_col);
		ttv.getColumns().add(is_col);
		
		ttv.setPrefWidth(300);
		ttv.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
		
		
//		name_col.setCellValueFactory(new TreeItemPropertyValueFactory<Data, String>("name"));
		name_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Data,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Data, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().getNameProperty();
			}
		});
		
		
//		age_col.setCellValueFactory(new TreeItemPropertyValueFactory<Data,Number>("age"));
		age_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Data,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<Data, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().getAgeProperty();
			}
		});
		
//		is_col.setCellValueFactory(new TreeItemPropertyValueFactory<Data,Boolean>("is"));
		is_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Data,Boolean>, ObservableValue<Boolean>>() {
			
			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Data, Boolean> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().getIsProperty();
			}
		});
		
		
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,ttv);
		AnchorPane.setTopAnchor(ttv, 50.0);
		
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
				d1.setName("AAA");
				root.getChildren().add(new TreeItem<Data>(new Data("E",20,true)));
				
			}
		});
		
		ttv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		ttv.getSelectionModel().setCellSelectionEnabled(true);
		
//		ttv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Data>>() {
//
//			@Override
//			public void changed(ObservableValue<? extends TreeItem<Data>> observable, TreeItem<Data> oldValue,
//					TreeItem<Data> newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue.getValue().getName());
//			}
//		});
		
//		ttv.getSelectionModel().getSelectedItems().addListener(new InvalidationListener() {
//			
//			@Override
//			public void invalidated(Observable observable) {
//				// TODO Auto-generated method stub
//				ObservableList<TreeItem<Data>> list=(ObservableList<TreeItem<Data>>)observable;
//				System.out.println(list);
//			}
//		});
		
		ttv.getSelectionModel().getSelectedCells().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				ObservableList<TreeTablePosition<Data, ?>> list=(ObservableList<TreeTablePosition<Data, ?>>)observable;
				list.forEach(item->{
					System.out.println("行: "+item.getRow()+" 列:"+item.getColumn()+" "+
							item.getTableColumn().getCellData(item.getRow()));
				});
			}
		});
	}

}

