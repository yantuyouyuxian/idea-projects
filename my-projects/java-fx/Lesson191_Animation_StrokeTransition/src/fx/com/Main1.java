/**
 * 
 */
package fx.com;


import javafx.animation.Animation;
import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
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

		Button bu=new Button("²¥·Å");
		Rectangle rec=new Rectangle(100,100,Color.ANTIQUEWHITE);
		rec.setStrokeWidth(10);
		rec.setStrokeType(StrokeType.CENTERED);
		
		StrokeTransition ft=new StrokeTransition();
//		ft.getCuePoints().put("", value);
		ft.setDuration(Duration.seconds(0.2));
		ft.setShape(rec);
		
		ft.setFromValue(Color.RED);
		ft.setToValue(Color.YELLOW);
		
		ft.setAutoReverse(true);
		ft.setCycleCount(Animation.INDEFINITE);
		
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(bu,rec);
		
		AnchorPane.setTopAnchor(rec, 200.0);
		AnchorPane.setLeftAnchor(rec, 300.0);
		

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ft.play();
			}
		});
		
		
	}

}
