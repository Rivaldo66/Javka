import java.util.ArrayList;
import java.util.List;

import Data_Layer.DictionaryStaff;
import Data_Layer.SQL;
import Logical_Layer.DataRepository;
import Logical_Layer.DataService;
import Presentation_Layer.LOG;
import javafx.application.Application;


public class Program  {
	

	public static void main(String[] args) {
		SQL sql = new SQL();
		//sql.dbConnect(
				 //"jdbc:sqlserver://localhost\\sqlexpress:1433;database=Tamagotchi; user=Pawel; password=mama");
		sql.dbConnect(
				 "jdbc:sqlserver://localhost\\sqlexpress:1433; database=Tamagotchi; user=Damian; password=Worrior");
		DataRepository dataRepository = new DataRepository(sql);
		DataService dataService = new DataService(dataRepository);
		List<String> list1 = new ArrayList<String>();
		
		System.out.println(dataRepository.GetDictionary("Pies").getImage());
	
		Application.launch(LOG.class, args);
	}
}
