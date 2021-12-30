/**
 * 
 */
package fx.com;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author Z H
 *
 */
public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student("A", 18);
		
		SimpleIntegerProperty a=new SimpleIntegerProperty(5);
		
		SimpleIntegerProperty b=new SimpleIntegerProperty(stu, "name", 10);
	
		IntegerExpression n=SimpleIntegerProperty.integerExpression(b);
		
		SimpleIntegerProperty sip=(SimpleIntegerProperty)n;
		
		b.set(12);
		
		System.out.println(n.get());
		
		System.out.println(sip.getName());
		
		ObjectProperty<Integer> objectProperty =
				new SimpleObjectProperty<>(2);
		System.out.println(IntegerExpression.integerExpression(objectProperty).get());
		
		SimpleIntegerProperty.readOnlyIntegerProperty(b);
		
		System.out.println("----------------");
		
		SimpleBooleanProperty b1=new SimpleBooleanProperty(true);
		
		SimpleBooleanProperty b2=new SimpleBooleanProperty(false);
		
		System.out.println(b1.and(b2).get());
		
		System.out.println(b1.or(b2).get());
		
		System.out.println(b1.not().get());
		
		System.out.println(b1.isEqualTo(b2).get());
		
		System.out.println("-----------------");
		
		
		SimpleStringProperty ssp1=new SimpleStringProperty("A");
		
		SimpleStringProperty ssp2=new SimpleStringProperty("B");
		
		System.out.println(ssp2.greaterThan(ssp1).get());
		
		
	}

}
class Student{
	
	private String name;
	private int age;
	
	public Student(String name,int age) {
		this.setName(name);
		this.setAge(age);
	}

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
}