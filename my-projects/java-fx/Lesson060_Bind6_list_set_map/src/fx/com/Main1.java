/**
 * 
 */
package fx.com;

import java.util.Comparator;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
		ObservableList<String> obslist1 = FXCollections.observableArrayList();

		SimpleListProperty<String> list1 = new SimpleListProperty<String>(obslist1);

		list1.addAll("A","B");
		
		ObservableList<String> obslist2 = FXCollections.observableArrayList();

		SimpleListProperty<String> list2 = new SimpleListProperty<String>(obslist2);
		
		list2.addAll("C","D");
		
		System.out.println("list1="+list1.getValue());
		
		System.out.println("list2="+list2.getValue());
		
		System.out.println("---------");
		
		list1.bind(list2);//list1Î¬»¤obslist2
		
		System.out.println("list1="+list1.getValue());
		
		System.out.println("list2="+list2.getValue());
		
		System.out.println("---------");
		
		list1.add("E");
		
		list2.add("F");
		
		System.out.println("list1=" + list1.getValue());

		System.out.println("list2=" + list2.getValue());

		System.out.println("---------");
		
		System.out.println("obslist1="+obslist1+"  "+"obslist2="+obslist2);
	
//		list1.sort((item1,item2) -> item2.compareTo(item1));
		list1.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
		System.out.println("list1=" + list1.getValue());

		System.out.println("list2=" + list2.getValue());
		
		System.out.println("obslist1="+obslist1+"  "+"obslist2="+obslist2);
	}

}
