/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *	Accordion TitledPane
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
		
		Accordion acc=new Accordion();
		
		TitledPane tp1=new TitledPane("tp1",new Button("button1"));
		tp1.setExpanded(false);
		tp1.setAnimated(false);
//		tp1.setCollapsible(true);
		
		
		TitledPane tp2=new TitledPane();
		tp2.setText("tp2");
		tp2.setContent(new Button("button2"));
		
		TitledPane tp3=new TitledPane();
		tp3.setText("tp3");
		HBox hbox=new HBox();
		hbox.setStyle("-fx-background-color:yellow");
		hbox.getChildren().addAll(new Button("button3"),new Button("button4"),new Button("button5"));
		tp3.setContent(hbox);
		tp3.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		
//		tp3.setGraphic(new ImageView());
		
		acc.getPanes().addAll(tp1,tp2,tp3);
		
//		an.getChildren().addAll(tp1,tp2,tp3);
		an.getChildren().add(acc);
		
//		an.setTopAnchor(tp2, 60.0);
//		
//		an.setTopAnchor(tp3, 120.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		tp1.expandedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
//				System.out.println(newValue);
			}
		});
		
		acc.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {

			@Override
			public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue,
					TitledPane newValue) {
				// TODO Auto-generated method stub
				if(newValue!=null) {
					System.out.println(newValue.getText()+" expand");
				}else {
					System.out.println(oldValue.getText()+" folded");
				}
				
			}
		});
	}

}
