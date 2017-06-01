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
	Dao<Food, String> foodDao = null;
	Dao<Play, String> playDao = null;
	Dao<Treatment, String> treatmentDao = null;
	QueryBuilder<User, String> userBuilder = null;
	QueryBuilder<Animal, String> animalBuilder = null;
	QueryBuilder<Dictionary, String> dictionaryBuilder = null;
	QueryBuilder<Action, String> actionBuilder = null;
	QueryBuilder<Food, String> foodBuilder = null;
	QueryBuilder<Play, String> playBuilder = null;
	QueryBuilder<Treatment, String> treatmentBuilder = null;
	
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
			foodDao = DaoManager.createDao(conn, Food.class);
			TableUtils.createTableIfNotExists(conn, Food.class);
		} catch (Exception e) {

		}
		try {
			playDao = DaoManager.createDao(conn, Play.class);
			TableUtils.createTableIfNotExists(conn, Play.class);
		} catch (Exception e) {

		}
		try {
			treatmentDao = DaoManager.createDao(conn, Treatment.class);
			TableUtils.createTableIfNotExists(conn, Treatment.class);
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
			foodBuilder = foodDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			playBuilder = playDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			treatmentBuilder = treatmentDao.queryBuilder();
		} catch (Exception e) {

		}
		try {
			dictionaryDao.create(dictionary1);
			dictionaryDao.create(dictionary2);
			dictionaryDao.create(dictionary3);
			dictionaryDao.create(dictionary4);
		} catch (Exception e) {

		}
		try {
			foodDao.create(new Food(dictionary1, "karma"));
			foodDao.create(new Food(dictionary1, "miêso"));
			foodDao.create(new Food(dictionary1, "kie³basa"));
			foodDao.create(new Food(dictionary2, "karma"));
			foodDao.create(new Food(dictionary2, "mleko"));
			foodDao.create(new Food(dictionary2, "ryba"));
			foodDao.create(new Food(dictionary3, "karma"));
			foodDao.create(new Food(dictionary3, "siano"));
			foodDao.create(new Food(dictionary3, "marchewka"));
			foodDao.create(new Food(dictionary4, "karma"));
			foodDao.create(new Food(dictionary4, "siano"));
			foodDao.create(new Food(dictionary4, "ser"));
			
			playDao.create(new Play(dictionary1, "spacer"));
			playDao.create(new Play(dictionary1, "aportowanie"));
			playDao.create(new Play(dictionary1, "guma koœæ"));
			playDao.create(new Play(dictionary2, "g³askanie"));
			playDao.create(new Play(dictionary2, "³apanie myszy"));
			playDao.create(new Play(dictionary2, "drapak"));
			playDao.create(new Play(dictionary3, "g³askanie"));
			playDao.create(new Play(dictionary3, "zabawa w ogródku"));
			playDao.create(new Play(dictionary3, "zabawa w chowanego"));
			playDao.create(new Play(dictionary4, "g³askanie"));
			playDao.create(new Play(dictionary4, "ko³owrotek"));
			playDao.create(new Play(dictionary4, "zabawa w chowanego"));
			
			treatmentDao.create(new Treatment(dictionary1, "szczepenie"));
			treatmentDao.create(new Treatment(dictionary1, "odrobaczanie"));
			treatmentDao.create(new Treatment(dictionary1, "czesanie"));
			treatmentDao.create(new Treatment(dictionary2, "szczepenie"));
			treatmentDao.create(new Treatment(dictionary2, "odrobaczanie"));
			treatmentDao.create(new Treatment(dictionary2, "czesanie"));
			treatmentDao.create(new Treatment(dictionary3, "szczepenie"));
			treatmentDao.create(new Treatment(dictionary3, "mycie zêbów"));
			treatmentDao.create(new Treatment(dictionary3, "czesanie"));
			treatmentDao.create(new Treatment(dictionary4, "szczepenie"));
			treatmentDao.create(new Treatment(dictionary4, "mycie zêbów"));
			treatmentDao.create(new Treatment(dictionary4, "czesanie"));
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

	public Dao<Food, String> getFoodDao() {
		return foodDao;
	}

	public void setFoodDao(Dao<Food, String> foodDao) {
		this.foodDao = foodDao;
	}

	public Dao<Play, String> getPlayDao() {
		return playDao;
	}

	public void setPlayDao(Dao<Play, String> playDao) {
		this.playDao = playDao;
	}

	public Dao<Treatment, String> getTreatmentDao() {
		return treatmentDao;
	}

	public void setTreatmentDao(Dao<Treatment, String> treatmentDao) {
		this.treatmentDao = treatmentDao;
	}

	public QueryBuilder<Food, String> getFoodBuilder() {
		return foodBuilder;
	}

	public void setFoodBuilder(QueryBuilder<Food, String> foodBuilder) {
		this.foodBuilder = foodBuilder;
	}

	public QueryBuilder<Play, String> getPlayBuilder() {
		return playBuilder;
	}

	public void setPlayBuilder(QueryBuilder<Play, String> playBuilder) {
		this.playBuilder = playBuilder;
	}

	public QueryBuilder<Treatment, String> getTreatmentBuilder() {
		return treatmentBuilder;
	}

	public void setTreatmentBuilder(QueryBuilder<Treatment, String> treatmentBuilder) {
		this.treatmentBuilder = treatmentBuilder;
	}	
	
	
}
