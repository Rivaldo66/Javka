package Logical_Layer;

public class DataService {
	
	DataRepository dataRepository;

	public DataService(DataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}
	
	public String CheckLogin(String login, String password){
		
		if(dataRepository.GetUser(login)==null){
			return "Poda³eœ niepoprawny login"; 
		}
		else{
			if(dataRepository.GetUser(login).getPassword()==password){
				return "Logowanie";
			}
			else{
				return "Poda³eœ z³e has³o";
			}
		}
	}
}
