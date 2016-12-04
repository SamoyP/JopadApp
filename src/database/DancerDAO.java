package database;

import models.Dancer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DancerDAO extends DatabaseSingleton {
	public List<Dancer> getAllDancers() throws SQLException{
		this.open();
		List<Dancer> dancers = new ArrayList<Dancer>();
		
		Statement stmt = null;
		ResultSet rs = null;

		stmt = connection.createStatement();
		rs = stmt.executeQuery("SELECT * FROM dancers");
		while (rs.next()){
			dancers.add(new Dancer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10)));
		}
		
		rs.close();
		stmt.close();
		this.close();
		return dancers;
	}
	public int addDancer(Dancer dancer) throws SQLException{
		this.open();
		PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO Dancers VALUES(null, ?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, dancer.getVoornaam());
			prepStmt.setString(2, dancer.getAchternaam());
			prepStmt.setString(3, dancer.getAdres());
			prepStmt.setInt(4, dancer.getPostcode());
			prepStmt.setString(5, dancer.getGemeente());
			prepStmt.setString(6, dancer.getEmail());
			prepStmt.setString(7,dancer.getTelefoonLid());
			prepStmt.setDate(8, dancer.getGeboorteDatum());
			prepStmt.setString(9, dancer.getGeslacht());
			prepStmt.executeUpdate();
		ResultSet rs = prepStmt.getGeneratedKeys();
		if (rs.next()){
			int id = rs.getInt(1);
			prepStmt.close();
			this.close();
			return id;
		}
		return -1;
	}
	public List<Dancer> getDancersBySurName(String surname) throws SQLException{
		this.open();
		List<Dancer> dancers = new ArrayList<Dancer>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM dancers WHERE voornaam LIKE ?");
		
		prepStmt.setString(1,"%" + surname + "%");
		rs = prepStmt.executeQuery();
		while (rs.next()){
			dancers.add(new Dancer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10)));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return dancers;
	}
	public List<Dancer> getDancersByLastName(String lastname) throws SQLException{
		this.open();
		List<Dancer> dancers = new ArrayList<Dancer>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM dancers WHERE achternaam LIKE ?");
		prepStmt.setString(1, "%" + lastname + "%");
		rs = prepStmt.executeQuery();
		while (rs.next()){
			dancers.add(new Dancer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10)));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return dancers;
	}
	public List<Dancer> getDancersByGroupId(int groupId) throws SQLException{
		this.open();
		List<Integer> dancerIds = new ArrayList<Integer>();
		List<Dancer> dancers = new ArrayList<Dancer>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM dancer_groups WHERE group_id = ?");
		prepStmt.setInt(1, groupId);
		rs = prepStmt.executeQuery();
		while (rs.next()){
			dancerIds.add(rs.getInt(2));
		}
		for(int i : dancerIds){
			dancers.add(this.getDancerById(i));
		}
		rs.close();
		prepStmt.close();
		this.close();
		return dancers;
	}
	public Dancer getDancerById(int dancerId) throws SQLException{
		this.open();
		
		Dancer dancer = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM dancers WHERE id_dancer = ?");
		prepStmt.setInt(1, dancerId);
		rs = prepStmt.executeQuery();
		while (rs.next()){
			dancer = new Dancer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return dancer;
	}
}
