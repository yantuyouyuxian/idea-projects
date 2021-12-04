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
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.ChoiceBoxTreeCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.ComboBoxTreeCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import jdk.internal.org.objectweb.asm.util.Textifiable;

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
				System.out.println(i3.getChildren().indexOf(i3_3));
				
				
			}
		});
		
		tree.setEditable(true);
		tree.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
			
			TreeCell<String> temp;
			
			@Override
			public TreeCell<String> call(TreeView<String> param) {
				// TODO Auto-generated method stub
				TreeCell<String> cell =new TreeCell<String>() {

					@Override
					protected void updateItem(String item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty == false) {
							HBox hbox=new HBox();
							Label lab=new Label(item);
							hbox.getChildren().add(lab);
							if(this.getTreeItem().isExpanded()) {
								this.setDisclosureNode(new Label("-"));
							}else {
								this.setDisclosureNode(new Label("+"));
							}
							this.setGraphic(hbox);
						}else if(empty == true) {
							this.setGraphic(null);
						}
					}
				};
				
//				cell.setOnDragEntered(new EventHandler<DragEvent>() {
//
//					@Override
//					public void handle(DragEvent event) {
//						// TODO Auto-generated method stub
////						cell.getTreeView().getFocusModel().focus(cell.getIndex());
//					}
//				});
				
				cell.setOnDragDetected(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Dragboard db=cell.startDragAndDrop(TransferMode.COPY_OR_MOVE);
						
						ClipboardContent content=new ClipboardContent();
						content.putString(cell.getItem());
						
						WritableImage wi=new WritableImage((int)cell.getWidth(), (int)cell.getHeight());
						cell.snapshot(new SnapshotParameters(), wi);
						
						db.setDragView(wi);
						db.setContent(content);
						temp=cell;
					}
				});
				
				cell.setOnDragOver(new EventHandler<DragEvent>() {

					@Override
					public void handle(DragEvent event) {
						// TODO Auto-generated method stub
						event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

						cell.getTreeView().getFocusModel().focus(cell.getIndex());
					}
				});
				
				cell.setOnDragDropped(new EventHandler<DragEvent>() {

					@Override
					public void handle(DragEvent event) {
						// TODO Auto-generated method stub
						String value=event.getDragboard().getString();
						
						if(!cell.getTreeItem().isLeaf()) {
							
						}
						
						if(cell.getTreeItem().getParent() != null) {
							
							temp.getTreeItem().getParent().getChildren().remove(temp.getTreeItem());
							
							int index=cell.getTreeItem().getParent().getChildren().indexOf(cell.getTreeItem());
							
							cell.getTreeItem().getParent().getChildren().add(index+1,new TreeItem<String>(value));
							
							cell.getTreeView().getFocusModel().focus(cell.getIndex());
							cell.getTreeView().getSelectionModel().select(cell.getIndex());
							
						}
						
						
					}
				});
				
				return cell;
			}
		});
	}

}

