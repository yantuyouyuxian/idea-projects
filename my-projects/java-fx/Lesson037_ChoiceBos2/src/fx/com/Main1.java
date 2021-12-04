package fx.com;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main1 extends Application{
	
	public Student changeStudent;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		TextField tf=new TextField();
		Button bu=new Button("ÐÞ¸ÄÃû×Ö");
		
		Student s1=new Student("A", 18, 90);
		Student s2=new Student("B", 19, 80);
		Student s3=new Student("C", 20, 70);
		Student s4=new Student("D", 21, 60);
		Student s5=new Student("E", 22, 50);
		
//		changeStudent=s1;
		
		AnchorPane an=new AnchorPane();
		
		ChoiceBox<Student> cb=new ChoiceBox<Student>();
		
		cb.getItems().addAll(s1,s2,s3,s4,s5);
		
		cb.setConverter(new StringConverter<Student>() {
			
			@Override
			public String toString(Student object) {
				// TODO Auto-generated method stub
				String value=object.getName()+" "+object.getAge()+" "+object.getScore();
				System.out.println("toString()");
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
		AnchorPane.setLeftAnchor(bu, 200.0);
		
		an.getChildren().addAll(cb,tf,bu);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {

			@Override
			public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
				// TODO Auto-generated method stub
//				System.out.println(newValue.getName());
				changeStudent=newValue;
				changeStudent.getNameSimpleStringProperty().addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
						// TODO Auto-generated method stub
						int index=cb.getItems().indexOf(changeStudent);
//						
						cb.getItems().remove(changeStudent);
						
						cb.getItems().add(index, changeStudent);
						
						System.out.println("changestudentlistener");
						
					}
				});
			}
		});
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				int index=cb.getItems().indexOf(changeStudent);
//				
//				cb.getItems().remove(changeStudent);
//				
//				changeStudent.setName(tf.getText());
//				
//				cb.getItems().add(index, changeStudent);
				
				changeStudent.setName(tf.getText());
				System.out.println("setOnAction()");
			}
		});
		
		
		
	}

}

class Student{
	
	private SimpleStringProperty name=new SimpleStringProperty();
	
	private SimpleIntegerProperty age=new SimpleIntegerProperty();
	
	private SimpleDoubleProperty score=new SimpleDoubleProperty();
	
	public Student(String name,int age,double score) {
		this.name.setValue(name);
		this.age.setValue(age);
		this.score.setValue(score);
	}

	public String getName() {
		return name.getValue();
	}

	public void setName(String name) {
		this.name.setValue(name);;
	}

	public int getAge() {
		return age.getValue();
	}

	public void setAge(int age) {
		this.age.setValue(age);;
	}

	public double getScore() {
		return score.getValue();
	}

	public void setScore(double score) {
		this.score.setValue(score);;
	}
	
	public SimpleStringProperty getNameSimpleStringProperty() {
		return name;
	}
	
	
	
}

