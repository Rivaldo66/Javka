
public class DataService {

	DataRepository repository;
		
	public DataService(DataRepository repository) {
		
		this.repository = repository;
	}
	
	public void BawSie(Animal animal, String typZabawy){
		
		animal.setLevelOfFunNeeded(100);
	}
	
	public void Zabieg(Animal animal, String typZabiegu){
		
		animal.setHp(100);
	}
	
	public void Karm(Animal animal, String typZabawy){
		
		animal.setLevelOfHunger(100);
	}
		
}
