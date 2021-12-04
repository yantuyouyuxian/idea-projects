/**
 * 
 */
package fx.com;

import java.net.URL;
import java.net.URLDecoder;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableMap;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaMarkerEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

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


		URL url1=this.getClass().getClassLoader().getResource("res/即使手中空无一物.mp3");
		System.out.println(url1.toExternalForm());
		System.out.println(URLDecoder.decode(url1.toExternalForm(), "UTF-8"));
		
	
		Media media=new Media(url1.toExternalForm());
		
		media.getMarkers().put("10", Duration.seconds(10));
		media.getMarkers().put("20", Duration.seconds(20));
		media.getMarkers().put("30", Duration.seconds(30));
		
		MediaPlayer mp=new MediaPlayer(media);
		mp.setVolume(0.3);;
		
		mp.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("tracks---"+media.getTracks());
				System.out.println();
//				media.get
				ObservableMap<String, Object> map=media.getMetadata();
				for(String key: map.keySet()) {
					System.out.println(key+"---"+map.get(key));
				}
			}
		});
		mp.setOnMarker(new EventHandler<MediaMarkerEvent>() {
			
			@Override
			public void handle(MediaMarkerEvent event) {
				// TODO Auto-generated method stub
				System.out.println(event.getMarker());
			}
		});
		
		Button bu1=new Button("play");
		Button bu2=new Button("stop");
		Button bu3=new Button("pause");
		ImageView iv=new ImageView();
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(bu1,bu2,bu3);
		AnchorPane.setLeftAnchor(bu2, 60.0);
		AnchorPane.setLeftAnchor(bu3, 120.0);

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
		
		bu3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				mp.pause();
			}
		});
		
	}

}
