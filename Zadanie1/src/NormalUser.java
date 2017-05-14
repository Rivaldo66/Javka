import java.util.ArrayList;

public class NormalUser extends User {

	ArrayList<Animal> animals;

	public NormalUser(String login, String password) {
		super(login, password);
		
		this.animals = new ArrayList<Animal>();
	}		
}
