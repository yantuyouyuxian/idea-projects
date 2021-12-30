/**
 * 
 */
package fx.com;

import java.net.URL;
import java.net.URLDecoder;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

//		String http="http://ws.stream.qqmusic.qq.com/C4000027vODg1uLVlM.m4a?guid=1520352230&vkey=FF61D72FB868EB1568E15258721D5A4A5B7E0A22EF0544B83D3B71D9ED8437C0DDD531C0FB67D3A9743A8F3B7AD4196F564E9402BC8CD97C&uin=180&fromtag=66";
		
//		URL url1=this.getClass().getClassLoader().getResource("E:/BaiduNetdiskDownload/“Ù¿÷/Aimer - LAST STARDUST.mp3");
//		System.out.println(url1.toExternalForm());
//		System.out.println(URLDecoder.decode(url1.toExternalForm(), "UTF-8"));
		
		URL url2=this.getClass().getClassLoader().getResource("res/œ…Ω£Œ «È.mp3");
		System.out.println(url2.toExternalForm());
		System.out.println(URLDecoder.decode(url2.toExternalForm(), "UTF-8"));
		
		Media media1=new Media("file:/E:/BaiduNetdiskDownload/“Ù¿÷/‘Ï√Œ’ﬂ.mp3");
		Media media2=new Media(url2.toExternalForm());
		
		MediaPlayer mp=new MediaPlayer(media1);
		mp.setCycleCount(2);
		
		mp.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("ready");
			}
		});
		mp.setOnError(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("error");
			}
		});
		mp.setOnHalted(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("halt");
			}
		});
		mp.setOnStalled(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("stall");
			}
		});
		mp.setOnRepeat(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("repeat");
			}
		});
		mp.setOnPaused(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("pause");
			}
		});
		mp.setOnStopped(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("stop");
			}
		});
		mp.setOnPlaying(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("playing");
			}
		});
		mp.setOnEndOfMedia(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("end of media");
			}
		});
		
		mp.statusProperty().addListener(new ChangeListener<Status>() {

			@Override
			public void changed(ObservableValue<? extends Status> observable, Status oldValue, Status newValue) {
				// TODO Auto-generated method stub
				System.out.println("status:"+newValue.name());
			}
		});
		mp.errorProperty().addListener(new ChangeListener<MediaException>() {

			@Override
			public void changed(ObservableValue<? extends MediaException> observable, MediaException oldValue,
					MediaException newValue) {
				// TODO Auto-generated method stub
				System.out.println("error:"+newValue.getMessage());
			}
		});
		
		Button bu1=new Button("play");
		Button bu2=new Button("stop");
		Button bu3=new Button("pause");
		
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
				mp.pause();
				mp.setStartTime(Duration.seconds(240));
			}
		});
		
	}

}
