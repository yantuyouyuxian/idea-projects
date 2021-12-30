/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main2 extends Application{

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
		
		TextField t1=new TextField();
		
		TextField t2=new TextField();
		
		Button bu=new Button("判断");
		
		HBox hbox=new HBox(10);
		
		hbox.getChildren().addAll(t1,t2,bu);
		
		
		 SimpleIntegerProperty a=new SimpleIntegerProperty(0);
		 SimpleIntegerProperty b=new SimpleIntegerProperty(0);
		 BooleanBinding boo=a.greaterThan(b);
		 
		 HBox h1=new HBox();
		 ImageView iv1=new ImageView("images/001.jpeg");
		 iv1.setPreserveRatio(true);//等比例缩放
		 iv1.setFitWidth(1000);
		 h1.getChildren().add(iv1);
		 
		 HBox h2=new HBox();
		 ImageView iv2=new ImageView("images/002.png");
		 iv2.setPreserveRatio(true);//等比例缩放
		 iv2.setFitWidth(1000);
		 h2.getChildren().add(iv2);
		 
		 
		an.getChildren().addAll(h1,hbox);
		Scene sc=new Scene(an);
		primaryStage.setScene(sc);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				int value_a = Integer.parseInt(t1.getText());

				a.set(value_a);

				int value_b = Integer.parseInt(t2.getText());

				b.set(value_b);
				
				if(boo.get()) {
					an.getChildren().set(0, h1);
				}else {
					an.getChildren().set(0, h2);
				}
			}
		});
		
	}

}
