import Data_Layer.Animal;
import Data_Layer.SQL;
import Data_Layer.User;
import Logical_Layer.DataRepository;
import Presentation_Layer.GUI;

public class Program {

	public static void main(String[] args) {

		SQL connServer = new SQL();
		connServer.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Pawel; password=mama");

		DataRepository tata2 = new DataRepository(connServer);
		
		Animal animal = null;
		
		animal = tata2.GetAnimal(4);
		
		System.out.println(animal.getName());
		
		GUI gra = new GUI();
		gra.runLogFrame();
		
		
		gra.runGameFrame();
	}

}
