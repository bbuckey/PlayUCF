package mongodao;

import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;

import com.mongodb.Mongo;
import annotation.ModelField;
import mongodao.MongoDataSource;
import com.mongodb.DBAddress;
import com.mongodb.QueryOperators;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.QueryBuilder;
import com.mongodb.DBEncoder;
import com.mongodb.DefaultDBDecoder;
import com.mongodb.DefaultDBEncoder;

import org.bson.BasicBSONEncoder;

public abstract class MongoDB {

	private MongoDataSource mongoDataSource;

	protected MongoDB() {
		;
	}

	public MongoDB(DBAddress _dbAddress) throws UnknownHostException {
		mongoDataSource = new MongoDataSource(_dbAddress);
	}

	public MongoDB(Mongo _mongo, String dbName)
			throws UnknownHostException {
		mongoDataSource = new MongoDataSource(_mongo, dbName);
	}

	public MongoDB(MongoDataSource _mds) {
		mongoDataSource = _mds;
	}

	protected void setMangoDataSource(MongoDataSource _mds) {
		this.mongoDataSource = _mds;
	}

	public MongoDataSource getMongoDataSource() {
		return mongoDataSource;
	}

	protected DBCollection getDBCollectionOrCreateNewCollection(
			String collectionName) {
		DBCollection dbc;
		dbc = mongoDataSource.getDB().getCollection(collectionName);
		return dbc;
	}
	
	protected boolean createNewCollection(
			String collectionName, Class model) {
		DBObject options = new com.mongodb.BasicDBObject();
		for(Field f : model.getFields()){
			annotation.ModelField mf = f.getAnnotation(annotation.ModelField.class);
			if(mf != null ){
				options.put(mf.alternateFieldName() != null ? mf.alternateFieldName() : mf.viewFieldName() ,null);
			}
		}
		return mongoDataSource.getDB().createCollection(collectionName, options) != null;
	}

	protected DBCollection getDBCollection(String collectionName) {
		DBCollection dbc;
		dbc = mongoDataSource.getDB().getCollectionFromString(collectionName);
		return dbc;
	}

	protected DBCollection getDBCollectionFromDataBaseAndCollectionName(
			String dbname, String collectionName) {
		return mongoDataSource.getDBCollectionWithDataBaseAndCollectionName(
				dbname, collectionName);
	}

	public void closeDB() {
		this.mongoDataSource.closeDB();
	}
	
	public Set<String> getListofDBCollectionNames(){
		return  mongoDataSource.getDB().getCollectionNames();
	}

}
