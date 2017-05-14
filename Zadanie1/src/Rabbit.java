
public class Rabbit extends Animal{

	public Rabbit(String name) {
		super(name);
		
		this.food.add("karma");
		this.food.add("siano");
		this.food.add("marchewka");
		
		this.play.add("g³askanie");
		this.play.add("tor przeszkód");
		this.play.add("zabawa w ogródku");
		
		this.treatment.add("szczepienie");
		this.treatment.add("mycie zêbów");
		this.treatment.add("czesanie");
		
		this.weight = 1.37;
	}
}