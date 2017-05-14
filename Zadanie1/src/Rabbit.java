
public class Rabbit extends Animals{

	public Rabbit(String name, float age, float weight, float experience, float hp, float levelOfHunger) {
		super(name, age, weight, experience, hp, levelOfHunger);
		
		this.food.add("karma");
		this.food.add("siano");
		this.food.add("marchewka");
		
		this.play.add("g³askanie");
		this.play.add("tor przeszkód");
		this.play.add("zabawa w ogródku");
		
		this.treatment.add("szczepienie");
		this.treatment.add("mycie zêbów");
		this.treatment.add("czesanie");
	}
}