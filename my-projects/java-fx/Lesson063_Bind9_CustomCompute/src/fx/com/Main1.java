/**
 * 
 */
package fx.com;

import javafx.beans.binding.IntegerBinding;
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
		SimpleIntegerProperty sip=
				new SimpleIntegerProperty(10);
		
		MyIntegerBinding myib=new MyIntegerBinding(15);
		
		System.out.println(myib.get());
		
		sip.bind(myib);
		System.out.println("sip= "+sip.getValue());
		System.out.println("myib= "+myib.getValue());
		
		myib.setValue(20);
		System.out.println("sip= "+sip.getValue());
		System.out.println("myib= "+myib.getValue());
	}

}

class MyIntegerBinding extends IntegerBinding{

	private SimpleIntegerProperty x=
			new SimpleIntegerProperty();
	
	public  MyIntegerBinding(int value) {
		this.bind(x);
		x.set(value);
	}
	
	@Override
	protected int computeValue() {
		// TODO Auto-generated method stub
		int b=x.get()*2;
		return b;
	}
	
	public void setValue(int value) {
		x.set(value);
	}
	
}