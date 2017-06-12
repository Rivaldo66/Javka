package Logical_Layer;

import java.util.ArrayList;
import java.util.List;

import Data_Layer.Animal;
import Data_Layer.User;

public class Timer extends Thread {

	private DataService dataService;
	private User currentUser;
	private List<Animal> animalList = new ArrayList<Animal>();

	public void run() {
		while(true){
			try {
				for(Animal i : animalList){
					i.setHp(-5);
					i.setLevelOfFunNeeded(5);
					i.setLevelOfHunger(5);
					System.out.println("zmnniejszylem staty dla:"+i.getAnimalID());
				}
				Timer.sleep(5000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Timer(DataService dataService, User currentUser, List<Animal> animalList) {
		super();
		this.dataService = dataService;
		this.currentUser = currentUser;
		this.animalList = animalList;
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
}
