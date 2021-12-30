/**
 * 
 */
package fx.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
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
		
		Clipboard cb=Clipboard.getSystemClipboard();
		
		ClipboardContent cbc=new ClipboardContent();
		cbc.put(DataFormat.PLAIN_TEXT, "hello");
		//image的url本地的加file:
		cbc.put(DataFormat.IMAGE, new Image("file:E:\\Users\\Z H\\Desktop\\images/3.png"));
		
		cb.setContent(cbc);
		
//		cb.clear();
		
		Label lab=new Label("label");
		
		ImageView iv=new ImageView();
		iv.setPreserveRatio(true);
		iv.setFitWidth(300);
		
		AnchorPane an=new AnchorPane();
		
		an.getChildren().addAll(lab,iv);
		AnchorPane.setTopAnchor(iv, 50.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		KeyCodeCombination kc=new KeyCodeCombination(KeyCode.V, KeyCombination.SHORTCUT_DOWN);
		scene.getAccelerators().put(kc, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(cb.hasString()) {
					lab.setText(cb.getString());
				}
				if(cb.hasImage()) {
					iv.setImage(cb.getImage());
				}
			}
		});
	}

}
