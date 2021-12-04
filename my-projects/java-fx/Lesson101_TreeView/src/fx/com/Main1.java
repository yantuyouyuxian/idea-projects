/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
		
		
		TreeItem<String> i2=new TreeItem<String>("湖南");
		TreeItem<String> i2_1=new TreeItem<String>("长沙");
		TreeItem<String> i2_2=new TreeItem<String>("怀化");
		
		TreeItem<String> i3=new TreeItem<String>("浙江");
		TreeItem<String> i3_1=new TreeItem<String>("杭州");
		TreeItem<String> i3_2=new TreeItem<String>("金华");
		
		
		tree.setRoot(root);
		root.getChildren().addAll(i1,i2,i3);
		i1.getChildren().addAll(i1_1,i1_2);
		i2.getChildren().addAll(i2_1,i2_2);
		i3.getChildren().addAll(i3_1,i3_2);
		
		root.setExpanded(true);
		
//		tree.setPrefWidth(300);
		
//		tree.scrollTo(index);
//		tree.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
//			
//			@Override
//			public void handle(ScrollToEvent<Integer> event) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
//		tree.setFixedCellSize(value);
		
//		root.setValue(value);
		
//		System.out.println(root.isLeaf());
		
//		System.out.println(root.getChildren().size());
		
//		System.out.println(i1.previousSibling(i2).getValue());
//		i2.nextSibling()
		
//		System.out.println(root.isExpanded());
		
		
		
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
				// TODO Auto-generated method stub
				System.out.println(tree.getExpandedItemCount());
			}
		});
		
		tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
//		tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem>() {
//
//			@Override
//			public void changed(ObservableValue<? extends TreeItem> observable, TreeItem oldValue, TreeItem newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue.getValue());
//			}
//		});
		
//		tree.getFocusModel().focus(index);
		
//		tree.getExpandedItemCount();
		
		tree.setEditable(true);
//		tree.setCellFactory(TextFieldTreeCell.forTreeView());
		
		tree.setCellFactory(TextFieldTreeCell.forTreeView(new StringConverter<String>() {

			@Override
			public String toString(String object) {
				// TODO Auto-generated method stub
				return object;
			}

			@Override
			public String fromString(String string) {
				// TODO Auto-generated method stub
				return string;
			}
		}));
	}

}

