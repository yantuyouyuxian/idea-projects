package application;
	
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Locale locale=Locale.getDefault();
		System.out.println("language: "+locale.getLanguage()+" country:"+locale.getCountry());
		
//		Locale.setDefault(new Locale("en","us"));
		
//		if(locale.getLanguage().equals("zh")) {
//			Locale.setDefault(new Locale("zh...", "cn"));
//		}//找不到配置文件时
		
		FXMLLoader fl=new FXMLLoader();
		URL url=fl.getClassLoader().getResource("fxml/main1.fxml");
		fl.setLocation(url);
		
		ResourceBundle rb=ResourceBundle.getBundle("fxml/language");
		fl.setResources(rb);
		
		AnchorPane an=(AnchorPane)fl.load();

		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
