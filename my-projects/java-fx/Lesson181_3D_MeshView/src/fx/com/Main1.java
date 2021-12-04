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
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.TriangleMesh;
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
//		Box
		hbox.setAlignment(Pos.CENTER);
		
		float[] points= new float[]
				{
						0,0,0,
						100,0,0,
						100,100,0,
						0,100,0,
	
						0,0,100,
						100,0,100,
						100,100,100,
						0,100,100
				};
		
		float[] texcoords= new float[]
				{
						0,0
//						0.5f,0,
//						0.5f,0.5f,
//						0,0.5f,
//						
//						1,0,
//						1,0.5f,
//						
//						0,-0.5f,
//						
//						0,1
				};
		int[] faces= new int[]
				{
//					3,0,2,0,0,0,
//					2,0,1,0,0,0,
						
					3,0,1,0,0,0,
					1,0,2,0,3,0,
				};
		
		TriangleMesh tm=new TriangleMesh();
		
		tm.getPoints().addAll(points);
		
		tm.getTexCoords().addAll(0,0);
		
		tm.getFaces().addAll(faces);
	
		MeshView mv=new MeshView(tm);
		
//		mv.setRotationAxis(new Point3D(1, 1, 0));
//		mv.setRotate(45);
		
		
		
		
		hbox.getChildren().addAll(mv);
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().add(hbox);
		AnchorPane.setTopAnchor(hbox, 200.0);
		AnchorPane.setLeftAnchor(hbox, 200.0);
		
		
		Scene scene = new Scene(root,1000,600,true,SceneAntialiasing.BALANCED);
		scene.setCamera(new PerspectiveCamera());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}
	

}
