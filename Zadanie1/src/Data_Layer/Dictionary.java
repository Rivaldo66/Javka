package Data_Layer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Klasa odpowiedzialna za przetrzymywanie i organizacje danych zwi�zanych z
 * rodzajami gatunk�w naszych zwierzak�w
 *
 * @author Damian Rudnicki i Pawe� Tomaszewski
 *
 */
@DatabaseTable(tableName = "Dictionary")
public class Dictionary {

	@DatabaseField(id = true)
	String name;

	@DatabaseField(canBeNull = false)
	String image;

	public Dictionary(String name) {
		super();
		this.name = name;
		this.image = "https://www.cbdzoe.pl/img/artykuly/mowa-ciala-pies.png";
	}

	public Dictionary() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
