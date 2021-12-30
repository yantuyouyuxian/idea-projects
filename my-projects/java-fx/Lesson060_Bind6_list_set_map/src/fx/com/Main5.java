package fx.com;

import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

public class Main5 {
	public static void main(String[] args) {
		
		ObservableSet<String> obsset1=
				FXCollections.observableSet("A","B");
		
		SimpleSetProperty<String> set1=
				new SimpleSetProperty<String>(obsset1);
		
		ObservableSet<String> obsset2=
				FXCollections.observableSet("C","D");
		
		SimpleSetProperty<String> set2=
				new SimpleSetProperty<String>(obsset2);
		
		
		System.out.println("set1="+set1.getValue()+"  set2="+set2.getValue());
		
		
//		set1.bind(set2);//同样也是都维护obsset2
//		set1.bindBidirectional(set2);//同上
//		set1.bindContent(set2);//各自维护，set2影响set1
		set1.bindContentBidirectional(set2);//
		System.out.println("set1="+set1.getValue()+"  set2="+set2.getValue());
		
		set1.add("E");
		
		set2.add("F");
		System.out.println("set1="+set1.getValue()+"  set2="+set2.getValue());
		System.out.println("obsset1="+obsset1+"  obsset2="+obsset2);
		
		System.out.println("--------------------------------------");
		
		
		ObservableMap<String, String> obsmap1=
				FXCollections.observableHashMap();
		SimpleMapProperty<String, String> map1=
				new SimpleMapProperty<String,String>(obsmap1);
		
		map1.put("A", "1");
		map1.put("B", "2");
		
		ObservableMap<String, String> obsmap2=
				FXCollections.observableHashMap();
		SimpleMapProperty<String, String> map2=
				new SimpleMapProperty<String,String>(obsmap2);
		
		map2.put("C", "1");
		map2.put("D", "2");
		System.out.println("map1="+map1.getValue()+"  map2="+map2.getValue());
		System.out.println("obsmap1="+obsmap1+"  obsmap2="+obsmap2);
		
		map1.bind(map2);//同上
		System.out.println("map1="+map1.getValue()+"  map2="+map2.getValue());
		System.out.println("obsmap1="+obsmap1+"  obsmap2="+obsmap2);
		
		map1.put("E", "3");
		map2.put("F", "3");
		System.out.println("map1="+map1.getValue()+"  map2="+map2.getValue());
		System.out.println("obsmap1="+obsmap1+"  obsmap2="+obsmap2);
		
	}
}
