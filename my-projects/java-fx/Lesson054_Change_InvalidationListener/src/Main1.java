import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;

/**
 * 
 */

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
				new SimpleIntegerProperty(1);
		
		Change change=new Change();
		
		WeakChangeListener<Number> weak=
				new WeakChangeListener<Number>(change);
		
		sip.addListener(weak);
		
		Inva inva =new Inva();
		sip.addListener(inva);//changelistener会调用该监听
//		sip.removeListener(inva);
		sip.set(2);//sip.get();
		
		sip.set(3);//sip.get();
		
		sip.set(4);//sip.get();
	
	}
}

class Inva implements InvalidationListener{

	@Override
	public void invalidated(Observable observable) {
		// TODO Auto-generated method stub
		System.out.println("Invalitation");
//		System.out.println(observable);
	}
	
}
class Change implements ChangeListener<Number>{
	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		// TODO Auto-generated method stub
		System.out.println("Change");
	}
}
