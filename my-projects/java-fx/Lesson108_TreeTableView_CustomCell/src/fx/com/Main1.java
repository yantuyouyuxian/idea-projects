/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.ProgressBarTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
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
	
		Data d1=new Data("A", 0.2, true);
		Data d2=new Data("B", 0.4, false);
		Data d3=new Data("C", 0.8, true);
		Data d4=new Data("D", 1, false);
		
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
		
		TreeTableColumn<Data, String> name_col=new TreeTableColumn<Data, String>("����");
		TreeTableColumn<Data, Double> age_col=new TreeTableColumn<Data, Double>("����");
		TreeTableColumn<Data, Boolean> is_col=new TreeTableColumn<Data, Boolean>("boolean");
		
		ttv.getColumns().add(name_col);
		ttv.getColumns().add(age_col);
		ttv.getColumns().add(is_col);
		
		ttv.setPrefWidth(300);
		ttv.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
		ttv.setEditable(true);
		
//		name_col.setCellValueFactory(new TreeItemPropertyValueFactory<Data, String>("name"));
		name_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Data,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Data, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().getNameProperty();
			}
		});
		name_col.setCellFactory(new Callback<TreeTableColumn<Data,String>, TreeTableCell<Data,String>>() {
			
			@Override
			public TreeTableCell<Data, String> call(TreeTableColumn<Data, String> param) {
				// TODO Auto-generated method stub
				TreeTableCell<Data, String> tt_cell=new TreeTableCell<Data, String>() {
					
					
					@Override
					public void startEdit() {
						// TODO Auto-generated method stub
						TreeTableCell<Data, String> cell=this;
						super.startEdit();
						HBox hbox=new HBox();
						TextField tf=new TextField(this.getTreeTableRow().getItem().getName());
						hbox.getChildren().add(tf);
						this.setGraphic(hbox);
						tf.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								String value=tf.getText();
								
								cell.commitEdit(value);
								//nameֻ���������޸�����Դ
							}
						});
					}

					@Override
					public void commitEdit(String newValue) {
						// TODO Auto-generated method stub
						super.commitEdit(newValue);
					}

					@Override
					public void cancelEdit() {
						// TODO Auto-generated method stub
						super.cancelEdit();
						HBox hbox=new HBox();
						Label label=new Label(this.getTreeTableRow().getItem().getName());
						hbox.getChildren().add(label);
						this.setGraphic(hbox);
					}

					@Override
					protected void updateItem(String item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty==false) {
							HBox hbox=new HBox();
							Label label=new Label(item);
							hbox.getChildren().add(label);
							this.setGraphic(hbox);
						}else if(empty == true) {
							this.setGraphic(null);
						}
					}
					
				};
				return tt_cell;
			}
		});
		
		age_col.setCellValueFactory(new TreeItemPropertyValueFactory<Data,Double>("age"));//��ageProperty()��������ʵʱ����
//		age_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Data,Number>, ObservableValue<Number>>() {
//			
//			@Override
//			public ObservableValue<Number> call(CellDataFeatures<Data, Number> param) {
//				// TODO Auto-generated method stub
//				return param.getValue().getValue().getAgeProperty();
//			}
//		});
		age_col.setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn());
		
		
//		is_col.setCellValueFactory(new TreeItemPropertyValueFactory<Data,Boolean>("is"));
		is_col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Data,Boolean>, ObservableValue<Boolean>>() {
			
			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Data, Boolean> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().getIsProperty();
			}
		});
		is_col.setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(new TreeTableColumn<Data, Boolean>()));
		
		
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
				System.out.println(d1.getIs());
			}
		});
		
		
		
		
	}

}

