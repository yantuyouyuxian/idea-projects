/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Z H
 *TextArea
 */
public class Main1 extends Application{
	
	int i=1;

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
		
		TextArea ta=new TextArea();
		
//		ta.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		ta.setFont(Font.font(15));
//		ta.setWrapText(true);//自动换行
		ta.setPrefRowCount(10);
		ta.setPrefColumnCount(30);
		ta.setPrefWidth(500);
		ta.setPrefHeight(300);//宽高优先行列
//		ta.appendText("APPENDTEXT");
//		ta.deleteText(0, 2);
//		ta.insertText(0, "insert");
//		ta.replaceText(0, 1, "replace");
//		ta.selectAll();
//		ta.copy();
//		ta.selectForward();
//		ta.selectPositionCaret(10);
//		ta.selectRange(0, 1);
//		ta.positionCaret(3);//移动光标到指定位置
//		ta.home();
		
//		ta.selectEnd();
//		ta.selectHome();从光标位置选择到尾或头
//		ta.setEditable(false);
		
		
		
		
		an.getChildren().addAll(ta);
		an.setStyle("-fx-background-color:gray");
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
//		ta.textProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				// TODO Auto-generated method stub
//				if(newValue.length()>5) {
//					ta.setText(oldValue);
//				}
//			}
//		});
		
		
		
//		an.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				// TODO Auto-generated method stub
//				ta.setScrollLeft(i+=20);//滚动条移动到从左数20的位置
//				
//			}
//		});
		
		ta.scrollLeftProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
	}

}
