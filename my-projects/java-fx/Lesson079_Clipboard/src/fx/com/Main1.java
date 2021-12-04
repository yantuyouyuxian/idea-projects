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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
		
		Clipboard cb=Clipboard.getSystemClipboard();
		
		Label lab=new Label("label");
		
		ImageView iv=new ImageView();
		iv.setPreserveRatio(true);
		iv.setFitWidth(300);
		
		AnchorPane an=new AnchorPane();
		
		an.getChildren().addAll(lab,iv);
		AnchorPane.setTopAnchor(iv, 200.0);
		
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
				
				//mac复制图片是一个字符串
//				if(cb.hasFiles()) {
//					List<File> list=cb.getFiles();
//					try {
//						Image image=new Image(new FileInputStream(list.get(0)));
//						iv.setImage(image);//iv.setImage(cb.getImage());
//						Object obj=cb.getContent(DataFormat.IMAGE);
//						Image im=(Image)obj;
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				
			}
		});
	}

}
