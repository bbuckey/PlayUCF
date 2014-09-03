package utils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.DBAddress;
import com.mongodb.DBObject;

import mongodao.MongoDataSource;

import com.mongodb.BasicDBObject;
import com.mongodb.QueryOperators;

public class MongoDBContext {

	private static transient Logger logger = Logger
			.getLogger(MongoDBContext.class.getName());
	private static String host;
	private static int port;
	private static String dbName;
	private static MongoDataSource mds;
	static {
		// TODO add connection properties file and parse information
		host = DBAddress.defaultHost();
		port = DBAddress.defaultPort();
		dbName = "UCF";
	}

	public static MongoDataSource getMongoDataSourceFromContext() {
		try {
			mds = mds != null && mds.isDBready() ? mds : new MongoDataSource(
					new DBAddress(host, port, dbName));
		} catch (Throwable t) {
			logger.log( Level.SEVERE, "Could not connect to data base due to ", t);
			
		}
		return mds;
	}


	
}
