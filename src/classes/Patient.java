package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient extends Personne{
    
	private String adresse_mail;
	
	Patient(int id, String nom, String prenon, Date date_ness, int telf, String sexe) {
			super(id, nom, prenon, date_ness, telf, sexe);
			this.adresse_mail=adresse_mail;
    }
	
	
	
	 //*************************************************************************
		//methode d'insertion d'un nouveau patient au base de donnée 
	 //*************************************************************************
	public void create_patient(Connection conn,Patient P) throws SQLException{
		   String sql = "INSERT INTO Patient (id, nom, prenon, date_ness, telf, sexe,adresse_mail) VALUES (?, ?, ?, ?, ?, ?, ?)";
		   
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
	 // methode read_patient(lister le ptients )
	 //*************************************************************************
	 public void read_patient(Connection conn) throws SQLException {
		 String sql = ".....";
		 
		 Statement statement = conn.createStatement();
		 ResultSet result = statement.executeQuery(sql);
		 int count = 0;
		 while (result.next()){
		     var name = result.getString(1);
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
		       String email = result.getString("email");
	
		   }   

	    }

    public void payer(){

    }
    public void demander_RDV(){

    }
	public String getAdresse_mail() {
		return adresse_mail;
	}
	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}
}
