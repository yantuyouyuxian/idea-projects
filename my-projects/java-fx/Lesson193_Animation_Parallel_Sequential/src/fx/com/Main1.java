/**
 * 
 */
package fx.com;


import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
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
		
		
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(Duration.seconds(6));
		tt.setFromX(0);
		tt.setToX(600);
		
		FillTransition ft=new FillTransition();
		ft.setDuration(Duration.seconds(2));
		ft.setFromValue(Color.YELLOW);
		ft.setToValue(Color.GREEN);
		
		RotateTransition rt=new RotateTransition();
		rt.setDuration(Duration.seconds(3));
		rt.setFromAngle(0);
		rt.setToAngle(360);
		
		ParallelTransition pt=new ParallelTransition();
		pt.setNode(rec);
		pt.getChildren().addAll(tt,rt);
//		pt.setAutoReverse(true);
//		pt.setCycleCount(Animation.INDEFINITE);
		
		SequentialTransition st=new SequentialTransition();
		st.setNode(rec);
//		st.getChildren().addAll(tt,rt);
		st.getChildren().addAll(ft,pt);
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(bu,rec);

		AnchorPane.setTopAnchor(rec, 100.0);
		AnchorPane.setLeftAnchor(rec, 100.0);

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
//				pt.play();
				st.play();
			}
		});
		
		
	}

}
