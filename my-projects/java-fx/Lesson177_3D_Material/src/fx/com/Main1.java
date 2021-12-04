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
//		cylinder.setRotate(30);

		Sphere sphere=new Sphere(100,64);
		hbox.getChildren().addAll(box,cylinder,sphere);
		
		hbox.getChildren().forEach(new Consumer<Node>() {

			@Override
			public void accept(Node t) {
				// TODO Auto-generated method stub
				Shape3D shape=(Shape3D)t;
				PhongMaterial pm=new PhongMaterial();
				
//				pm.setDiffuseColor(Color.ANTIQUEWHITE);//漫反射
//				pm.setSpecularColor(Color.WHITE);//高光
//				pm.setSpecularPower(value);
				
//				pm.setSpecularMap(new Image(""));//
				pm.setDiffuseMap(new Image("image/2.jpeg"));//
//				pm.setBumpMap(new Image(""));//需要法线贴图
				
//				pm.setSelfIlluminationMap(new Image("image/2.jpeg"));//
				
				shape.setMaterial(pm);
			}
		});
		
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().add(hbox);
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 100.0);
		
		
		Scene scene = new Scene(root,1000,600,true,SceneAntialiasing.BALANCED);
		scene.setCamera(new PerspectiveCamera());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}
	

}
