
public class Rabbit extends Animals{

	public Rabbit(String name, float age, float weight, float experience, float hp, float levelOfHunger) {
		super(name, age, weight, experience, hp, levelOfHunger);
		
		this.food.add("karma");
		this.food.add("siano");
		this.food.add("marchewka");
		
		this.play.add("g�askanie");
		this.play.add("tor przeszk�d");
		this.play.add("zabawa w ogr�dku");
		
		this.treatment.add("szczepienie");
		this.treatment.add("mycie z�b�w");
		this.treatment.add("czesanie");
	}
}