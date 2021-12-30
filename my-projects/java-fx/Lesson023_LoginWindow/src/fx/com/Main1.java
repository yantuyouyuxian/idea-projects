/**
 * 
 */
package fx.com;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H 
 *һ����½����
 */
public class Main1 extends Application {

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

		Label lab_account = new Label("�˻�");
		lab_account.setFont(Font.font(15));
		Label lab_pwd = new Label("����");
		lab_pwd.setFont(Font.font(15));

		TextField text_account = new TextField();
		text_account.setUserData("123");
		text_account.setTooltip(new Tooltip("�������˻�"));
		
		PasswordField pwd = new PasswordField();
		pwd.setUserData("123");
		pwd.setTooltip(new Tooltip("����������"));

		Button bt_login = new Button("��½");
		Button bt_clear = new Button("���");

		GridPane gp = new GridPane();

		// gp.setStyle("-fx-background-color:gray");

		gp.add(lab_account, 0, 0);
		gp.add(text_account, 1, 0);
		gp.add(lab_pwd, 0, 1);
		gp.add(pwd, 1, 1);
		gp.add(bt_login, 1, 2);
		gp.add(bt_clear, 0, 2);

		gp.setAlignment(Pos.CENTER);
		gp.setHgap(5);
		gp.setVgap(10);
		gp.setMargin(bt_login, new Insets(0, 0, 0, 120));
		// gp.setGridLinesVisible(true);

		Scene scene = new Scene(gp);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFxLogUp");
		primaryStage.setHeight(300);
		primaryStage.setWidth(500);
		primaryStage.setResizable(false);
		primaryStage.show();

		bt_clear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				text_account.setText("");
				pwd.setText("");
			}
		});

		bt_login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				 //TODO Auto-generated method stub
//				 text_account.getProperties().put("key", "value");
//				 System.out.println(text_account.getProperties().get("key"));
//				
//				 text_account.setUserData("tf_account");
//				 System.out.println(text_account.getUserData());
//				String account = text_account.getText();
//				String pw = pwd.getText();

				if (text_account.getText().equals(text_account.getUserData()) 
						&& pwd.getText().equals(pwd.getUserData())) {
					System.out.println("Ok");
					primaryStage.close();
					MyWindow mw=new MyWindow(text_account.getText(),pwd.getText());
				}else {
					System.out.println("Sorry");
					
					lab_account.setTextFill(Color.RED);
					lab_pwd.setTextFill(Color.RED);
					
					pwd.setText("");
					primaryStage.setTitle("�˻�������������");
					
					
					FadeTransition fade=new FadeTransition();
					fade.setDuration(Duration.seconds(0.1));
					fade.setNode(gp);
					fade.setFromValue(0);
					fade.setToValue(1);
					fade.play();
				
				}
			}
		});

	}

}

class MyWindow{
	private final Stage stage=new Stage();
	public MyWindow(String account,String pwd) {
		
		Text text=new Text("�û���:"+account+"����:"+"pwd");
		
		BorderPane bor=new BorderPane();
		bor.setStyle("-fx-background-color:yellow");
		bor.setCenter(text);
		Scene scene=new Scene(bor);
		
		stage.setScene(scene);
		stage.setHeight(150);
		stage.setWidth(250);
		stage.setTitle("wellcome");
		stage.show();
	}
}

