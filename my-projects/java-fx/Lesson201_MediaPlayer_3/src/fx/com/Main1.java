/**
 * 
 */
package fx.com;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
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

	ArrayList<Media> list=new ArrayList<>();
	Slider s1;
	Slider s2;
	int index=0;
	MediaPlayer mp=null;
	
	boolean mouse=false;
	
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


		String url1=this.getClass().getClassLoader().getResource("res/即使手中空无一物.mp3").toExternalForm();
		String url2=this.getClass().getClassLoader().getResource("res/仙剑问情.mp3").toExternalForm();
		String url3=this.getClass().getClassLoader().getResource("res/二人世界.mp3").toExternalForm();
		list.add(new Media(url1));
		list.add(new Media(url2));
		list.add(new Media(url3));
	

		HBox hbox=new HBox(30);
	
		Button bu1=new Button("play");
		Button bu2=new Button("stop");
		Button bu3=new Button("pause");
		Button bu4=new Button("next");
		Button bu5=new Button("last");
		
		s1=new Slider(0, 1, 0.2);
		s1.setPrefWidth(100);
		
		s2=new Slider(0, 1, 0);
		s2.setPrefWidth(600);
		hbox.getChildren().addAll(bu1,bu2,bu3,bu4,bu5,s1,s2);
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox);
		
		AnchorPane.setTopAnchor(hbox,200.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		s2.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				mouse=true;
			}
		});
		
		s2.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				mouse=false;
				mp.seek(Duration.seconds(s2.getValue()));
			}
		});
		
		bu1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				initmusic(list);
			}
		});
		
		bu2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		bu3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
		bu4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				index=(index+1)%list.size();
				initmusic(list);
			}
		});//next
		bu5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				index=(index-1+list.size())%list.size();
				initmusic(list);
			}
		});//last
	
	}
	
	public void initmusic(ArrayList<Media> list) {
		
		if(mp !=null) {
			mp.dispose();
		}
		mp=new MediaPlayer(list.get(index));
		mp.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mp.volumeProperty().bind(s1.valueProperty());
				s2.setValue(0);
				s2.setMin(0);
				s2.setMax(mp.getTotalDuration().toSeconds());
				
				mp.currentTimeProperty().addListener(new ChangeListener<Duration>() {

					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
							Duration newValue) {
						// TODO Auto-generated method stub
						if(mouse == false) {
							s2.setValue(newValue.toSeconds());
						}
					}
				});
				
//				s2.valueProperty().addListener(new ChangeListener<Number>() {
//
//					@Override
//					public void changed(ObservableValue<? extends Number> observable, Number oldValue,
//							Number newValue) {
//						// TODO Auto-generated method stub
//						System.out.println(newValue);
//						if((newValue.intValue()-oldValue.intValue())>1 || (oldValue.intValue()-newValue.intValue())>1) {
//							mp.seek(Duration.seconds(newValue.doubleValue()));
//						}
////						mp.seek(Duration.seconds(newValue.doubleValue()));
//					}
//				});
				
				mp.play();
			}
		});
		
	}

}
