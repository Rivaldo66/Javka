import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Dictionary")
public class Dictionary {
	
	@DatabaseField(id = true)
	String name;
	
	@DatabaseField(canBeNull = false)
	String food1;

	@DatabaseField(canBeNull = false)
	String food2;
	
	@DatabaseField(canBeNull = false)
	String food3;
	
	@DatabaseField(canBeNull = false)
	String play1;
	
	@DatabaseField(canBeNull = false)
	String play2;
	
	@DatabaseField(canBeNull = false)
	String play3;
	
	@DatabaseField(canBeNull = false)
	String treatment1;
	
	@DatabaseField(canBeNull = false)
	String treatment2;
	
	@DatabaseField(canBeNull = false)
	String treatment3;

	public Dictionary(String name, String food1, String food2, String food3, String play1, String play2, String play3,
			String treatment1, String treatment2, String treatment3) {
		super();
		this.name = name;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.play1 = play1;
		this.play2 = play2;
		this.play3 = play3;
		this.treatment1 = treatment1;
		this.treatment2 = treatment2;
		this.treatment3 = treatment3;
	}
	
	public Dictionary(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFood1() {
		return food1;
	}

	public void setFood1(String food1) {
		this.food1 = food1;
	}

	public String getFood2() {
		return food2;
	}

	public void setFood2(String food2) {
		this.food2 = food2;
	}

	public String getFood3() {
		return food3;
	}

	public void setFood3(String food3) {
		this.food3 = food3;
	}

	public String getPlay1() {
		return play1;
	}

	public void setPlay1(String play1) {
		this.play1 = play1;
	}

	public String getPlay2() {
		return play2;
	}

	public void setPlay2(String play2) {
		this.play2 = play2;
	}

	public String getPlay3() {
		return play3;
	}

	public void setPlay3(String play3) {
		this.play3 = play3;
	}

	public String getTreatment1() {
		return treatment1;
	}

	public void setTreatment1(String treatment1) {
		this.treatment1 = treatment1;
	}

	public String getTreatment2() {
		return treatment2;
	}

	public void setTreatment2(String treatment2) {
		this.treatment2 = treatment2;
	}

	public String getTreatment3() {
		return treatment3;
	}

	public void setTreatment3(String treatment3) {
		this.treatment3 = treatment3;
	}
	
	
}
