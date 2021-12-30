/**
 * 
 */
package fx.com;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	/**
	 * @param args
	 */
	
	ImageView iv_blur=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		ImageView iv=new ImageView("img/2.jpeg");
		
		AnchorPane pane=new AnchorPane();
		AnchorPane.setLeftAnchor(b1, 200.0);
		AnchorPane.setLeftAnchor(b2, 400.0);
		pane.getChildren().addAll(iv,b1,b2);
		Node node=getView(primaryStage);
	
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(pane,node);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		iv.fitWidthProperty().bind(primaryStage.widthProperty());
		iv.fitHeightProperty().bind(primaryStage.heightProperty());
		
		TranslateTransition tt=new TranslateTransition(Duration.seconds(1),node);
		tt.setInterpolator(Interpolator.EASE_BOTH);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				tt.setFromX(-200);
				tt.setToX(0);
				tt.play();
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				tt.setFromX(0);
				tt.setToX(-200);
				tt.play();
			}
		});
		
		node.translateXProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				int w=200+newValue.intValue();
				int h=(int)root.getHeight();
				if(w >0) {
					WritableImage wi=new WritableImage(w, h);
					pane.snapshot(new SnapshotParameters(), wi);
					iv_blur.setImage(wi);
				}
			}
		});
		
	}
	
	public Node getView(Stage stage) {
		
		StackPane sp=new StackPane();
		
		AnchorPane ap=new AnchorPane();
		iv_blur=new ImageView();
		iv_blur.setEffect(new GaussianBlur(50));
		ap.getChildren().add(iv_blur);
		AnchorPane.setRightAnchor(iv_blur, 0.0);
		
		VBox vbox=new VBox(20);
		vbox.setStyle("-fx-background-color:#ffffff55");
		vbox.setPrefWidth(200);
		for(int i=0;i<5;i++) {
			vbox.getChildren().add(new Text("hello world"+i));
		}
		sp.getChildren().addAll(ap,vbox);
		sp.setTranslateX(-200);
		vbox.prefHeightProperty().bind(stage.heightProperty());
		return sp;
	}

}
