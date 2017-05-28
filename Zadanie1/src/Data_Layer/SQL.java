package Data_Layer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class SQL {
	
	ConnectionSource conn = null;
	Dao<User, String> userDao = null;
	Dao<Animal, String> animalDao = null;
	Dao<Dictionary, String> dictionaryDao = null;
	Dao<Action, String> actionDao = null;
	QueryBuilder<User, String> userBuilder = null;
	QueryBuilder<Animal, String> animalBuilder = null;
	QueryBuilder<Dictionary, String> dictionaryBuilder = null;
	QueryBuilder<Action, String> actionBuilder = null;

	public void dbConnect(String connection) {
		
		try {
			conn = new JdbcConnectionSource(connection);
		} catch (Exception e) {	
			
		}
		try {
			userDao = DaoManager.createDao(conn, User.class);
			TableUtils.createTableIfNotExists(conn, User.class);
		} catch (Exception e) {

		}
		try {
			animalDao = DaoManager.createDao(conn, Animal.class);
			TableUtils.createTableIfNotExists(conn, Animal.class);
		} catch (Exception e) {

		}
		try {
			dictionaryDao = DaoManager.createDao(conn, Dictionary.class);
			TableUtils.createTableIfNotExists(conn, Dictionary.class);
		} catch (Exception e) {

		}
		try {
			actionDao = DaoManager.createDao(conn, Action.class);
			TableUtils.createTableIfNotExists(conn, Action.class);
		} catch (Exception e) {

		}
		try {
			userBuilder = userDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			animalBuilder = animalDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			dictionaryBuilder = dictionaryDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			actionBuilder = actionDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			dictionaryDao.create(new Dictionary("Pies", "karma", "miêso", "kie³basa", "spacer", "aportowanie", "gumowa koœæ", "szczepienie", "odrobaczanie", "czesanie"));
			dictionaryDao.create(new Dictionary("Kot", "karma", "mleko", "ryba", "g³askanie", "³apanie myszy", "drapak", "szczepienie", "odrobaczanie", "czesanie"));
			dictionaryDao.create(new Dictionary("Królik", "karma", "siano", "marchewka", "g³askanie", "zabawa w ogródku", "zabawa w chowanego", "szczepienie", "mycie zêbów", "czesanie"));
			dictionaryDao.create(new Dictionary("Mysz", "karma", "siano", "ser", "g³askanie", "ko³owrotek", "zabawa w chowanego", "szczepienie", "mycie zêbów", "czesanie"));
		} catch (Exception e) {

		}
	}

	public ConnectionSource getConn() {
		return conn;
	}

	public void setConn(ConnectionSource conn) {
		this.conn = conn;
	}

	public Dao<User, String> getUserDao() {
		return userDao;
	}

	public void setUserDao(Dao<User, String> userDao) {
		this.userDao = userDao;
	}

	public Dao<Animal, String> getAnimalDao() {
		return animalDao;
	}

	public void setAnimalDao(Dao<Animal, String> animalDao) {
		this.animalDao = animalDao;
	}

	public Dao<Dictionary, String> getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(Dao<Dictionary, String> dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	public Dao<Action, String> getActionDao() {
		return actionDao;
	}

	public void setActionDao(Dao<Action, String> actionDao) {
		this.actionDao = actionDao;
	}

	public QueryBuilder<User, String> getUserBuilder() {
		return userBuilder;
	}

	public void setUserBuilder(QueryBuilder<User, String> userBuilder) {
		this.userBuilder = userBuilder;
	}

	public QueryBuilder<Animal, String> getAnimalBuilder() {
		return animalBuilder;
	}

	public void setAnimalBuilder(QueryBuilder<Animal, String> animalBuilder) {
		this.animalBuilder = animalBuilder;
	}

	public QueryBuilder<Dictionary, String> getDictionaryBuilder() {
		return dictionaryBuilder;
	}

	public void setDictionaryBuilder(QueryBuilder<Dictionary, String> dictionaryBuilder) {
		this.dictionaryBuilder = dictionaryBuilder;
	}

	public QueryBuilder<Action, String> getActionBuilder() {
		return actionBuilder;
	}

	public void setActionBuilder(QueryBuilder<Action, String> actionBuilder) {
		this.actionBuilder = actionBuilder;
	}	
}
