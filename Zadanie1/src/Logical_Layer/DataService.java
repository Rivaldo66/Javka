package Logical_Layer;

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
	
	public List<DictionaryStaff> GetTypeOfDictionaryStaffByDictionary(Dictionary dictionary, String type){
		
		List<DictionaryStaff> list = new ArrayList<DictionaryStaff>();
		List<DictionaryStaff> list1 = new ArrayList<DictionaryStaff>();
		
		list = dataRepository.GetDictionaryStaffByDictionary(dictionary);
		
		for(DictionaryStaff i : list){
			if(i.getType().matches(type)){
				list1.add(i);
			}
		}
		
		return list1;	
	}
	
	// ------------------------------------------ShowImage-------------------------------------------//
	
	public String ShowImageByAnimalID(String animal_txt){
		
		return dataRepository.GetDictionary(dataRepository.GetAnimal(Integer.valueOf(animal_txt)).getType().getName()).getImage();
	}
	
	public void Eating(Animal animal, DictionaryStaff dictionaryStaff){
		
		float hunger=animal.getLevelOfHunger();
		
		if(hunger<=75){
			animal.setLevelOfHunger(hunger-25);
			animal.setExperience(animal.getExperience()+50);
			dataRepository.AddAction(new Action(animal, dictionaryStaff));
		}else{
			if(hunger<=100){
				animal.setLevelOfHunger(100);
				animal.setExperience(animal.getExperience()+50);
				dataRepository.AddAction(new Action(animal, dictionaryStaff));
			}
			else{
				System.out.println("Twój zwiekrzak jest ju¿ wybawiony");
			}
		}
		
		dataRepository.UpdateAnimal(animal);
	}
	
	// -------------------------------------------Playing--------------------------------------------//
	
	public void Playing(Animal animal, DictionaryStaff dictionaryStaff){
		
		float play=animal.getLevelOfFunNeeded();
		
		if(play<=75){
			animal.setLevelOfFunNeeded(play-25);
			animal.setExperience(animal.getExperience()+50);
			dataRepository.AddAction(new Action(animal, dictionaryStaff));
		}else{
			if(play<=100){
				animal.setLevelOfFunNeeded(100);
				animal.setExperience(animal.getExperience()+50);
				dataRepository.AddAction(new Action(animal, dictionaryStaff));
			}
			else{
				System.out.println("Twój zwiekrzak jest ju¿ najedzony");
			}
		}
		
		dataRepository.UpdateAnimal(animal);
	}
	
	// --------------------------------------------Curing--------------------------------------------//
	
	public void Curing(Animal animal, DictionaryStaff dictionaryStaff){
			
			float hp=animal.getHp();
			
			if(hp<=75){
				animal.setHp(animal.getHp()-75);
				animal.setExperience(animal.getExperience()+50);
				dataRepository.AddAction(new Action(animal, dictionaryStaff));
			}else{
				if(hp<=100){
					animal.setHp(100);
					animal.setExperience(animal.getExperience()+50);
					dataRepository.AddAction(new Action(animal, dictionaryStaff));
				}
				else{
					System.out.println("Twój zwiekrzak jest ju¿ zdrowy");
				}
			}
			
			dataRepository.UpdateAnimal(animal);
		}
}
