/**
 * 
 */
package fx.com;

import java.util.function.Predicate;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * @author Z H
 *
 */
public class Main3 extends Application{
	ObservableList<Student> obs;
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
		
		Student s1=new Student("1A", 18, 90);
		Student s2=new Student("1B", 19, 80);
		Student s3=new Student("1A", 20, 70);
		Student s4=new Student("1D", 21, 60);
		Student s5=new Student("1E", 22, 50);
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		
		ComboBox<Student> cbb=new ComboBox<Student>();
		
		cbb.getItems().addAll(s1,s2,s3,s4,s5);
		
		obs=cbb.getItems();
		
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
				
				return value;
			}
			
			@Override
			public Student fromString(String string) {
				// TODO Auto-generated method stub
				return null;
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
		
		TextField tf=cbb.editorProperty().get();
		
		tf.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
				if(newValue==null) {
					cbb.setItems(null);
					cbb.setPlaceholder(new Label("NO"));
					cbb.hide();
					cbb.show();
					return;
				}
				
				FilteredList<Student> newlist=obs.filtered(new Predicate<Student>() {
					
					@Override
					public boolean test(Student t) {
						// TODO Auto-generated method stub
						
						return t.getName().contains(newValue);
					}
				});
				if(newlist.isEmpty()) {
					cbb.setItems(null);
					cbb.setPlaceholder(new Label("NO"));
					cbb.hide();
					cbb.show();
				}else {
					cbb.setItems(newlist);
					cbb.hide();
					cbb.show();
				}
			}
		});
	}

}
