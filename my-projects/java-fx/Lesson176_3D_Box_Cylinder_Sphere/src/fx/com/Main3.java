/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main3 extends Application{

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
		
		HBox hbox=new HBox(100);
		ObservableList<Node> list=hbox.getChildren();
		
		for(int i=0; i<5; i++) {
			Sphere sphere=new Sphere(100,128);
			list.add(sphere);
		}
		
		Sphere b1=(Sphere)hbox.getChildren().get(0);
//		b1.setTranslateZ(100);
//		b1.setTranslateX(100);
		b1.setRotationAxis(new Point3D(1, 0, 0));
//		System.out.println(b1.getRotationAxis());
		b1.setRotate(10);//顺时针旋转
		
		Sphere b2=(Sphere)hbox.getChildren().get(1);
		b2.setRotationAxis(new Point3D(1, 1, 1));
		b2.setRotate(45);
		b2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("clicked");
			}
		});
		
		Sphere b3=(Sphere)hbox.getChildren().get(2);
		b3.setRotationAxis(new Point3D(1, 1, 1));
		b3.setRotate(45);
		b3.setDrawMode(DrawMode.LINE);
		b3.setCullFace(CullFace.BACK);//cull:剔除
		System.out.println(b3.getDivisions());
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox);
		
		AnchorPane.setLeftAnchor(hbox, 100.0);
		AnchorPane.setTopAnchor(hbox, 100.0);
		
		Scene scene = new Scene(root,600,600,true,SceneAntialiasing.BALANCED);
//		scene.setFill(Color.ANTIQUEWHITE);
		
		scene.setCamera(new PerspectiveCamera());//相机始终在窗口中间
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}
	

}
