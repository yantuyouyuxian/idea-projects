/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Z H
 *宽高，坐标和边界
 */
public class Main3 extends Application{

	double x=0,y=0;
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
		AnchorPane an=new AnchorPane();
		
		 Button b1=new Button("button1");
		 Button b2=new Button("button2");
		 
		 an.getChildren().addAll(b1,b2);
		 AnchorPane.setTopAnchor(b2, 100.0);
		 AnchorPane.setLeftAnchor(b2, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
//		Bounds bou2=b2.getLayoutBounds();
		Bounds bou2=b2.getBoundsInParent();
		
		
		
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			Bounds bou1=null;
			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode().equals(KeyCode.A)) {
					x-=10.0;
				}

				if (event.getCode().equals(KeyCode.S)) {
					y+=10.0;
				}
				if (event.getCode().equals(KeyCode.D)) {
					x+=10.0;
				}

				if (event.getCode().equals(KeyCode.W)) {
					y-=10.0;
				}
				b1.setLayoutX(x);
				b1.setLayoutY(y);
				bou1=b1.getBoundsInParent();
				boolean bool=bou1.getMaxX()<bou2.getMinX()||
						bou1.getMinX()>bou2.getMaxX()||
						bou1.getMaxY()<bou2.getMinY()||
						bou1.getMinY()>bou2.getMaxY();
				System.out.println(!bool);
			}
		});
		
	}

}
