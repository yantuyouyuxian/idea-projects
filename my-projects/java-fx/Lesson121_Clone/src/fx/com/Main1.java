/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
		MyButton mybutton=new MyButton("mybutton1");
//		mybutton.setGraphic(new Label("label"));
		mybutton.setPrefWidth(100);
		mybutton.setPrefHeight(100);
		mybutton.setStyle("-fx-background-color:yellow");
		mybutton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("mybutton1 action");
			}
		});
		
	
		MyButton node=(MyButton)mybutton.clone();
		node.setText("button2");//影响本体，有点像一个指向原节点的指针
		
		
		ObservableList<String> obslist=FXCollections.observableArrayList();
		obslist.addAll("A","B","C");
		MyListView mylistview=new MyListView(obslist);
		
		
		MyListView mylistview2=mylistview.clone();
		//公用一个list
		
		
		
		HBox hbox=new HBox(20);
		hbox.getChildren().addAll(mybutton,node,mylistview,mylistview2);
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(hbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}


class MyButton extends Button implements Cloneable{
	
	public MyButton() {
		super();
	}
	
	public MyButton(String text) {
		super(text);
	}
	
	public MyButton(String text,Node node) {
		super(text,node);
	}
	
	@Override
	public Node clone() throws CloneNotSupportedException {
		
		return (Node)super.clone();
	}
	
}

class MyListView extends ListView<String> implements Cloneable{
	
	public MyListView() {
		super();
	}
	public MyListView(ObservableList<String> obslist) {
		super(obslist);
	}
	
	@Override
	protected MyListView clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (MyListView)super.clone();
	}
	
}


