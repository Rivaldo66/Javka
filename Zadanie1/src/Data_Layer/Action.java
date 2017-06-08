package Data_Layer;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Action")
public class Action {

	@DatabaseField(generatedId = true)
	int actionID;
	
	@DatabaseField(canBeNull = false, foreign = true)
	User user;
	
	@DatabaseField(canBeNull = false, foreign = true)
	Animal animal;
	
	@DatabaseField(canBeNull = false, foreign = true)
	DictionaryStaff dictionaryStaff;
	
	@DatabaseField(canBeNull = false)
	Date dateAdded = new Date();

	public Action(User user, Animal animal, DictionaryStaff dictionaryStaff) {
		super();
		this.user = user;
		this.animal = animal;
		this.dictionaryStaff = dictionaryStaff;
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
	

	public DictionaryStaff getDictionaryStaff() {
		return dictionaryStaff;
	}

	public void setDictionaryStaff(DictionaryStaff dictionaryStaff) {
		this.dictionaryStaff = dictionaryStaff;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}
