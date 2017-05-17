import java.util.ArrayList;

public class NormalUser extends User {

	ArrayList<Animal> animals;

	public NormalUser(String login, String password, String permissionLevel) {
		super(login, password, permissionLevel);
		
		this.animals = new ArrayList<Animal>();
	}		
}
