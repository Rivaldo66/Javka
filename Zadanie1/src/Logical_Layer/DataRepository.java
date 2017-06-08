package Logical_Layer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data_Layer.Action;
import Data_Layer.Animal;
import Data_Layer.Dictionary;
import Data_Layer.SQL;
import Data_Layer.User;

public class DataRepository {

	SQL database;

	public DataRepository(SQL database) {

		this.database = database;
	}

	// ---------------------------------------------User---------------------------------------------//

	public DataRepository() {
	}

	public void AddUser(User user){
		
		try {
			database.getUserDao().create(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateUser(User user){
		
		try {
			database.getUserDao().update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<User> GetAllUsers(){
		
		List<User> users = new ArrayList<User>();
		
		try {
			users = database.getUserDao().queryForAll();
		} catch (SQLException e) {
			users = null;
		}
		
		return users;
	}
	
	public void DeleteUser(User user){
		
		try {
			database.getUserDao().delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User GetUser(String login){
		
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

	public void AddAnimal(Animal animal){
		
		try {
			database.getAnimalDao().create(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateAnimal(Animal animal){
		
		try {
			database.getAnimalDao().update(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Animal> GetAllAnimals(){
		
		List<Animal> animals = new ArrayList<Animal>();
		
		try {
			animals = database.getAnimalDao().queryForAll();
		} catch (SQLException e) {
			animals = null;
		}
		
		return animals;
	}
	
	public void DeleteAnimal(Animal animal){
		
		try {
			database.getAnimalDao().delete(animal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Animal GetAnimal(int idAnimal){
		
		Animal animal = null;
		
		try {
			database.getAnimalBuilder().where().like("idAnimal", idAnimal);
			animal = database.getAnimalDao().query(database.getAnimalBuilder().prepare()).get(0);
		} catch (SQLException e) {
			animal = null;
		}
		
		return animal;
	}
	
	// ------------------------------------------Dictionary------------------------------------------//

	public void AddNewAnimal(Dictionary dictionary){
		
		try {
			database.getDictionaryDao().create(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateDictionary(Dictionary dictionary){
		
		try {
			database.getDictionaryDao().update(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Dictionary> GetAllDictionaries(){
		
		List<Dictionary> dictionaries = new ArrayList<Dictionary>();
		
		try {
			dictionaries = database.getDictionaryDao().queryForAll();
		} catch (SQLException e) {
			dictionaries = null;
		}
		
		return dictionaries;
	}
	
	public void DeleteDictionary(Dictionary dictionary){
		
		try {
			database.getDictionaryDao().delete(dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Dictionary GetDictionary(String name){
		
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

	public void AddAction(Action action){
		
		try {
			database.getActionDao().create(action);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Action> GetAllActions(){
		
		List<Action> actions = new ArrayList<Action>();
		
		try {
			actions = database.getActionDao().queryForAll();
		} catch (SQLException e) {
			actions = null;
		}
		
		return actions;
	}
	
	public void DeleteAction(Action action){
		
		try {
			database.getActionDao().delete(action);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Action GetAction(int idAction){
		
		Action action = null;
		
		try {
			database.getActionBuilder().where().like("idAction", idAction);
			action = database.getActionDao().query(database.getActionBuilder().prepare()).get(0);
		} catch (SQLException e) {
			action = null;
		}
		
		return action;
	}
}
