package Presentation_Layer;

import Data_Layer.Action;
import Data_Layer.Dictionary;
import Data_Layer.DictionaryStaff;
import Data_Layer.User;
import Logical_Layer.DataService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminView extends Application {

	private DataService dataService;
	private BorderPane border;
	private GridPane gridCenter;
	private GridPane gridRight;
	private GridPane gridLeft;
	private GridPane gridTop;
	private String type;

	public AdminView(DataService dataService) {
		super();
		this.dataService = dataService;
		this.type = "start";
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("ADMIN PANEL");
		border = new BorderPane();
		border.setStyle("-fx-background-color: #336699;");

		border.setTop(addGridPaneTop(primaryStage));
		border.setCenter(addBorderPaneCenter(primaryStage));
		border.setRight(addGridPaneRight(primaryStage));
		border.setRight(addGridPaneLeft(primaryStage));

		Scene scene = new Scene(border, 900, 552);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public BorderPane addBorderPaneCenter(Stage primaryStage) {
		BorderPane gridBorderCenter = new BorderPane();
		gridBorderCenter.setStyle("-fx-background-color: #336699;");

		gridCenter = new GridPane();
		gridCenter.setStyle("-fx-background-color: #336699;");

		if (type.matches("start")) {
			ListView<String> list = new ListView<String>();
			ObservableList<User> users = FXCollections
					.observableArrayList(dataService.getDataRepository().GetAllUsers());
			ObservableList<String> usersNames = FXCollections.observableArrayList();

			for (User i : users) {
				usersNames.add(i.getLogin());
			}

			list.setItems(usersNames);
			gridCenter.add(list, 0, 2);
			
			ListView<String> list1 = new ListView<String>();
			ObservableList<Dictionary> dic = FXCollections
					.observableArrayList(dataService.getDataRepository().GetAllDictionaries());
			ObservableList<String> dictionary = FXCollections.observableArrayList();

			for (Dictionary i : dic) {
				dictionary.add(i.getName());
			}

			list1.setItems(dictionary);
			gridCenter.add(list1, 1, 2);
			
			ListView<String> list2 = new ListView<String>();
			ObservableList<Action> act = FXCollections
					.observableArrayList(dataService.getDataRepository().GetAllActions());
			ObservableList<String> action = FXCollections.observableArrayList();

			for (Action i : act) {
				action.add(i.toString());
			}

			list2.setItems(action);
			gridCenter.add(list2, 2, 2);
			gridCenter.setAlignment(Pos.CENTER);
		}

		if (type.matches("adduser")) {
			Label userName = new Label("User name:");
			userName.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
			userName.setTextFill(Color.WHITE);
			gridCenter.add(userName, 0, 1);

			TextField userTextField = new TextField();
			gridCenter.add(userTextField, 1, 1);

			Label pw = new Label("Password:");
			pw.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
			pw.setTextFill(Color.WHITE);
			gridCenter.add(pw, 0, 2);

			TextField userPwdField = new TextField();
			gridCenter.add(userPwdField, 1, 2);

			Button btn = new Button("Confrim");
			gridCenter.add(btn, 0, 3);

			btn.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					User newUser = new User();
					newUser.setLogin(userTextField.getText());
					newUser.setPassword(userPwdField.getText());
					newUser.setAdmin(false);
					dataService.AddUser(newUser);
					type = "start";
					start(primaryStage);
				}
			});
		}
		if (type.matches("addspecies")) {
			Label speciesName = new Label("Species name:");
			speciesName.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
			speciesName.setTextFill(Color.WHITE);
			gridCenter.add(speciesName, 0, 1);

			TextField speciesNamef = new TextField();
			gridCenter.add(speciesNamef, 1, 1);

			Label pw = new Label("Link to photo:");
			pw.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
			pw.setTextFill(Color.WHITE);
			gridCenter.add(pw, 0, 2);

			TextField link = new TextField();
			gridCenter.add(link, 1, 2);

			Button btn = new Button("Confrim");
			gridCenter.add(btn, 0, 3);

			btn.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					Dictionary dic = new Dictionary();
					dic.setName(speciesNamef.getText());
					dic.setImage(link.getText());
					dataService.getDataRepository().AddNewAnimal(dic);
					DictionaryStaff dicS = new DictionaryStaff();
					dicS.setDictionary(dic);
					type = "start";
					start(primaryStage);
				}
			});
		}

		gridBorderCenter.setCenter(gridCenter);
		return gridBorderCenter;
	}

	public GridPane addGridPaneTop(Stage primaryStage) {
		gridTop = new GridPane();
		gridTop.setStyle("-fx-background-color: #336699;");

		Text scenetitle = new Text("Admin view");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		scenetitle.setFill(Color.WHITE);
		gridTop.add(scenetitle, 0, 0);

		Button addNewUser = new Button("Add new user");
		addNewUser.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				type = "adduser";
				start(primaryStage);
			}
		});
		gridTop.add(addNewUser, 0, 1);

		Button addNewSpecies = new Button("Add new species");
		addNewSpecies.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				type = "addspecies";
				start(primaryStage);
			}
		});
		gridTop.add(addNewSpecies, 1, 1);
		
		Button addNewFood = new Button("Add new food");
		addNewFood.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				type = "addfood";
				start(primaryStage);
			}
		});
		gridTop.add(addNewFood, 2, 1);
		
		Button addNewTreat = new Button("Add new treatment");
		addNewTreat.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				type = "addtreat";
				start(primaryStage);
			}
		});
		gridTop.add(addNewTreat, 3, 1);

		Button addNewPlay = new Button("Add new play");
		addNewPlay.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				type = "addplay";
				start(primaryStage);
			}
		});
		gridTop.add(addNewPlay, 4, 1);
		
		return gridTop;
	}

	public GridPane addGridPaneRight(Stage primaryStage) {
		gridRight = new GridPane();
		gridRight.setHgap(10);
		gridRight.setVgap(10);
		gridRight.setPadding(new Insets(0, 10, 0, 10));
		gridRight.setStyle("-fx-background-color: #336699;");

		return gridRight;
	}

	public GridPane addGridPaneLeft(Stage primaryStage) {
		gridLeft = new GridPane();
		gridLeft.setHgap(10);
		gridLeft.setVgap(10);
		gridLeft.setPadding(new Insets(0, 10, 0, 10));
		gridLeft.setStyle("-fx-background-color: #336699;");

		return gridLeft;
	}

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

}
