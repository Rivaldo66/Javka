
public class DataRepository {
	
	DataContext database;

	public DataRepository(DataContext database) {
		
		this.database = database;
	}
	
	//---------------------------------------------User---------------------------------------------//
	
	public void AddNewNormalUser(String login, String password){
		
		database.users.add(new NormalUser(login, password));
	}
	
	public void RemoveNormalUser(NormalUser normalUser){
		
		database.users.remove(normalUser);
	}

	public User GetUser(int index){
		
		return database.users.get(index);
	}
}
