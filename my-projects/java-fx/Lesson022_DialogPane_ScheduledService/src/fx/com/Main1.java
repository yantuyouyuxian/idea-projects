/**
 * 
 */
package fx.com;

import java.awt.Dialog;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * @author Z H DialogPane ScheduledService
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

		Button b1 = new Button("点击显示窗口");

		AnchorPane an = new AnchorPane();
		an.setStyle("-fx-background-color:gray");

		an.getChildren().add(b1);
		an.setTopAnchor(b1, 50.0);
		an.setLeftAnchor(b1, 50.0);

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				DialogPane diap = new DialogPane();

				diap.setHeaderText("setheadertext");
				diap.setContentText("setcontenttext");

				diap.getButtonTypes().add(ButtonType.APPLY);
				diap.getButtonTypes().add(ButtonType.CLOSE);

				ImageView im = new ImageView("images/icon.png");

				diap.setGraphic(im);

				diap.setExpandableContent(new Text("扩展内容"));
				diap.setExpanded(true);

				Button apply = (Button) diap.lookupButton(ButtonType.APPLY);

				Button close = (Button) diap.lookupButton(ButtonType.CLOSE);

				Stage stage = new Stage();

				Scene sc = new Scene(diap);

				stage.setScene(sc);

				stage.setTitle("弹出窗口");
				stage.initOwner(primaryStage);
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initStyle(StageStyle.UTILITY);
				stage.setResizable(false);
				stage.show();

				apply.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						System.out.println("apply");
					}
				});

				close.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						System.out.println("close");
					}
				});
				
				MyScheduledService my = new MyScheduledService(diap, stage);
//				my.setDelay(Duration.millis(0));
				my.setPeriod(Duration.millis(1000));
				my.start();
			}

		});

		// lanmuda表达式
		// b1.setOnAction(acton -> System.out.println("b1.setOnAction()"));

		Scene scene = new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}

class MyScheduledService extends ScheduledService<Integer> {

	private DialogPane di = null;
	private Stage stage = null;
	int i = 0;

	public MyScheduledService(DialogPane di, Stage stage) {
		// TODO Auto-generated constructor stub
		this.di = di;
		this.stage = stage;
	}

	@Override
	protected Task<Integer> createTask() {
		// TODO Auto-generated method stub

		return new Task<Integer>() {

			@Override
			protected Integer call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("call: " + Thread.currentThread().getName());
				return i = i + 1;
			}

			@Override
			protected void updateValue(Integer arg0) {
				// TODO Auto-generated method stub
				System.out.println("updatevalue: " + Thread.currentThread().getName());
				System.out.println("updatevalue arg0=" + arg0);

				if (arg0 <= 5) {
					MyScheduledService.this.di.setContentText(String.valueOf(arg0));
				} else {
					MyScheduledService.this.stage.close();
					MyScheduledService.this.cancel();
				}
			}

		};
	}

}
