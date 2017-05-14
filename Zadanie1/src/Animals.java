import java.util.ArrayList;
import java.util.Date;

public class Animals {
	
	String name;
	float age;
	float weight;
	float experience;
	float hp;
	float levelOfHunger;
	Date dateAdded = new Date();
	
	ArrayList<String> food;
	ArrayList<String> play;
	ArrayList<String> treatment;

	public Animals(String name, float age, float weight, float experience, float hp, float levelOfHunger) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.experience = experience;
		this.hp = hp;
		this.levelOfHunger = levelOfHunger;
	}	
}
