/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
		
		AnchorPane an=new AnchorPane();
		
		ComboBox<String> cbb=new ComboBox<String>();
		
		cbb.getItems().addAll("str1","str2","str3","str4","str5");
		
		cbb.setConverter(new StringConverter<String>() {
			
			@Override
			public String toString(String object) {
				System.out.println("toString()");
				return object;
			}
			
			@Override
			public String fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		cbb.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				// TODO Auto-generated method stub
				ListCell<String> list=new ListCell<String>(){

					@Override
					protected void updateItem(String item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty==false) {
							System.out.println("scfitem="+item);
							this.setText(item+" scf");
						}
					}
					
				};
				return list;
			}
		});
		
		cbb.cellFactoryProperty().set(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				ListCell<String> list=new ListCell<String>(){

					@Override
					protected void updateItem(String item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty==false) {
							System.out.println("cfpitem="+item);
							this.setText(item+" cfp");
						}
					}
					
				};
				return list;
			}
		});
		
		cbb.setPrefWidth(150);
		
		an.getChildren().addAll(cbb);
		AnchorPane.setTopAnchor(cbb, 50.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
	}

}
