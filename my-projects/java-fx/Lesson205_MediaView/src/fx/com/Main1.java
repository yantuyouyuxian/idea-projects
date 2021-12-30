/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
		Media media=new Media("file:/E:/末日时.mp4");
		
		MediaPlayer mp=new MediaPlayer(media);
		mp.setVolume(0.1);
		
		MediaView mv=new MediaView(mp);
		mv.setFitWidth(800);//默认保存宽高比
		mv.setSmooth(true);
		
		ColorAdjust ca=new ColorAdjust();
		ca.setHue(1);
		mv.setEffect(ca);
		
//		mv.setViewport(new Rectangle2D(0, 0, 800, 300));
		
		mp.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(media.getWidth()+" * "+media.getHeight());
			}
		});
		
		
		Button bu1=new Button("play");
		Button bu2=new Button("stop");
		Button bu3=new Button("bu3");
		
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(bu1,bu2,bu3,mv);
		AnchorPane.setLeftAnchor(bu2, 100.0);
		AnchorPane.setLeftAnchor(bu3, 200.0);
		AnchorPane.setTopAnchor(mv, 50.0);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		bu1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mp.play();
			}
		});
		bu2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mp.stop();
			}
		});
	}

}
