import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class SQL {

	public void dbConnect(String connection) {

		ConnectionSource conn = null;
		Dao<Animal, String> nazwa = null;

		try {
			conn = new JdbcConnectionSource(connection);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			nazwa = DaoManager.createDao(conn, Animal.class);
			TableUtils.createTableIfNotExists(conn, Animal.class);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			nazwa.create(new Animal("Wiesiek", "Pies"));
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
	}
}
