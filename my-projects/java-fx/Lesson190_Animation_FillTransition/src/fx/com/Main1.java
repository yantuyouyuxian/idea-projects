/**
 * 
 */
package fx.com;


import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
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
		Rectangle rec=new Rectangle(100,100,Color.RED);
	
		FillTransition ft=new FillTransition();
		ft.setDuration(Duration.seconds(1));
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
