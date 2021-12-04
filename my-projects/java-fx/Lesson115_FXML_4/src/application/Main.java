package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import fx.coms.PersonBuilderMapFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		FXMLLoader fl=new FXMLLoader();
		fl.setLocation(fl.getClassLoader().getResource("fxml/Data1.fxml"));
		
//		fl.setBuilderFactory(new PersonBuilderFactory());
		//PersonBuilderFactory->PersonBuilder设置name和age实例化一个Person
		
		fl.setBuilderFactory(new PersonBuilderMapFactory());
		
		
//		Person person=(Person)fl.load();
//		System.out.println(person.getName()+" "+person.getAge());
		
		
//		ArrayList<Person> array=(ArrayList<Person>)fl.load();
//		array.forEach(item->{
//			System.out.println(item.getName()+" "+item.getAge());
//		});
		
		HashMap map=(HashMap)fl.load();
//		System.out.println(map);
		map.keySet().forEach(item->
			System.out.println(item+" "+map.get(item)));
		
		
		
		
//		Scene scene=new Scene(an);
//		
//		primaryStage.setScene(scene);
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
