/**
 * 
 */
package fx.com;

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
		SimpleIntegerProperty a=new SimpleIntegerProperty(10);
		
		SimpleIntegerProperty b=new SimpleIntegerProperty(1);
		
		
		System.out.println(a.greaterThan(b).get());
		System.out.println(a.lessThan(b).get());
		System.out.println(a.isEqualTo(b).get());
		
		System.out.println(a.isNotEqualTo(b).get());
		
		System.out.println(a.isEqualTo(10, 1).get());//和10比较，误差为1
		
		System.out.println(a.isNotEqualTo(8,1).get());
		
		System.out.println(a.greaterThanOrEqualTo(b).get());
		
		//。。。
		//比较判断
		
		
		
	}

}
