package application;
	
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
//		Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
//		Application.setUserAgentStylesheet(STYLESHEET_MODENA);//д╛хо
		
		
		FXMLLoader fl=new FXMLLoader();
		URL url=fl.getClassLoader().getResource("fxml/main1.fxml");
		fl.setLocation(url);
		VBox vbox=(VBox)fl.load();
		
		AnchorPane an=getView();
		an.setId("root");
//		an.setStyle("-fx-background-color:yellow;"+
//					"-fx-border-color:blue;"+
//					"-fx-border-width:5 10 15 20;"
//					);
//		an.setStyle("-fx-background-color:linear-gradient(to bottom right,red,black)");
//		an.setStyle("-fx-background-image:url(file:E:/3.png)");
//		an.setStyle("-fx-background-image:url(https://i1.hdslb.com/bfs/face/d39f98a4e958b0fa6ec6e940563a3b01eb5ce443.jpg)");
		
		an.getChildren().add(vbox);
		AnchorPane.setTopAnchor(vbox, 50.0);
		AnchorPane.setLeftAnchor(vbox, 350.0);
		
		Scene scene=new Scene(an);
		
		URL cssurl=this.getClass().getClassLoader().getResource("css/mycss.css");
		scene.getStylesheets().add(cssurl.toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}
	
	public AnchorPane getView() {
		Button bu=new Button("button");
//		bu.setId(value);
		bu.getStyleClass().add("my_css");
		Label label=new Label("label");
		TextField tf=new TextField("textfield");
		
		AnchorPane an=new AnchorPane();
		
		an.getChildren().addAll(bu,label,tf);
		AnchorPane.setTopAnchor(bu, 50.0);
		AnchorPane.setTopAnchor(label, 100.0);
		AnchorPane.setTopAnchor(tf, 150.0);
		
		AnchorPane.setLeftAnchor(bu, 50.0);
		AnchorPane.setLeftAnchor(label, 50.0);
		AnchorPane.setLeftAnchor(tf, 50.0);
		
		return an;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
