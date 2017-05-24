
public class Program {

	public static void main(String[] args) {

		SQL connServer = new SQL();
		connServer.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Damian; password=Worrior");

		DataContext mama2 = new DataContext();
		DataRepository tata2 = new DataRepository(mama2);
		DataService dziadek2 = new DataService(tata2);

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
