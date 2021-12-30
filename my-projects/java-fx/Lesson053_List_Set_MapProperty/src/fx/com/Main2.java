package fx.com;

import java.util.Iterator;
import java.util.function.BiConsumer;

import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

public class Main2 {
	public static void main(String[] args) {
		
		ObservableSet <String> set=
				FXCollections.observableSet("A","B","C");
		
		
		SimpleSetProperty<String> ssp=
				new SimpleSetProperty<String>(set);
		
		ssp.addListener(new SetChangeListener<String>() {

			@Override
			public void onChanged(Change<? extends String> change) {
				// TODO Auto-generated method stub
				System.out.println("wasAdded()= "+change.wasAdded());
				
			}
		});
		
		ssp.add("D");
		
		
		//
		Iterator<String> it =ssp.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		//
//		ssp.forEach(System.out::println);
		
		
		ObservableMap<String, String> map=
				FXCollections.observableHashMap();
		
		map.put("1", "A");
		map.put("2", "B");
		
		SimpleMapProperty<String, String> smp=
				new SimpleMapProperty<String, String>(map);
		
		smp.addListener(new MapChangeListener<String, String>(){

			@Override
			public void onChanged(Change<? extends String, ? extends String> change) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		smp.forEach(new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				// TODO Auto-generated method stub
				System.out.println(t+" - "+u);
			}
		});
		
		
		
	}
}
