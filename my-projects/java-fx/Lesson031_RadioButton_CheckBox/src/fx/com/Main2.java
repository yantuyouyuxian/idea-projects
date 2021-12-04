/**
 * 
 */
package fx.com;

import java.util.Iterator;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main2 extends Application{

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
		
		AnchorPane an=new AnchorPane();
		
		HBox hbox=new HBox(10);
		
		CheckBox cb1=new CheckBox("cb1");
		CheckBox cb2=new CheckBox("cb2");
		CheckBox cb3=new CheckBox("cb3");
		CheckBox cb4=new CheckBox("cb4");
		
		cb1.setSelected(true);
		cb2.setIndeterminate(true);
		cb3.setAllowIndeterminate(true);
		
		hbox.getChildren().addAll(cb1,cb2,cb3,cb4);
		
		an.getChildren().addAll(hbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		cb1.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				System.out.println("cb1 selected is "+newValue);
			}
		});
		
		an.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
//				Object[] obj=hbox.getChildren().toArray();
//				for(Object o:obj) {
//					System.out.println(((CheckBox)o).getText()+"的选择状态是 "+((CheckBox)o).isSelected()+"不确定状态是 "+((CheckBox)o).isIndeterminate());
//				}
				
//				Iterator<Node> it=hbox.getChildren().iterator();
//				while(it.hasNext()) {
//					CheckBox c=(CheckBox)it.next();
//					System.out.println(c.getText()+"的选择状态是 "+c.isSelected()+"不确定状态是 "+c.isIndeterminate());
//				}
				
//				hbox.getChildren().forEach(new Consumer<Node>() {
//
//					@Override
//					public void accept(Node t) {
//						// TODO Auto-generated method stub
//						CheckBox c=(CheckBox)t;
//						System.out.println(c.getText()+"的选择状态是 "+c.isSelected()+"不确定状态是 "+c.isIndeterminate());
//					}
//				});
				
				
				
				hbox.getChildren().forEach(item ->{
					CheckBox c=(CheckBox)item;
					System.out.println(c.getText()+"的选择状态是 "+c.isSelected()+"不确定状态是 "+c.isIndeterminate());
					
				});
				
			}
		});
		
	}

}
