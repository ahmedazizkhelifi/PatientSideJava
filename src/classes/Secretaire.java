package classes;

import java.sql.Date;

import classes.Personne;

public class Secretaire extends Personne{
	
	private float salaire;
    Secretaire(int id, String nom, String prenon, Date date_ness, int telf, String sexe,float salaire) {
		super(id, nom, prenon, date_ness, telf, sexe);
		this.salaire=salaire;
		// TODO Auto-generated constructor stub
	}

    
    public void accepter_RDV(){

    }
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
}
