package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient extends Personne{
    

	
	public Patient(int id, String nom, String prenon, Date date_ness, String telf, String sexe,String adresse) {
			super(id, nom, prenon, date_ness, telf, sexe, adresse);
			
    }
	
	public Patient(String nom, String prenon, Date date_ness, String telf, String sexe,String adresse) {
		super(nom, prenon, date_ness, telf, sexe, adresse);
		
}
	
	
	 //*************************************************************************
		//methode d'insertion d'un nouveau patient au base de donnée 
	 //*************************************************************************
	public void create_patient(Connection conn,Patient P) throws SQLException{
		   String sql = "INSERT INTO Patient (nom, prenon, date_ness, telf, sexe,adresse_mail) VALUES (?, ?, ?, ?, ?, ?, ?)";
		   
		   PreparedStatement statement = conn.prepareStatement(sql);
		   statement.setString(1, "");
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
	 //methode UPDATE ( modification des des donnees personnels du patient )
	 //*************************************************************************
	 public void update_patient(Connection conn, String sql ) throws SQLException{
         
     PreparedStatement statement = conn.prepareStatement(sql);

	 int rowsUpdated = statement.executeUpdate();
	 if (rowsUpdated > 0) {
	     System.out.println("An existing user was updated successfully!");
	 }
    }
	 //*************************************************************************
	 //methode READ (lister les donnees) 
	 //*************************************************************************
	 public void read_hitorique_consumtation(Connection conn, String sql ) throws SQLException{
 
		   Statement statement = conn.createStatement();
		   ResultSet result = statement.executeQuery(sql);
		    
		   int count = 0;
		    
		   while (result.next()){
		       int id = result.getInt(1);
		       String nom = result.getString(3);
		       String prenom = result.getString("fullname");
		       Date date_ness= result.getDate("", null);
		       //String email = result.getString("email");
	
		   }   

	    }

    public void payer(){

    }
    public void demander_RDV(){

    }
    

	public Patient getPatient(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "";
	}



}
