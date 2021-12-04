/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	double x=0;
	double y=0;
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
		
		Button bu=new Button("button");
		
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu);
		
		Background bg=new Background(new BackgroundFill(Paint.valueOf("yellow"), new CornerRadii(20), new Insets(0)));
		an.setBackground(bg);
		
		an.setBorder(
				new Border(
				new BorderStroke(Paint.valueOf("blue"), BorderStrokeStyle.DASHED, new CornerRadii(15), new BorderWidths(2), new Insets(0))));
		
//		an.setBorder(new Border());
		
		AnchorPane.setLeftAnchor(bu, 100.0);
		AnchorPane.setTopAnchor(bu, 100.0);
		
		Scene scene=new Scene(an);
		scene.setFill(Paint.valueOf("#ffffff00"));
		
		
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		
		bu.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				x=event.getX();
				y=event.getY();
			}
		});
		
		bu.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				AnchorPane.setLeftAnchor(bu, event.getSceneX()-x);
				AnchorPane.setTopAnchor(bu, event.getSceneY()-y);
			}
		});
		
		
		
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				x=event.getX();
				y=event.getY();
			}
		});
		
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				primaryStage.setX(event.getScreenX()-x);
				primaryStage.setY(event.getScreenY()-y);
			}
		});
	}

}
