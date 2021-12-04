package fx.com;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {

	private ReadOnlyStringWrapper name=new ReadOnlyStringWrapper();
	private SimpleDoubleProperty age=new SimpleDoubleProperty();
	private SimpleBooleanProperty is=new SimpleBooleanProperty();
	
	public Data(String name,double age,boolean is) {
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

	public double getAge() {
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

	
	
	public ReadOnlyStringProperty getNameProperty() {
		return name.getReadOnlyProperty();//Ö»¶Á
	}

	public SimpleDoubleProperty getAgeProperty() {
		return age;
	}

	

	public SimpleBooleanProperty getIsProperty() {
		return is;
	}

	
	
	
	
}
