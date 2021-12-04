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
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		HBox hbox=new HBox();
		hbox.setPrefHeight(300);
		hbox.setPrefWidth(300);
		hbox.setStyle("-fx-background-color:yellow");
		
		ImageView iv=new ImageView();
		iv.setFitWidth(300);
		iv.setFitHeight(300);
		
		hbox.getChildren().add(iv);
		
		AnchorPane an=new AnchorPane();
		an.getChildren().add(hbox);
		AnchorPane.setLeftAnchor(hbox, 200.0);
		AnchorPane.setTopAnchor(hbox, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		hbox.setOnDragEntered(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				hbox.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
				System.out.println("enter:"+event.getTransferMode());
				
			}
		});
		
		hbox.setOnDragExited(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				hbox.setBorder(null);
			}
		});
		
		hbox.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("over:"+event.getTransferMode());
				event.acceptTransferModes(event.getTransferMode());
			}
		});
		
		hbox.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				Dragboard db=event.getDragboard();
				if(db.hasFiles()) {
					System.out.println("hasfile");
					if(db.hasImage()) {
						System.out.println("hasimage");
					}
					
					try {
						Image image=new Image(new FileInputStream(db.getFiles().get(0)));
						iv.setImage(image);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	
	}

}
