package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dancer_GroupDAO extends DatabaseSingleton {
	public void addDancerGroup(int dancerId, int groupId) throws SQLException{
		this.open();
		PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO dancer_groups VALUES(null, ?,?)");
			prepStmt.setInt(1, dancerId);
			prepStmt.setInt(2, groupId);
			prepStmt.executeUpdate();
			
			prepStmt.close();
			this.close();
	}
}
