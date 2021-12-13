package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Personne;

public class Secretaire extends Personne {

  private float salaire;

  Secretaire(int id, String nom, String prenom, Date date_ness, String telf, String sexe, float salaire, String adresse) {
    super(id, nom, prenom, date_ness, telf, sexe, adresse);
    this.salaire = salaire;
  }

  //Methode d'insertion d'un nouveau patient au base de donnée 
  public void create_partient(Patient p) throws SQLException {
    p.create_patient();
  }

  //Methode READ (lister les patients) 
  public ArrayList < Patient > readPatients(Patient p) throws SQLException {
    ArrayList < Patient > listPatients = Patient.readPatients();
    return listPatients;
  }

  //Methode UPDATE ( modification des donnees personnels du patient )
  public void updatePatient(Patient p) throws SQLException {
	  p.update_patient();
	  System.out.println("[Debug]: Patient updated from secretaire " + getId());
  }
  
  //methode delete_patient ( supprimer les patient )
  
  public void deletePatient(Patient p) throws SQLException {
	  p.delete();
	  System.out.println("[Debug] Patient deleted from secreatire " + getId());
	  
	  // DELETE USER ZEDA
  }

  //**************************************************************************
  //methode READ_RV (afficher l'historique des rondez-vous)
  //**************************************************************************
  public ArrayList < RDV > read_RDV(Connection conn) throws SQLException {

    String sql = null;
    Statement statement = conn.createStatement();
    ResultSet result = statement.executeQuery(sql);
    //creation du table pour stocker les RDV 
    ArrayList < RDV > listRDV = new ArrayList < > ();

    while (result.next()) {
      //importation des donnees d'un RV
      int id = result.getInt("id");
      Date date_RDV = result.getDate("date_RDV");
      int heure = result.getInt("heure");
      int id_patient = result.getInt("id_patient");
      //RDV r=new RDV(id,date_RDV,heure,id_patient);
      //listRDV.add(r);

    }
    return listRDV;
  }
  public void accepter_RDV() {

  }
  public float getSalaire() {
    return salaire;
  }
  public void setSalaire(float salaire) {
    this.salaire = salaire;
  }
}