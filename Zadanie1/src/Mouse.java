
public class Mouse extends Animal{

	public Mouse(String name) {
		super(name);
		
		this.food.add("karma");
		this.food.add("ser");
		this.food.add("siano");
		
		this.play.add("g³askanie");
		this.play.add("ko³owrotek");
		this.play.add("zabawa w chowanego");
		
		this.treatment.add("szczepienie");
		this.treatment.add("mycie zêbów");
		this.treatment.add("czesanie");
		
		this.weight = 0.58;
	}
}