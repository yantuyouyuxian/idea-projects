/**
 * 
 */
package fx.com;


import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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

		Rectangle rec=new Rectangle(300, 300);
		rec.setFill(Color.RED);
		
		ToggleGroup group = new ToggleGroup();
		ToggleButton tb1 = new ToggleButton("播放");
		ToggleButton tb2 = new ToggleButton("暂停");
		ToggleButton tb3 = new ToggleButton("停止");
		ToggleButton tb4 = new ToggleButton("重启");
		group.getToggles().addAll(tb1, tb2, tb3, tb4);

		Button bu=new Button("button");
		
		
		Timeline timeline=new Timeline(60);//帧数
		
		KeyValue kv1=new KeyValue(bu.translateXProperty(), 300,Interpolator.EASE_BOTH);
		KeyValue kv2=new KeyValue(bu.translateYProperty(), 0,Interpolator.EASE_BOTH);
		KeyFrame kf1=new KeyFrame(Duration.seconds(2), "kf1", new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("kf1:"+bu.getTranslateX()+" "+bu.getTranslateY());
			}
			
		}, kv1,kv2);
		
		KeyValue kv3=new KeyValue(bu.translateYProperty(), 300,Interpolator.EASE_BOTH);
		KeyFrame kf2=new KeyFrame(Duration.seconds(4), "kf2", new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("kf2:"+bu.getTranslateX()+" "+bu.getTranslateY());
			}
			
		},kv3);
		

		timeline.getKeyFrames().addAll(kf1,kf2);
//		timeline.setDelay(Duration.seconds(2));
//		timeline.setCycleCount(Timeline.INDEFINITE);//Timeline.INDEFINITE
//		timeline.setAutoReverse(true);
		System.out.println("totalduration:"+timeline.getTotalDuration());
//		timeline.setRate(2);//可以为负数
//		timeline.getCuePoints().put("aaa", Duration.seconds(5));//设置一个提示点
//		timeline.playFrom();//时间或者提示点
		
		
		timeline.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("finished"+bu.getTranslateX()+" "+bu.getTranslateY());
			}
		});
		
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(tb1, tb2, tb3, tb4);

		AnchorPane root = new AnchorPane();
		
		root.getChildren().addAll(hbox,rec,bu);
		AnchorPane.setTopAnchor(bu, 200.0);
		AnchorPane.setLeftAnchor(bu, 200.0);
		
		AnchorPane.setTopAnchor(rec, 200.0);
		AnchorPane.setLeftAnchor(rec, 200.0);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		timeline.statusProperty().addListener(new ChangeListener<Status>() {

			@Override
			public void changed(ObservableValue<? extends Status> observable, Status oldValue, Status newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
//				System.out.println(bu.getLayoutX()+" "+bu.getLayoutY());
			}
		});
		
		
		tb1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				timeline.play();
				System.out.println("play:"+bu.getTranslateX()+" "+bu.getTranslateY());
			}
		});
		tb2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				timeline.pause();
			}
		});
		tb3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				timeline.stop();
			}
		});
		tb4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				timeline.jumpTo("kf2");
				timeline.playFromStart();
//				System.out.println(timeline.getCurrentTime().toSeconds());
			}
		});
	}

}
