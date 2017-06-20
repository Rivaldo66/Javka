package Data_Layer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Klasa odpowiedzialna za przetrzymywanie i organizacje danych zwi¹zanych z mo¿liwymi do wykonania akcjami na zierzaku danego gatunku
 *
 * @author Damian Rudnicki i Pawe³ Tomaszewski
 *
 */
@DatabaseTable(tableName = "DictionaryStaff")
public class DictionaryStaff {
	@DatabaseField(id = true)
	String dictionaryStaffID;
	
	@DatabaseField(canBeNull = false, foreign = true)
	Dictionary dictionary;
	
	@DatabaseField(canBeNull = false)
	String type;

	@DatabaseField(canBeNull = false)
	String name;

	public DictionaryStaff(Dictionary dictionary, String type, String name) {
		super();
		this.dictionary = dictionary;
		this.type = type;
		this.name = name;
		this.dictionaryStaffID = dictionary.getName()+"_"+name;
	}
	
	public DictionaryStaff(){
		
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDictionaryStaffID() {
		return dictionaryStaffID;
	}

	public void setDictionaryStaffID(String dictionaryStaffID) {
		this.dictionaryStaffID = dictionaryStaffID;
	}
}
