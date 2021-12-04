package fx.com;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {

	private SimpleStringProperty name=new SimpleStringProperty();
	private SimpleIntegerProperty age=new SimpleIntegerProperty();
	private SimpleBooleanProperty is=new SimpleBooleanProperty();
	
	public Data(String name,int age,boolean is) {
		this.name.set(name);
		this.age.set(age);
		this.is.set(is);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int age) {
		this.age.set(age);;
	}



	public boolean getIs() {
		return is.get();
	}

	public void setIs(boolean is) {
		this.is.set(is);;
	}

	
	
	public SimpleStringProperty getNameProperty() {
		return name;
	}

	public SimpleIntegerProperty getAgeProperty() {
		return age;
	}

	

	public SimpleBooleanProperty getIsProperty() {
		return is;
	}

	
	
	
	
}
