/**
 * 
 */
package fx.com;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

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
		ObservableList<String> obslist = 
				FXCollections.observableArrayList();

		SimpleListProperty<String> list = 
				new SimpleListProperty<String>(obslist);

		list.addAll("A","B","C");
		int i=0;
		
		ObjectBinding<String> objbind=list.valueAt(i);
		
		System.out.println(objbind.get());
		
//		list.set(0, "F");
		i=2;
		objbind=list.valueAt(i);
		System.out.println(objbind.get());
		
		System.out.println("----------------");
		
//		SimpleIntegerProperty index=new SimpleIntegerProperty(2);
//		
//		ObjectBinding<String> obj=list.valueAt(index);
//		
//		System.out.println(obj.get());
//		
//		list.set(2, "T");
//		System.out.println(obj.get());
//		
//		index.set(1);
//		System.out.println(obj.get());
		System.out.println("-------------------------");
		ObservableMap<String, String> obsmap=
				FXCollections.observableHashMap();
		SimpleMapProperty<String, String> map=
				new SimpleMapProperty<String,String>(obsmap);
		
		map.put("A", "1");
		map.put("B", "2");
		
		ObjectBinding<String> objmap=map.valueAt("A");
		System.out.println(objmap.get());
		
		map.put("A", "R");
		System.out.println(objmap.get());
		
		
	}

}
