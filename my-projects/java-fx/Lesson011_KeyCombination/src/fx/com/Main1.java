/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.stage.Stage;

/**
 * @author Z H
 *设置快捷键
 */
public class Main1 extends Application {

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

		Button b1 = new Button("b1");

		b1.setPrefHeight(60);
		b1.setPrefWidth(100);

		b1.setLayoutX(100);
		b1.setLayoutY(100);

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("setOnAction");
				play();
			}
		});

		

		Group group = new Group();
		
		group.getChildren().add(b1);

		Scene scene = new Scene(group);
		
		//first//
		KeyCombination kc1=new KeyCodeCombination(KeyCode.C,KeyCombination.ALT_DOWN,KeyCombination.CONTROL_DOWN);
		Mnemonic mnemonic1=new Mnemonic(b1, kc1);
		scene.addMnemonic(mnemonic1);//mnemonic:助记的
		
		//second
		KeyCombination kc2=new KeyCharacterCombination("O",KeyCombination.ALT_DOWN);
		Mnemonic mnemonic2=new Mnemonic(b1, kc2);
		scene.addMnemonic(mnemonic2);//mnemonic:助记的
		
		//third
		KeyCombination kc3=new KeyCodeCombination(KeyCode.K,KeyCombination.SHIFT_DOWN,KeyCombination.CONTROL_DOWN,KeyCombination.ALT_DOWN,KeyCombination.META_DOWN,KeyCombination.SHORTCUT_DOWN);
		Mnemonic mnemonic3=new Mnemonic(b1, kc3);
		scene.addMnemonic(mnemonic3);//mnemonic:助记的

		//forth//
		KeyCombination kcb=new KeyCodeCombination(KeyCode.Y, KeyCombination.SHORTCUT_DOWN);//windows上SHORTCUT就是CTRL
		scene.getAccelerators().put(kcb, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("forth run "+Thread.currentThread().getName());
				play();
				//b1.fire();
			}});
		
		//fifth//
		KeyCombination kc5= KeyCombination.valueOf("alt+b");
		Mnemonic mnemonic5=new Mnemonic(b1, kc5);
		scene.addMnemonic(mnemonic5);//mnemonic:助记的
		
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}
	
	public static void play() {
		System.out.println("play");
	}

}
