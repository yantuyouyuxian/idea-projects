/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

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
		Button b=new Button("button");
		VBox vbox=new VBox();
		for(int i=0 ;i<10;i++) {
			vbox.getChildren().add(new Button("Button"+i));
		}
		
		ScrollBar sc=new ScrollBar();
		sc.setOrientation(Orientation.VERTICAL);
		sc.setVisibleAmount(20);
//		sc.setValue(50);
		sc.setUnitIncrement(10);
		sc.setBlockIncrement(20);
		
		AnchorPane.setLeftAnchor(sc, 200.0);
		AnchorPane.setLeftAnchor(b, 400.0);
		
		an.getChildren().addAll(sc,vbox,b);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		sc.setPrefHeight(vbox.getHeight());
		sc.setPrefWidth(30);
		
		sc.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
				vbox.setLayoutY(newValue.doubleValue());
			}
		});
		
		b.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				sc.increment();
			}
		});
		
	}

}
