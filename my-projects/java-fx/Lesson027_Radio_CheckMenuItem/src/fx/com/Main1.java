/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *menu的多选，单选，分隔符，子菜单
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
		
		Scene scene =new Scene(an);
		
		MenuBar menubar =new MenuBar();
		
		Menu menu1=new Menu("menu1");
		Menu menu2=new Menu("menu2");
		Menu menu3=new Menu("menu3");
		Menu menu4=new Menu("menu4");
		
		MenuItem menui1=new MenuItem("menui1");
		MenuItem menui2=new MenuItem("menui2");
		MenuItem menui3=new MenuItem("menui3");
		MenuItem menui4=new MenuItem("menui4");
		
		Menu m=new Menu("m");
		MenuItem menui5=new MenuItem("menui5");
		MenuItem menui6=new MenuItem("menui6");
		
		ToggleGroup tg=new ToggleGroup();
		
		RadioMenuItem r1=new RadioMenuItem("r1");
		RadioMenuItem r2=new RadioMenuItem("r2");
		RadioMenuItem r3=new RadioMenuItem("r3");
		
		CheckMenuItem cmi1=new CheckMenuItem("cmi1");
		CheckMenuItem cmi2=new CheckMenuItem("cmi2");
		CheckMenuItem cmi3=new CheckMenuItem("cmi3");
		
		
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r3.setToggleGroup(tg);
		
		r2.setSelected(true);
		
		
		m.getItems().addAll(menui5,menui6);
		
		
		SeparatorMenuItem separ1=new SeparatorMenuItem();
		SeparatorMenuItem separ2=new SeparatorMenuItem();
		
		
		menu1.getItems().addAll(menui1,separ1,menui2,separ2,menui3,menui4,m);
		
		menu2.getItems().addAll(r1,r2,r3);
		
		menu3.getItems().addAll(cmi1,cmi2,cmi3);
		
		menubar.getMenus().addAll(menu1,menu2,menu3,menu4);
		
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
		
		r1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println(((RadioMenuItem)event.getSource()).getText());
			}
		});
		
		
	}

}
