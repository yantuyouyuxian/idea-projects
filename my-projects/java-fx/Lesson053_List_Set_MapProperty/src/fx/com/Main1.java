/**
 * 
 */
package fx.com;

import java.util.Comparator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		ObservableList<String> list=
				FXCollections.observableArrayList();
		list.add("A");
		list.add("B");
		list.add("C");
		
		SimpleListProperty<String> slp=
				new SimpleListProperty<String>(list);
		
//		slp.addListener(new ChangeListener<ObservableList<String>>() {
//
//			@Override
//			public void changed(ObservableValue<? extends ObservableList<String>> observable,
//					ObservableList<String> oldValue, ObservableList<String> newValue) {
//				// TODO Auto-generated method stub
//				oldValue.forEach(System.out::println);
//				System.out.println("-------old");
//				newValue.forEach(System.out::println);
//				System.out.println("-------new");
//				//两个一样
//			}
//		});
		
		
		slp.addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(Change<? extends String> c) {
				// TODO Auto-generated method stub
				System.out.println(c);
				c.getList().forEach(System.out::println);
				while(c.next()) {
//					c.reset();//恢复c的索引
					System.out.println(c.getFrom()+" -> "+c.getTo());
					System.out.println("wasAdded= "+c.wasAdded());
					System.out.println("wasRemoved= "+c.wasRemoved());
					System.out.println("wasReplaced= "+c.wasReplaced());
					System.out.println("wasPermutated= "+c.wasPermutated());
//					System.out.println("wasUpdated= "+c.wasUpdated());
					
					System.out.println("AddedSubList= "+c.getAddedSubList());
					System.out.println("removed= "+c.getRemovedSize());
					System.out.println(c.getPermutation(0));
					
				}
			}
			
		});
		
//		slp.addAll("D","E","X");
//		slp.remove(0);
//		slp.set(0, "F");
//		slp.remove(0, 1);
		
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});//permutated=true;slp为false
		
		Platform.exit();
	}

}
