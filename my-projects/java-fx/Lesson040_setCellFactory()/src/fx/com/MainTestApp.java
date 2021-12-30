package fx.com;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainTestApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
	
		AnchorPane an=new AnchorPane();
		
		Label lab1=new Label();
		
		HBox hbox1=new HBox(10);
		hbox1.setMaxWidth(150);
		hbox1.setMaxHeight(100);
		hbox1.setStyle("-fx-background-color:yellow");
		hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(new Button("b1"),new Button("b2"));
		
//		lab1.setText("lab1");
		lab1.setGraphic(hbox1);//
		lab1.setContentDisplay(ContentDisplay.CENTER);
		lab1.setStyle("-fx-background-color:red");
		lab1.setPrefWidth(300);
		lab1.setPrefHeight(200);
		lab1.setAlignment(Pos.CENTER);
		
		
		HBox hbox2=new HBox(10);
		hbox2.setMaxWidth(150);
		hbox2.setMaxHeight(100);
		hbox2.setStyle("-fx-background-color:green");
		hbox2.setAlignment(Pos.CENTER);
		hbox2.getChildren().addAll(new Button("b3"),new Button("b4"));
		
		ListCell<String> listcell=new ListCell<String>();
		listcell.setContentDisplay(ContentDisplay.CENTER);
		listcell.setStyle("-fx-background-color:blue");
		listcell.setPrefWidth(300);
		listcell.setPrefHeight(200);
		listcell.setAlignment(Pos.CENTER);
		listcell.setGraphic(hbox2);//
		
		MyListCell<String> mlc=new MyListCell<String>();
		
		mlc.updateItem("mlc", true);
		
		AnchorPane.setTopAnchor(lab1, 100.0);
		AnchorPane.setLeftAnchor(lab1, 50.0);
		
		AnchorPane.setTopAnchor(listcell, 100.0);
		AnchorPane.setLeftAnchor(listcell, 450.0);
		
		AnchorPane.setTopAnchor(mlc, 100.0);
		AnchorPane.setLeftAnchor(mlc, 850.0);

		an.getChildren().addAll(lab1,listcell,mlc);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1200);
		primaryStage.show();
	
	}

}

class MyListCell<T> extends ListCell<String>{

	@Override
	protected void updateItem(String item, boolean empty) {
		// TODO Auto-generated method stub
		super.updateItem(item, empty);
		HBox hbox2=new HBox(10);
		hbox2.setMaxWidth(150);
		hbox2.setMaxHeight(100);
		hbox2.setStyle("-fx-background-color:gray");
		hbox2.setAlignment(Pos.CENTER);
		hbox2.getChildren().addAll(new Button(item),new Button(item));
	
		this.setContentDisplay(ContentDisplay.CENTER);
		this.setStyle("-fx-background-color:pink");
		this.setPrefWidth(300);
		this.setPrefHeight(200);
		this.setAlignment(Pos.CENTER);
		this.setGraphic(hbox2);//
	}

	
	
}
