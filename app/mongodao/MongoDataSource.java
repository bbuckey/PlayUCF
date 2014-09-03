package mongodao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBConnector;
import com.mongodb.DBAddress;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;


public final class MongoDataSource {

	private Mongo mongo;
	private ServerAddress dbAddress;
	private DBConnector dbConnector;
	private DB db;
	private String dbName;

	MongoDataSource() {
		;
	}

	public MongoDataSource(MongoOptions mo, ServerAddress sa, String _dbName)
			throws UnknownHostException {
		dbName = _dbName;
		mongo = new Mongo(sa, mo);
		dbAddress = new DBAddress(sa.getHost(), sa.getPort(), dbName);
		db = mongo.getDB(dbName);
		dbConnector = mongo.getConnector();
	}

	public MongoDataSource(Mongo _mongo, ServerAddress sa, DB _db,
			String _dbName) throws UnknownHostException {
		dbName = _dbName;
		mongo = _mongo;
		dbAddress = new DBAddress(sa.getHost(), sa.getPort(), dbName);
		db = _db;
		dbConnector = mongo.getConnector();
	}

	public MongoDataSource(Mongo _mongo, String _dbName)
			throws UnknownHostException {
		dbName = _dbName;
		mongo = _mongo;
		dbAddress = new DBAddress(_mongo.getAddress().getHost(), _mongo
				.getAddress().getPort(), dbName);
		db = mongo.getDB(dbName);
		dbConnector = mongo.getConnector();
	}

	public MongoDataSource(ServerAddress _dbAddress, String _dbName)
			throws UnknownHostException {
		dbName = _dbName;
		dbAddress = new DBAddress(_dbAddress.getHost(), _dbAddress.getPort(),
				dbName);
		db = Mongo.connect((DBAddress) dbAddress);
		mongo = db.getMongo();
		dbConnector = mongo.getConnector();
	}

	public MongoDataSource(DBAddress _dbAddress) throws UnknownHostException {
		dbAddress = _dbAddress;
		db = Mongo.connect((DBAddress) dbAddress);
		mongo = db.getMongo();
		dbConnector = mongo.getConnector();
		dbName = db.getName();
	}

	public MongoDataSource(DB _db) throws UnknownHostException {
		db = _db;
		dbAddress = db.getMongo().getAddress();
		mongo = db.getMongo();
		dbConnector = mongo.getConnector();
		dbName = db.getName();
	}

	public DBConnector getDBConnecter() {
		return this.dbConnector;
	}

	public DBAddress getDBAddress() {
		return (DBAddress) this.dbAddress;
	}

	public ServerAddress getServerAddress() {
		return this.dbAddress;
	}

	public DB getDB() {
		return this.db;
	}

	public String getDBName() {
		return this.dbName;
	}

	public boolean ConnectToTheDBWithUser(String username, char[] passwd) {
		boolean isAuth = db.authenticate(username, passwd);
		return isAuth;
	}

	public DB getDBbyName(String name) {
		return mongo.getDB(name);
	}

	public DBCollection getDBCollectionWithDataBaseAndCollectionName(
			String dataBase, String collectionName) {
		return this.mongo.getDB(dataBase).getCollectionFromString(
				collectionName);
	}

	public void closeDB() {
		this.db.requestDone();
		this.mongo.close();
		this.db = null;
		this.mongo = null;
	}

	public boolean isDBready(){
		return db != null && mongo != null;
	}
	
}
