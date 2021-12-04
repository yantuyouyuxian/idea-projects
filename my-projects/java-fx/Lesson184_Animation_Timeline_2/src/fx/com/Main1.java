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
public class Main1 extends Application {

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
		
		KeyValue kv1=new KeyValue(rec.translateXProperty(), 0);
		KeyValue kv1R=new KeyValue(rec.rotateProperty(), 0);
		KeyValue kv1SX=new KeyValue(rec.scaleXProperty(), 1);
		KeyValue kv1SY=new KeyValue(rec.scaleYProperty(), 1);
		KeyValue kv1Op=new KeyValue(rec.opacityProperty(), 1);
		KeyFrame kf1=new KeyFrame(Duration.seconds(0), kv1,kv1R,kv1SX,kv1SY,kv1Op);
		
		KeyValue kv2=new KeyValue(rec.translateXProperty(), 300);
		KeyValue kv2R=new KeyValue(rec.rotateProperty(), 360);
		KeyValue kv2SX=new KeyValue(rec.scaleXProperty(), 2);
		KeyValue kv2SY=new KeyValue(rec.scaleYProperty(), 2);
		KeyValue kv2Op=new KeyValue(rec.opacityProperty(), 0.2);
		KeyFrame kf2=new KeyFrame(Duration.seconds(3), kv2,kv2R,kv2SX,kv2SY,kv2Op);
		
		
		timeline.getKeyFrames().addAll(kf1,kf2);
		
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
