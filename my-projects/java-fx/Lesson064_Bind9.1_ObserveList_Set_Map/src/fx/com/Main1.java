/**
 * 
 */
package fx.com;

import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

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
//		ObservableList<String> list= 
//				FXCollections.observableArrayList();
		
//		list.addAll("a","b","c");
//		
//		FXCollections.rotate(list, 1);
//		
//		list.forEach(System.out::println);
		
//		System.out.println(list);
		
		SimpleStringProperty s1=new SimpleStringProperty("A");
		SimpleStringProperty s2=new SimpleStringProperty("B");
		ObservableList<SimpleStringProperty> list =

				FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {

					@Override
					public Observable[] call(SimpleStringProperty param) {
						// TODO Auto-generated method stub
						System.out.println("call= "+param);
						Observable[] obsarray=new Observable[] {param};
//						Observable[] obsarray=new Observable[] {new SimpleStringProperty("d")};
						return obsarray;
					}

				});
		list.addListener(new ListChangeListener<SimpleStringProperty>() {

			@Override
			public void onChanged(Change<? extends SimpleStringProperty> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println("onChanged= "+c+"   wasUpdated= "+c.wasUpdated());
				}
			}
			
		});
		list.add(s1);
//		list.add(s2);
//		list.add(s1);
		
		s1.set("C");
		
//		System.out.println(list.get(0).get());
//		list.forEach(System.out::println);
		System.out.println("--------------------------");
		
//		ObservableList<SimpleStringProperty> list2=
//				FXCollections.observableArrayList();
		
		ObservableList<SimpleStringProperty> list2 =

				FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {

					@Override
					public Observable[] call(SimpleStringProperty param) {
						// TODO Auto-generated method stub
						System.out.println("call= "+param);
						Observable[] obsarray=new Observable[] {param};
						return obsarray;
					}

				});
		
		SimpleListProperty<SimpleStringProperty> slp=
				new SimpleListProperty<>(list2);
		
		SimpleStringProperty s3=new SimpleStringProperty("C");
		slp.addListener(new ListChangeListener<SimpleStringProperty>() {

			@Override
			public void onChanged(Change<? extends SimpleStringProperty> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					System.out.println("onChanged= "+c+"   wasUpdated= "+c.wasUpdated());
				}
				
			}});
		slp.add(s3);
		s3.set("D");
		
		
		
	}

}
