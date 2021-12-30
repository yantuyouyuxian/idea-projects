/**
 * 
 */
package fx.com;

import java.util.Locale;
import java.util.concurrent.Callable;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

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
		SimpleIntegerProperty value =
				new SimpleIntegerProperty(10);
		StringExpression string1=
				Bindings.concat("value= ",value.asString(Locale.getDefault(),"%s"));//Æ´½Ó
		System.out.println("string1= "+string1.get());
		
		StringExpression string2=
				Bindings.format("value= %s", value);
		System.out.println("string2= "+string2.get());
		
		value.set(20);
		System.out.println("string1= "+string1.get()+" string2= "+string2.get());
		
		System.out.println("----------------");
		
		SimpleIntegerProperty x=new SimpleIntegerProperty(1);
		SimpleIntegerProperty y=new SimpleIntegerProperty(2);
		System.out.println(Bindings.max(x, y).intValue());
		
		System.out.println("---------");
		
		
		SimpleIntegerProperty a=new SimpleIntegerProperty(1);
		SimpleIntegerProperty b=new SimpleIntegerProperty(2);
		///
		StringBinding stringbind=Bindings.createStringBinding(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
//				System.out.println("call()");
				String value="hello";
				if(a.get()==1) {
					value="A";
				}else if(a.get()==2) {
					value="B";
				}
				
				return value;
			}
		}, a); 
		
		System.out.println(stringbind.get());
		System.out.println(a.get());
		
		a.set(2);
		System.out.println(stringbind.get());
		System.out.println(a.get());
		
		a.set(3);
		System.out.println(stringbind.get());
		System.out.println(a.get());
		
		System.out.println("-------------------------");
		
		Student student =new Student("A");
		SimpleObjectProperty<Student> stu=
				new SimpleObjectProperty<Student>(student);
		
		StringBinding strvalue=Bindings.selectString(stu, "stuname","name");
		
		System.out.println(strvalue.get());
		
		student.setName("B");
		System.out.println(strvalue.get());
		
		System.out.println("------------------");
		
		System.out.println(Bindings.convert(new SimpleIntegerProperty(100)).get());
		//×ª³É×Ö·û´®
		
	}

}
