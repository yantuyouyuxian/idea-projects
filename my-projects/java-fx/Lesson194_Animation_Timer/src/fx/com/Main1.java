/**
 * 
 */
package fx.com;


import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

		Button bu=new Button("播放");
		Rectangle rec=new Rectangle(100,100,Color.RED);
		
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(Duration.seconds(1));
		tt.setNode(rec);
		tt.setFromX(0);
		tt.setToX(600);
		
		AnimationTimer at=new AnimationTimer() {
			int i=0;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				//帧数，纳秒
				Duration duration=new Duration(now/100000);
				System.out.println(now/1000000000);
				System.out.println(now);
				System.out.println("i= "+ i++);//一帧运行一次
				rec.setRotate(rec.getRotate()+6);
			}
			
		};
		
		
		tt.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				at.stop();
			}
		});
	
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
				at.start();
				tt.play();
			}
		});
		
		
	}

}
