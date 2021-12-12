package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private Date date_ness;
    private String telf;	
    private String sexe;
    private String adresse;

	
    
    public Personne(int id,String nom,String prenom,Date date_ness,String telf,String sexe, String adresse){
     this.id=id;
     this.nom = nom;
     this.prenom = prenom;
     this.date_ness = date_ness;
     this.telf = telf;
     this.sexe = sexe;
     this.adresse = adresse;
    }
    
    public Personne(String nom,String prenom,Date date_ness,String telf,String sexe, String adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.date_ness = date_ness;
        this.telf = telf;
        this.sexe = sexe;
        this.adresse = adresse;
       }
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_ness() {
		return date_ness;
	}
	public void setDate_ness(Date date_ness) {
		this.date_ness = date_ness;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", nom='" + getNom() + "'" +
			", prenom='" + getPrenom() + "'" +
			", date_ness='" + getDate_ness() + "'" +
			", telf='" + getTelf() + "'" +
			", sexe='" + getSexe() + "'" +
			", adresse='" + getAdresse() + "'" +
			"}";
	}

}
