package Data_Layer;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Action")
public class Action {

	@DatabaseField(generatedId = true)
	int idAction;
	
	@DatabaseField(canBeNull = false, foreign = true)
	User user;
	
	@DatabaseField(canBeNull = false, foreign = true)
	Animal animal;
	
	@DatabaseField(canBeNull = false)
	String typeOfAction;
	
	@DatabaseField(canBeNull = false)
	String action;
	
	@DatabaseField(canBeNull = false)
	Date dateAdded = new Date();

	public Action(User user, Animal animal, String typeOfAction, String action) {
		super();
		this.user = user;
		this.animal = animal;
		this.action = action;
		this.typeOfAction = typeOfAction;
	}

	public Action(){
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getAkcja() {
		return action;
	}

	public void setAkcja(String akcja) {
		this.action = akcja;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}
