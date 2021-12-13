package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Personne;

public class Secretaire extends Personne{
	
	private float salaire;
    Secretaire(int id, String nom, String prenon, Date date_ness, String telf, String sexe,float salaire, String adresse) {
		super(id, nom, prenon, date_ness, telf, sexe, adresse);
		this.salaire=salaire;
	}
  //*************************************************************************	
  //methode d'insertion d'un nouveau patient au base de donnée 
  //*************************************************************************
      public void create_partient(Connection conn,Patient p) throws SQLException{
    	       //la requete à executer(inserer un nouveau patient)
  			   String sql = "INSERT INTO Patient (id, nom, prenon, date_ness, telf, sexe,adresse_mail) VALUES (?, ?, ?, ?, ?, ?, ?)";
  			   
  			   PreparedStatement statement = conn.prepareStatement(sql);
  			   //parser la donnée du patient et ll'inserer dans la base de donnée
  			   statement.setInt(1, p.getId());
  			   statement.setString(2, p.getNom());
  			   statement.setString(3, p.getPrenom());
  			   statement.setDate(4, p.getDate_ness());
  			   statement.setString(5, p.getTelf());
  			   statement.setString(6,p.getSexe());
  			   statement.setString(7, p.getAdresse());

  			   int rowsInserted = statement.executeUpdate();
  			   if (rowsInserted > 0) {
  			       System.out.println("A new row was inserted successfully!");
  			   }
  		 }
 	 //*************************************************************************
 	 //methode READ (lister les patients) 
 	 //*************************************************************************
 	 public ArrayList<Patient> read_listpatient(Connection conn, String sql ) throws SQLException{
  
 		   Statement statement = conn.createStatement();
 		   ResultSet result = statement.executeQuery(sql);
 		   //creation du table pour stocker les patients 
 		   ArrayList<Patient> listpatient= new ArrayList<>();
 		    
 		   while (result.next()){
 			   //importation des donnees d'un patient
 		       int id = result.getInt(1);
 		       String nom = result.getString(2);
 		       String prenom = result.getString(3);
 		       Date date_ness= result.getDate(4);
 		       String telf= result.getString(5);
 		       String sexe= result.getString(6);
 		       String email = result.getString(7);
 	 		   
 		     //sockage des patient dans une liste
 	 		   Patient p=new Patient(id,nom,prenom,date_ness,telf,sexe,email);
               listpatient.add(p); 

 		   }
	       return listpatient;  

 	    }
 	 //*************************************************************************
 	 //methode filtrer (lister les patients) 
 	 //*************************************************************************
 	
  //*************************************************************************
  //methode UPDATE ( modification des donnees personnels du patient )
  //*************************************************************************
  		 public void update_patient(Connection conn, String sql) throws SQLException{
  	         
  	      PreparedStatement statement = conn.prepareStatement(sql);

  		 int rowsUpdated = statement.executeUpdate();
  		 if (rowsUpdated > 0) {
  		     System.out.println("An existing user was updated successfully!");
  		 }
  	    }
  //*************************************************************************
  //methode delete_patient ( supprimer les patient )
  //*************************************************************************
  		 public void delete_patient(Connection conn, int i) throws SQLException{	 
  		     //requete a executer( supprimer le patient de l'ID i)
  			 String sql = "DELETE FROM Users WHERE id=?";
  			 
  			 PreparedStatement statement = conn.prepareStatement(sql);
  			 statement.setInt(1, i);
  			  
  			 int rowsDeleted = statement.executeUpdate();
  			 if (rowsDeleted > 0) {
  			     System.out.println("A client was deleted successfully!");
  			 }
  		 }
    
  //**************************************************************************
  //methode READ_RV (afficher l'historique des rondez-vous)
  //**************************************************************************
  	public ArrayList<RDV> read_RDV(Connection conn) throws SQLException{
           
  		String sql = null;
		   Statement statement = conn.createStatement();
		   ResultSet result = statement.executeQuery(sql);
		   //creation du table pour stocker les RDV 
		   ArrayList<RDV> listRDV= new ArrayList<>();
		    
		   while (result.next()){
			   //importation des donnees d'un RV
		       int id = result.getInt("id");
		       Date date_RDV= result.getDate("date_RDV");
		       int heure=result.getInt("heure"); 
		       int id_patient=result.getInt("id_patient");
		       //RDV r=new RDV(id,date_RDV,heure,id_patient);
		       //listRDV.add(r);
  	
		   }
		return listRDV;
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
