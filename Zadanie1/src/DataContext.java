import java.util.ArrayList;
import java.util.HashMap;

public class DataContext {

	ArrayList<User> users;
	HashMap<String, HashMap<String, ArrayList<String>>> dictionary;

	public DataContext() {

		this.users = new ArrayList<User>();
		this.dictionary = new HashMap<String, HashMap<String, ArrayList<String>>>();

		this.dictionary.put("Pies", Mapa(Lista("karma", "mi�so", "kie�basa"),
				Lista("spacer", "aportowanie", "gumowa ko��"), Lista("szczepienie", "odrobaczanie", "czesanie")));
		this.dictionary.put("Kot", Mapa(Lista("karma", "mleko", "ryba"), Lista("g�askanie", "�apanie myszy", "drapak"),
				Lista("szczepienie", "odrobaczanie", "czesanie")));
		this.dictionary.put("Kr�lik",
				Mapa(Lista("karma", "siano", "marchewka"), Lista("g�askanie", "zabawa w ogr�dku", "zabawa w chowanego"),
						Lista("szczepienie", "mycie z�b�w", "czesanie")));
		this.dictionary.put("Mysz",
				Mapa(Lista("karma", "ser", "siano"), Lista("g�askanie", "zabawa w chowanego", "ko�owrotek"),
						Lista("szczepienie", "mycie z�b�w", "czesanie")));
	}

	ArrayList<String> Lista(String jeden, String dwa, String trzy) {

		ArrayList<String> listaa = new ArrayList<String>();

		listaa.add(jeden);
		listaa.add(dwa);
		listaa.add(trzy);

		return listaa;
	}

	HashMap<String, ArrayList<String>> Mapa(ArrayList<String> lista, ArrayList<String> lista1,
			ArrayList<String> lista2) {

		HashMap<String, ArrayList<String>> slownik = new HashMap<String, ArrayList<String>>();

		slownik.put("Pokarm", lista);
		slownik.put("Zabawy", lista1);
		slownik.put("Zabiegi", lista2);

		return slownik;
	}
}
