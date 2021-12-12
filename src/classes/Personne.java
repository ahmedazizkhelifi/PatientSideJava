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
    Personne(int id,String nom,String prenom,Date date_ness,String telf,String sexe){
     this.id=id;
     this.nom = nom;
     this.prenom = prenom;
     this.date_ness = date_ness;
     this.telf = telf;
     this.sexe = sexe;
    }
    
    Personne(String nom,String prenon,Date date_ness,String telf,String sexe){
        this.nom = nom;
        this.prenom = prenom;
        this.date_ness = date_ness;
        this.telf = telf;
        this.sexe = sexe;
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

}
