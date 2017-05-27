package Data_Layer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class SQL {
	
	ConnectionSource conn = null;
	Dao<User, String> userDao = null;
	Dao<Animal, String> animalDao = null;
	Dao<Dictionary, String> dictionaryDao = null;
	Dao<Action, String> actionDao = null;

	public void dbConnect(String connection) {
		
		Dictionary dictionary1 = new Dictionary("Pies", "karma", "miêso", "kie³basa", "spacer", "aportowanie", "gumowa koœæ", "szczepienie", "odrobaczanie", "czesanie");
		User user1 = new User("Pawe³", "Tomaszewski", false);
		Animal animal1 = new Animal("Rex", dictionary1, user1);

		try {
			conn = new JdbcConnectionSource(connection);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			userDao = DaoManager.createDao(conn, User.class);
			TableUtils.createTableIfNotExists(conn, User.class);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			animalDao = DaoManager.createDao(conn, Animal.class);
			TableUtils.createTableIfNotExists(conn, Animal.class);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			dictionaryDao = DaoManager.createDao(conn, Dictionary.class);
			TableUtils.createTableIfNotExists(conn, Dictionary.class);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			actionDao = DaoManager.createDao(conn, Action.class);
			TableUtils.createTableIfNotExists(conn, Action.class);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			dictionaryDao.create(dictionary1);
			dictionaryDao.create(new Dictionary("Kot", "karma", "mleko", "ryba", "g³askanie", "³apanie myszy", "drapak", "szczepienie", "odrobaczanie", "czesanie"));
			dictionaryDao.create(new Dictionary("Królik", "karma", "siano", "marchewka", "g³askanie", "zabawa w ogródku", "zabawa w chowanego", "szczepienie", "mycie zêbów", "czesanie"));
			dictionaryDao.create(new Dictionary("Mysz", "karma", "siano", "ser", "g³askanie", "ko³owrotek", "zabawa w chowanego", "szczepienie", "mycie zêbów", "czesanie"));
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			userDao.create(user1);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			animalDao.create(animal1);
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
		try {
			actionDao.create(new Action(user1, animal1, "karmienie", "karma"));
		} catch (Exception e) {
			// jakas tam obs³uga wyj¹tku kurwa lol chyban nie
		}
	}
	
	
}
