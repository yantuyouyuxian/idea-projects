/**
 * 
 */
package fx.com;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *宽高，坐标和边界
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
		
		Button b1=new Button("button1");
		Student s=new Student("A", 18);
		
		an.getChildren().addAll(b1);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		s.pcs.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				System.out.println(evt.getOldValue()+"->"+evt.getNewValue());
				System.out.println(evt.getSource());
			}
		});
		
//		s.pcs.addPropertyChangeListener("setName_pro", new PropertyChangeListener() {
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				// TODO Auto-generated method stub
//				System.out.println(evt.getOldValue() + "->" + evt.getNewValue());
//			}
//		});
//
//		s.pcs.addPropertyChangeListener("setAge_pro", new PropertyChangeListener() {
//
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				// TODO Auto-generated method stub
//				System.out.println(evt.getOldValue() + "->" + evt.getNewValue());
//			}
//		});
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				s.setName("B");
				s.setAge(19);
			}
		});
	}

}
