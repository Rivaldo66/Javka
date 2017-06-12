package Logical_Layer;

import java.util.ArrayList;
import java.util.List;

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
	
	public Boolean CheckSignIn(String login, String password){
		
		if(dataRepository.GetUser(login)==null){
			return false; 
		}
		else{
			if(dataRepository.GetUser(login).getPassword()==password){
				return true;
			}
			else{
				return true;
			}
		}
	}
	
	public User Login(String login){
		return dataRepository.GetUser(login);
	}
	
	// --------------------------------------------SignUp--------------------------------------------//
	
	public Boolean CheckSignUp(String login){
		
		if(dataRepository.GetUser(login)==null){
			return false; 
		}
		else{
			return true;
		}
	}
	
	public void AddUser(User user){
		
		dataRepository.AddUser(user);
	}
	
	// ----------------------------------------ShowingAnimals----------------------------------------//
	
	public List<Animal> GetAnimalsByUser(User user){
		
		return dataRepository.GetAnimalByUser(user);
	}
	
	// -----------------------------------------ShowingFood------------------------------------------//
	
	public List<DictionaryStaff> GetFoodByDictionary(Dictionary dictionary){
		
		List<DictionaryStaff> list = new ArrayList<DictionaryStaff>();
		List<DictionaryStaff> list1 = new ArrayList<DictionaryStaff>();
		
		list = dataRepository.GetDictionaryStaffByDictionary(dictionary);
		
		for(DictionaryStaff i : list){
			if(i.getType()=="Food"){
				list1.add(i);
			}
		}
		
		return list1;	
	}
}
