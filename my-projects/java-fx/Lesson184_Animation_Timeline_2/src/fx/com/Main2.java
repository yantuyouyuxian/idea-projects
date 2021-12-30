/**
 * 
 */
package fx.com;


import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main2 extends Application {

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

		Rectangle rec=new Rectangle(100, 100,Color.RED);
		
		ToggleGroup group = new ToggleGroup();
		ToggleButton tb1 = new ToggleButton("≤•∑≈");
		ToggleButton tb2 = new ToggleButton("‘›Õ£");
		ToggleButton tb3 = new ToggleButton("Õ£÷π");
		ToggleButton tb4 = new ToggleButton("÷ÿ∆Ù");
		group.getToggles().addAll(tb1, tb2, tb3, tb4);

		Timeline timeline=new Timeline();
		
		KeyValue kv1=new KeyValue(rec.rotateProperty(), 0);
		KeyFrame kf1=new KeyFrame(Duration.seconds(0), kv1);
		
		KeyValue kv2=new KeyValue(rec.rotateProperty(), 360);
		KeyFrame kf2=new KeyFrame(Duration.seconds(1), kv2);
		
	
		KeyValue kv3=new KeyValue(rec.translateXProperty(), 0);
		KeyFrame kf3=new KeyFrame(Duration.seconds(1), kv3);
		
		KeyValue kv4=new KeyValue(rec.translateXProperty(), 300);
		KeyFrame kf4=new KeyFrame(Duration.seconds(3), kv4);
		
		
		KeyValue kv5=new KeyValue(rec.rotateProperty(), 360);
		KeyFrame kf5=new KeyFrame(Duration.seconds(3), kv5);
		
		KeyValue kv6=new KeyValue(rec.rotateProperty(), 0);
		KeyFrame kf6=new KeyFrame(Duration.seconds(4), kv6);
		
		KeyValue kv7=new KeyValue(rec.rotateProperty(), 0);
		KeyFrame kf7=new KeyFrame(Duration.seconds(4), kv7);
		
		timeline.getKeyFrames().addAll(kf1,kf2,kf3,kf4,kf5,kf6,kf7);
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		
		
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(tb1, tb2, tb3, tb4);

		AnchorPane root = new AnchorPane();
		
		root.getChildren().addAll(hbox,rec);
		AnchorPane.setTopAnchor(rec, 200.0);
		AnchorPane.setLeftAnchor(rec, 200.0);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		tb1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				timeline.play();
			}
		});
		
	}

}
