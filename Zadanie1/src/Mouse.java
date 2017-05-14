
public class Mouse extends Animals{

	public Mouse(String name, float age, float weight, float experience, float hp, float levelOfHunger) {
		super(name, age, weight, experience, hp, levelOfHunger);
		
		this.food.add("karma");
		this.food.add("ser");
		this.food.add("siano");
		
		this.play.add("g³askanie");
		this.play.add("ko³owrotek");
		this.play.add("zabawa w chowanego");
		
		this.treatment.add("szczepienie");
		this.treatment.add("mycie zêbów");
		this.treatment.add("czesanie");
	}
}