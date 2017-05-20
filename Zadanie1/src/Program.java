
public class Program {

	public static void main(String[] args) {

		System.out.println("Jebaæ biede, elo");

		SQL connServer = new SQL();

		connServer.dbConnect("jdbc:sqlserver://localhost:1433", "Damian", "Worrior");
		//connServer.dbConnect("jdbc:sqlserver://localhost:1433", "Pawel", "mama");

		DataContext mama2 = new DataContext();
		DataRepository tata2 = new DataRepository(mama2);

		System.out.println(mama2.dictionary.get("Pies").get("Pokarm").get(0));

		String[] a = { "Koza", "Trawa", "Chrzan", "Ksiazki", "spacer", "aportowanie", "gumowa koœæ", "szczepienie",
				"mycie zêbów", "czesanie" };
		tata2.AddNewAnimal(a);

		System.out.println(mama2.dictionary.get("Koza"));

		tata2.AddNewPokarm("Koza", "KurczakIKSDE");

		System.out.println(mama2.dictionary.get("Koza"));
	}

}
