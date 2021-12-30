/**
 * 
 */
package fx.com;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
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
		
		SimpleIntegerProperty a=new SimpleIntegerProperty(5);
	
		SimpleIntegerProperty b=new SimpleIntegerProperty(1);
		
		IntegerBinding ib=a.add(6);//产生一个新的值，a不变
		System.out.println("ib= "+ib.get()+"  a="+a.get());
		
		NumberBinding nb=a.add(b);
//		System.out.println("nb= "+nb.intValue());
//		
//		System.out.println(a.subtract(1).get());
//		
//		System.out.println(a.divide(2.0).get());
//		
//		System.out.println(a.multiply(2).get());
		
		System.out.println("--------------------------------------");
	
		a.set(10);//ib,
		b.set(8);
		
		System.out.println("ib= "+ib.get()+
				"  nb="+nb.intValue());
		
		System.out.println("------------------------------");
	
		
		SimpleIntegerProperty x=new SimpleIntegerProperty(5);
		
		System.out.println(x.negate().get());
		//boolean没有上面的取反操作，用！
		
		
		
	}

}
