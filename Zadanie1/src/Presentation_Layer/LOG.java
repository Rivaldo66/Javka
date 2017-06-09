package Presentation_Layer;

import Data_Layer.SQL;
import Data_Layer.User;
import Logical_Layer.DataRepository;
import Logical_Layer.DataService;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LOG extends Application{

	DataService dataService;
	@FXML
	private Text scenetitle;
	@FXML
	private Label userName;
	@FXML
	private TextField userTextField;
	@FXML
	private Label pw;
	@FXML
	private PasswordField pwBox;
	@FXML
	private Button btn;
	
	public LOG() {
		SQL sql = new SQL();
		DataRepository dataRepository = new DataRepository(sql);
		dataService = new DataService(dataRepository);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LOGIN PANEL");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setStyle(
				"-fx-background-image: url('https://s-media-cache-ak0.pinimg.com/736x/78/b1/96/78b1965dbb8d754bbeb6f9a1addf0d4f.jpg')");
		
		grid.setHgap(10);
		grid.setVgap(10);

		scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 55));
		scenetitle.setFill(Color.WHITE);
		grid.add(scenetitle, 0, 0, 2, 1);

		userName = new Label("User name:");
		userName.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
		userName.setTextFill(Color.WHITE);
		grid.add(userName, 0, 1);

		userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		pw = new Label("Password:");
		pw.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
		pw.setTextFill(Color.WHITE);
		grid.add(pw, 0, 2);

		pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);

		btn = new Button("Sign in");

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				User user = new User();
				user.setLogin(userTextField.getText());
				user.setPassword(pwBox.getText());

				if (dataService.CheckLogin(user.getLogin(), user.getPassword())) {
					actiontarget.setFill(Color.WHITE);
					actiontarget.setText("Zapraszamy do gry :)");
					// odpalanie okna gry
				} else {
					actiontarget.setFill(Color.WHITE);
					actiontarget.setText("Co� posz�o nie tak :(");
				}
			}
		});

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		hbBtn.setBlendMode(BlendMode.HARD_LIGHT);
		grid.add(hbBtn, 1, 4);
		
		TranslateTransition t1 = new TranslateTransition();
		t1.setDuration(Duration.seconds(5));
		t1.setNode(btn);	
		t1.setToY(-100);

		TranslateTransition t2 = new TranslateTransition();
		t2.setDuration(Duration.seconds(4));
		t2.setNode(pw);	
		t2.setToY(-100);
		
		TranslateTransition t3 = new TranslateTransition();
		t3.setDuration(Duration.seconds(3));
		t3.setNode(userTextField);	
		t3.setToY(-100);
		
		TranslateTransition t4 = new TranslateTransition();
		t4.setDuration(Duration.seconds(4));
		t4.setNode(pwBox);	
		t4.setToY(-100);

		TranslateTransition t5 = new TranslateTransition();
		t5.setDuration(Duration.seconds(2));
		t5.setNode(scenetitle);	
		t5.setToY(-100);
		
		TranslateTransition t6 = new TranslateTransition();
		t6.setDuration(Duration.seconds(3));
		t6.setNode(userName);	
		t6.setToY(-100);
		
		ParallelTransition p = new ParallelTransition(t1,t2,t3,t4,t5,t6);
		p.play();


		Scene scene = new Scene(grid, 500, 733);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
