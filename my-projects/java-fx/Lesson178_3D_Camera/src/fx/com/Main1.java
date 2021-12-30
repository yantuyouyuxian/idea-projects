/**
 * 
 */
package fx.com;

import java.util.function.Consumer;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
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

		HBox hbox=new HBox(200);
		hbox.setAlignment(Pos.CENTER);
		
		Box box1=new Box(150,150,150);
		
		Box box2=new Box(150,150,150);
		
		Box box3=new Box(150,150,150);
		
		hbox.getChildren().addAll(box1,box2,box3);

		AnchorPane root = new AnchorPane();
		root.getChildren().add(hbox);
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 300.0);
		
		
		
		
		PerspectiveCamera camera=new PerspectiveCamera();//参数指定true时，相机在(0,0)
		
//		camera.setTranslateY(-300);
//		camera.setTranslateZ(300);
		camera.setRotationAxis(Rotate.Y_AXIS);
		camera.setRotate(60);
		
//		camera.setFieldOfView(30);//视野大小
		
		camera.setNearClip(1.2);
		camera.setFarClip(1.9);
		
		
		
		
		Scene scene = new Scene(root,1000,600,true,SceneAntialiasing.BALANCED);
		
		scene.setCamera(camera);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}
	

}
