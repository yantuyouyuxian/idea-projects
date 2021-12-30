/**
 * 
 */
package fx.com;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * @author Z H
 *
 */
public class Main2 extends Application{

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
		
		DatePicker date=new DatePicker(LocalDate.now());
		
		date.valueProperty().addListener(new ChangeListener<LocalDate>() {

			@Override
			public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue,
					LocalDate newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
//		date.setConverter(new StringConverter<LocalDate>() {
//			
//			@Override
//			public String toString(LocalDate object) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public LocalDate fromString(String string) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
		
		date.setDayCellFactory(new Callback<DatePicker, DateCell>() {
			
			@Override
			public DateCell call(DatePicker param) {
				// TODO Auto-generated method stub
				DateCell cell=new DateCell() {

					@Override
					public void updateItem(LocalDate item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						this.setGraphic(new Button("button"));
					}
					
				};
				return cell;
			}
		});
		
		an.getChildren().add(date);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
