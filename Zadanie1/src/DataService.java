
public class DataService {

	DataRepository repository;

	public DataService(DataRepository repository) {

		this.repository = repository;
	}

	public void BawSie(Animal animal, String typZabawy) {

		repository.BawSie(animal, typZabawy);
	}

	public void Zabieg(Animal animal, String typZabiegu) {

		repository.Zabieg(animal, typZabiegu);
	}

	public void Nakarm(Animal animal, String typZabawy) {

		repository.Nakarm(animal, typZabawy);
	}

}
