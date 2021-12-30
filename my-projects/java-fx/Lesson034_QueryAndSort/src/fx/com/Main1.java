/**
 * 
 */
package fx.com;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	/**
	 * @param args
	 */
	
	int index=0;
	
	String substr="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		AnchorPane an=new AnchorPane();
		
		TextField tf=new TextField();
		Button bfind=new Button("查询");
		Button bsort=new Button("排序");
		HBox hbox=new HBox(10);
		
		hbox.getChildren().addAll(tf,bfind,bsort);
		hbox.setAlignment(Pos.CENTER);
		
		TextArea ta=new TextArea();
		ta.setText("dcbalasjdofnvlzxjfoiewroinfosajfs");
		ta.setWrapText(true);
		
		VBox vbox=new VBox(10);
		vbox.getChildren().addAll(hbox,ta);
		vbox.setPrefWidth(500);
		
		an.setStyle("-fx-background-color:gray");
		an.getChildren().addAll(vbox);
		AnchorPane.setTopAnchor(vbox, 10.0);
		AnchorPane.setLeftAnchor(vbox, 10.0);
		
		ta.setFont(Font.font(15));
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bfind.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				ta.getParagraphs().forEach(new Consumer<CharSequence>() {

					@Override
					public void accept(CharSequence t) {
						// TODO Auto-generated method stub
						String findstr=tf.getText();
						
						String string=t.toString();
						
						if(string.contains(findstr)) {
							primaryStage.setTitle("ok");
							ta.requestFocus();
							int i=string.indexOf(findstr,index);
							if(i==-1){
								primaryStage.setTitle("done");
								index=0;
								return;
							}
							index=i+findstr.length();
							System.out.println(i);
							ta.selectRange(i, index);
						}
						
						
//						substr=string.substring(index);
//						if(substr.contains(findstr)) {
//							primaryStage.setTitle("ok");
//							ta.requestFocus();
//							int i=substr.indexOf(findstr)+string.length()-substr.length();
//							index=i+findstr.length();
//							System.out.println(i);
//							ta.selectRange(i, index);
//						}else {
//							primaryStage.setTitle("done");
//							substr=string;
//							index=0;
//						}	
					}
				});
			}
		});
		bsort.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				char[] ch=ta.getText().toCharArray();
				ArrayList <String> list=new ArrayList<String>();
				for(char c:ch) {
					list.add(String.valueOf(c));
				}
				ta.clear();
				//使用流排序
				list.stream().sorted((o1,o2)->o1.compareTo(o2)).forEach(item->ta.appendText(item));
				
				Stream <String> stream=list.stream().sorted(new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						return o1.compareTo(o2);
					}
				});
				stream.forEach(new Consumer<String>() {

					@Override
					public void accept(String t) {
						// TODO Auto-generated method stub
						ta.appendText(t);
					}
				});
				
//				Collections.sort(list);
//				ta.clear();
//				for(String str:list) {
//					ta.appendText(str);
//				}
				
//				Arrays.sort(ch);
//				ta.setText(String.valueOf(ch));
				
			}
		});
	}

}
