import java.util.ArrayList;
import java.util.Date;

public class Animal {
	
	String name;
	float age;
	double weight;
	float experience;
	float hp;
	float levelOfHunger;
	Date dateAdded = new Date();
	
	ArrayList<String> food;
	ArrayList<String> play;
	ArrayList<String> treatment;

	public Animal(String name) {
		super();
		this.name = name;
		this.age = 1;
		this.experience = 0;
		this.hp = 100;
		this.levelOfHunger = 100;
	}	
}
