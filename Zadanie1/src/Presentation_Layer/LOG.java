package Presentation_Layer;

import Data_Layer.SQL;
import Data_Layer.User;
import Logical_Layer.DataRepository;
import Logical_Layer.DataService;
import javafx.animation.FadeTransition;
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

public class LOG extends Application {

	private DataService dataService;
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
	@FXML
	private Button signUpButton;
	@FXML
	private Scene scene;

	public LOG() {
		SQL sql = new SQL();
		 //sql.dbConnect(
				 //"jdbc:sqlserver://localhost\\sqlexpress:1433;database=Tamagotchi; user=Pawel; password=mama");
		sql.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Damian; password=Worrior");
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
		signUpButton = new Button("Sign up");

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 3);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				if (dataService.CheckSignIn(userTextField.getText(), pwBox.getText())) {
					actiontarget.setFill(Color.WHITE);
					actiontarget.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 12));
					actiontarget.setText("Witaj " + userTextField.getText());
					
					GAME game = new GAME(dataService);
					game.start(primaryStage);

				} else {
					actiontarget.setFill(Color.WHITE);
					actiontarget.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 12));
					userTextField.setText(null);
					pwBox.setText(null);
					actiontarget.setText("Poda³eœ niepoprawny login lub has³o :/");
				}
			}
		});

		signUpButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				actiontarget.setFill(Color.WHITE);
				actiontarget.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 15));
				SignUp signUp = new SignUp(dataService);
				signUp.SignUpWindow(primaryStage);
			}
		});

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		hbBtn.setBlendMode(BlendMode.HARD_LIGHT);
		hbBtn.getChildren().add(signUpButton);
		grid.add(hbBtn, 1, 4);

		TranslateTransition t1 = new TranslateTransition();
		t1.setDuration(Duration.seconds(5));
		t1.setNode(btn);
		t1.setToY(-100);
		FadeTransition f1 = new FadeTransition(Duration.seconds(5), btn);
		f1.setFromValue(0.0);
		f1.setToValue(1.0);

		TranslateTransition t11 = new TranslateTransition();
		t11.setDuration(Duration.seconds(5));
		t11.setNode(signUpButton);
		t11.setToY(-100);
		FadeTransition f11 = new FadeTransition(Duration.seconds(5), signUpButton);
		f11.setFromValue(0.0);
		f11.setToValue(1.0);

		TranslateTransition t2 = new TranslateTransition();
		t2.setDuration(Duration.seconds(4));
		t2.setNode(pw);
		t2.setToY(-100);
		FadeTransition f2 = new FadeTransition(Duration.seconds(4), pw);
		f2.setFromValue(0.0);
		f2.setToValue(1.0);

		TranslateTransition t3 = new TranslateTransition();
		t3.setDuration(Duration.seconds(3));
		t3.setNode(userTextField);
		t3.setToY(-100);
		FadeTransition f3 = new FadeTransition(Duration.seconds(3), userTextField);
		f3.setFromValue(0.0);
		f3.setToValue(1.0);

		TranslateTransition t4 = new TranslateTransition();
		t4.setDuration(Duration.seconds(4));
		t4.setNode(pwBox);
		t4.setToY(-100);
		FadeTransition f4 = new FadeTransition(Duration.seconds(4), pwBox);
		f4.setFromValue(0.0);
		f4.setToValue(1.0);

		TranslateTransition t5 = new TranslateTransition();
		t5.setDuration(Duration.seconds(2));
		t5.setNode(scenetitle);
		t5.setToY(-100);
		FadeTransition f5 = new FadeTransition(Duration.seconds(3), scenetitle);
		f5.setFromValue(0.0);
		f5.setToValue(1.0);

		TranslateTransition t6 = new TranslateTransition();
		t6.setDuration(Duration.seconds(3));
		t6.setNode(userName);
		t6.setToY(-100);
		FadeTransition f6 = new FadeTransition(Duration.seconds(3), userName);
		f6.setFromValue(0.0);
		f6.setToValue(1.0);

		ParallelTransition p = new ParallelTransition(t1, f1, t11, f11, t2, f2, t3, f3, t4, f4, t5, f5, t6, f6);
		p.play();

		scene = new Scene(grid, 500, 733);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Text getScenetitle() {
		return scenetitle;
	}

	public void setScenetitle(Text scenetitle) {
		this.scenetitle = scenetitle;
	}

	public Label getUserName() {
		return userName;
	}

	public void setUserName(Label userName) {
		this.userName = userName;
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(TextField userTextField) {
		this.userTextField = userTextField;
	}

	public Label getPw() {
		return pw;
	}

	public void setPw(Label pw) {
		this.pw = pw;
	}

	public PasswordField getPwBox() {
		return pwBox;
	}

	public void setPwBox(PasswordField pwBox) {
		this.pwBox = pwBox;
	}

	public Button getBtn() {
		return btn;
	}

	public void setBtn(Button btn) {
		this.btn = btn;
	}

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Button getSignUpButton() {
		return signUpButton;
	}

	public void setSignUpButton(Button signUpButton) {
		this.signUpButton = signUpButton;
	}

}
