/**
 * 
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
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * CustomMenuItem
 * MenuButton
 * SplitMenuButton
 * ContextMenu
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
		
		Scene scene =new Scene(an);
		
		MenuBar menubar =new MenuBar();
		
		Menu menu1=new Menu("menu1");
		Menu menu2=new Menu("menu2");
		Menu menu3=new Menu("menu3");
		
		MenuItem menui1=new MenuItem("menui1");
		MenuItem menui2=new MenuItem("menui2");
		MenuItem menui3=new MenuItem("menui3");
		
		MenuButton mb=new MenuButton("menubutton");//node
		
		MenuItem menui4=new MenuItem("menui4");
		MenuItem menui5=new MenuItem("menui5");
		MenuItem menui6=new MenuItem("menui6");
		
		CustomMenuItem cmi3=new CustomMenuItem();
		HBox hbox=new HBox();
		hbox.setStyle("-fx-background-color:red");
		hbox.getChildren().addAll(new Button("b1"),new Button("b2"),new Button("b3"));
		cmi3.setContent(hbox);
		
		mb.getItems().addAll(menui4,menui5,menui6,cmi3);
		mb.setPrefWidth(100);
//		mb.setMaxWidth(100);
//		mb.setMinWidth(100);
		
		menubar.getMenus().addAll(menu1,menu2,menu3);
		
		menu1.getItems().addAll(menui1,menui2,menui3);
		
		menui4.setAccelerator(KeyCombination.valueOf("ctrl+P"));
		
		an.getChildren().addAll(menubar,mb);
		
		an.setTopAnchor(mb, 50.0);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		menubar.setPrefWidth(an.getWidth());
		
		an.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				menubar.setPrefWidth((double)newValue);
			}
		});
		
		menui4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mb.setText("hello");
			}
		});
		
		menui4.setOnMenuValidation(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("menui4.setOnMenuValidation()");
			}
		});
	}

}
