package fx.com;

/**
 * CustomMenuItem
 * MenuButton
 * SplitMenuButton
 * ContextMenu
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main1 extends Application{
	
	public static void main(String[] args) {
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
		
		CustomMenuItem cmi1=new CustomMenuItem();
		Button bt1=new Button("bt1");
		cmi1.setContent(bt1);
		
		CustomMenuItem cmi2=new CustomMenuItem();
		ProgressBar pbar=new ProgressBar(0.5);
		cmi2.setContent(pbar);
		
		CustomMenuItem cmi3=new CustomMenuItem();
		HBox hbox=new HBox();
		hbox.setStyle("-fx-background-color:red");
		hbox.getChildren().addAll(new Button("b1"),new Button("b2"),new Button("b3"));
		cmi3.setContent(hbox);
		
		
		
		
		
		menubar.getMenus().addAll(menu1,menu2,menu3);
		
		menu1.getItems().addAll(menui1,menui2,menui3,cmi1,cmi2,cmi3);
		
		an.getChildren().add(menubar);
		
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
	}

}
