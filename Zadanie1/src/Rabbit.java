
public class Rabbit extends Animal{

	public Rabbit(String name) {
		super(name);
		
		this.food.add("karma");
		this.food.add("siano");
		this.food.add("marchewka");
		
		this.play.add("g�askanie");
		this.play.add("tor przeszk�d");
		this.play.add("zabawa w ogr�dku");
		
		this.treatment.add("szczepienie");
		this.treatment.add("mycie z�b�w");
		this.treatment.add("czesanie");
		
		this.weight = 1.37;
	}
}