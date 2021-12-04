/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
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
//		cylinder.setRotationAxis(p);
//		cylinder.setRotate(30);

		Sphere sphere=new Sphere(100,64);
		hbox.getChildren().addAll(box,cylinder,sphere);
		
		AnchorPane root = new AnchorPane();
		
		root.getChildren().addAll(hbox);
		AnchorPane.setTopAnchor(hbox, 50.0);
		AnchorPane.setLeftAnchor(hbox, 50.0);
		
		PerspectiveCamera camera=new PerspectiveCamera();
		
		SubScene subscene = new SubScene(root,1000,600,true,SceneAntialiasing.BALANCED);
		subscene.setCamera(camera);
		
		HBox h=new HBox(100);
		
		Button b1=new Button("button");
		TextField tf=new TextField("javafx 3D");
		
		h.getChildren().addAll(b1,tf,subscene);
	
		Scene scene = new Scene(h);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(900);
		primaryStage.setWidth(1500);
		primaryStage.show();
		
		
	}
	

}
