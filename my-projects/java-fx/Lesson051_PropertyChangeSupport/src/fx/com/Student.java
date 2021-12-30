package fx.com;

import java.beans.PropertyChangeSupport;

public class Student{
	private String name;
	private int age;
	
	public PropertyChangeSupport pcs=new PropertyChangeSupport(this);
	
	public Student(String name,int age) {
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		pcs.firePropertyChange("setName_pro", this.name	, name);
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		pcs.firePropertyChange("setAge_pro", this.age	, age);
		this.age = age;
	}
}

