/**
 * 
 */
package fx.com;

import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
		int a=1;
		int b=2;
		int c= a>b ? 10 : 20;
		System.out.println(c+"\n");
		
		SimpleIntegerProperty x=new SimpleIntegerProperty(1);
		
		SimpleIntegerProperty y=new SimpleIntegerProperty(2);
		
		SimpleBooleanProperty boo=new SimpleBooleanProperty(true);
		
		When when=new When(x.greaterThan(y));
		
		NumberBinding n=when.then(10).otherwise(20);
		
		System.out.println(n.doubleValue());
		
		x.set(3);
		
		System.out.println(new When(x.greaterThan(y)).then(10).otherwise(20).doubleValue());
		
		System.out.println(new When(x.greaterThan(y)).then("A").otherwise("B").get());
		
		
		
		SimpleIntegerProperty e=new SimpleIntegerProperty(10);
		
		SimpleIntegerProperty f=new SimpleIntegerProperty(20);
		
		NumberBinding n2=new When(x.greaterThan(y)).then(e).otherwise(f);
		
		System.out.println(n2.doubleValue());
		
		
	}

}
