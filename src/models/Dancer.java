package models;

import java.sql.Date;

public class Dancer {
	private int lidNummer;
	private String voornaam;
	private String achternaam;
	private String adres;
	private int postcode;
	private String gemeente;
	private String email;
	private String telefoonLid;
	private Date geboorteDatum;
	private String geslacht;
	
	public Dancer(){}
	public Dancer(int lidNummer, String voornaam, String achternaam, String adres, int postcode, String gemeente, String mail, String telefoon, Date datum, String geslacht){
		this.lidNummer = lidNummer;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adres = adres;
		this.postcode = postcode;
		this.gemeente = gemeente;
		this.email = mail;
		this.telefoonLid = telefoon;
		this.geboorteDatum = datum;
		this.geslacht = geslacht;
		
	}
	public Dancer(String voornaam, String achternaam, String adres, int postcode, String gemeente, String mail, String telefoon, Date datum, String geslacht){
		this.lidNummer = -1;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adres = adres;
		this.postcode = postcode;
		this.gemeente = gemeente;
		this.email = mail;
		this.telefoonLid = telefoon;
		this.geboorteDatum = datum;
		this.geslacht = geslacht;
		
	}
	@Override
	public String toString() {
		return "Dancer [lidNummer=" + lidNummer + ", voornaam=" + voornaam + ", achternaam=" + achternaam + ", adres="
				+ adres + ", postcode=" + postcode + ", gemeente=" + gemeente + ", email=" + email + ", telefoonLid="
				+ telefoonLid + ", geboorteDatum=" + geboorteDatum + ", geslacht=" + geslacht + "]";
	}
	public int getLidNummer() {
		return lidNummer;
	}
	public void setLidNummer(int lidNummer) {
		this.lidNummer = lidNummer;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getGemeente() {
		return gemeente;
	}
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefoonLid() {
		return telefoonLid;
	}
	public void setTelefoonLid(String telefoonLid) {
		this.telefoonLid = telefoonLid;
	}
	public Date getGeboorteDatum() {
		return geboorteDatum;
	}
	public void setGeboorteDatum(Date geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}
	public String getGeslacht() {
		return geslacht;
	}
	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}
}
