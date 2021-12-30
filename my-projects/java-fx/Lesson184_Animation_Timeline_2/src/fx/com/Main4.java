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
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.MapChangeListener;
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
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main4 extends Application {

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
		
		ToggleGroup group = new ToggleGroup();
		ToggleButton tb1 = new ToggleButton("播放");
		ToggleButton tb2 = new ToggleButton("暂停");
		ToggleButton tb3 = new ToggleButton("停止");
		ToggleButton tb4 = new ToggleButton("重启");
		group.getToggles().addAll(tb1, tb2, tb3, tb4);

		Rectangle rec=new Rectangle(100, 100,Color.RED);
		
		Rotate rotate=new Rotate(0, 200, 200);
		
		Rotate rotate1=new Rotate(0, 50, 50);//先自传的话会干扰公转坐标的计算
		
//		rec.getTransforms().addAll(rotate,rotate1);
		rec.getTransforms().addAll(rotate1);
		HBox hb=new HBox();
		hb.getChildren().add(rec);
		hb.getTransforms().add(rotate);//公转
		

		KeyValue kv1=new KeyValue(rotate.angleProperty(), 0);
		KeyValue kv3=new KeyValue(rotate1.angleProperty(), 0);//rec.rotateProperty()
		KeyFrame kf1=new KeyFrame(Duration.seconds(0), kv1,kv3);
	
		KeyValue kv2=new KeyValue(rotate.angleProperty(), 360);
		KeyValue kv4=new KeyValue(rotate1.angleProperty(), 360);
		KeyFrame kf2=new KeyFrame(Duration.seconds(3), kv2,kv4);
		
	
		Timeline timeline1=new Timeline();
		timeline1.getKeyFrames().addAll(kf1,kf2);
		
		
		timeline1.setCycleCount(Timeline.INDEFINITE);
//		timeline1.setAutoReverse(true);

		
	
		
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(tb1, tb2, tb3, tb4);

		AnchorPane root = new AnchorPane();
		
		root.getChildren().addAll(hbox,hb);
		AnchorPane.setTopAnchor(hb, 200.0);
		AnchorPane.setLeftAnchor(hb, 200.0);

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
