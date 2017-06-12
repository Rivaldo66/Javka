package Presentation_Layer;

import java.util.ArrayList;
import java.util.List;

import Data_Layer.Animal;
import Data_Layer.User;
import Logical_Layer.DataService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnimalDetails extends Application {

	private DataService dataService;
	private User currentUser;
	private List<Animal> animalList = new ArrayList<Animal>();
	private Button currentAnimalBtn;
	private int currentAnimalId;

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("DETAILS PANEL");
		BorderPane border = new BorderPane();
		border.setStyle("-fx-background-color: #336699;");

		border.setCenter(addGridPaneCenter(primaryStage));

		Scene scene = new Scene(border, 900, 552);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public GridPane addGridPaneCenter(Stage primaryStage) {
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
		petName.setPrefSize(100, 20);
		petName.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petName.setTextFill(Color.WHITE);
		grid.add(petName, 0, 1);

		Label petN = new Label(dataService.getDataRepository().GetAnimal(currentAnimalId).getName());
		petN.setPrefSize(100, 20);
		petN.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petN.setTextFill(Color.WHITE);
		grid.add(petN, 1, 1);

		Label petSpecies = new Label("Species:");
		petSpecies.setPrefSize(100, 20);
		petSpecies.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petSpecies.setTextFill(Color.WHITE);
		grid.add(petSpecies, 0, 2);

		Label petS = new Label(dataService.getDataRepository().GetAnimal(currentAnimalId).getType().getName());
		petS.setPrefSize(100, 20);
		petS.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petS.setTextFill(Color.WHITE);
		grid.add(petS, 1, 2);

		Button btn = new Button("Back");
		btn.setPrefSize(100, 20);
		grid.add(btn, 1, 3);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				GAME game = new GAME(dataService, currentUser);
				game.start(primaryStage);
			}
		});

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

}
