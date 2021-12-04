/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H 宽高，坐标和边界
 */
public class Main1 extends Application {

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
		AnchorPane an = new AnchorPane();

		// SimpleIntegerProperty sip=new SimpleIntegerProperty(5);
		//
		// sip.addListener(new ChangeListener<Number>() {
		//
		// @Override
		// public void changed(ObservableValue<? extends Number> observable, Number
		// oldValue, Number newValue) {
		// // TODO Auto-generated method stub
		// System.out.println(oldValue+" -> "+newValue);
		//
		// }
		// });
		// sip.set(9);

		// ReadOnlyDoubleWrapper rodw=new ReadOnlyDoubleWrapper(3);
		// ReadOnlyDoubleProperty rodp=rodw.getReadOnlyProperty();//只读
		//
		// System.out.println(rodw.get());
		// rodw.set(6);
		// System.out.println(rodw.get());

		Data data = new Data("a", 18);

		
		Data2 data2 = new Data2("D");
		
		data2.nameProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(oldValue+" -> "+newValue);
			}
		});

		Button b1 = new Button("button");
		
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				// data.setName("B");
				data2.setName("F");
				System.out.println(data2.getName());
			}
		});

		data.getSimpleStringPropertyName().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub

				SimpleStringProperty name = (SimpleStringProperty) observable;
				System.out.println(name.getName());

				System.out.println(observable.toString());

				System.out.println(name.getBean().toString());

				System.out.println(oldValue + " -> " + newValue);

			}
		});

		an.getChildren().add(b1);
		Scene scene = new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

	}

}

class Data {
	private SimpleIntegerProperty age = new SimpleIntegerProperty(this, "age");
	private SimpleStringProperty name = new SimpleStringProperty(this, "data_name");

	public Data(String name, int age) {
		this.name.set(name);
		this.age.set(age);
	}

	public SimpleIntegerProperty getSimpleIntegerPropertyAge() {
		return age;
	}

	public SimpleStringProperty getSimpleStringPropertyName() {
		return name;
	}

	public int getAge() {
		return this.age.get();
	}

	public String getName() {
		return this.name.get();
	}

	public void setAge(int age) {
		this.age.set(age);
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String toString() {
		return "data_toString()";
	}

}

class Data2 {

	private String name;

	private SimpleStringProperty namepro;

	public Data2(String name) {
		if (namepro == null) {
			this.name = name;
		} else {
			this.namepro.set(name);
		}

	}

	public StringProperty nameProperty() {
		if (namepro == null) {
			namepro = new SimpleStringProperty(this, "name", name);
		}
		return namepro;
	}

	public String getName() {
		if (namepro == null) {
			return this.name;
		} else {
			return this.namepro.get();
		}
	}

	public void setName(String name) {
		if (namepro == null) {
			this.name = name;
		} else {
			this.namepro.set(name);
		}

	}

}
