package Logical_Layer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data_Layer.Action;
import Data_Layer.Animal;
import Data_Layer.Dictionary;
import Data_Layer.DictionaryStaff;
import Data_Layer.SQL;
import Data_Layer.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Klasa odpowiedzialna za operacje typu CRUD na bazie danych
 *
 * @author Damian Rudnicki i Pawe³ Tomaszewski
 *
 */
public class DataRepository {

	SQL database;

	public DataRepository(SQL database) {

		this.database = database;
	}

	// ---------------------------------------------User---------------------------------------------//

	/**
	 * Metoda odpowiedzialna za dodanie nowego u¿ytkownika do bazy danych
	 * 
	 * @param user
	 *            - objekt przechowywuj¹cy u¿ytkownika który ma zostaæ dodany do
	 *            bazy danych
	 */
	public void AddUser(User user) {

		try {
			database.getUserDao().create(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda odpowiedzialna za uaktualnienie obecnie istniej¹cego u¿ytkownika
	 * 
	 * @param user
	 *            - objekt przechowywuj¹cy zaktualizowanego u¿ytkownika
	 */
	public void UpdateUser(User user) {

		try {
			database.getUserDao().update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca wszystkich u¿ytkowników znajduj¹cych siê w bazie danych
	 * 
	 * @return - zwraca wszystkich u¿ytkowników
	 */
	public List<User> GetAllUsers() {

		List<User> users = new ArrayList<User>();

		try {
			users = database.getUserDao().queryForAll();
		} catch (SQLException e) {
			users = null;
		}

		return users;
	}

	/**
	 * Metoda usuwaj¹ca u¿ytkownika z bazy danych
	 * 
	 * @param user
	 *            - u¿ytkownik który ma zostac usuniêty
	 */
	public void DeleteUser(User user) {

		try {
			database.getUserDao().delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹cym obiekt u¿ytkownika o odpowiednim loginie
	 * 
	 * @param login
	 *            - login szukanego u¿ytkownika
	 * 
	 * @return - zwraca szukanego u¿ytkownika
	 */
	public User GetUser(String login) {

		User user = null;

		try {
			database.getUserBuilder().where().like("login", login);
			user = database.getUserDao().query(database.getUserBuilder().prepare()).get(0);

		} catch (Exception e) {
			user = null;
		}

		return user;
	}

	// --------------------------------------------Animal--------------------------------------------//

	/**
	 * Metoda odpowiedzialna za dodanie nowego zwierzaka do bazy danych
	 * 
	 * @param animal
	 *            - obiket pupila który ma zostac dodany
	 */
	public void AddAnimal(Animal animal) {

		try {
			database.getAnimalDao().create(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda odpowiedzialna za uaktualnienie obecnie istniej¹cego zwierzaka
	 * 
	 * @param animal
	 *            - objekt przechowywuj¹cy zaktualizowanego zwierzaka
	 */
	public void UpdateAnimal(Animal animal) {

		try {
			database.getAnimalDao().update(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca wszystkie zwierzaki znajduj¹ce siê w bazie danych
	 * 
	 * @return - zwraca wszystkie zwierzaki
	 */
	public List<Animal> GetAllAnimals() {

		List<Animal> animals = new ArrayList<Animal>();

		try {
			animals = database.getAnimalDao().queryForAll();
		} catch (SQLException e) {
			animals = null;
		}

		return animals;
	}

	/**
	 * Metoda usuwaj¹ca zwierzaka z bazy danych
	 * 
	 * @param animal
	 *            - zwierzak który ma zostaæ usuniêty
	 */
	public void DeleteAnimal(Animal animal) {

		try {
			database.getAnimalDao().delete(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹cym obiekt zwierzaka o odpowiednim numerze ID
	 * 
	 * @param animalID
	 *            - unikalny numer poszukiwanego zwierzaka
	 * 
	 * @return - zwraca szukanego zwierzaka
	 */
	public Animal GetAnimal(int animalID) {

		Animal animal = null;

		try {
			database.getAnimalBuilder().where().like("animalID", animalID);
			animal = database.getAnimalDao().query(database.getAnimalBuilder().prepare()).get(0);
		} catch (SQLException e) {
			animal = null;
		}

		return animal;
	}

	/**
	 * Metoda zwracaj¹ca wszystkie zwierzaki nale¿¹ce do danego u¿ytkownika
	 * 
	 * @param user
	 *            - obiekt u¿ytkownika którego s¹ dane zwierzêta
	 * 
	 * @return - zwraca liste zwierzaków które nale¿¹ do danego u¿ytkownika
	 */
	public List<Animal> GetAnimalByUser(User user) {

		List<Animal> animals = new ArrayList<Animal>();

		try {
			database.getAnimalBuilder().where().like("user_id", user);
			animals = database.getAnimalDao().query(database.getAnimalBuilder().prepare());
		} catch (SQLException e) {
			animals = null;
		}

		return animals;
	}

	// ------------------------------------------Dictionary------------------------------------------//

	/**
	 * Metoda odpowiedzialna za dodanie nowego gatunku do bazy danych
	 * 
	 * @param dictionary
	 *            - obiekt gatunku który ma zostac dodany
	 */
	public void AddNewAnimal(Dictionary dictionary) {

		try {
			database.getDictionaryDao().create(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca wszystkie nazwy gatunków znajduj¹cych siê w bazie
	 * danych
	 * 
	 * @return - zwraca liste wszystkich nazw gatunków
	 */
	public List<String> GetAllSpecies() {

		List<String> list = new ArrayList<String>();

		try {
			for (Dictionary i : database.getDictionaryDao().queryForAll()) {
				list.add(i.getName());
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list = null;
			return list;
		}
	}

	/**
	 * Metoda odpowiedzialna za uaktualnienie obecnie istniej¹cego gatunku
	 * 
	 * @param dictionary
	 *            - obiekt przechowywuj¹cy uaktualniony gatunek
	 */
	public void UpdateDictionary(Dictionary dictionary) {

		try {
			database.getDictionaryDao().update(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca wszystkie gatunki znajduj¹ce siê w bazie danych
	 * 
	 * @return - zwraca liste wszystkich gatunków
	 */
	public List<Dictionary> GetAllDictionaries() {

		List<Dictionary> dictionaries = new ArrayList<Dictionary>();

		try {
			dictionaries = database.getDictionaryDao().queryForAll();
		} catch (SQLException e) {
			dictionaries = null;
		}

		return dictionaries;
	}

	/**
	 * Metoda usuwaj¹ca gatunek z bazy danych
	 * 
	 * @param dictionary
	 *            - gatunek który ma zostac usuniêty
	 */
	public void DeleteDictionary(Dictionary dictionary) {

		try {
			database.getDictionaryDao().delete(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca gatunek o odpowiedniej nazwie
	 * 
	 * @param name
	 *            - nazwa gatunku
	 * 
	 * @return - zwraca szukany gatunek
	 */
	public Dictionary GetDictionary(String name) {

		Dictionary dictionary = null;

		try {
			database.getDictionaryBuilder().where().like("name", name);
			dictionary = database.getDictionaryDao().query(database.getDictionaryBuilder().prepare()).get(0);
		} catch (SQLException e) {
			dictionary = null;
		}

		return dictionary;
	}

	// --------------------------------------------Action--------------------------------------------//

	/**
	 * Metoda odpowiedzialna za dodanie nowej akcji do bazy danych
	 * 
	 * @param action
	 *            - obiekt akcji która ma zostaæ dodana
	 */
	public void AddAction(Action action) {

		try {
			database.getActionDao().create(action);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca wszystkie akcje znajduj¹ce siê w bazie danych
	 * 
	 * @return - zwraca liste wszystkich akcji
	 */
	public List<Action> GetAllActions() {

		List<Action> actions = new ArrayList<Action>();

		try {
			actions = database.getActionDao().queryForAll();
		} catch (SQLException e) {
			actions = null;
		}

		return actions;
	}

	/**
	 * Metoda zwracaj¹ca akcje o odpowiednim ID
	 * 
	 * @param actionID
	 *            - unikalne ID akcji
	 * 
	 * @return - zwraca szukan¹ akcje
	 */
	public Action GetAction(int actionID) {

		Action action = null;

		try {
			database.getActionBuilder().where().like("idAction", actionID);
			action = database.getActionDao().query(database.getActionBuilder().prepare()).get(0);
		} catch (SQLException e) {
			action = null;
		}

		return action;
	}

	/**
	 * Metoda zwracaj¹ca wszystkie akcje dla danego zwierzaka
	 * 
	 * @param animalId
	 *            - unikalne ID zwierzaka dla którego szukamy akcji
	 * 
	 * @return - zwraca liste szukanych akcji
	 */
	public List<Action> GetActionsByAnimal(int animalId) {

		List<Action> actions = new ArrayList<Action>();

		try {
			database.getActionBuilder().where().like("animal_id", animalId);
			actions = database.getActionDao().query(database.getActionBuilder().prepare());
		} catch (SQLException e) {
			actions = null;
		}

		return actions;
	}

	// ----------------------------------------DictionaryStaff-----------------------------------------//

	/**
	 * Metoda odpowiedzialna za dodanie nowej akcji dla zwierzaka do bazy danych
	 * 
	 * @param dictionaryStaff
	 *            - objekt akcji dla zwierzaka która ma zostaæ dodana
	 */
	public void AddDictionaryStaff(DictionaryStaff dictionaryStaff) {

		try {
			database.getDictionaryStaffDao().create(dictionaryStaff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda odpowiedzialna za uaktualnienie obecnie istniej¹cej akcji
	 * zwierzaka
	 * 
	 * @param dictionaryStaff
	 *            - objekt przechowywuj¹cy uaktualnion¹ akcje dla zwierzaka
	 */
	public void UpdateDictionaryStaff(DictionaryStaff dictionaryStaff) {

		try {
			database.getDictionaryStaffDao().update(dictionaryStaff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca wszystkie akcje zwierzaka znajduj¹ce siê w bazie danych
	 * 
	 * @return - zwraca liste wszystkich akcji
	 */
	public List<DictionaryStaff> GetAllDictionaryStaffs() {

		List<DictionaryStaff> dictionaryStaffs = new ArrayList<DictionaryStaff>();

		try {
			dictionaryStaffs = database.getDictionaryStaffDao().queryForAll();
		} catch (SQLException e) {
			dictionaryStaffs = null;
		}

		return dictionaryStaffs;
	}

	/**
	 * Metoda usuwaj¹ca akcje z bazy danych
	 * 
	 * @param dictionaryStaff
	 *            - akcja zwierzaka która ma zostaæ usuniêta
	 */
	public void DeleteDictionaryStaff(DictionaryStaff dictionaryStaff) {

		try {
			database.getDictionaryStaffDao().delete(dictionaryStaff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwracaj¹ca akcje dla zwierzaka o odpowiednim ID
	 * 
	 * @param dictionaryStaffID
	 *            - unikalne ID akcji zwierzaka
	 * 
	 * @return - zwraca szukan¹ akcje zwierzaka
	 */
	public DictionaryStaff GetDictionaryStaff(String dictionaryStaffID) {

		DictionaryStaff dictionaryStaff = null;

		try {
			database.getDictionaryStaffBuilder().where().like("dictionaryStaffID", dictionaryStaffID);
			dictionaryStaff = database.getDictionaryStaffDao().query(database.getDictionaryStaffBuilder().prepare())
					.get(0);

		} catch (Exception e) {
			dictionaryStaff = null;
		}

		return dictionaryStaff;
	}

	/**
	 * Metoda zwracaj¹ca liste akcji dla danego gatunku
	 * 
	 * @param dictionary
	 *            - unikalna nazwa gatunku dla którego poszukujemy akcji
	 * 
	 * @return - zwraca liste odpowiednich akcji zwierzaka
	 */
	public List<DictionaryStaff> GetDictionaryStaffByDictionary(Dictionary dictionary) {

		List<DictionaryStaff> dictionaryStaffs = new ArrayList<DictionaryStaff>();

		try {
			database.getDictionaryStaffBuilder().where().like("dictionary_id", dictionary);
			dictionaryStaffs = database.getDictionaryStaffDao().query(database.getDictionaryStaffBuilder().prepare());
		} catch (SQLException e) {
			dictionaryStaffs = null;
		}

		return dictionaryStaffs;
	}
}
