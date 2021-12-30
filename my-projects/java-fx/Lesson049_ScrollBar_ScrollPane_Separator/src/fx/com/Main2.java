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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		
		VBox vbox1=new VBox();
		
		HBox hbox=new HBox();
		for(int i=0 ;i<10;i++) {
			hbox.getChildren().add(new Button("Button"+i));
		}
		
		VBox vbox2=new VBox();
		for(int i=0 ;i<10;i++) {
			vbox2.getChildren().add(new Button("Button"+i));
		}
		vbox1.getChildren().addAll(hbox,vbox2);
		ScrollPane sp=new ScrollPane();
		sp.setPrefHeight(200);
		sp.setPrefWidth(200);
		sp.setContent(vbox1);
	
		an.getChildren().addAll(sp);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		sp.hvalueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
		
		
	}

}
