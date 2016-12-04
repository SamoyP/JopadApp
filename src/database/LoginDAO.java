package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Login;

public class LoginDAO extends DatabaseSingleton {
	public void addLogin(Login login) throws SQLException{
		this.open();
		PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO logins VALUES(null, ?,?,?)");
			prepStmt.setString(1, login.getNaam());
			prepStmt.setString(2, login.getWachtwoord());
			prepStmt.setInt(3, login.getRolId());
			prepStmt.executeUpdate();
			
			prepStmt.close();
			this.close();
	}

	public boolean controleerLogin(String username, String password) throws SQLException{
		this.open();
		
		List<Login> logins = new ArrayList<Login>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM logins WHERE loginNaam = ? AND loginWachtwoord = ?");
		
		prepStmt.setString(1, username);
		prepStmt.setString(2, password);
		
		rs = prepStmt.executeQuery();
		
		while (rs.next()){
			logins.add(new Login(rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		if(logins.size() >= 1){
			return true;
		}
		else {
			return false;
		}
	}
	public List<Login> getAllLogins() throws SQLException{
		this.open();
		List<Login> logins = new ArrayList<Login>();
		
		Statement stmt = null;
		ResultSet rs = null;

		stmt = connection.createStatement();
		rs = stmt.executeQuery("SELECT * FROM logins");
		while (rs.next()){
			logins.add(new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		rs.close();
		stmt.close();
		this.close();
		return logins;
	}
	public Login getLoginById(int id) throws SQLException{
		this.open();
		Login login = null;
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM logins WHERE id_login = ?");
		
		prepStmt.setInt(1,id);
		rs = prepStmt.executeQuery();
		while (rs.next()){
			login = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return login;
	}
	public List<Login> getLoginsByName(String name) throws SQLException{
		this.open();
		List<Login> logins = new ArrayList<Login>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM logins WHERE loginNaam LIKE ?");
		
		prepStmt.setString(1,"%" + name + "%");
		rs = prepStmt.executeQuery();
		while (rs.next()){
			logins.add(new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return logins;
	}
	public List<Login> getLoginsByRolId(int id) throws SQLException{
		this.open();
		List<Login> logins = new ArrayList<Login>();
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		prepStmt = connection.prepareStatement("SELECT * FROM logins WHERE id_rol = ?");
		
		prepStmt.setInt(1, id);
		rs = prepStmt.executeQuery();
		while (rs.next()){
			logins.add(new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		rs.close();
		prepStmt.close();
		this.close();
		return logins;
	}
}
