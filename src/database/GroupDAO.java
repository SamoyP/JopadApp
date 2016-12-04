package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Dancer;
import models.Group;

public class GroupDAO extends DatabaseSingleton {
	public List<Group> getAllGroups() throws SQLException{
		this.open();
		List<Group> groups = new ArrayList<Group>();
		
		Statement stmt = null;
		ResultSet rs = null;

		stmt = connection.createStatement();
		rs = stmt.executeQuery("SELECT * FROM groups");
		while (rs.next()){
			groups.add(new Group(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		rs.close();
		stmt.close();
		this.close();
		return groups;
	}
	public void addGroup(Group group) throws SQLException{
		this.open();
		PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO Groups VALUES(null, ?,?,?)");
			prepStmt.setString(1, group.getNaam());
			prepStmt.setInt(2, group.getMinLeeftijd());
			prepStmt.setInt(3, group.getMaxLeeftijd());
			prepStmt.executeUpdate();
			
			prepStmt.close();
			this.close();
	}
	public List<Group> getGroupByName(String name) throws SQLException{
		this.open();
		List<Group> groups = new ArrayList<Group>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM groups WHERE naam LIKE ?");
		
		prepStmt.setString(1,"%" + name + "%");
		rs = prepStmt.executeQuery();
		while (rs.next()){
			groups.add(new Group(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return groups;
	}
	public List<Group> getGroupBetweenAges(int age) throws SQLException{
		this.open();
		List<Group> groups = new ArrayList<Group>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM groups WHERE min_leeftijd <= ? AND max_leeftijd >= ?");
		
		prepStmt.setInt(1,age);
		prepStmt.setInt(2,age);
		rs = prepStmt.executeQuery();
		while (rs.next()){
			groups.add(new Group(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return groups;
	}
	public Group getGroupById(int id)throws SQLException{
		this.open();
		Group group = null;
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM groups WHERE id_group = ?");
		
		prepStmt.setInt(1,id);
		rs = prepStmt.executeQuery();
		while (rs.next()){
			group = new Group(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return group;
	}
}