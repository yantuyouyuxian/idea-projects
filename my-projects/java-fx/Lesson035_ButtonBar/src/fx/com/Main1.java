/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application implements EventHandler<ActionEvent>{

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
		
		ButtonBar bb=new ButtonBar();
		bb.setStyle("-fx-background-color:yellow");
		
		Button b1=new Button("b1");
		Button b2=new Button("b2");
		Button b3=new Button("b3");
		
		b1.setPrefWidth(150);
//		b2.setPrefWidth(200);
		
		ButtonBar.setButtonData(b1, ButtonData.APPLY);
		ButtonBar.setButtonData(b2, ButtonData.FINISH);
		ButtonBar.setButtonData(b3, ButtonData.NO);
		
		bb.getButtons().addAll(b1,b2,b3);
		bb.setButtonOrder(ButtonBar.BUTTON_ORDER_NONE);
//		ButtonBar.setButtonUniformSize(b1, false);
		
		b1.setOnAction(this);
		b2.setOnAction(this);
		b3.setOnAction(this);
		
		an.getChildren().addAll(bb);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Button bu=(Button)event.getSource();
		if(ButtonBar.getButtonData(bu)==ButtonData.APPLY) {
			System.out.println("apply "+bu.getText());
		}
		if(ButtonBar.getButtonData(bu)==ButtonData.FINISH) {
			System.out.println("finish "+bu.getText());
		}
		if(ButtonBar.getButtonData(bu)==ButtonData.NO) {
			System.out.println("no "+bu.getText());
		}
		
	}

}
