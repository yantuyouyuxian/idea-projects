/**
 * 
 */
package fx.com;




import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main4 extends Application {

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

		Button bu1=new Button("button1");
		Button bu2=new Button("button2");

		
		
		StackPane sp=new StackPane();
		sp.setPrefWidth(400);
		sp.setPrefHeight(400);
		sp.setBorder(
				new Border(
						new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		
		
		HBox hbox1=new HBox();
		hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(new Button("button1"));
		hbox1.setBackground(
				new Background(
						new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
		
		HBox hbox2=new HBox();
		hbox2.setAlignment(Pos.CENTER);
		hbox2.getChildren().addAll(new Button("button2"));
		hbox2.setBackground(
				new Background(
						new BackgroundFill(Color.AQUA, null, null)));
		hbox2.setBorder(
				new Border(
						new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		
		sp.getChildren().addAll(hbox1,hbox2);
		
		Pane pane=new Pane();
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(Duration.seconds(2));
		tt.setNode(pane);
		tt.setFromX(0);
		tt.setToX(400);
		tt.setInterpolator(Interpolator.LINEAR);
//		tt.setAutoReverse(true);
//		tt.setCycleCount(Animation.INDEFINITE);
		
		
		DisplacementMap dismap=new DisplacementMap();
//		dismap.setWrap(true);
//		dismap.setOffsetX(0.5);
		hbox2.setEffect(dismap);
		
		DisplacementMap dismap2=new DisplacementMap();
		hbox1.setEffect(dismap2);
		dismap2.setOffsetX(1);
		
		pane.translateXProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
//				System.out.println(newValue.intValue());
//				hbox2.setTranslateX(newValue.intValue());
				dismap.setOffsetX(newValue.doubleValue()/(-400));
				dismap2.setOffsetX(1-(newValue.doubleValue()/400));
//				hbox2.setTranslateX(newValue.intValue());
			}
		});
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(bu1,bu2,sp);
		
		AnchorPane.setTopAnchor(sp, 100.0);
		AnchorPane.setLeftAnchor(sp, 300.0);
		
		AnchorPane.setLeftAnchor(bu2, 100.0);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		bu1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				tt.play();
			}
		});
		
		bu2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				tt.setFromX(400);
//				tt.setToX(0);
//				tt.play();
			}
		});
		
		tt.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				// sp.getChildren().remove(hbox2);
				// hbox2.setVisible(false);
				System.out.println(dismap.getOffsetX());
				System.out.println(dismap2.getOffsetX());
			}
		});

	}

}
