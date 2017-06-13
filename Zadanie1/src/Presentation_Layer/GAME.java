package Presentation_Layer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Data_Layer.Animal;
import Data_Layer.Dictionary;
import Data_Layer.DictionaryStaff;
import Data_Layer.User;
import Logical_Layer.DataService;
import Logical_Layer.Timer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GAME extends Application {

	private DataService dataService;
	private User currentUser;
	private List<Animal> animalList = new ArrayList<Animal>();
	private Button currentAnimalBtn;
	private int currentAnimalId;
	private AnimalDetails animalDetails;

	@FXML
	private BorderPane border;
	@FXML
	private GridPane gridRight;
	@FXML
	private BorderPane gridCenter;
	@FXML
	private Label petSpecies;
	@FXML
	private Text scenetitle;
	@FXML
	private Label petName;
	@FXML
	private TextField userTextField;
	@FXML
	private Button btn;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button food;
	@FXML
	private Button treatment;
	@FXML
	private Button play;
	@FXML
	private Scene scene;
	@FXML
	private ChoiceBox<String> species;

	public GAME(DataService dataService, User user) {
		this.dataService = dataService;
		this.currentUser = user;
		this.animalList = dataService.GetAnimalsByUser(user);
		this.animalDetails = new AnimalDetails(dataService, currentUser, animalList, currentAnimalBtn, currentAnimalId);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("GAME PANEL");
		border = new BorderPane();
		border.setStyle("-fx-background-color: #336699;");

		border.setCenter(addBorderPaneCenter(primaryStage));
		border.setRight(addGridPaneRight(primaryStage));

		Thread t1 = new Thread(new Timer(this.dataService, this.currentUser, this.animalList, this.currentAnimalBtn,
				this.currentAnimalId, this, this.animalDetails));
		t1.setDaemon(true);
		t1.start();

		scene = new Scene(border, 900, 552);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public BorderPane getGridCenter() {
		return gridCenter;
	}

	public void setGridCenter(BorderPane gridCenter) {
		this.gridCenter = gridCenter;
	}

	public HBox addAnimals(Stage primaryStage) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		List<Button> animalsBtn = new ArrayList<Button>();

		for (Animal i : animalList) {
			if (i.getStatus()) {
				animalsBtn.add(new Button(Integer.toString(i.getAnimalID())));
			}
		}
		for (Button i : animalsBtn) {
			i.setPrefSize(150, 150);

			i.setStyle("-fx-background-color: transparent;" + "-fx-border: false;" + "-fx-background-image: url('"
					+ dataService.ShowImageByAnimalID(i.getText()) + "');" + "-fx-background-size: cover;");

			i.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					setCurrentAnimalBtn(i);
					setCurrentAnimalId(i.getText());
					gridCenter.setCenter(addAnimalsTools());
					AnimalDetails animalDetails = new AnimalDetails(dataService, currentUser, animalList,
							currentAnimalBtn, currentAnimalId);
					try {
						animalDetails.start(primaryStage);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		hbox.getChildren().addAll(animalsBtn);

		return hbox;
	}
	
	public HBox addAnimalButtons(Stage primaryStage) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		List<Button> animalsBtn = new ArrayList<Button>();
		
		for (Dictionary i : dataService.GetAllDictionaries()) {

			animalsBtn.add(new Button(i.getName()));
		}
		for (Button i : animalsBtn) {
			i.setPrefSize(100, 20);

			i.setStyle("-fx-background-color: #336699;");

			i.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					for(Animal a : animalList){
						if(a.getType().getName().matches(i.getText())){
							gridCenter.setCenter(addDictionaryStaffButtons(dataService.getDataRepository().GetDictionary(i.getText())));
						}
					}
				}
			});
		}
		hbox.getChildren().addAll(animalsBtn);

		return hbox;
	}
	
	public HBox addDictionaryStaffButtons(Dictionary dictionary) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		play = new Button("Play");
		play.setPrefSize(100, 20);
		play.setStyle("-fx-background-color: #336699;");

		play.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				gridCenter.setCenter(addFoodButton(dataService.GetTypeOfDictionaryStaffByDictionary(dictionary, "Play"), dictionary));
			}
		});

		treatment = new Button("Treatment");
		treatment.setPrefSize(100, 20);
		treatment.setStyle("-fx-background-color: #336699;");

		treatment.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				gridCenter.setCenter(addFoodButton(dataService.GetTypeOfDictionaryStaffByDictionary(dictionary, "Treatment"), dictionary));
			}
		});

		food = new Button("Food");
		food.setPrefSize(100, 20);
		food.setStyle("-fx-background-color: #336699;");

		food.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				gridCenter.setCenter(addFoodButton(dataService.GetTypeOfDictionaryStaffByDictionary(dictionary, "Food"), dictionary));
			}
		});

		hbox.getChildren().addAll(play, food, treatment);
		
		return hbox;
	}

	public HBox addFoodButton(List<DictionaryStaff> list, Dictionary dictionary) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		List<Button> animalsBtn = new ArrayList<Button>();
		
		for (DictionaryStaff i : list) {

			animalsBtn.add(new Button(i.getName()));
		}
		for (Button i : animalsBtn) {
			i.setPrefSize(100, 20);

			i.setStyle("-fx-background-color: #336699;");

			i.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					for(Animal a : animalList){
						if(a.getType().getName().matches(dictionary.getName())){
							dataService.Eating(a, dataService.GetDictionaryStaffByName(i.getText(), list));
						}
					}
				}
			});
		}
		hbox.getChildren().addAll(animalsBtn);

		return hbox;
	}
	
	public HBox addPlayButton(List<DictionaryStaff> list, Dictionary dictionary) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		List<Button> animalsBtn = new ArrayList<Button>();
		
		for (DictionaryStaff i : list) {

			animalsBtn.add(new Button(i.getName()));
		}
		for (Button i : animalsBtn) {
			i.setPrefSize(100, 20);

			i.setStyle("-fx-background-color: #336699;");

			i.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					for(Animal a : animalList){
						if(a.getType().getName().matches(dictionary.getName())){
							dataService.Playing(a, dataService.GetDictionaryStaffByName(i.getText(), list));
						}
					}
				}
			});
		}
		hbox.getChildren().addAll(animalsBtn);

		return hbox;
	}
	
	public HBox addTreatmentButton(List<DictionaryStaff> list, Dictionary dictionary) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		List<Button> animalsBtn = new ArrayList<Button>();
		
		for (DictionaryStaff i : list) {

			animalsBtn.add(new Button(i.getName()));
		}
		for (Button i : animalsBtn) {
			i.setPrefSize(100, 20);

			i.setStyle("-fx-background-color: #336699;");

			i.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					for(Animal a : animalList){
						if(a.getType().getName().matches(dictionary.getName())){
							dataService.Curing(a, dataService.GetDictionaryStaffByName(i.getText(), list));
						}
					}
				}
			});
		}
		hbox.getChildren().addAll(animalsBtn);

		return hbox;
	}
	
	public HBox addAnimalsTools() {

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		play = new Button("Play");
		play.setPrefSize(100, 20);
		play.setStyle("-fx-background-color: #336699;");

		play.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				Animal current = dataService.getDataRepository().GetAnimal(currentAnimalId);
				current.setLevelOfFunNeeded(-10);
				dataService.getDataRepository().UpdateAnimal(current);
			}
		});

		treatment = new Button("Treatment");
		treatment.setPrefSize(100, 20);
		treatment.setStyle("-fx-background-color: #336699;");

		treatment.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				Animal current = dataService.getDataRepository().GetAnimal(currentAnimalId);
				current.setHp(10);
				dataService.getDataRepository().UpdateAnimal(current);
			}
		});

		food = new Button("Food");
		food.setPrefSize(100, 20);
		food.setStyle("-fx-background-color: #336699;");

		food.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				Animal current = dataService.getDataRepository().GetAnimal(currentAnimalId);
				current.setLevelOfHunger(-10);
				dataService.getDataRepository().UpdateAnimal(current);
			}
		});

		hbox.getChildren().addAll(play, food, treatment);

		return hbox;
	}

	public BorderPane addBorderPaneCenter(Stage primaryStage) {
		gridCenter = new BorderPane();
		gridCenter.setStyle(
				"-fx-background-image: url('https://s-media-cache-ak0.pinimg.com/736x/5f/74/e6/5f74e63976b7657a209488ee7a200ded.jpg')");

		gridCenter.setBottom(addAnimals(primaryStage));
		gridCenter.setTop(addAnimalButtons(primaryStage));

		return gridCenter;
	}

	public BorderPane addGridPaneRight(Stage primaryStage) {
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(0, 10, 0, 10));
		border.setStyle("-fx-background-color: #336699;");
		
		gridRight = new GridPane();
		gridRight.setHgap(10);
		gridRight.setVgap(10);
		gridRight.setPadding(new Insets(0, 10, 0, 10));
		gridRight.setStyle("-fx-background-color: #336699;");
		
		GridPane gridC = new GridPane();
		gridC.setHgap(10);
		gridC.setVgap(10);
		gridC.setPadding(new Insets(0, 10, 0, 10));
		gridC.setStyle("-fx-background-color: #336699;");

		scenetitle = new Text("Add new pet");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		scenetitle.setFill(Color.WHITE);
		gridRight.add(scenetitle, 0, 0, 2, 1);

		petName = new Label("Name:");
		petName.setPrefSize(100, 20);
		petName.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petName.setTextFill(Color.WHITE);
		gridRight.add(petName, 0, 1);

		userTextField = new TextField();
		userTextField.setPrefSize(100, 20);
		gridRight.add(userTextField, 1, 1);

		petSpecies = new Label("Species:");
		petSpecies.setPrefSize(100, 20);
		petSpecies.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 15));
		petSpecies.setTextFill(Color.WHITE);
		gridRight.add(petSpecies, 0, 2);

		species = new ChoiceBox<String>();
		species.setPrefSize(100, 20);
		species.getItems().addAll(dataService.getDataRepository().GetAllSpecies());
		gridRight.add(species, 1, 2);

		btn = new Button("Add");
		btn.setPrefSize(100, 20);
		gridRight.add(btn, 1, 3);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				if (!species.getValue().isEmpty()) {
					Dictionary dic = new Dictionary(species.getValue());
					Animal newAnimal = new Animal(userTextField.getText(), dic, currentUser);

					dataService.getDataRepository().AddAnimal(newAnimal);
					animalList.add(newAnimal);
					border.setCenter(addBorderPaneCenter(primaryStage));
				} else {

				}
			}
		});
		
		btn1 = new Button("Log out");
		btn1.setPrefSize(100, 20);
		gridC.add(btn1, 0, 0);

		btn1.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				LOG log = new LOG();
				log.start(primaryStage);
			}
		});
		
		btn2 = new Button("Turn off");
		btn2.setPrefSize(100, 20);
		gridC.add(btn2, 0, 1);

		btn2.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				primaryStage.close();
			}
		});

		btn3 = new Button("Serialization");
		btn3.setPrefSize(100, 20);
		gridC.add(btn3, 0, 2);

		btn3.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				try {
					dataService.Serialization();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btn4 = new Button("Deserialization");
		btn4.setPrefSize(100, 20);
		gridC.add(btn4, 0, 3);

		btn4.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				try {
					dataService.Deserialization();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		border.setTop(gridRight);
		gridC.setAlignment(Pos.CENTER);
		border.setCenter(gridC);
		return border;
	}

	public Text getScenetitle() {
		return scenetitle;
	}

	public void setScenetitle(Text scenetitle) {
		this.scenetitle = scenetitle;
	}

	public Label getPetName() {
		return petName;
	}

	public void setPetName(Label userName) {
		this.petName = userName;
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(TextField userTextField) {
		this.userTextField = userTextField;
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

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	public int getCurrentAnimalId() {
		return currentAnimalId;
	}

	public void setCurrentAnimalId(String string) {
		this.currentAnimalId = Integer.parseInt(string);
	}

	public Button getCurrentAnimalBtn() {
		return currentAnimalBtn;
	}

	public void setCurrentAnimalBtn(Button currentAnimalBtn) {
		this.currentAnimalBtn = currentAnimalBtn;
	}

}
