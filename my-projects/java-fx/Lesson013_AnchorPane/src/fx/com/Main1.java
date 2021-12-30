/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *布局
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
		
//		Group root=new Group();
//		root.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		
		
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		Button b3=new Button("button3");
		Button b4=new Button("button4");
		
		AnchorPane ap=new AnchorPane();
		ap.setStyle("-fx-background-color:gray");
		
		ap.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("ap.setOnMouseClicked()");
			}
		});
		
//		ap.getChildren().addAll(b1);
		
//		ap.setLeftAnchor(b1, 20.0);//该布局可以同时设置上下左右，会改变控件的大小来进行适配
//		ap.setLeftAnchor(b2, 100.0);//使用布局管理时再设置控件的layout坐标无效
		
//		ap.setPadding(new Insets(10));//内边距要配合下面使用
//		ap.setTopAnchor(b1, 0.0);
//		ap.setLeftAnchor(b1, 0.0);
		
		Group g1=new Group();
		Group g2=new Group();
		g1.getChildren().addAll(b1,b2);
		g2.getChildren().addAll(b3,b4);
		
		ap.setLeftAnchor(g1, 0.0);
		ap.setLeftAnchor(g2, 200.0);
		
		b2.setLayoutX(80);
		b4.setLayoutX(80);
		
		
		ap.getChildren().addAll(g1,g2);//group透明
		
		
		Scene scene=new Scene(ap);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
