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
import javafx.scene.control.cell.ChoiceBoxTreeCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.ComboBoxTreeCell;
import javafx.scene.control.cell.TextFieldTreeCell;
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

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
		TreeView<String> tree=new TreeView<String>();
		
		TreeItem<String> root=new TreeItem<String>("中国");
//		root.setGraphic(value);
		
		TreeItem<String> i1=new TreeItem<String>("河南");
		TreeItem<String> i1_1=new TreeItem<String>("郑州");
		TreeItem<String> i1_2=new TreeItem<String>("开封");
		TreeItem<String> i1_3=new TreeItem<String>("信阳");
		TreeItem<String> i1_4=new TreeItem<String>("洛阳");
		
		TreeItem<String> i2=new TreeItem<String>("湖南");
		TreeItem<String> i2_1=new TreeItem<String>("长沙");
		TreeItem<String> i2_2=new TreeItem<String>("怀化");
		TreeItem<String> i2_3=new TreeItem<String>("常德");
		TreeItem<String> i2_4=new TreeItem<String>("永州");
		
		TreeItem<String> i3=new TreeItem<String>("浙江");
		TreeItem<String> i3_1=new TreeItem<String>("杭州");
		TreeItem<String> i3_2=new TreeItem<String>("金华");
		TreeItem<String> i3_3=new TreeItem<String>("温州");
		TreeItem<String> i3_4=new TreeItem<String>("台州");
		
		
		tree.setRoot(root);
		root.getChildren().addAll(i1,i2,i3);
		i1.getChildren().addAll(i1_1,i1_2,i1_3,i1_4);
		i2.getChildren().addAll(i2_1,i2_2,i2_3,i2_4);
		i3.getChildren().addAll(i3_1,i3_2,i3_3,i3_4);
		
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
		
//		tree.setCellFactory(TextFieldTreeCell.forTreeView(new StringConverter<String>() {
//
//			@Override
//			public String toString(String object) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public String fromString(String string) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		}));
		
//		tree.setCellFactory(ComboBoxTreeCell.forTreeView("A","B","C"));
		
//		tree.setCellFactory(ChoiceBoxTreeCell.forTreeView("A","B","C"));
		
		tree.setCellFactory(CheckBoxTreeCell.forTreeView(new Callback<TreeItem<String>, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(TreeItem<String> param) {
				if(tree.getTreeItemLevel(param)==1) {
					return new SimpleBooleanProperty(true);
				}
				return new SimpleBooleanProperty(false);
			}
		}));
		
		tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
			@Override
			public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue,
					TreeItem<String> newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.getValue());
			}
		});
		
	}

}

