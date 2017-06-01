package Data_Layer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Dictionary")
public class Dictionary {
	
	@DatabaseField(id = true)
	String name;

	public Dictionary(String name) {
		super();
		this.name = name;
	}
	
	public Dictionary(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
