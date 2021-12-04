/**
 * 
 */
package fx.com;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

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

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
		TreeView<Data> tree=new TreeView<Data>();
		
		TreeItem<Data> root=new TreeItem<Data>(new Data(true,"中国"));
		
		TreeItem<Data> i1=new TreeItem<Data>(new Data(true,"河南"));
		TreeItem<Data> i1_1=new TreeItem<Data>(new Data(true,"郑州"));
		TreeItem<Data> i1_2=new TreeItem<Data>(new Data(true,"开封"));
		
		TreeItem<Data> i2=new TreeItem<Data>(new Data(false,"湖南"));
		TreeItem<Data> i2_1=new TreeItem<Data>(new Data(false,"长沙"));
		TreeItem<Data> i2_2=new TreeItem<Data>(new Data(false,"怀化"));
		
	
		
		
		tree.setRoot(root);
		root.getChildren().addAll(i1,i2);
		i1.getChildren().addAll(i1_1,i1_2);
		i2.getChildren().addAll(i2_1,i2_2);
		
		root.setExpanded(true);
		
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,tree);
		
		AnchorPane.setTopAnchor(tree, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
		tree.setEditable(true);
		
		tree.setCellFactory(CheckBoxTreeCell.forTreeView(new Callback<TreeItem<Data>, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(TreeItem<Data> param) {
				// TODO Auto-generated method stub
				if(tree.getTreeItemLevel(param)==1) {
					param.getValue().setBoo(true);
					return param.getValue().getBooProperty();
				}else {
					param.getValue().setBoo(false);
					return param.getValue().getBooProperty();
				}
				
			}
		}, new StringConverter<TreeItem<Data>>() {

			@Override
			public String toString(TreeItem<Data> object) {
				// TODO Auto-generated method stub
				return object.getValue().getData_value();
			}

			@Override
			public TreeItem<Data> fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}));
		
		tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Data>>() {

			@Override
			public void changed(ObservableValue<? extends TreeItem<Data>> observable, TreeItem<Data> oldValue,
					TreeItem<Data> newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.getValue().getData_value()+"  "+newValue.getValue().getBoo());
			}
		});
		
	}

}

