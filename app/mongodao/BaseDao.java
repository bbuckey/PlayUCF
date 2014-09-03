package mongodao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mongodao.MongoDB;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import com.mongodb.MongoException;

import utils.MongoDBContext;


public abstract class BaseDao extends MongoDB implements IBaseDao {
	
	String collectionName;
	
	public BaseDao(String _collectionName){
		super(MongoDBContext.getMongoDataSourceFromContext());
		this.collectionName = _collectionName;
	}
	
	public BaseDao(String _collectionName, Class model){
		super(MongoDBContext.getMongoDataSourceFromContext());
		super.createNewCollection(_collectionName,model);
		this.collectionName = _collectionName;
	}

	public String getCollectionName(){
		return collectionName;
	}
	
	protected abstract DBCollection getDBCollection();
	
	public DBCollection getDatabaseCollection(){
		if(collectionName == null){
			this.collectionName = getDBCollection().getName();
		}
		return getDBCollection();
	}
	
	public DBObject findOneObjectByID(String id) {
		DBCollection dbc = getDatabaseCollection();
		DBObject dbo = new BasicDBObject();
		DBObject dbo2 = new BasicDBObject();
		dbo2.put("$oid", id);
		dbo.put("_id", dbo2);
		return dbc.findOne(dbo);
	}
	
	
	@Override
	public DBObject findOneObject(String key, Object value) {
		DBCollection dbc = getDatabaseCollection();
		DBObject dbo = new BasicDBObject();
		dbo.put(key, value);
		return dbc.findOne(dbo);
	}

	@Override
	public void addDBObjectToCollection(DBObject dbo) throws Exception {
		DBCollection dbc = getDatabaseCollection();
		WriteResult wr = //dbc.save(dbo);
		dbc.insert(dbo);
	//	if (wr.!= null && !wr.getError().equals("")) {
		//	throw new MongoException("Error while inserting a document"
		//			+ wr.getError());
		//}
		//dbc.save(dbo);

	}

	@Override
	public void removeDBObjectFromCollection(String key, Object value)
			throws Exception {
		DBCollection dbc = getDatabaseCollection();
		DBObject dbo = dbc.findOne((new BasicDBObject()).put(key, value));
		if (dbo != null && dbo.containsField(key) && dbo.get(key).equals(value)) {
			removeDBObjectFromCollection(dbo);
		} else {
			throw new MongoException(
					"Error while removing a document: The document was not found");
		}

	}

	@Override
	public void removeDBObjectFromCollection(DBObject dbo) throws Exception {
		DBCollection dbc = getDatabaseCollection();
		WriteResult wr = dbc.remove(dbo);
		if (wr.getError() != null && !wr.getError().equals("")) {
			throw new MongoException("Error while removing a document"
					+ wr.getError());
		}
	}

	@Override
	public DBObject findOneObject(DBObject obj) {
		DBCollection dbc = getDatabaseCollection();
		return dbc.findOne(obj);
	}

	@Override
	public List<DBObject> findObjects(Map m) {
		DBCollection dbc = getDatabaseCollection();
		DBObject dbo = new BasicDBObject();
		dbo.putAll(m);
		DBCursor cursor = dbc.find(dbo);
		List<DBObject> ldbo = new ArrayList<DBObject>();
		try{
		while(cursor!= null && cursor.hasNext()){
			ldbo.add(cursor.next());
		}

			cursor.close();
		}catch(Throwable t){
			//UI.showInformationWindow(Utils.getResource("problem"));
			System.exit(0);
		}
		return ldbo;
	}

	@Override
	public List<DBObject> findObjects(DBObject obj) {
		DBCollection dbc = getDatabaseCollection();
		DBCursor cursor = dbc.find(obj);
		List<DBObject> ldbo = new ArrayList<DBObject>();
		try{
		while(cursor!= null && cursor.hasNext()){
			ldbo.add(cursor.next());
		}
		
			cursor.close();
		}catch(Throwable t){
			//UI.showInformationWindow(Utils.getResource("problem"));
			System.exit(0);
		}
		return ldbo;
	}

	@Override
	public List<DBObject> getCollectionAsList() {
		DBCollection dbc = getDatabaseCollection();
		DBCursor cursor = dbc.find();
		List<DBObject> ldbo = new ArrayList<DBObject>();
		try{
		while(cursor != null && cursor.hasNext()){
			ldbo.add(cursor.next());
		}
			cursor.close();
		}catch(Throwable t){
			//UI.showInformationWindow(Utils.getResource("problem"));
			System.exit(0);
		}
		return ldbo;
	}

	@Override
	public void updateDocumentWithDBObject(DBObject query, DBObject updateObject) {
		DBCollection dbc = getDatabaseCollection();
		WriteResult wr = dbc.update(query, updateObject);
		if (wr.getError() != null && !wr.getError().equals("")) {
			throw new MongoException("Error while updating a document"
					+ wr.getError());
		}
	}

	@Override
	public DBObject updateDocumentWithDBObjectandReturnUpdate(DBObject query, DBObject updateObject) {
		DBCollection dbc = getDatabaseCollection();
		return dbc.findAndModify(query, updateObject);
		
	}

	
	
	@Override
	public void removeDBObjectFromCollection(Map map) throws Exception {
		DBCollection dbc = getDatabaseCollection();
		DBObject dbo = new BasicDBObject();
		dbo.putAll(map);
		WriteResult wr = dbc.remove(dbo);
		if (wr.getError() != null && !wr.getError().equals("")) {
			throw new MongoException("Error while removing a document"
					+ wr.getError());
		}
	}

	@Override
	public void addDBObjectToCollection(Map map) throws Exception {
		DBCollection dbc = getDatabaseCollection();
		DBObject dbo = new BasicDBObject();
		dbo.putAll(map);
		WriteResult wr = dbc.insert(dbo);
		// this.dbc.insert(dbo);
		if (wr.getError() != null && !wr.getError().equals("")) {
			throw new MongoException("Error while inserting a document"
					+ wr.getError());
		}
		//dbc.save(dbo);

	}

	@Override
	public DBObject findOneObject(Map map) {
		DBCollection dbc = getDatabaseCollection();
		DBObject dbo = new BasicDBObject();
		dbo.putAll(map);
		return dbc.findOne(dbo);
	}
	
	@Override
	public Long getQueryCount(DBObject query){
		DBCollection dbc = getDatabaseCollection();
		return dbc.count(query);
	}
	
	@Override
	public void bulkQueryUpdate(DBObject query, DBObject update){
		DBCollection dbc = getDatabaseCollection();
		dbc.updateMulti(query, update);
	}
	
	
	
}
