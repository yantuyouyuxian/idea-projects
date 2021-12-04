package fx.coms;

import java.util.HashMap;

import application.Person;
import javafx.util.Builder;

public class PersonBuilderMap extends HashMap<String, Object> implements Builder<Person>{

	private String name;
	
	private int age;
	
	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		if("name".equals(key)) {
			this.name=String.valueOf(value);
		}else if("age".equals(key)) {
			this.age=Integer.valueOf(String.valueOf(value));
		}
		return null;
	}
	
	@Override
	public Person build() {
		// TODO Auto-generated method stub
		return new Person(name,age);
	}

}
