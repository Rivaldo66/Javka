
public class Program {

	public static void main(String[] args) {
		
		System.out.println("Jebaæ biede, elo, elo2");
		
		SQL connServer = new SQL();
	      connServer.dbConnect("jdbc:sqlserver://localhost:1433", "Damian",
	               "Worrior");
	      //connServer.dbConnect("jdbc:sqlserver://localhost:1433", "Pawel",
	               //"mama");
	      
	    DataContext mama2 = new DataContext();
	    
	    System.out.println(mama2.dictionary.get("Pies").get("Pokarm").get(0));
	}

}
