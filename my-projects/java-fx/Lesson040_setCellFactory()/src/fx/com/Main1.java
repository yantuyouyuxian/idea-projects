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
				System.out.println(object);
				return object;
			}
			
			@Override
			public String fromString(String string) {
				// TODO Auto-generated method stub
				return null;
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
		
		cbb.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				// TODO Auto-generated method stub
				My_ListCell<String> listcell=new My_ListCell<String>();
				return listcell;
			}
		});
		
	}

}

class My_ListCell<T> extends ListCell<String>{

	@Override
	protected void updateItem(String item, boolean empty) {
		// TODO Auto-generated method stub
		super.updateItem(item, empty);
		if(empty==false) {
			HBox hbox2=new HBox(10);
			hbox2.setStyle("-fx-background-color:gray");
			hbox2.setAlignment(Pos.CENTER);
			hbox2.getChildren().addAll(new Button(item),new Button(item));
		
			this.setContentDisplay(ContentDisplay.CENTER);
			this.setStyle("-fx-background-color:pink");
			this.setAlignment(Pos.CENTER);
			this.setGraphic(hbox2);//
		}
		System.out.println("item: "+item+" empty: "+empty);
		
	}
	
	
}
