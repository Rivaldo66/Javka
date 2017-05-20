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
		this.levelOfFunNeeded = 1;
	}	
}
