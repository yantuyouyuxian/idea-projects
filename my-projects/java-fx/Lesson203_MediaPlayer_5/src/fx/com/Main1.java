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
import javafx.scene.media.AudioSpectrumListener;
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
		
		MediaPlayer mp=new MediaPlayer(media);
		mp.setVolume(0.3);;
		
		
		
		
		
		
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
		primaryStage.setHeight(500);
		primaryStage.setWidth(300);
		primaryStage.show();
//		mp.setAudioSpectrumInterval(value);//频谱间隔
//		mp.setAudioSpectrumThreshold(-100);//min
//		mp.setAudioSpectrumNumBands(128);//128
		mp.setAudioSpectrumListener(new AudioSpectrumListener() {
			
			@Override
			public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
				// TODO Auto-generated method stub
				System.out.println(phases.length);
				for(float f:phases) {
					System.out.print(f+" ");
				}
				System.out.println();
			}
		});
		
		
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
				mp.pause();
			}
		});
		
	}

}
