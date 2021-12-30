/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.DepthTest;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
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
		
		HBox hbox=new HBox(100);
		ObservableList<Node> list=hbox.getChildren();
		
		for(int i=0; i<5; i++) {
			Box box=new Box(100, 100, 100);
			list.add(box);
		}
		
		Box b1=(Box)hbox.getChildren().get(0);
//		b1.setTranslateZ(100);
//		b1.setTranslateX(100);
		b1.setRotationAxis(new Point3D(1, 0, 0));
//		System.out.println(b1.getRotationAxis());
		b1.setRotate(10);//顺时针旋转
		
		Box b2=(Box)hbox.getChildren().get(1);
		b2.setRotationAxis(new Point3D(1, 1, 1));
		b2.setRotate(45);
		b2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("clicked");
			}
		});
		
		Box b3=(Box)hbox.getChildren().get(2);
		b3.setRotationAxis(new Point3D(1, 1, 1));
		b3.setRotate(45);
		b3.setDrawMode(DrawMode.LINE);
		b3.setCullFace(CullFace.BACK);//cull:剔除
		
		
		
		
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
