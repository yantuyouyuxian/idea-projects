/**
 * 
 */
package fx.com;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

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
		FileInputStream fis1=new FileInputStream(new File("C:\\Java\\eclipse-workspace\\Lesson67_Image\\src\\images\\001.jpeg"));
		Image im1=new Image(fis1);
		
		FileInputStream fis2=new FileInputStream(new File("C:\\Java\\eclipse-workspace\\Lesson67_Image\\src\\images\\001.jpeg"));
		Image im2=new Image(fis2,600,600,true,true);
		
		//url形式，本地要在前面加file:
		String path="file:C:\\Java\\eclipse-workspace\\Lesson67_Image\\src\\images\\002.png";
		Image im3=new Image(path,600,600,true,true,true);
		
		String path2="https://i0.hdslb.com/bfs/archive/e421f398102547c747c68a273295fa0661efea69.png";
		Image im4=new Image(path2,600,600,true,true,true);
		
		Image im5=new Image("images/002.png",600,600,true,true,true);
		
		
		URL url=getClass().getClassLoader().getResource("images/002.png");
		String urlpath=url.toExternalForm();
		Image im6=new Image(urlpath,600,600,true,true,true);
		
		
		URL url2=getClass().getResource("/images/002.png");
		String urlpath2=url2.toExternalForm();
		Image im7=new Image(urlpath2,600,600,true,true,true);
		
		
		ImageView iv=new ImageView(im7);
		
//		ImageView iv=new ImageView("images/001.jpeg");
		
		AnchorPane an=new AnchorPane();
		
		an.getChildren().addAll(iv);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
