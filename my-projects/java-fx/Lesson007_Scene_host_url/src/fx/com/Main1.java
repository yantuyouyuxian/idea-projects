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
 *node�Ǵ󲿷��������
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
		host.showDocument("www.baidu.com");//ʹ��Ĭ���������һ��url
		
		
		URL url=getClass().getClassLoader().getResource("images/icon.png");
		String path=url.toExternalForm();//������Դ
		
		Button button=new Button("OK");
		button.setPrefHeight(60);
		button.setPrefWidth(100);
		button.setCursor(Cursor.MOVE);
		
		Group group=new Group();
		group.getChildren().add(button);//�����������node
		
		Scene scene=new Scene(group);//Ӧ�ý����ڵ���Ϊ��������scene��һ�����֣�
		
		scene.setCursor(Cursor.cursor(path));
		
		
		primaryStage.setScene(scene);//����stage��scene
		
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		
		primaryStage.show();
	}

}
