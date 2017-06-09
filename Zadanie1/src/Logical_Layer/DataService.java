package Logical_Layer;

import Data_Layer.User;

public class DataService {
	
	DataRepository dataRepository;

	public DataService(DataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}
	
	public Boolean CheckLogin(String login, String password){
		
		if(dataRepository.GetUser(login)==null){
			return false; 
		}
		else{
			if(dataRepository.GetUser(login).getPassword()==password){
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
}
