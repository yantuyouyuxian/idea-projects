/**
 * 
 */
package fx.com;

import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * @author Z H
 *
 */
public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox box=new VBox();
		
		TextField tf=new TextField();
		
		TextArea ta=new TextArea();
		
		//¹ýÂË
		tf.setTextFormatter(new TextFormatter<String>(new UnaryOperator<Change>() {

			@Override
			public Change apply(Change t) {
				// TODO Auto-generated method stub
				System.out.println(t.getText());
				String value=t.getText();
				if(value.matches("[a-z]*")) {
					return t;
				}
				return null;
			}
		}));
		
		
		
		box.getChildren().addAll(tf,ta);
		box.setAlignment(Pos.CENTER);

		Scene scene=new Scene(box);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		ta.requestFocus();
		
		ta.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				ta.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {

					@Override
					public String toString(String object) {
						// TODO Auto-generated method stub
						System.out.println("obj="+object);
						return object;
					}

					@Override
					public String fromString(String string) {
						// TODO Auto-generated method stub
						System.out.println("str="+string);
						if(string.contains("5")) {
							String value=string.replace("5", "Îå");
							return value;
						}
						return string;
					}
				}));
				ta.commitValue();
			}
		});
		
	
		
		tf.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				tf.setTextFormatter(new TextFormatter<Integer>(new StringConverter<Integer>() {

					@Override
					public String toString(Integer object) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public Integer fromString(String string) {
						// TODO Auto-generated method stub
						return null;
					}
				}));
				tf.commitValue();
			}});
		
	}

}
