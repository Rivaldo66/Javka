import Data_Layer.SQL;
import Logical_Layer.DataRepository;
import Logical_Layer.DataService;
import Logical_Layer.LogControler;
import Presentation_Layer.GAME;
import Presentation_Layer.GUI;
import Presentation_Layer.LOG;

public class Program {

	public static void main(String[] args) {

		SQL connServer = new SQL();
		//connServer.dbConnect(
				//"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Pawel; password=mama");
		connServer.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Damian; password=Worrior");

		DataRepository tata2 = new DataRepository(connServer);
		DataService mama2 = new DataService(tata2);
		LogControler checkLog = new LogControler(tata2, new LOG(), new GAME());
		
		GUI gra = new GUI();
		gra.runLogFrame();
		
		gra.runRejestrFrame();
		
		gra.runGameFrame();
	}

}
