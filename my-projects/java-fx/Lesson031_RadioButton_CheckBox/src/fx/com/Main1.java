/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *	RadioButton
 *	CheckBox
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
		
		HBox hbox=new HBox(10);
		
		ToggleGroup tg=new ToggleGroup();
		
		RadioButton rb1=new RadioButton("rb1");
		RadioButton rb2=new RadioButton("rb2");
		RadioButton rb3=new RadioButton("rb3");
		RadioButton rb4=new RadioButton("rb4");
		
//		rb1.setToggleGroup(tg);
//		rb2.setToggleGroup(tg);
//		rb3.setToggleGroup(tg);
//		rb4.setToggleGroup(tg);
		
		tg.getToggles().addAll(rb1,rb2,rb3,rb4);
		
		hbox.getChildren().addAll(rb1,rb2,rb3,rb4);
		
		an.getChildren().addAll(hbox);
		
		an.setStyle("-fx-background-color:yellow");
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		rb1.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				System.out.println("rb1.selectedProperty = "+newValue);
			}
		});
		
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				// TODO Auto-generated method stub
				System.out.println(((RadioButton)newValue).getText()+" "+newValue.isSelected());
			}
		});
		
	}

}
