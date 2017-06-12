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
			if(dataRepository.GetUser(login).getPassword().matches(password)){
				return true;
			}
			else{
				return false;
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
	
	// ------------------------------------ShowingDictionaryStaff------------------------------------//
	
	public List<String> GetTypeOfDictionaryStaffByDictionary(Dictionary dictionary, String type){
		
		List<DictionaryStaff> list = new ArrayList<DictionaryStaff>();
		List<String> list1 = new ArrayList<String>();
		
		list = dataRepository.GetDictionaryStaffByDictionary(dictionary);
		
		for(DictionaryStaff i : list){
			if(i.getType().matches(type)){
				list1.add(i.getName());
			}
		}
		
		return list1;	
	}
	
	// ------------------------------------------ShowImage-------------------------------------------//
	
	public String ShowImageByAnimalID(String animal_txt){
		
		return dataRepository.GetDictionary(dataRepository.GetAnimal(Integer.valueOf(animal_txt)).getType().getName()).getImage();
	}
	
	// --------------------------------------------Eating--------------------------------------------//
	
	public void Eating(Animal animal){
		
		
	}
}
