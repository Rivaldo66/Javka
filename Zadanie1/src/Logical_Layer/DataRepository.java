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

public class DataRepository {

	SQL database;

	public DataRepository(SQL database) {

		this.database = database;
	}

	// ---------------------------------------------User---------------------------------------------//

	public void AddUser(User user) {

		try {
			database.getUserDao().create(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateUser(User user) {

		try {
			database.getUserDao().update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<User> GetAllUsers() {

		List<User> users = new ArrayList<User>();

		try {
			users = database.getUserDao().queryForAll();
		} catch (SQLException e) {
			users = null;
		}

		return users;
	}

	public void DeleteUser(User user) {

		try {
			database.getUserDao().delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public void AddAnimal(Animal animal) {

		try {
			database.getAnimalDao().create(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateAnimal(Animal animal) {

		try {
			database.getAnimalDao().update(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Animal> GetAllAnimals() {

		List<Animal> animals = new ArrayList<Animal>();

		try {
			animals = database.getAnimalDao().queryForAll();
		} catch (SQLException e) {
			animals = null;
		}

		return animals;
	}

	public void DeleteAnimal(Animal animal) {

		try {
			database.getAnimalDao().delete(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public void AddNewAnimal(Dictionary dictionary) {

		try {
			database.getDictionaryDao().create(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> GetAllSpecies() {

		List<String> list = new ArrayList<String>();

		try {
			for(Dictionary i : database.getDictionaryDao().queryForAll()){
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

	public void UpdateDictionary(Dictionary dictionary) {

		try {
			database.getDictionaryDao().update(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Dictionary> GetAllDictionaries() {

		List<Dictionary> dictionaries = new ArrayList<Dictionary>();

		try {
			dictionaries = database.getDictionaryDao().queryForAll();
		} catch (SQLException e) {
			dictionaries = null;
		}

		return dictionaries;
	}

	public void DeleteDictionary(Dictionary dictionary) {

		try {
			database.getDictionaryDao().delete(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public void AddAction(Action action) {

		try {
			database.getActionDao().create(action);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Action> GetAllActions() {

		List<Action> actions = new ArrayList<Action>();

		try {
			actions = database.getActionDao().queryForAll();
		} catch (SQLException e) {
			actions = null;
		}

		return actions;
	}

	public void DeleteAction(Action action) {

		try {
			database.getActionDao().delete(action);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public List<Action> GetActionsByAnimal(Animal animal) {

		List<Action> actions = new ArrayList<Action>();

		try {
			database.getActionBuilder().where().like("animal", animal);
			actions = database.getActionDao().query(database.getActionBuilder().prepare());
		} catch (SQLException e) {
			actions = null;
		}

		return actions;
	}

	// ----------------------------------------DictionaryStaff-----------------------------------------//

	public void AddDictionaryStaff(DictionaryStaff dictionaryStaff) {

		try {
			database.getDictionaryStaffDao().create(dictionaryStaff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateDictionaryStaff(DictionaryStaff dictionaryStaff) {

		try {
			database.getDictionaryStaffDao().update(dictionaryStaff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<DictionaryStaff> GetAllDictionaryStaffs() {

		List<DictionaryStaff> dictionaryStaffs = new ArrayList<DictionaryStaff>();

		try {
			dictionaryStaffs = database.getDictionaryStaffDao().queryForAll();
		} catch (SQLException e) {
			dictionaryStaffs = null;
		}

		return dictionaryStaffs;
	}

	public void DeleteDictionaryStaff(DictionaryStaff dictionaryStaff) {

		try {
			database.getDictionaryStaffDao().delete(dictionaryStaff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DictionaryStaff GetDictionaryStaff(int dictionaryStaffID) {

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
	
	public List<DictionaryStaff> GetFoodByDictionary(Dictionary dictionary) {

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
