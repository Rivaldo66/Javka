import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "User")
public class User {

	@DatabaseField(id = true)
	String login;
	
	@DatabaseField(canBeNull = false)
	String password;
	
	@DatabaseField(canBeNull = false)
	String permissionLevel;

	public User(String login, String password, String permissionLevel) {
		this.login = login;
		this.password = password;
		this.permissionLevel = permissionLevel;
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

	public String getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

}
