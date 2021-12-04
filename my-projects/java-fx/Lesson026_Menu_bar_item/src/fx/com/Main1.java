/**
 * MenuBar Menu MenuItem
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;

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
		
		AnchorPane ap=new AnchorPane();
//		ap.setStyle("-fx-background-color:gray");
		
		MenuBar menubar =new MenuBar();
//		menubar.setStyle("-fx-background-color:white");
		
		
//		Menu menu1=new Menu("menu1",new Button("button"));
		Menu menu1=new Menu("menu1");
		Menu menu2=new Menu("menu2");
		Menu menu3=new Menu("menu3");
		Menu menu4=new Menu("menu4");
		
		menu1.setOnShowing(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("menu1.setOnShowing()");
			}
		});
		menu1.setOnShown(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("menu1.setOnShown()");
			}
		});
		menu1.setOnHidden(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("menu1.setOnHidden()");
			}
		});
		
		menu1.setOnHiding(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("menu1.setOnHidding()");
			}
		});
		
		MenuItem menui1=new MenuItem("menui1",new ImageView("images/icon.png"));
		MenuItem menui2=new MenuItem("menui2");
		MenuItem menui3=new MenuItem("menui3");
		MenuItem menui4=new MenuItem("menui4");
		MenuItem menui5=new MenuItem("menui5");
		
		menui1.setAccelerator(KeyCombination.valueOf("ctrl+p"));
		
		
		menu1.getItems().addAll(menui1,menui2,menui3);
		menu2.getItems().addAll(menui4,menui5);
		
		menubar.getMenus().addAll(menu1,menu2,menu3,menu4);
		
		ap.getChildren().add(menubar);
		
		
		menui1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("menui1");
			}
		});
		
		
		
		Scene scene=new Scene(ap);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		menubar.setPrefWidth(ap.getWidth());
		
		ap.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				menubar.setPrefWidth((double)newValue);
			}
		});
	}

}
