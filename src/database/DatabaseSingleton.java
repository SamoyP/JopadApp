package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
	private static DatabaseSingleton ref;
	protected Connection connection;
	
	public DatabaseSingleton(){
	}	
	public static DatabaseSingleton getDatabaseSingleton(){
		if(ref == null){
			ref = new DatabaseSingleton();
		}
		return ref;
	}	
	public Connection getConnection(boolean autoCommit) throws SQLException {
		if (connection == null || connection.isClosed()){
			connection = DriverManager.getConnection("jdbc:mysql://mysql5017.smarterasp.net/db_"+DatabaseProperties.USERNAME, DatabaseProperties.USERNAME, DatabaseProperties.PASSWORD);
		}	
			return connection;
	}
	
	public void open(){
		try {
			connection = getConnection(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(){
		if(this.connection!= null){
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
