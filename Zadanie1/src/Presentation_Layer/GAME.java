package Presentation_Layer;

import Logical_Layer.DataService;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GAME extends Application{

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

	public GAME(DataService dataService) {
		this.dataService = dataService;
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("LOGIN PANEL");
		BorderPane border = new BorderPane();
		border.setStyle(
				"-fx-background-image: url('https://s-media-cache-ak0.pinimg.com/736x/5f/74/e6/5f74e63976b7657a209488ee7a200ded.jpg')");
		
		//HBox hbox = addHBox();
		//border.setTop(hbox);

		//border.setCenter(addGridPane());
		border.setRight(addHBox());
		
		scene = new Scene(border, 900, 552);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button AddNewBtn = new Button("Add new Animal");
	    AddNewBtn.setPrefSize(200, 20);

	    //Button buttonProjected = new Button("Projected");
	    //buttonProjected.setPrefSize(100, 20);
	    hbox.getChildren().addAll(AddNewBtn);

	    return hbox;
	}
	
	public FlowPane addFlowPane() {
	    FlowPane flow = new FlowPane();
	    flow.setPadding(new Insets(5, 0, 5, 0));
	    flow.setVgap(4);
	    flow.setHgap(4);
	    flow.setPrefWrapLength(170); // preferred width allows for two columns
	    flow.setStyle("-fx-background-color: DAE6F3;");

	    //ImageView pages[] = new ImageView[8];
	    //for (int i=0; i<8; i++) {
	      //  pages[i] = new ImageView(
	        //    new Image(LayoutPath.class.getResourceAsStream(
	          //  "graphics/chart_"+(i+1)+".png")));
	        //flow.getChildren().add(pages[i]);
	    //}

	    return flow;
	}
	
	public GridPane addGridPane() {
	    GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));

	    // Category in column 2, row 1
	    Text category = new Text("Sales:");
	    category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(category, 1, 0); 

	    // Title in column 3, row 1
	    Text chartTitle = new Text("Current Year");
	    chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(chartTitle, 2, 0);

	    // Subtitle in columns 2-3, row 2
	    Text chartSubtitle = new Text("Goods and Services");
	    grid.add(chartSubtitle, 1, 1, 2, 1);

	    // House icon in column 1, rows 1-2
	    //ImageView imageHouse = new ImageView(
	      //new Image(LayoutSample.class.getResourceAsStream("graphics/house.png")));
	    //grid.add(imageHouse, 0, 0, 1, 2); 

	    // Left label in column 1 (bottom), row 3
	    //Text goodsPercent = new Text("Goods\n80%");
	    //GridPane.setValignment(goodsPercent, VPos.BOTTOM);
	    //grid.add(goodsPercent, 0, 2); 

	    // Chart in columns 2-3, row 3
	    //ImageView imageChart = new ImageView(
	    // new Image(LayoutSample.class.getResourceAsStream("graphics/piechart.png")));
	    //grid.add(imageChart, 1, 2, 2, 1); 

	    // Right label in column 4 (top), row 3
	    //Text servicesPercent = new Text("Services\n20%");
	    //GridPane.setValignment(servicesPercent, VPos.TOP);
	    //grid.add(servicesPercent, 3, 2);

	    return grid;
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
