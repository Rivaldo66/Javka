package Data_Layer;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Klasa odpowiedzialna za przetrzymywanie i organizacje danych zwi�zanych ze zwierzakiem 
 *
 * @author Damian Rudnicki i Pawe� Tomaszewski
 *
 */
@DatabaseTable(tableName = "Animal")
public class Animal {

	@DatabaseField(generatedId = true)
	int animalID;

	@DatabaseField(canBeNull = false)
	String name;

	@DatabaseField(canBeNull = false, foreign = true)
	Dictionary type;
	
	@DatabaseField(canBeNull = false, foreign = true)
	User user;

	@DatabaseField(canBeNull = false)
	float age;

	@DatabaseField(canBeNull = false)
	float experience;

	@DatabaseField(canBeNull = false)
	Date dateAdded = new Date();
	
	@DatabaseField(canBeNull = false)
	float hp;
	
	@DatabaseField(canBeNull = false)
	float levelOfHunger;
	
	@DatabaseField(canBeNull = false)
	float levelOfFunNeeded;
	
	@DatabaseField(canBeNull = false)
	boolean status;

	public Animal() {
	}

	public Animal(String name, Dictionary type, User user) {
		super();
		this.name = name;
		this.type = type;
		this.user = user;
		this.age = 1;
		this.experience = 0;
		this.hp = 100;
		this.levelOfHunger = 50;			
		this.levelOfFunNeeded = 50;	
		this.status = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dictionary getType() {
		return type;
	}

	public void setType(Dictionary type) {
		this.type = type;
	}

	public float getAge() {
		return age;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setAge(float age) {
		this.age = this.age + age;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public float getHp() {
		return hp;
	}

	public void addHp(float hp) {
		this.hp = this.hp + hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}
	public float getLevelOfHunger() {
		return levelOfHunger;
	}

	public void setLevelOfHunger(float levelOfHunger) {
		this.levelOfHunger = levelOfHunger;
	}
	
	public void addLevelOfHunger(float levelOfHunger) {
		this.levelOfHunger = this.levelOfHunger + levelOfHunger;
	}

	public float getLevelOfFunNeeded() {
		return levelOfFunNeeded;
	}

	public void setLevelOfFunNeeded(float levelOfFunNeeded) {
		this.levelOfFunNeeded = levelOfFunNeeded;
	}
	
	public void addLevelOfFunNeeded(float levelOfFunNeeded) {
		this.levelOfFunNeeded = this.levelOfFunNeeded + levelOfFunNeeded;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAnimalID() {
		return animalID;
	}
	
}
