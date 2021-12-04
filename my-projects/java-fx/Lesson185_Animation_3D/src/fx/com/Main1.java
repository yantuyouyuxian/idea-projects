/**
 * 
 */
package fx.com;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
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

		Button bu=new Button("²¥·Å");
		
		AnchorPane subap=new AnchorPane();
		subap.setPrefHeight(800);
		subap.setPrefWidth(800);
		
		Box box=new Box(100,100,100);
		subap.getChildren().add(box);
		
		AnchorPane.setTopAnchor(box, 100.0);
		AnchorPane.setLeftAnchor(box, 100.0);
		
		SubScene subscene=new SubScene(subap, 800, 800,true,SceneAntialiasing.BALANCED);
		
		PerspectiveCamera camera=new PerspectiveCamera();
		camera.setNearClip(0);
		camera.setFarClip(100);
		
		subscene.setCamera(camera);
		
		Rotate rotate =new Rotate(0, 100, 100, 0);
		rotate.setAxis(Rotate.Z_AXIS);;
		
		
		Scale scale=new Scale(1, 1, 1, -50, -50, -50);
		
		box.getTransforms().addAll(scale);
		
		
		
		KeyValue kv1x=new KeyValue(scale.xProperty(),1);
		KeyValue kv1y=new KeyValue(scale.yProperty(),1);
		KeyValue kv1z=new KeyValue(scale.zProperty(),1);
		KeyFrame kf1=new KeyFrame(Duration.seconds(0), kv1x,kv1y,kv1z);
		
		KeyValue kv2x=new KeyValue(scale.xProperty(),2);
		KeyValue kv2y=new KeyValue(scale.yProperty(),2);
		KeyValue kv2z=new KeyValue(scale.zProperty(),2);
		KeyFrame kf2=new KeyFrame(Duration.seconds(2), kv2x,kv2y,kv2z);
		
		Timeline timeline=new Timeline();
		timeline.getKeyFrames().addAll(kf1,kf2);
		
//		timeline.setAutoReverse(true);
//		timeline.setCycleCount(Timeline.INDEFINITE);
		
		
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(bu,subscene);
		
		AnchorPane.setTopAnchor(subscene, 200.0);
		AnchorPane.setLeftAnchor(subscene, 300.0);
		

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				timeline.play();
			}
		});
	}

}
