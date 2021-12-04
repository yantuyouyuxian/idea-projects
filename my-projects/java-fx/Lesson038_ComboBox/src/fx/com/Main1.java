/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
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
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		
		ComboBox<String> cbb=new ComboBox<String>();
		
		cbb.getItems().addAll("str1","str2","str3","str4","str5");
		
		cbb.setEditable(true);
		
		cbb.setPromptText("XXXX");
		
//		cbb.setPlaceholder(new Button("placeholder1"));//占位，为空时有效
		
		cbb.setVisibleRowCount(3);
		
		
		
		
		an.getChildren().addAll(bu,cbb);
		AnchorPane.setTopAnchor(cbb, 50.0);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		cbb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
		cbb.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("setOnAction()");
			}
		});
		
	}

}
