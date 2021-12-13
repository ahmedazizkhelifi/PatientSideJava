package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BDconnector.Mysqlconnector;
public class Patient extends Personne{
    
	private static Connection conn = Mysqlconnector.getConnection();
	
	public Patient(int id, String nom, String prenom, Date date_ness, String telf, String sexe,String adresse) {
			super(id, nom, prenom, date_ness, telf, sexe, adresse);
			
    }
	
	public Patient(String nom, String prenom, Date date_ness, String telf, String sexe,String adresse) {
		super(nom, prenom, date_ness, telf, sexe, adresse);
	}
	
	public Patient() {
		super("","",new Date(1,1,2000), "","","");
	}

	public static Patient getPatientFromId(int id) throws SQLException {
		String query = "SELECT * FROM patient WHERE id = ?";
		Patient p = new Patient();
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			p.setId(result.getInt(1)); 
			p.setNom(result.getString(2));
			p.setPrenom(result.getString(3));
			p.setDate_ness(result.getDate(4));
			p.setTelf(result.getString(5));
			p.setSexe(result.getString(6));
			p.setAdresse(result.getString(7));
		}
		return p;
		
	}
	
	 //*************************************************************************
		//methode d'insertion d'un nouveau patient au base de donnée 
	 //*************************************************************************
	public void create_patient(Patient P) throws SQLException{
		
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
	 public void update_patient() throws SQLException{
		 String query = "UPDATE patient SET nom = ?, prenom = ?, telf = ?, sexe = ?, adresse = ? WHERE id = ?";
	     PreparedStatement statement = conn.prepareStatement(query);
	     statement.setString(1, this.getNom());
	     statement.setString(2, this.getPrenom());
	     statement.setString(3, this.getTelf());
	     statement.setString(4, this.getSexe());
	     statement.setString(5, this.getAdresse());
	     statement.setInt(6, this.getId());
		 int rowsUpdated = statement.executeUpdate();
		 if (rowsUpdated > 0) {
		     System.out.println("An existing user was updated successfully!");
		 }
    }
	 
	 public String getNotes() throws SQLException{
		 String query = "SELECT notes FROM patient WHERE id = ? ";
		 PreparedStatement statement = conn.prepareStatement(query);
		 statement.setInt(1, this.getId());
		 ResultSet result = statement.executeQuery();
		 if (result.next()) {
			 return result.getString(1);
		 }
		 return "Vide";
	 }
	 
	 public void updatePatientNotes(String notes) throws SQLException{
		 String query = "UPDATE patient SET notes = ? WHERE id = ?";
	     PreparedStatement statement = conn.prepareStatement(query);
	     statement.setString(1, notes);

	     statement.setInt(2, this.getId());
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
