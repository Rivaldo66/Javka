package Data_Layer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User {

	@DatabaseField(id = true)
	String login;
	
	@DatabaseField(canBeNull = false)
	String password;
	
	@DatabaseField(canBeNull = false)
	Boolean admin;

	public User(String login, String password, Boolean admin) {
		this.login = login;
		this.password = password;
		this.admin = admin;
	}

	public User(){
	
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
