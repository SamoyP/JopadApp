package models;

public class Login {
	private int loginId;
	private String naam;
	private String wachtwoord;
	private int rolId;
	
	public Login(int id, String naam, String wachtwoord, int rol){
		this.loginId = id;
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.rolId = rol;
	}	
	public Login(String naam, String wachtwoord, int rol){
		this.loginId = -1;
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.rolId = rol;
	}	
	public int getLoginId(){
		return this.loginId;
	}
	public void setLoginId(int id){
		this.loginId = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	public int getRolId() {
		return rolId;
	}
	public void setRolId(int rolId) {
		this.rolId = rolId;
	}
}
