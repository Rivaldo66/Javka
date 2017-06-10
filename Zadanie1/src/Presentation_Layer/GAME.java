package Presentation_Layer;

import Logical_Layer.DataService;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
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

public class GAME extends Application {

	private DataService dataService;;
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

	public GAME(DataService dataService) {
		this.dataService = dataService;
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LOGIN PANEL");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setStyle(
				"-fx-background-image: url('https://s-media-cache-ak0.pinimg.com/736x/5f/74/e6/5f74e63976b7657a209488ee7a200ded.jpg')");
		grid.setHgap(10);
		grid.setVgap(10);

		
		scene = new Scene(grid, 736, 552);
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
