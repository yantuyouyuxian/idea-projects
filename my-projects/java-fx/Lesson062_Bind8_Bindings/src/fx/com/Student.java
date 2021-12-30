package fx.com;

import javafx.beans.property.SimpleObjectProperty;

public class Student {
	private Name name=new Name();
	private SimpleObjectProperty<Name> stuname=
			new SimpleObjectProperty<Name>();

	public SimpleObjectProperty<Name> stunameProperty() {
		System.out.println("student");
		return stuname;
	}
	
	public Student(String name) {
		this.name.setName(name);
		this.stuname.set((this.name));
	}
	
	public void setName(String name) {
		this.name.setName(name);
//		this.stuname.set((this.name));
	}
}
