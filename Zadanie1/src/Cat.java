
public class Cat extends Animals{

	public Cat(String name, float age, float weight, float experience, float hp, float levelOfHunger) {
		super(name, age, weight, experience, hp, levelOfHunger);
		
		this.food.add("karma");
		this.food.add("mleko");
		this.food.add("kryba");
		
		this.play.add("g³askanie");
		this.play.add("³apanie myszy");
		this.play.add("drapak");
		
		this.treatment.add("szczepienie");
		this.treatment.add("odrobaczanie");
		this.treatment.add("czesanie");
	}
}