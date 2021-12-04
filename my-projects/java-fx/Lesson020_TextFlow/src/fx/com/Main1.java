/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * @author Z H
 *TextFlow
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
		
		Text t1=new Text("Text 文本 Text 文本 Text 文本");
		t1.setFont(Font.font(20));
		t1.setFill(Paint.valueOf("blue"));
//		t1.setStyle("-fx-fill:red");
		Text t2=new Text("HelloWorld HelloWorld HelloWorld");
		
		Text t3=new Text("JavaFx JavaFx JavaFx JavaFx");
		
		TextFlow tf=new TextFlow();
		tf.setStyle("-fx-background-color:gray");
		
		
		tf.getChildren().addAll(t1,t2,t3);
		
		tf.setPadding(new Insets(10));
		
		tf.setTextAlignment(TextAlignment.CENTER);
		
		tf.setLineSpacing(20);
		
		
		AnchorPane ap=new AnchorPane();
		TextFlow tf1=new TextFlow();
		Text t4=new Text("Text4 文本 Text4 文本 Text4 文本");
		
		tf1.getChildren().add(t4);
		tf1.setStyle("-fx-background-color:blue");
		
		ap.getChildren().addAll(tf,tf1);
		
		ap.setTopAnchor(tf1, 50.0);
		
		
		
		Scene scene=new Scene(ap);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		primaryStage.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println("anchorpane.width="+ap.getWidth());
				System.out.println("tf.width+"+tf.getWidth());
				System.out.println("tf1.width+"+tf1.getWidth());
			}
		});
		
		ap.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				tf.setPrefWidth(ap.getWidth());
				tf1.setPrefWidth(ap.getWidth());
			}
		});
	}

}
