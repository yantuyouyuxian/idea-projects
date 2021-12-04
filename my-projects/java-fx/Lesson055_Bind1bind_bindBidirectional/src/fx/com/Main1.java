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
		SimpleIntegerProperty x=new SimpleIntegerProperty(1);
		
		SimpleIntegerProperty y=new SimpleIntegerProperty(5);
		
		x.bind(y);//x随y改变，x不能自己设置值
		
//		x.isBound()==true;y.isBound()==false
//		x.unbind();
		
		System.out.println("x="+x.get()+"  y="+y.get());
		
		SimpleIntegerProperty a=new SimpleIntegerProperty(3);
		
		SimpleIntegerProperty b=new SimpleIntegerProperty(6);
		
//		a.bindBidirectional(b);
		b.bindBidirectional(a);
		
//		a,b.isBound()==false;
		
		System.out.println("a="+a.get()+"  b="+b.get());
		
		
	}

}
