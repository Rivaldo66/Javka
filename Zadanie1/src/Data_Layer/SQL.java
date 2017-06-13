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
	Dao<DictionaryStaff, String> dictionaryStaffDao = null;
	QueryBuilder<User, String> userBuilder = null;
	QueryBuilder<Animal, String> animalBuilder = null;
	QueryBuilder<Dictionary, String> dictionaryBuilder = null;
	QueryBuilder<Action, String> actionBuilder = null;
	QueryBuilder<DictionaryStaff, String> dictionaryStaffBuilder = null;
	
	Dictionary dictionary1 = new Dictionary("Pies");
	Dictionary dictionary2 = new Dictionary("Kot");
	Dictionary dictionary3 = new Dictionary("Królik");
	Dictionary dictionary4 = new Dictionary("Mysz");

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
			dictionaryStaffDao = DaoManager.createDao(conn, DictionaryStaff.class);
			TableUtils.createTableIfNotExists(conn, DictionaryStaff.class);
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
			dictionaryStaffBuilder = dictionaryStaffDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			dictionary1.setImage("https://www.cbdzoe.pl/img/artykuly/mowa-ciala-pies.png");
			dictionary2.setImage("http://2.bp.blogspot.com/-mXYoQvnmJog/UcFoFjUMwnI/AAAAAAAABPw/wSDQEeU9oQg/s250/nadrapaku-kot-2.png");
			dictionary3.setImage("http://lh4.ggpht.com/hwM2DwntUQX6Zq2hxNA1ts_YAoVNvQpnbs3q-odjYxQ-v_Mc4h1slGgyLULdeEmeTqc=w300");
			dictionary4.setImage("https://kochamzwierzta.files.wordpress.com/2016/11/chomik.png?w=660&h=495");
			dictionaryDao.create(dictionary1);
			dictionaryDao.create(dictionary2);
			dictionaryDao.create(dictionary3);
			dictionaryDao.create(dictionary4);
		} catch (Exception e) {

		}
		try {
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Food", "karma"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Food", "miêso"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Food", "kie³basa"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Food", "karma"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Food", "mleko"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Food", "ryba"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Food", "karma"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Food", "siano"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Food", "marchewka"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Food", "karma"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Food", "siano"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Food", "ser"));
			
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Play", "spacer"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Play", "aportowanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Play", "guma koœæ"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Play", "g³askanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Play", "³apanie myszy"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Play", "drapak"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Play", "g³askanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Play", "zabawa w ogródku"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Play", "zabawa w chowanego"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Play", "g³askanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Play", "ko³owrotek"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Play", "zabawa w chowanego"));
			
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Treatment", "szczepenie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Treatment", "odrobaczanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary1, "Treatment", "czesanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Treatment", "szczepenie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Treatment", "odrobaczanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary2, "Treatment", "czesanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Treatment", "szczepenie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Treatment", "mycie zêbów"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary3, "Treatment", "czesanie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Treatment", "szczepenie"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Treatment", "mycie zêbów"));
			dictionaryStaffDao.create(new DictionaryStaff(dictionary4, "Treatment", "czesanie"));
		} catch (Exception e) {

		}
		try {
			userDao.create(new User("admin", "admin", true));
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

	public Dao<DictionaryStaff, String> getDictionaryStaffDao() {
		return dictionaryStaffDao;
	}

	public void setDictionaryStaffDao(Dao<DictionaryStaff, String> dictionaryStaffDao) {
		this.dictionaryStaffDao = dictionaryStaffDao;
	}

	public QueryBuilder<DictionaryStaff, String> getDictionaryStaffBuilder() {
		return dictionaryStaffBuilder;
	}

	public void setDictionaryStaffBuilder(QueryBuilder<DictionaryStaff, String> dictionaryStaffBuilder) {
		this.dictionaryStaffBuilder = dictionaryStaffBuilder;
	}
		
}
