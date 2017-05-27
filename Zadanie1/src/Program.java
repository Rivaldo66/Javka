import java.sql.SQLException;

public class Program {

	public static void main(String[] args) {

		SQL connServer = new SQL();
		connServer.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Pawel; password=mama");

		DataRepository tata2 = new DataRepository(connServer);
		
		GUI gra = new GUI();
		gra.runLogFrame();
		
		gra.runGameFrame();

		// System.out.println(mama2.dictionary.get("Pies").get("Pokarm").get(0));

		// String[] a = { "Koza", "Trawa", "Chrzan", "Ksiazki", "spacer",
		// "aportowanie", "gumowa koœæ", "szczepienie",
		// "mycie zêbów", "czesanie" };
		// tata2.AddNewAnimal(a);

		// System.out.println(mama2.dictionary.get("Koza"));

		// tata2.AddNewPokarm("Koza", "KurczakIKSDE");

		// System.out.println(mama2.dictionary.get("Koza"));
	}

}
