/**
 * 
 */
package fx.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
		
		TextField tf=new TextField();
		Label lab=new Label("hello world");
		
		
		AnchorPane an=new AnchorPane();
		
		an.getChildren().addAll(lab,tf);
		AnchorPane.setTopAnchor(tf, 50.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		lab.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				//ÍÏ×§Ãæ°å
				
				
				ClipboardContent cbc=new ClipboardContent();
				cbc.putString(lab.getText());
				
				Dragboard db=lab.startDragAndDrop(TransferMode.MOVE);
				//ÉèÖÃÍÏ×§Í¼±ê
				WritableImage wi=new WritableImage((int)lab.getWidth(), (int)lab.getHeight());
				lab.snapshot(new SnapshotParameters(), wi);
				db.setDragView(wi);
				
				db.setContent(cbc);
			}
		});
		
		tf.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				event.acceptTransferModes(TransferMode.MOVE);
			}
		});
		
//		tf.setOnDragEntered(new EventHandler<DragEvent>() {
//
//			@Override
//			public void handle(DragEvent event) {
//				// TODO Auto-generated method stub
//				event.acceptTransferModes(TransferMode.COPY);
//			}
//		});
		
		tf.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				tf.setText(event.getDragboard().getString());
				event.setDropCompleted(true);
			}
		});
		
		lab.setOnDragDone(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				if(event.getTransferMode()==TransferMode.MOVE) {
					lab.setText("");
				}
				
			}
		});
	}

}
