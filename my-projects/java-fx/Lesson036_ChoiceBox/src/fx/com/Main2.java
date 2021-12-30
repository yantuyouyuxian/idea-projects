package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main2 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
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
		
		an.getChildren().addAll(cb);
		
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
				System.out.println(newValue.getName());
			}
		});
		
	}

}

class Student{
	private String name;
	private int age;
	private double score;
	
	public Student(String name,int age,double score) {
		this.setName(name);
		this.setAge(age);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}

