/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
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
		

		HBox hbox=new HBox(20);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPrefWidth(400);
		hbox.setPrefHeight(400);
		hbox.setStyle("-fx-background-color:yellow");
		
		Button bu=new Button("button");
		
		Label label=new Label("hello world");
		label.setFont(new Font(20));
		label.setStyle("-fx-background-color:blue");
		
		hbox.getChildren().addAll(bu,label);
		
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 100.0);
		
		AnchorPane an=new AnchorPane();
		an.setStyle("-fx-background-color:gray");
		an.getChildren().addAll(hbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bu.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("bu.addEventFilter "+event.getEventType()+" source:"+event.getSource()+" target:"+event.getTarget());
				
			}
			
		});
		
		hbox.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("hbox.addEventFilter "+event.getEventType()+" source:"+event.getSource()+" target:"+event.getTarget());
			}
			
		});
		
		an.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("an.addEventFilter "+event.getEventType()+" source:"+event.getSource()+" target:"+event.getTarget());
			}
			
		});
		
		
		
		
		
//		scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event event) {
//				// TODO Auto-generated method stub
//				System.out.println("scene "+event.getEventType());
//			}
//			
//		});
//		
//		primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event event) {
//				// TODO Auto-generated method stub
//				System.out.println("primaryStage "+event.getEventType());
//			}
//			
//		});
//		primaryStage.setFullScreen(true);
		
		//filter从父到子
		//handler从子到父
		//filter先于handler执行
		
//		bu.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event event) {
//				// TODO Auto-generated method stub
//				System.out.println("bu.addEventHandler "+event.getEventType()+" source:"+event.getSource()+" target:"+event.getTarget());
//				//button不会自动向上传递handler
////				Event.fireEvent(hbox, event);
//			}
//			
//		});
//		
		label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("label.addEventHandler "+event.getEventType()+" source:"+event.getSource()+" target:"+event.getTarget());
//				event.consume();//阻止事件向上传递
//				System.out.println(event.isConsumed());
			}
			
		});
//		
//		hbox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event event) {
//				// TODO Auto-generated method stub
//				System.out.println("hbox.addEventHandler "+event.getEventType()+" source:"+event.getSource()+" target:"+event.getTarget());
//			}
//			
//		});
//		
//		
//		an.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event event) {
//				// TODO Auto-generated method stub
//				System.out.println("an.addEventHandler "+event.getEventType()+" source:"+event.getSource()+" target:"+event.getTarget());
//			}
//			
//		});
		
		
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("label.setOnMouseClicked");
			}
		});
		
	}

}
