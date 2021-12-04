/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		AnchorPane an=new AnchorPane();
		
		String path="file:E:\\Users\\Z H\\Pictures\\Saved Pictures/bg.png";
		Image image=new Image(path,600,600,true,true);
		
		ImageView iv=new ImageView(image);
		iv.setFitWidth(500);
		iv.setPreserveRatio(true);
		iv.setSmooth(true);
		
		an.getChildren().addAll(iv);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
