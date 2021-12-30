package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main1 extends Application{

	int index;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Button bu=new Button("ÐÞ¸ÄÃû³Æ");
		
		Student s1=new Student("A", 18, 90);
		Student s2=new Student("B", 19, 80);
		Student s3=new Student("C", 20, 70);
		Student s4=new Student("D", 21, 60);
		Student s5=new Student("E", 22, 50);
		
		AnchorPane an=new AnchorPane();
		
		ChoiceBox<Student> cb=new ChoiceBox<Student>();
		
		cb.getItems().addAll(s1,s2,s3,s4,s5);
		
		cb.setConverter(new StringConverter<Student>() {
			
			@Override
			public String toString(Student object) {
				// TODO Auto-generated method stub
				String value=object.getName()+" "+object.getAge()+" "+object.getScore();
				return value;
			}
			
			@Override
			public Student fromString(String string) {
				// TODO Auto-generated method stub
				System.out.println("fromString()");
				return null;
			}
		});
		
		cb.setPrefWidth(150);
		AnchorPane.setTopAnchor(cb, 100.0);
		
		an.getChildren().addAll(bu,cb);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				index =newValue.intValue();
			}
		});
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				int i=index;
				Student s=cb.getItems().get(i);
				cb.getItems().remove(i);
				s.setName("ÐÞ¸Ä");
				cb.getItems().add(i, s);
				
			}
		});
		
		
		
	}

}

