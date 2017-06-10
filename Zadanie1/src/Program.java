import Data_Layer.SQL;
import Presentation_Layer.LOG;
import javafx.application.Application;


public class Program  {
	
	private static SQL sql;

	public static void main(String[] args) {

		sql = new SQL();
		//sql.dbConnect(
				//"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Pawel; password=mama");
		sql.dbConnect(
				"jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Damian; password=Worrior");

		Application.launch(LOG.class, args);
	}
}
