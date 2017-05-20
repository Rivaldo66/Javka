import java.util.Date;

public class Animal {

	String name;
	String type;
	float age;
	float experience;
	float hp;
	float levelOfHunger;
	float levelOfFunNeeded;
	Date dateAdded = new Date();

	public Animal(String name, String type) {
		super();
		this.name = name;
		this.type = type;
		this.age = 1;
		this.experience = 0;
		this.hp = 100;
		this.levelOfHunger = 100;
		this.levelOfFunNeeded = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
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

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getLevelOfHunger() {
		return levelOfHunger;
	}

	public void setLevelOfHunger(float levelOfHunger) {
		this.levelOfHunger = levelOfHunger;
	}

	public float getLevelOfFunNeeded() {
		return levelOfFunNeeded;
	}

	public void setLevelOfFunNeeded(float levelOfFunNeeded) {
		this.levelOfFunNeeded = levelOfFunNeeded;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

}
