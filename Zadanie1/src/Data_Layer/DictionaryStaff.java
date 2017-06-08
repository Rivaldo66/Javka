package Data_Layer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "DictionaryStaff")
public class DictionaryStaff {
	@DatabaseField(generatedId = true)
	int dictionaryStaffID;
	
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
}
