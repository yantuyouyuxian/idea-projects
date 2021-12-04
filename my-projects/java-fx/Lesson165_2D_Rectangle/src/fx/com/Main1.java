/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
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
		
		Rectangle rec1=new Rectangle();
//		rec1.setX(0);
//		rec1.setY(0);//能否设置坐标要看父组件是否有约束
		rec1.setWidth(200);
		rec1.setHeight(100);
		rec1.setFill(Paint.valueOf("blue"));
		
		Rectangle rec2=new Rectangle();
		rec2.setWidth(200);
		rec2.setHeight(100);
		rec2.setFill(Paint.valueOf("blue"));
		rec2.setArcWidth(20);
		rec2.setArcHeight(20);
		
		Rectangle rec3=new Rectangle();
		rec3.setWidth(200);
		rec3.setHeight(100);
		rec3.setFill(Paint.valueOf("blue"));
		rec3.setArcWidth(20);
		rec3.setArcHeight(20);
		
		rec3.setStrokeWidth(10);
		rec3.setStroke(Color.RED);
		rec3.setStrokeType(StrokeType.INSIDE);
		
		Rectangle rec4=new Rectangle();
		rec4.setWidth(200);
		rec4.setHeight(100);
		rec4.setFill(Paint.valueOf("blue"));
		rec4.setArcWidth(20);
		rec4.setArcHeight(20);
		rec4.setStrokeWidth(3);
		rec4.setStroke(Color.RED);
		rec4.setStrokeType(StrokeType.INSIDE);
		rec4.getStrokeDashArray().addAll(10.0,20.0);
		
		
		
		HBox hbox=new HBox(30);
		hbox.getChildren().addAll(rec1,rec2,rec3,rec4);
		
		AnchorPane root = new AnchorPane();
		
		Rectangle rec5=new Rectangle();
		rec5.setX(100);
		rec5.setY(300);
		rec5.setWidth(200);
		rec5.setHeight(100);
		rec5.setFill(Paint.valueOf("blue"));
		
		rec5.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("rec5");
			}
		});
		
		root.getChildren().addAll(hbox,rec5);
		
		AnchorPane.setLeftAnchor(hbox, 100.0);
		AnchorPane.setTopAnchor(hbox, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1300);
		primaryStage.show();
		
		System.out.println(rec5.getLayoutBounds());
		System.out.println(rec5.getBoundsInLocal());
		System.out.println(rec5.getBoundsInParent());
	}
	

}
