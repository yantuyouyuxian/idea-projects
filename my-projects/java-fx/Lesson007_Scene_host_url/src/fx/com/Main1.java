/**
 * 
 */
package fx.com;

import java.net.URL;

import javax.swing.text.GapContent;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Z H
 *Stage>Scene>Node
 *node是大部分组件父类
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
		
		HostServices host=getHostServices();
		host.showDocument("www.baidu.com");//使用默认浏览器打开一个url
		
		
		URL url=getClass().getClassLoader().getResource("images/icon.png");
		String path=url.toExternalForm();//加载资源
		
		Button button=new Button("OK");
		button.setPrefHeight(60);
		button.setPrefWidth(100);
		button.setCursor(Cursor.MOVE);
		
		Group group=new Group();
		group.getChildren().add(button);//布局里再添加node
		
		Scene scene=new Scene(group);//应该将根节点作为参数传给scene（一个布局）
		
		scene.setCursor(Cursor.cursor(path));
		
		
		primaryStage.setScene(scene);//关联stage和scene
		
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		
		primaryStage.show();
	}

}
