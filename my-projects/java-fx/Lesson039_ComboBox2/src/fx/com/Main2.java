/**
 * 
 */
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

/**
 * @author Z H
 *
 */
public class Main2 extends Application{

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
		
		Student s1=new Student("A", 18, 90);
		Student s2=new Student("B", 19, 80);
		Student s3=new Student("C", 20, 70);
		Student s4=new Student("D", 21, 60);
		Student s5=new Student("E", 22, 50);
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		
		ComboBox<Student> cbb=new ComboBox<Student>();
		
		cbb.getItems().addAll(s1,s2,s3,s4,s5);
		
		cbb.setEditable(true);
		
//		cbb.setPromptText("XXXX");
		
//		cbb.setPlaceholder(new Button("placeholder1"));//占位，为空时有效
		
		cbb.setVisibleRowCount(3);
		

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
				String value=object.getName()+" "+object.getAge()+" "+object.getScore();
				if(cbb.getItems().contains(object)==false) {
					cbb.getItems().add(object);
				}
				return value;
			}
			
			@Override
			public Student fromString(String string) {
				// TODO Auto-generated method stub
				if(string.equals("")) {
					return null;
				}
				
				System.out.println(string);
				
				Student s=new Student(string, 0, 0);
				
				return s;
			}
		});
		
		cbb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.intValue());
			}
		});
		
		cbb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {

			@Override
			public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.getName());
			}
		});
		
		cbb.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("setOnAction()");
			}
		});
		
	}

}
