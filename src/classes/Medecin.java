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
	
	Medecin(int id, String nom, String prenon, Date date_ness, String telf, String sexe,String specialite) {
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
