/**
 * 
 */
package fx.com;

import java.util.Comparator;

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
import javafx.scene.control.TreeItem.TreeModificationEvent;
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
//				System.out.println(tree.getExpandedItemCount());
//				i1.getChildren().add(new TreeItem<String>("信阳"));
				root.getChildren().sort(new Comparator<TreeItem<String>>() {

					@Override
					public int compare(TreeItem<String> o1, TreeItem<String> o2) {
						// TODO Auto-generated method stub
						return o2.getValue().toString().compareTo(o1.getValue().toString());
					}
				});
				
			}
		});
		tree.setEditable(true);
		tree.setCellFactory(TextFieldTreeCell.forTreeView());
		root.addEventHandler(TreeItem.valueChangedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>() {

			@Override
			public void handle(TreeModificationEvent<String> event) {
				// TODO Auto-generated method stub
				System.out.println(event.getNewValue());
			}
		});
		
//		root.addEventHandler(TreeItem.graphicChangedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>() {
//
//			@Override
//			public void handle(TreeModificationEvent<String> event) {
//				// TODO Auto-generated method stub
//				System.out.println(event.getTreeItem().getValue());
//			}
//		});
		
		root.addEventHandler(TreeItem.branchCollapsedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>() {

			@Override
			public void handle(TreeModificationEvent<String> event) {
				// TODO Auto-generated method stub
				System.out.println(event.getTreeItem().getValue()+" 收起");
			}
		});
		
		root.addEventHandler(TreeItem.branchExpandedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>() {

			@Override
			public void handle(TreeModificationEvent<String> event) {
				// TODO Auto-generated method stub
				System.out.println(event.getTreeItem().getValue()+" 展开");
			}
		});
		
		root.addEventHandler(TreeItem.childrenModificationEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>() {

			@Override
			public void handle(TreeModificationEvent<String> event) {
				// TODO Auto-generated method stub
				System.out.println(event.getEventType()+" wasAdded:"+event.wasAdded());
			}
		});
		
		root.addEventHandler(TreeItem.treeNotificationEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>() {

			@Override
			public void handle(TreeModificationEvent<String> event) {
				// TODO Auto-generated method stub
				if(event.wasPermutated()) {
					System.out.println("Permutated");
				}
			}
		});
		
	}

}

