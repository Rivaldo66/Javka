package Logical_Layer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data_Layer.Action;
import Data_Layer.Animal;
import Data_Layer.Dictionary;
import Data_Layer.DictionaryStaff;
import Data_Layer.User;

public class DataService {

	public DataRepository getDataRepository() {
		return dataRepository;
	}

	DataRepository dataRepository;

	public DataService(DataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}

	// --------------------------------------------SignIn--------------------------------------------//

	public Boolean CheckSignIn(String login, String password) {

		if (dataRepository.GetUser(login) == null) {
			return false;
		} else {
			if (dataRepository.GetUser(login).getPassword().matches(password)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public User Login(String login) {
		return dataRepository.GetUser(login);
	}

	// --------------------------------------------SignUp--------------------------------------------//

	public Boolean CheckSignUp(String login) {

		if (dataRepository.GetUser(login) == null) {
			return false;
		} else {
			return true;
		}
	}

	public void AddUser(User user) {

		dataRepository.AddUser(user);
	}

	// ----------------------------------------ShowingAnimals----------------------------------------//

	public List<Animal> GetAnimalsByUser(User user) {

		return dataRepository.GetAnimalByUser(user);
	}

	// ------------------------------------ShowingDictionaryStaff------------------------------------//

	public List<DictionaryStaff> GetTypeOfDictionaryStaffByDictionary(Dictionary dictionary, String type) {

		List<DictionaryStaff> list = new ArrayList<DictionaryStaff>();
		List<DictionaryStaff> list1 = new ArrayList<DictionaryStaff>();

		list = dataRepository.GetDictionaryStaffByDictionary(dictionary);

		for (DictionaryStaff i : list) {
			if (i.getType().matches(type)) {
				list1.add(i);
			}
		}

		return list1;
	}

	// ------------------------------------------ShowImage-------------------------------------------//

	public String ShowImageByAnimalID(String animal_txt) {

		return dataRepository.GetDictionary(dataRepository.GetAnimal(Integer.valueOf(animal_txt)).getType().getName())
				.getImage();
	}

	public void Eating(Animal animal, DictionaryStaff dictionaryStaff) {

		float hunger = animal.getLevelOfHunger();

		if (hunger <= 75) {
			animal.setLevelOfHunger(25);
			animal.setExperience(animal.getExperience() + 50);
			dataRepository.AddAction(new Action(animal, dictionaryStaff));
		} else {
			if (hunger <= 100) {
				animal.setLevelOfHunger(100);
				animal.setExperience(animal.getExperience() + 50);
				dataRepository.AddAction(new Action(animal, dictionaryStaff));
			} else {
				System.out.println("Twój zwiekrzak jest ju¿ wybawiony");
			}
		}

		dataRepository.UpdateAnimal(animal);
	}

	// -------------------------------------------Playing--------------------------------------------//

	public void Playing(Animal animal, DictionaryStaff dictionaryStaff) {

		float play = animal.getLevelOfFunNeeded();

		if (play <= 75) {
			animal.setLevelOfFunNeeded(25);
			animal.setExperience(animal.getExperience() + 50);
			dataRepository.AddAction(new Action(animal, dictionaryStaff));
		} else {
			if (play <= 100) {
				animal.setLevelOfFunNeeded(100);
				animal.setExperience(animal.getExperience() + 50);
				dataRepository.AddAction(new Action(animal, dictionaryStaff));
			} else {
				System.out.println("Twój zwiekrzak jest ju¿ najedzony");
			}
		}

		dataRepository.UpdateAnimal(animal);
	}

	// --------------------------------------------Curing--------------------------------------------//

	public void Curing(Animal animal, DictionaryStaff dictionaryStaff) {

		float hp = animal.getHp();

		if (hp <= 75) {
			animal.setHp(25);
			animal.setExperience(animal.getExperience() + 50);
			dataRepository.AddAction(new Action(animal, dictionaryStaff));
		} else {
			if (hp <= 100) {
				animal.setHp(100);
				animal.setExperience(animal.getExperience() + 50);
				dataRepository.AddAction(new Action(animal, dictionaryStaff));
			} else {
				System.out.println("Twój zwiekrzak jest ju¿ zdrowy");
			}
		}

		dataRepository.UpdateAnimal(animal);
	}

	// -------------

	public List<Dictionary> GetAllDictionaries() {

		return dataRepository.GetAllDictionaries();
	}

	public DictionaryStaff GetDictionaryStaffByName(String name, List<DictionaryStaff> list) {

		DictionaryStaff dictionaryStaff = null;

		for (DictionaryStaff d : list) {
			if (d.getName().matches(name)) {
				dictionaryStaff = d;
			}
		}

		return dictionaryStaff;
	}

	public void Serialization() throws FileNotFoundException {

		String nazwaPliku = "User.xml";
		String nazwaPliku1 = "Dictionary.xml";
		String nazwaPliku2 = "DictionaryStaff.xml";
		String nazwaPliku3 = "Animal.xml";
		String nazwaPliku4 = "Action.xml";

		XMLEncoder user = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nazwaPliku)));

		user.writeObject(dataRepository.GetAllUsers());

		XMLEncoder dictionary = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nazwaPliku1)));

		for (Dictionary d : dataRepository.GetAllDictionaries()) {
			dictionary.writeObject(d);
		}

		XMLEncoder dictionaryStaff = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nazwaPliku2)));

		for (DictionaryStaff ds : dataRepository.GetAllDictionaryStaffs()) {
			dictionaryStaff.writeObject(ds);
		}

		XMLEncoder animal = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nazwaPliku3)));

		for (Animal a : dataRepository.GetAllAnimals()) {
			animal.writeObject(a);
		}

		XMLEncoder action = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nazwaPliku4)));

		for (Action ac : dataRepository.GetAllActions()) {
			action.writeObject(ac);
		}

		user.close();
		dictionary.close();
		dictionaryStaff.close();
		animal.close();
		action.close();
	}

	public void Deserialization() throws FileNotFoundException {

		String nazwaPliku = "User.xml";
		String nazwaPliku1 = "Dictionary.xml";
		String nazwaPliku2 = "DictionaryStaff.xml";
		String nazwaPliku3 = "Animal.xml";
		String nazwaPliku4 = "Action.xml";

		XMLDecoder user = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) user.readObject()) {
			dataRepository.AddUser(u);
		}
		user.close();

		XMLDecoder dictionary = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) dictionary.readObject()) {
			dataRepository.AddUser(u);
		}
		dictionary.close();

		XMLDecoder dictionaryStaff = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) dictionaryStaff.readObject()) {
			dataRepository.AddUser(u);
		}
		dictionaryStaff.close();

		XMLDecoder animal = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) animal.readObject()) {
			dataRepository.AddUser(u);
		}
		animal.close();

		XMLDecoder action = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) action.readObject()) {
			dataRepository.AddUser(u);
		}
		action.close();
	}
}
