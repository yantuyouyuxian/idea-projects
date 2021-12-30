/**
 * 
 */
package fx.com;

import java.util.Optional;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;

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
		
		Button bu=new Button("µã»÷µ¯³öDialog");
	
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu);
		an.setStyle("-fx-background-color:yellow");
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Dialog<ButtonType> dialog=new Dialog<ButtonType>();
				
				dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
				dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
				
				Button close=(Button)dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
				Button ok=(Button)dialog.getDialogPane().lookupButton(ButtonType.OK);	
				
				close.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						System.out.println("close");
					}
				});
				
				ok.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						System.out.println("ok");
					}
				});
				
				dialog.setOnCloseRequest(new EventHandler<DialogEvent>() {
					
					@Override
					public void handle(DialogEvent event) {
						// TODO Auto-generated method stub
						System.out.println("closeRequest");
					}
				});
				
//				dialog.setResultConverter(new Callback<ButtonType, ButtonType>() {
//					
//					@Override
//					public ButtonType call(ButtonType param) {
//						// TODO Auto-generated method stub
//						return param;
//					}
//				});
				
				
				
				dialog.setHeaderText("HeaderText");
				dialog.setGraphic(new Button("Graphic"));
				dialog.setTitle("DialogTitle");
				dialog.getDialogPane().setPrefSize(300, 180);
				Optional<ButtonType> opt=dialog.showAndWait();
				opt.ifPresent(new Consumer<ButtonType>() {

					@Override
					public void accept(ButtonType t) {
						// TODO Auto-generated method stub
						String str=t.getButtonData().toString();
						
						dialog.setContentText(str);

					}
				});
				
//				dialog.setWidth(300);
//				dialog.setHeight(180);
				
//				dialog.setContentText("ContentText");
				
				
				
				dialog.show();
			}
		});
	}

}
