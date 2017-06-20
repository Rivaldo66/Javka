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

/**
 * Klasa odpowiedzialna za operacje potrzebne do odpowiedniego dzia³ania
 * aplikacji
 *
 * @author Damian Rudnicki i Pawe³ Tomaszewski
 *
 */
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

	/**
	 * Metoda sprawdzaj¹ca czy dany u¿ytkownik istnieje a jeœli tak to czy mo¿e
	 * siê zalogowaæ
	 * 
	 * @param login
	 *            - nazwa u¿ytkownika
	 * @param password
	 *            - has³o u¿ytkownika
	 * 
	 * @return - zwraca true jeœli u¿ytkownik mo¿e siê zalogowaæ i false jeœli
	 *         taka opercaja nie jest mo¿liwa
	 */
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

	/**
	 * Metoda zwracaj¹ca obiekt u¿ytkowinka o danej nazwie
	 * 
	 * @param login
	 *            - unikalna nazwa u¿ytkownika
	 * 
	 * @return - zwraca obiekt szukanego u¿ytkownika
	 */
	public User Login(String login) {
		return dataRepository.GetUser(login);
	}

	// --------------------------------------------SignUp--------------------------------------------//

	/**
	 * Metoda sprawdzaj¹ca czy u¿ytkownik o daym loginie istnieje
	 * 
	 * @param login
	 *            - nazwa u¿ytkownika
	 * 
	 * @return - zwraca false jeœli podany u¿ytkownik nie istenie i true jeœli
	 *         ju¿ istnieje
	 */
	public Boolean CheckSignUp(String login) {

		if (dataRepository.GetUser(login) == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Metoda odpowiedzialna za dodanie nowego u¿ytkownika
	 * 
	 * @param user
	 *            - obiekt nowego u¿ytkownika
	 */
	public void AddUser(User user) {

		dataRepository.AddUser(user);
	}

	// ----------------------------------------ShowingAnimals----------------------------------------//

	/**
	 * Metoda odpowiedzialna za zwrócenie listy zwierz¹t danego u¿ytkownika
	 * 
	 * @param user
	 *            - obiekt u¿ytkownika
	 * 
	 * @return - zwraca liste zwierz¹t które posiada dany u¿ytkownik
	 */
	public List<Animal> GetAnimalsByUser(User user) {

		return dataRepository.GetAnimalByUser(user);
	}

	// ------------------------------------ShowingDictionaryStaff------------------------------------//

	/**
	 * Metoda zwracaj¹ca liste akcji dla danego gatunku oraz odpowiedniego typu
	 * 
	 * @param dictionary
	 *            - obiekt gatunku
	 * @param type
	 *            - nazwa szukanego typu akcji
	 * 
	 * @return - zwraca liste akcji zwierzaka o odpowiednim typie
	 */
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

	/**
	 * Metoda zwracaj¹ca adres URL obrazka dla odpowiedniego gatunku
	 * 
	 * @param animal_txt
	 *            - unikalne ID zwierzaka
	 * 
	 * @return - zwraca adres URL
	 */
	public String ShowImageByAnimalID(String animal_txt) {

		return dataRepository.GetDictionary(dataRepository.GetAnimal(Integer.valueOf(animal_txt)).getType().getName())
				.getImage();
	}

	// ------------------------------------------Eating-------------------------------------------//
	/**
	 * Metoda odpowiedzialna za karmienie odpowiedniego zwierzaka oraz dodanie
	 * zwi¹zanej z t¹ operacj¹ akcji
	 * 
	 * @param animal
	 *            - obiekt zwierzaka który bêdzie karmiony
	 * @param dictionaryStaff
	 *            - obiekt akcji zwierzaka która zostanie wykonana
	 */
	public void Eating(Animal animal, DictionaryStaff dictionaryStaff) {

		float hunger = animal.getLevelOfHunger();

		if (hunger <= 75) {
			animal.addLevelOfHunger(25);
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

	/**
	 * Metoda odpowiedzialna za zabawe odpowiedniego zwierzaka oraz dodanie
	 * zwi¹zanej z t¹ operacj¹ akcji
	 * 
	 * @param animal
	 *            - obiekt zwierzaka który bêdzie siê bawiæ
	 * @param dictionaryStaff
	 *            - obiekt akcji zwierzaka która zostanie wykonana
	 */
	public void Playing(Animal animal, DictionaryStaff dictionaryStaff) {

		float play = animal.getLevelOfFunNeeded();

		if (play <= 75) {
			animal.addLevelOfFunNeeded(25);
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

	/**
	 * Metoda odpowiedzialna za leczenie odpowiedniego zwierzaka oraz dodanie
	 * zwi¹zanej z t¹ operacj¹ akcji
	 * 
	 * @param animal
	 *            - obiekt zwierzaka który bêdzie leczony
	 * @param dictionaryStaff
	 *            - obiekt akcji zwierzaka która bêdzie wykonana
	 */
	public void Curing(Animal animal, DictionaryStaff dictionaryStaff) {

		float hp = animal.getHp();

		if (hp <= 75) {
			animal.addHp(25);
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

	/**
	 * Metoda zwracaj¹ca wszystkie gatunki
	 * 
	 * @return - lista gatunków
	 */
	public List<Dictionary> GetAllDictionaries() {

		return dataRepository.GetAllDictionaries();
	}

	/**
	 * Metoda zwracaj¹ca obiekt akcji zwierzaka po nazwie
	 * 
	 * @param name
	 *            - nazwa akcji
	 * @param list
	 *            - lista akcji zwierzaka
	 * 
	 * @return - zwraca obiekt akcji zwierzaka
	 */
	public DictionaryStaff GetDictionaryStaffByName(String name, List<DictionaryStaff> list) {

		DictionaryStaff dictionaryStaff = null;

		for (DictionaryStaff d : list) {
			if (d.getName().matches(name)) {
				dictionaryStaff = d;
			}
		}

		return dictionaryStaff;
	}

	/**
	 * Metoda odpowiedzialna za wykonanie serializacji wszystkich obiektów
	 * znajduj¹cych siê w bazie danych
	 * 
	 * @throws FileNotFoundException
	 */
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

	/**
	 * Metoda odpowiedzialna za deserializacje
	 * 
	 * @throws FileNotFoundException
	 */
	public void Deserialization() throws FileNotFoundException {

		String nazwaPliku = "User.xml";
		String nazwaPliku1 = "Dictionary.xml";
		String nazwaPliku2 = "DictionaryStaff.xml";
		String nazwaPliku3 = "Animal.xml";
		String nazwaPliku4 = "Action.xml";

		XMLDecoder user = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) user.readObject()) {
			dataRepository.UpdateUser(u);
		}
		user.close();

		XMLDecoder dictionary = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) dictionary.readObject()) {
			dataRepository.UpdateUser(u);
		}
		dictionary.close();

		XMLDecoder dictionaryStaff = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) dictionaryStaff.readObject()) {
			dataRepository.UpdateUser(u);
		}
		dictionaryStaff.close();

		XMLDecoder animal = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) animal.readObject()) {
			dataRepository.UpdateUser(u);
		}
		animal.close();

		XMLDecoder action = new XMLDecoder(new BufferedInputStream(new FileInputStream(nazwaPliku)));

		for (User u : (List<User>) action.readObject()) {
			dataRepository.UpdateUser(u);
		}
		action.close();
	}
}
