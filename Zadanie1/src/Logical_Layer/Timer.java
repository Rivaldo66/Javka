package Logical_Layer;

import java.util.ArrayList;
import java.util.List;

import Data_Layer.Animal;
import Data_Layer.User;
import Presentation_Layer.AnimalDetails;
import Presentation_Layer.GAME;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Timer extends Thread {

	private DataService dataService;
	private User currentUser;
	private List<Animal> animalList = new ArrayList<Animal>();
	private Button currentAnimalBtn;
	private int currentAnimalId;
	private int licznik;
	private GAME game;
	private BorderPane gridCenter;
	private AnimalDetails animalDetails;

	public void run() {
		while (true) {
			try {
				for (Animal i : animalList) {
					if ((i.getHp()) >= 5)
						i.setHp(-5);
					if ((i.getLevelOfFunNeeded()) >= 5)
						i.setLevelOfFunNeeded(-5);
					if ((i.getLevelOfHunger()) >= 5)
						i.setLevelOfHunger(-5);
					if ((licznik % 5) == 0) {
						i.setAge(1);
					}
					dataService.getDataRepository().UpdateAnimal(i);
					animalDetails.setPetH(Float.toString(i.getHp()));
					animalDetails.setPetHgry(Float.toString(i.getLevelOfHunger()));
					animalDetails.setPetF(Float.toString(i.getLevelOfFunNeeded()));

					licznik = licznik + 1;
				}
				Timer.sleep(5000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Timer(DataService dataService, User currentUser, List<Animal> animalList, Button currentAnimalBtn,
			int currentAnimalId, GAME game, BorderPane gridCenter, AnimalDetails animalDetails) {
		super();
		this.dataService = dataService;
		this.currentUser = currentUser;
		this.animalList = animalList;
		this.currentAnimalBtn = currentAnimalBtn;
		this.currentAnimalId = currentAnimalId;
		this.gridCenter = gridCenter;
		this.game = game;
		this.animalDetails = animalDetails;
		this.licznik = 0;
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

	public int getLicznik() {
		return licznik;
	}

	public void setLicznik(int licznik) {
		this.licznik = licznik;
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

	public BorderPane getGridCenter() {
		return gridCenter;
	}

	public void setGridCenter(BorderPane gridCenter) {
		this.gridCenter = gridCenter;
	}

	public GAME getGame() {
		return game;
	}

	public void setGame(GAME game) {
		this.game = game;
	}
}
