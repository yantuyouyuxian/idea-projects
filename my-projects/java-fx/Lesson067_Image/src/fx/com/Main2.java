/**
 * 
 */
package fx.com;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
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
		String path="file:C:\\Java\\eclipse-workspace\\Lesson67_Image\\src\\images\\002.png";
		Image im=new Image(path,600,600,true,true,true);
		
		im.errorProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				System.out.println("errorProperty= "+newValue.booleanValue());
			}
		});
		
		im.exceptionProperty().addListener(new ChangeListener<Exception>() {

			@Override
			public void changed(ObservableValue<? extends Exception> observable, Exception oldValue,
					Exception newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.getMessage());
			}
		});
		
		im.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.doubleValue());
			}
		});//后台异步加载有效
		
//		System.out.println(im.getWidth());//600
//		System.out.println(im.getHeight());//337
//		
//		System.out.println(im.getRequestedWidth());//600
//		System.out.println(im.getRequestedHeight());//600
		
		
		
		ImageView iv=new ImageView(im);
		
		
		
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
