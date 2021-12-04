/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
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
	
		Scale scale1=new Scale(0.5, 0.5, 300, 0);//后两个是组件为原点的坐标
		Scale scale2=new Scale(0.5, 0.5, 300, 0);//变换原点坐标始终以组件最初形态进行计算
	
		System.out.println(scale1.createInverse());//比例取倒数
		System.out.println(scale1.transform(0.5,0.5));//怎么算的自己看
		
		
		Button b1=new Button("button1");
		b1.setPrefHeight(200);
		b1.setPrefWidth(200);
		
		Button b2=new Button("button2");
		b2.setStyle("-fx-background-color:yellow");
		b2.setPrefHeight(200);
		b2.setPrefWidth(200);
		b2.getTransforms().addAll(scale1);//
//		b2.setScaleX(0.5);//默认以中心为原点坐标
		
		

		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(b1,b2);
		AnchorPane.setTopAnchor(b1, 100.0);
		AnchorPane.setLeftAnchor(b1, 100.0);
		
		AnchorPane.setTopAnchor(b2, 100.0);
		AnchorPane.setLeftAnchor(b2, 100.0);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		System.out.println(b2.getWidth()+" "+b2.getHeight());//还是200
		System.out.println(b2.getLocalToParentTransform().getTx()+" "+b2.getLocalToParentTransform().getTy());
		
		Bounds bd1=b2.getLayoutBounds();
		System.out.println(bd1);//宽度还是200
		Bounds bd2=b2.localToParent(bd1);
		System.out.println(bd2);//宽度是100
		
	}

}




