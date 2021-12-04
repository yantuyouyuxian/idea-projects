/**
 * 
 */
package fx.com;

import java.util.function.Consumer;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
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
		
		Box box=new Box(150,150,150);
		
		Cylinder cylinder=new Cylinder(50, 150,64);
		Point3D p=new Point3D(1, 0, 0);
		cylinder.setRotationAxis(p);
		cylinder.setRotate(30);

		Sphere sphere=new Sphere(100,64);
		hbox.getChildren().addAll(box,cylinder,sphere);
		
		AmbientLight al=new AmbientLight();//环境光源
		al.setColor(Color.RED);
//		al.setLightOn(false);
		al.getScope().addAll(box);//添加受光源影响的组件
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox,al);
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 300.0);
		
		PerspectiveCamera camera=new PerspectiveCamera();
		
		Scene scene = new Scene(root,1000,600,true,SceneAntialiasing.BALANCED);
		
		scene.setCamera(camera);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}
	

}
