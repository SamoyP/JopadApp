package models;

public class Group {
	private int groupId;
	private String naam;
	private int minLeeftijd;
	private int maxLeeftijd;
	
	public Group(String naam){
		this.groupId = -1;
		this.naam = naam;
		this.minLeeftijd = -1;
		this.maxLeeftijd = -1;
	}
	public Group(String naam, int minLeeftijd, int maxLeeftijd){
		this.groupId = -1;
		this.naam = naam;
		this.minLeeftijd = minLeeftijd;
		this.maxLeeftijd = maxLeeftijd;
	}
	public Group(int id, String naam, int minLeeftijd, int maxLeeftijd){
		this.groupId = id;
		this.naam = naam;
		this.minLeeftijd = minLeeftijd;
		this.maxLeeftijd = maxLeeftijd;
	}
	public int getId(){
		return this.groupId;
	}
	public void setId(int id){
		this.groupId = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getMinLeeftijd() {
		return minLeeftijd;
	}
	public void setMinLeeftijd(int minLeeftijd) {
		this.minLeeftijd = minLeeftijd;
	}
	public int getMaxLeeftijd() {
		return maxLeeftijd;
	}
	public void setMaxLeeftijd(int maxLeeftijd) {
		this.maxLeeftijd = maxLeeftijd;
	}	
}
