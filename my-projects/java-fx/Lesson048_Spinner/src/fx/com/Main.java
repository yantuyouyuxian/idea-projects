package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane an=new AnchorPane();
		
//		Spinner<Integer> spinner=new Spinner<Integer>(0,10,0,2);
		
//		ObservableList<String> list=FXCollections.observableArrayList();
//		list.addAll("A","B","C","D");
//		Spinner<String> spinner=new Spinner<String>(list);
//		spinner.setEditable(true);
//		spinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
//		spinner.valueProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue);
//			}
//		});
		
		Student s1=new Student("A", 21);
		Student s2=new Student("B", 20);
		Student s3=new Student("C", 19);
		ObservableList<Student> list=FXCollections.observableArrayList();
		list.addAll(s1,s2,s3);
		Spinner<Student> spinner =new Spinner<Student>();
//		SpinnerValueFactory.ListSpinnerValueFactory<Student> slvf=
//				new SpinnerValueFactory.ListSpinnerValueFactory<Student>(list);
//		
//		slvf.setConverter(new StringConverter<Student>() {
//			
//			@Override
//			public String toString(Student object) {
//				// TODO Auto-generated method stub
//				if(object==null) {
//					return "";
//				}
//				return object.getName()+" "+object.getAge();
//			}
//			
//			@Override
//			public Student fromString(String string) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
//		spinner.setValueFactory(slvf);
		
		spinner.setEditable(true);
		
		SVF svf=new SVF(list);
		
		svf.setValue(s1);
		svf.setConverter(new StringConverter<Student>() {
			
			@Override
			public String toString(Student object) {
				// TODO Auto-generated method stub
//				System.out.println(object.getName());
				if(object==null) {
					return "";
				}
				return object.getName()+" - "+object.getAge();
			}
			
			@Override
			public Student fromString(String string) {
				// TODO Auto-generated method stub
				System.out.println(string);
				
				Student s=new Student(string, 77);
				
				return s;
			}
		});
		spinner.setValueFactory(svf);
//		spinner.increment(3);
		
		
		an.getChildren().addAll(spinner);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
	}
}

class SVF extends SpinnerValueFactory<Student>{

	private int index=-1;
	private ObservableList<Student> list;
	public SVF(ObservableList<Student> list) {
		this.list=list;
	}
	@Override
	public void decrement(int steps) {
		System.out.println("decrement "+steps);
		if(index-steps<=-1) {
			index=list.size()-1;
		}else {
			index=index-1;
		}
		this.setValue(list.get(index));
	}

	@Override
	public void increment(int steps) {
		System.out.println("increment "+steps);
		if(index+steps>=list.size()) {
			index=0;
		}else {
			index=index+steps;
		}
		this.setValue(list.get(index));
	}
	
}

