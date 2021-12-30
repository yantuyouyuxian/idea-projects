/**
 * 
 */
package fx.com;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
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
		URL url=this.getClass().getClassLoader().getResource("res/lei.wav");
		System.out.println(url);
		
//		AudioClip ac=new AudioClip(url.toExternalForm());
		AudioClip ac=new AudioClip("file:/C:/Java/eclipse-workspace/Lesson9999_AudioClip/src/res/lei.wav");
		ac.setBalance(0);//-1 0 1
//		ac.setPan(1);
//		ac.setPriority(5);//同时播放的优先级
//		ac.setRate(2);
		ac.setCycleCount(2);//AudioClip.INDEFINITE
		ac.setVolume(0.5);//0到1
		
		Button bu1=new Button("play");
		Button bu2=new Button("stop");
		Button bu3=new Button("button");
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(bu1,bu2);
		AnchorPane.setLeftAnchor(bu2, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bu1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ac.play();
			}
		});
		
		bu2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ac.stop();
			}
		});
		
		bu3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println(ac.isPlaying());
				
			}
		});
		
	}

}
