
public class Program {

	public static void main(String[] args) {
		
		System.out.println("Jeba� biede, elo");
		
		SQL connServer = new SQL();
	      connServer.dbConnect("jdbc:sqlserver://localhost:1433", "Pawel",
	               "mama");
	}

}
