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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
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
		hbox.setStyle("-fx-background-color:yellow");
		hbox.setPrefWidth(600);
		hbox.setPrefHeight(360);
		
		ImageView iv=new ImageView();
		iv.setPreserveRatio(true);
		iv.setFitWidth(500);
		
		hbox.getChildren().addAll(iv);
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(hbox);
		
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
				hbox.setBorder(
						new Border(
								new BorderStroke(Paint.valueOf("blue"), BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2), new Insets(0))));
			System.out.println("DragEntered "+event.getTransferMode());
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
				event.acceptTransferModes(event.getTransferMode());
				System.out.println("DragOver "+event.getTransferMode());
			}
		});
		
		
		//需要event.acceptTransferModes();才起作用
		hbox.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				Dragboard db=event.getDragboard();
				
				System.out.println("DragDropped");
				
//				if(db.hasImage()) {
//					System.out.println("has image");
//					iv.setImage(db.getImage());
//				}
				
				if(db.hasFiles()) {
					System.out.println("has files");
					System.out.println("type "+db.getContentTypes());
					System.out.println("list "+db.getFiles().get(0));
					iv.setImage(new Image("file:"+db.getFiles().get(0)));
				}else if(db.hasUrl()) {
					System.out.println("url "+db.getUrl());
					iv.setImage(new Image(db.getUrl()));
				}
				
//				if(db.hasFiles()) {
//					System.out.println("db has files");
//					List<File> list=db.getFiles();
//					try {
//						iv.setImage(new Image(new FileInputStream(list.get(0))));
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				
			}
		});
		
		
	}

}
