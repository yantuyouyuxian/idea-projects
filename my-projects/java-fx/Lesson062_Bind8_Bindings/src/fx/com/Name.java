package fx.com;

import javafx.beans.property.SimpleStringProperty;

public class Name {
	private SimpleStringProperty name=
			new SimpleStringProperty();

	public SimpleStringProperty nameProperty() {
		System.out.println("Name");
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	
}
