package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main2App extends Application{
	
	int index;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Student s1=new Student("A", 18, 90);
		Student s2=new Student("B", 19, 80);
		Student s3=new Student("C", 20, 70);
		Student s4=new Student("D", 21, 60);
		Student s5=new Student("E", 22, 50);
		
		Button bu=new Button("ÐÞ¸ÄÃû³Æ");
		
		AnchorPane an=new AnchorPane();
		
		ComboBox<Student> cbb=new ComboBox<Student>();
		
		cbb.getItems().addAll(s1,s2,s3,s4,s5);
		

		an.getChildren().addAll(bu,cbb);
		
		AnchorPane.setTopAnchor(cbb, 50.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		cbb.setConverter(new StringConverter<Student>() {
			
			@Override
			public String toString(Student object) {
				// TODO Auto-generated method stub
				if(object==null) {
					return "null";
				}
				return object.getName()+" "+object.getAge()+" "+object.getScore();
			}
			
			@Override
			public Student fromString(String string) {
				// TODO Auto-generated method stub
				System.out.println(string);
				return null;
			}
		});
		
		
		
		cbb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				index=newValue.intValue();
			}
		});
		
		
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				int i=index;
				cbb.getItems().get(index).setName("ÐÞ¸Ä");
				cbb.getSelectionModel().clearSelection();
				cbb.getSelectionModel().select(i);
			}
		});
		
	}
	
}
