
public class DataRepository {
	
	DataContext database;

	public DataRepository(DataContext database) {
		
		this.database = database;
	}
	
	//---------------------------------------------User---------------------------------------------//
	
	public void AddNewNormalUser(User u, String login, String password, String permissionLevel){
		
		if(u.getPermissionLevel()=="admin"){
		database.users.add(new NormalUser(login, password, permissionLevel));
		}
	}
	
	public void RemoveNormalUser(User u, NormalUser normalUser){
		
		if(u.getPermissionLevel()=="admin"){
		database.users.remove(normalUser);
		}
	}

	public User GetUser(int index){
		
		return database.users.get(index);
	}
	
	public void AddNewAnimal(User u, String[] a){
		
		if(u.getPermissionLevel()=="admin"){
			database.dictionary.put(a[0], 
					database.Mapa(database.Lista(a[1], a[2], a[3]), 
					database.Lista(a[4], a[5], a[6]), 
					database.Lista(a[7], a[8], a[9])));
		}
	}
}