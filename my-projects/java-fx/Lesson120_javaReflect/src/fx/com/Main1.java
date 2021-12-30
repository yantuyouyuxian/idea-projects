/**
 * 
 */
package fx.com;

import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
		
		Node node=new Button("button");
		
		String name=node.getClass().getName();
		System.out.println(name);
		
		Class<?> classtype=Class.forName(name);//ªÚ’ﬂButton.class;
		System.out.println(classtype);
//		Node node2=(Node)classtype.getConstructor(new Class[] {String.class}).newInstance("button2");
		Node node2=(Node)classtype.getConstructor(null).newInstance(null);
		
		Method method=classtype.getMethod("setText", new Class[] {String.class});
		method.invoke(node2, new Object[] {"Button2"});
		
		
		HBox hbox=new HBox(20);
		hbox.getChildren().addAll(node,node2);
		
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(hbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
