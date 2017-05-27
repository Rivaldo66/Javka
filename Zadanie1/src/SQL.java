import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class SQL {
	
	ConnectionSource conn = null;
	Dao<User, String> nazwa = null;
	Dao<Animal, String> nazwa1 = null;

	public void dbConnect(String connection) {

		try {
			conn = new JdbcConnectionSource(connection);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			nazwa = DaoManager.createDao(conn, User.class);
			TableUtils.createTableIfNotExists(conn, User.class);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			nazwa1 = DaoManager.createDao(conn, Animal.class);
			TableUtils.createTableIfNotExists(conn, Animal.class);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			nazwa.create(new User("Wiesi", "Pies", "dupa"));
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			nazwa1.create(new Animal("Wiesi", "Pies"));
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
	}
	
	
}
