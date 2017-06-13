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

	public void run() {
		while (true) {
			try {
				for (Animal i : animalList) {
					if ((i.getHp()) >= 5)
						i.addHp(-5);
					if ((i.getLevelOfFunNeeded()) >= 5)
						i.addLevelOfFunNeeded(-5);
					if ((i.getLevelOfHunger()) >= 5)
						i.addLevelOfHunger(-5);
					if ((licznik % 5) == 0)
						i.setAge(1);
					if ((i.getHp()) == 0 || (i.getLevelOfFunNeeded()) == 0 || (i.getLevelOfHunger()) == 0)
						i.setStatus(false);

					dataService.getDataRepository().UpdateAnimal(i);
					licznik = licznik + 1;
				}

				Timer.sleep(25000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Timer(DataService dataService, User currentUser, List<Animal> animalList, Button currentAnimalBtn,
			int currentAnimalId, GAME game, AnimalDetails animalDetails) {
		super();
		this.dataService = dataService;
		this.currentUser = currentUser;
		this.animalList = animalList;
		this.currentAnimalBtn = currentAnimalBtn;
		this.currentAnimalId = currentAnimalId;
		this.game = game;
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

	public GAME getGame() {
		return game;
	}

	public void setGame(GAME game) {
		this.game = game;
	}
}
