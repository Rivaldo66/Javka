package Presentation_Layer;

import java.util.ArrayList;
import java.util.List;

import Data_Layer.Animal;
import Data_Layer.User;
import Logical_Layer.DataService;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimalDetails extends Application {

	private DataService dataService;
	private User currentUser;
	private List<Animal> animalList = new ArrayList<Animal>();
	private Button currentAnimalBtn;
	private int currentAnimalId;
	private int sizeX = 170;

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("DETAILS PANEL");
		BorderPane border = new BorderPane();
		border.setStyle("-fx-background-color: #336699;");

		border.setCenter(addGridPaneCenter());
		border.setBottom(addGridPaneBottom(primaryStage));

		Scene scene = new Scene(border, 900, 552);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public GridPane addGridPaneBottom(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));
		grid.setStyle("-fx-background-color: #336659;");

		Button btn = new Button("Back");
		btn.setPrefSize(sizeX, 20);
		grid.add(btn, 0, 0);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				GAME game = new GAME(dataService, currentUser);
				game.start(primaryStage);
			}
		});

		return grid;
	}

	public GridPane addGridPaneCenter() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));
		grid.setStyle("-fx-background-color: #336699;");

		Text scenetitle = new Text("Details about your pet");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		scenetitle.setFill(Color.WHITE);
		grid.add(scenetitle, 0, 0, 2, 1);

		Label petName = new Label("Name:");
		petName.setPrefSize(sizeX, 20);
		petName.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petName.setTextFill(Color.WHITE);
		grid.add(petName, 0, 1);

		Label petN = new Label(dataService.getDataRepository().GetAnimal(currentAnimalId).getName());
		petN.setPrefSize(sizeX, 20);
		petN.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petN.setTextFill(Color.WHITE);
		grid.add(petN, 2, 1);

		Label petSpecies = new Label("Species:");
		petSpecies.setPrefSize(sizeX, 20);
		petSpecies.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petSpecies.setTextFill(Color.WHITE);
		grid.add(petSpecies, 0, 2);

		Label petS = new Label(dataService.getDataRepository().GetAnimal(currentAnimalId).getType().getName());
		petS.setPrefSize(sizeX, 20);
		petS.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petS.setTextFill(Color.WHITE);
		grid.add(petS, 2, 2);

		Label petDateAdded = new Label("Date of born:");
		petDateAdded.setPrefSize(sizeX, 20);
		petDateAdded.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petDateAdded.setTextFill(Color.WHITE);
		grid.add(petDateAdded, 0, 3);

		Label petD = new Label(dataService.getDataRepository().GetAnimal(currentAnimalId).getDateAdded().toString());
		petD.setPrefSize(sizeX, 20);
		petD.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petD.setTextFill(Color.WHITE);
		grid.add(petD, 2, 3);

		Label petHp = new Label("HP:");
		petHp.setPrefSize(sizeX, 20);
		petHp.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petHp.setTextFill(Color.WHITE);
		grid.add(petHp, 0, 4);

		Label petH = new Label(Float.toString(dataService.getDataRepository().GetAnimal(currentAnimalId).getHp()));
		petH.setPrefSize(sizeX, 20);
		petH.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petH.setTextFill(Color.WHITE);
		grid.add(petH, 2, 4);

		Label petFun = new Label("Level of fun needed:");
		petFun.setPrefSize(sizeX, 20);
		petFun.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petFun.setTextFill(Color.WHITE);
		grid.add(petFun, 0, 5);

		Label petF = new Label(
				Float.toString(dataService.getDataRepository().GetAnimal(currentAnimalId).getLevelOfFunNeeded()));
		petF.setPrefSize(sizeX, 20);
		petF.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petF.setTextFill(Color.WHITE);
		grid.add(petF, 2, 5);

		Label petHunger = new Label("Level of hunger:");
		petHunger.setPrefSize(sizeX, 20);
		petHunger.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petHunger.setTextFill(Color.WHITE);
		grid.add(petHunger, 0, 6);

		Label petHgry = new Label(
				Float.toString(dataService.getDataRepository().GetAnimal(currentAnimalId).getLevelOfHunger()));
		petHgry.setPrefSize(sizeX, 20);
		petHgry.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petHgry.setTextFill(Color.WHITE);
		grid.add(petHgry, 2, 6);

		Button picture = new Button();
		picture.setStyle("-fx-background-color: transparent;" + "-fx-border: false;" + "-fx-background-image: url('"
				+ dataService.ShowImageByAnimalID(String.valueOf(currentAnimalId)) + "');"
				+ "-fx-background-size: cover;");
		grid.add(picture,  1, 9);
		
		TranslateTransition t1 = new TranslateTransition();
		t1.setDuration(Duration.seconds(1));
		t1.setNode(petN);
		t1.setToX(-10);
		FadeTransition f1 = new FadeTransition(Duration.seconds(1), petN);
		f1.setFromValue(0.0);
		f1.setToValue(1.0);

		TranslateTransition t2 = new TranslateTransition();
		t2.setDuration(Duration.seconds(1));
		t2.setNode(petS);
		t1.setToX(-10);
		FadeTransition f2 = new FadeTransition(Duration.seconds(1), petS);
		f2.setFromValue(0.0);
		f2.setToValue(1.0);

		TranslateTransition t3 = new TranslateTransition();
		t3.setDuration(Duration.seconds(1));
		t3.setNode(petD);
		t3.setToX(-10);
		FadeTransition f3 = new FadeTransition(Duration.seconds(1), petD);
		f3.setFromValue(0.0);
		f3.setToValue(1.0);

		TranslateTransition t4 = new TranslateTransition();
		t4.setDuration(Duration.seconds(1));
		t4.setNode(petH);
		t4.setToX(-10);
		FadeTransition f4 = new FadeTransition(Duration.seconds(1), petH);
		f4.setFromValue(0.0);
		f4.setToValue(1.0);

		TranslateTransition t5 = new TranslateTransition();
		t5.setDuration(Duration.seconds(1));
		t5.setNode(petF);
		t5.setToX(-10);
		FadeTransition f5 = new FadeTransition(Duration.seconds(1), petF);
		f5.setFromValue(0.0);
		f5.setToValue(1.0);

		TranslateTransition t6 = new TranslateTransition();
		t6.setDuration(Duration.seconds(1));
		t6.setNode(petHgry);
		t6.setToX(-10);
		FadeTransition f6 = new FadeTransition(Duration.seconds(1), petHgry);
		f6.setFromValue(0.0);
		f6.setToValue(1.0);

		ParallelTransition p = new ParallelTransition(t1, f1, t2, f2, t3, f3, t4, f4, t5, f5, t6, f6);
		p.play();

		return grid;
	}
	
	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	public Button getCurrentAnimalBtn() {
		return currentAnimalBtn;
	}

	public void setCurrentAnimalBtn(Button currentAnimalBtn) {
		this.currentAnimalBtn = currentAnimalBtn;
	}

	public int getCurrentAnimalId() {
		return currentAnimalId;
	}

	public void setCurrentAnimalId(int currentAnimalId) {
		this.currentAnimalId = currentAnimalId;
	}

	public AnimalDetails(DataService dataService, User currentUser, List<Animal> animalList, Button currentAnimalBtn,
			int currentAnimalId) {
		super();
		this.dataService = dataService;
		this.currentUser = currentUser;
		this.animalList = animalList;
		this.currentAnimalBtn = currentAnimalBtn;
		this.currentAnimalId = currentAnimalId;
	}

	public int getButtonsSize() {
		return sizeX;
	}

	public void setButtonsSize(int buttonsSize) {
		this.sizeX = buttonsSize;
	}

}
