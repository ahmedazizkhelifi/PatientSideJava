package classes;

import java.sql.Date;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Medecin extends Personne{
	private String specialite;
	
	Medecin(int id, String nom, String prenon, Date date_ness, int telf, String sexe,String specialite) {
		super(id, nom, prenon, date_ness, telf, sexe);
		this.specialite=specialite;
	
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
//*************************************************************************	
//methode d'insertion d'un nouveau patient au base de donnée 
//*************************************************************************
    public void create_partient(Connection conn) throws SQLException{
			   String sql = "INSERT INTO Patient (id, nom, prenon, date_ness, telf, sexe,adresse_mail) VALUES (?, ?, ?, ?, ?, ?, ?)";
			   
			   PreparedStatement statement = conn.prepareStatement(sql);
			   statement.setInt(1,1);
			   statement.setString(2, "");
			   statement.setString(3, "");
			   statement.setString(4, "");
			   statement.setString(5, "");
			   statement.setString(6, "");
			   statement.setString(7, "");

			   int rowsInserted = statement.executeUpdate();
			   if (rowsInserted > 0) {
			       System.out.println("A new row was inserted successfully!");
			   }
		 }
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
//methode delete_patient ( supprimer des patient )
//*************************************************************************
		 public void delete_patient(Connection conn) throws SQLException{	 
		 
			 String sql = "DELETE FROM Users WHERE id=?";
			 
			 PreparedStatement statement = conn.prepareStatement(sql);
			 statement.setString(1, "..");
			  
			 int rowsDeleted = statement.executeUpdate();
			 if (rowsDeleted > 0) {
			     System.out.println("A client was deleted successfully!");
			 }
		 }
		//*************************************************************************
		//methode add_consultation ( ajouter des consultations )
		//*************************************************************************
				 public void add_consultation(Connection conn) throws SQLException{			 
					 
				 }
		 
		 
		 
		
		 public void read_hitorique_consumtation(Connection conn, String sql ) throws SQLException{
			 
			   Statement statement = conn.createStatement();
			   ResultSet result = statement.executeQuery(sql);
			    
			   int count = 0;
			    
			   while (result.next()){
			       int id = result.getInt(1);
			    //..........
		
			   }   

		    }
	

}
