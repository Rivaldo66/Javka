
public class Admin extends User{

	String permissionLevel;
	
	public Admin(String login, String password, String permissionLevel) {
		super(login, password);
		
		this.permissionLevel = permissionLevel;
	}	
}
