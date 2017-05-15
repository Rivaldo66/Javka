
public class Cat extends Animal{

	public Cat(String name) {
		super(name);
		
		this.food.add("karma");
		this.food.add("mleko");
		this.food.add("ryba");
		
		this.play.add("g³askanie");
		this.play.add("³apanie myszy");
		this.play.add("drapak");
		
		this.treatment.add("szczepienie");
		this.treatment.add("odrobaczanie");
		this.treatment.add("czesanie");
		
		this.weight = 5.38;
	}
}