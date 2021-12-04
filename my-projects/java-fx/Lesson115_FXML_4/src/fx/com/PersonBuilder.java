package fx.com;

import application.Person;
import javafx.util.Builder;

public class PersonBuilder implements Builder<Person>{

	private String name;
	
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public Person build() {
		// TODO Auto-generated method stub
		
		return new Person(name,age);
	}

}
