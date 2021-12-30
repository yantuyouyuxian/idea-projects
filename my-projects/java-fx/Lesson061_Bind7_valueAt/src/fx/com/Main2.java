/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
		ObservableList<String> obslist = 
				FXCollections.observableArrayList();

		SimpleListProperty<String> list = 
				new SimpleListProperty<String>(obslist);

		list.addAll("A","B","C","D","E");
		TextField t1=new TextField();
		TextField t2=new TextField();
		HBox hbox=new HBox(10);
		hbox.getChildren().addAll(t1,t2);
		VBox vbox=new VBox();
		
		VBox listdata =new VBox(10);
		for(int i=0;i<list.size();i++) {
			Label lab=new Label();
			lab.setFont(Font.font(30));
			ObjectBinding<String> objbind=list.valueAt(i);
			lab.textProperty().bind(objbind);
			
//			lab.setText(list.get(i));
			listdata.getChildren().add(lab);
		}
//		AnchorPane.setLeftAnchor(vbox, 100.0);
//		vbox.setPadding(new Insets(0, 0, 0, 50));
		VBox.setMargin(listdata,new Insets(50));
		vbox.getChildren().addAll(hbox,listdata);
		
		an.getChildren().addAll(vbox);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		t2.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if(t1.getText().equals("")) {
					return;
				}
				try {
					int index=Integer.parseInt(t1.getText());
					String value=t2.getText();
					list.set(index,value);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Exception");
				}
			}
		});
	}

}
