
public class User {

	String login;
	String password;
	String permissionLevel;

	public User(String login, String password, String permissionLevel) {
		this.login = login;
		this.password = password;
		this.permissionLevel = permissionLevel;
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
