/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		AnchorPane an=new AnchorPane();
		
		String path="file:E:\\Users\\Z H\\Pictures\\Saved Pictures/bg.png";
		Image image=new Image(path);
		
		String path2="file:C:\\Java\\eclipse-workspace\\Lesson68_ImageView\\src\\images\\001.jpeg";
		Image image2=new Image(path2);
		
		System.out.println("image:"+image.getWidth()+" * "+image.getHeight());
		Button bu=new Button("button");
		
		ImageView iv=new ImageView(image);
		iv.setFitWidth(500);
		iv.setPreserveRatio(true);
		iv.setSmooth(true);
		iv.setImage(image2);
		
		System.out.println("iv:"+iv.getFitWidth()+" * "+iv.getFitHeight());
		//设置的值，高没设置为0
		System.out.println("iv:"+iv.prefWidth(-1)+" * "+iv.prefHeight(-1));
		
		
		
		an.getChildren().addAll(iv);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
