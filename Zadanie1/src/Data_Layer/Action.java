package Data_Layer;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Klasa odpowiedzialna za przetrzymywanie i organizacje danych zwi¹zanych z
 * akcjami wykonanymi na zwierzaku
 *
 * @author Damian Rudnicki i Pawe³ Tomaszewski
 *
 */
@DatabaseTable(tableName = "Action")
public class Action {

	@DatabaseField(generatedId = true)
	int actionID;

	@DatabaseField(canBeNull = false, foreign = true)
	Animal animal;

	@DatabaseField(canBeNull = false, foreign = true)
	DictionaryStaff dictionaryStaff;

	@DatabaseField(canBeNull = false)
	Date dateAdded = new Date();

	public Action(Animal animal, DictionaryStaff dictionaryStaff) {
		super();
		this.animal = animal;
		this.dictionaryStaff = dictionaryStaff;
	}

	public Action() {

	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public DictionaryStaff getDictionaryStaff() {
		return dictionaryStaff;
	}

	public void setDictionaryStaff(DictionaryStaff dictionaryStaff) {
		this.dictionaryStaff = dictionaryStaff;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getActionID() {
		return actionID;
	}

	public void setActionID(int actionID) {
		this.actionID = actionID;
	}

	@Override
	public String toString() {
		return " - " + dateAdded;
	}

}
