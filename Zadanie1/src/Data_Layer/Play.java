package Data_Layer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Play")
public class Play {
	
	@DatabaseField(generatedId = true)
	int idFood;
	
	@DatabaseField(canBeNull = false, foreign = true)
	Dictionary dictionary;

	@DatabaseField(canBeNull = false)
	String name;

	public Play(Dictionary dictionary, String name) {
		super();
		this.dictionary = dictionary;
		this.name = name;
	}
	
	public Play(){
		
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
}
