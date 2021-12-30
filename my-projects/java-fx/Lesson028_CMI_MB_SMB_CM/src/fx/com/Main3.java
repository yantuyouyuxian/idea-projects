/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * CustomMenuItem
 * MenuButton
 * SplitMenuButton
 * ContextMenu
 */
public class Main3 extends Application{

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
		
		SplitMenuButton smb=new SplitMenuButton();
		smb.setText("smb");
		MenuItem menui4=new MenuItem("menui4");
		MenuItem menui5=new MenuItem("menui5");
		MenuItem menui6=new MenuItem("menui6");
		
		
		
		smb.getItems().addAll(menui4,menui5,menui6);
		
		menubar.getMenus().addAll(menu1,menu2,menu3);
		
		menu1.getItems().addAll(menui1,menui2,menui3);
		
		an.getChildren().addAll(menubar,smb);
		an.setTopAnchor(smb, 50.0);
		
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
