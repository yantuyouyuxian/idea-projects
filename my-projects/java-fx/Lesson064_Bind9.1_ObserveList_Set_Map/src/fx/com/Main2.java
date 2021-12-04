/**
 * 
 */
package fx.com;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 * @author Z H
 *
 */
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleStringProperty s1=new SimpleStringProperty("A");
		SimpleStringProperty s2=new SimpleStringProperty("B");
		
		ObservableList<SimpleStringProperty> list1 =
				FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {

					@Override
					public Observable[] call(SimpleStringProperty param) {
						// TODO Auto-generated method stub
						System.out.println("call1= "+param);
						Observable[] obsarray=new Observable[] {param};
						return obsarray;
					}

				});
		list1.addListener(new ListChangeListener<SimpleStringProperty>() {

			@Override
			public void onChanged(Change<? extends SimpleStringProperty> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println("onChanged1= "+c+"   wasUpdated= "+c.wasUpdated());
				}
			}
			
		});
		
		
		ObservableList<SimpleStringProperty> list2 = FXCollections.observableList(list1,
				new Callback<SimpleStringProperty, Observable[]>() {

					@Override
					public Observable[] call(SimpleStringProperty param) {
						// TODO Auto-generated method stub
						System.out.println("call2= "+param);
						Observable[] obsarray=new Observable[] {param};
						return obsarray;
					}
				});
		list2.addListener(new ListChangeListener<SimpleStringProperty>() {

			@Override
			public void onChanged(Change<? extends SimpleStringProperty> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println("onChanged2= "+c+"   wasUpdated= "+c.wasUpdated());
				}
			}
			
		});
//		list2.add(s1);
//		list2.add(s2);
		
		list1.add(s1);
		list2.add(s2);
		
		list1.forEach(item -> System.out.println("list1 :"+item.get()));
		
		list2.forEach(item -> System.out.println("list2 :"+item.get()));
		
//		s1.set("b");
//		list1.forEach(item -> System.out.println("list1 :"+item.get()));
//		
//		list2.forEach(item -> System.out.println("list2 :"+item.get()));
		
		
		
	}

}
