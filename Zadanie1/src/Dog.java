
public class Dog extends Animals{

	public Dog(String name, float age, float weight, float experience, float hp, float levelOfHunger) {
		super(name, age, weight, experience, hp, levelOfHunger);
		
		this.food.add("karma");
		this.food.add("miêso");
		this.food.add("kie³basa");
		
		this.play.add("spacer");
		this.play.add("aportowanie");
		this.play.add("gumowa koœc");
		
		this.treatment.add("szczepienie");
		this.treatment.add("odrobaczanie");
		this.treatment.add("czesanie");
	}
}
