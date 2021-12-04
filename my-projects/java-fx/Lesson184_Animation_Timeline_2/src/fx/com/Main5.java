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
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main5 extends Application {

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
		
		Scale scale=new Scale(1, 1, 0, 0);
		rec.getTransforms().add(scale);
		
		ToggleGroup group = new ToggleGroup();
		ToggleButton tb1 = new ToggleButton("≤•∑≈");
		ToggleButton tb2 = new ToggleButton("‘›Õ£");
		ToggleButton tb3 = new ToggleButton("Õ£÷π");
		ToggleButton tb4 = new ToggleButton("÷ÿ∆Ù");
		group.getToggles().addAll(tb1, tb2, tb3, tb4);
		

		KeyValue kv1x=new KeyValue(scale.xProperty(), 1);
		KeyValue kv1y=new KeyValue(scale.yProperty(), 1);
		KeyFrame kf1=new KeyFrame(Duration.seconds(0), kv1x,kv1y);
	
		KeyValue kv2x=new KeyValue(scale.xProperty(), 2);
		KeyValue kv2y=new KeyValue(scale.yProperty(), 2);
		KeyFrame kf2=new KeyFrame(Duration.seconds(2), kv2x,kv2y);
		
		
		Timeline timeline1=new Timeline();
		timeline1.getKeyFrames().addAll(kf1,kf2);
		
		
		timeline1.setCycleCount(Timeline.INDEFINITE);
		timeline1.setAutoReverse(true);
		
		
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
				timeline1.play();
			}
		});
		
	}

}
