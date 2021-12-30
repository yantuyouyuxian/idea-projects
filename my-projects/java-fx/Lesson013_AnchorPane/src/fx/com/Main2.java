/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *布局
 */
public class Main2 extends Application {

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
		

		Button b1=new Button("button1");
		Button b2=new Button("button2");
		Button b3=new Button("button3");
		Button b4=new Button("button4");
		
		
		
		AnchorPane ap=new AnchorPane();
	
		ap.setStyle("-fx-background-color:gray");
		
		
		
		AnchorPane ap2=new AnchorPane();
		
		ap2.setStyle("-fx-background-color:yellow");
		
		ap2.getChildren().add(b1);
		ap2.setRightAnchor(b1, 0.0);
		ap2.setBottomAnchor(b1, 0.0);
		
		
//		b1.setManaged(false);
//		b1.setVisible(value);
//		b1.setOpacity(value);
		 
		
		ap.getChildren().add(ap2);
		
//		ap.setTopAnchor(ap2, 30.0);
//		ap.setLeftAnchor(ap2, 30.0);
//		ap.setRightAnchor(ap2, 30.0);
//		ap.setBottomAnchor(ap2, 30.0);
		
		//此时无法获取布局的宽高
		Scene scene=new Scene(ap);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		ap.setTopAnchor(ap2, 0.0);
		ap.setLeftAnchor(ap2, 0.0);
		ap.setRightAnchor(ap2, ap.getWidth()/2);
		ap.setBottomAnchor(ap2, ap.getHeight()/2);
		
		primaryStage.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				ap.setBottomAnchor(ap2, ap.getHeight()/2);
			}
		});
		primaryStage.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				ap.setRightAnchor(ap2, ap.getWidth()/2);
			}
		});
	}

}
