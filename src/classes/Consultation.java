package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BDconnector.Mysqlconnector;

public class Consultation {
   private int id;
   private String details;
   private String ordonnance;
   private int idPatient;
   private int idRDV;

   private static Connection conn = Mysqlconnector.getConnection();
   
   public Consultation(int id, String details, String ordonnance, int id_patient, int idRdv) {
      this.id = id;
      this.details = details;
      this.idPatient = id_patient;
      this.idRDV = idRdv;
   }
   
   public Consultation() {
	   
   }

   // <CRUD

   // C

   public void create() throws SQLException {
      String _query = "INSERT INTO consultation (details, ordonnance, idPatient, idRDV) VALUES (?, ?, ?, ?)";
      PreparedStatement statement = conn.prepareStatement(_query);
      statement.setString(1, this.getDetails());
      statement.setString(2, this.getOrdonnance());
      statement.setInt(3, this.getIdPatient());
      statement.setInt(4, this.getIdRDV());

      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
         System.out.println("A new row was inserted successfully!");
      }
   }

   // C\

   // R

   public static ArrayList < Consultation > read() throws SQLException {
      String _query = "SELECT * FROM consultation";
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(_query);
      ArrayList < Consultation > listConsultation = new ArrayList < > ();
      while (result.next()) {
         int id = result.getInt(1);
         String details = result.getString(2);
         String ordonnance = result.getString(3);
         int id_patient = result.getInt(4);
         int idRdv = result.getInt(5);

         //stockage des consultation dans une liste de consultation
         Consultation p = new Consultation(id, details, ordonnance, id_patient, idRdv);
         listConsultation.add(p);
      }
      return listConsultation;
   }
   
   public static Consultation readFromId(int id) throws SQLException {
	    String query = "SELECT * FROM consultation WHERE id = ?";
	    Consultation c = new Consultation();
	    PreparedStatement statement = conn.prepareStatement(query);
	    statement.setInt(1, id);
	    ResultSet result = statement.executeQuery();
	    if (result.next()) {
	      c.setId(result.getInt(1));
	      c.setDetails(result.getString(2));
	      c.setOrdonnance(result.getString(3));
	      c.setIdPatient(result.getInt(4));
	      c.setIdRDV(result.getInt(5));
	    }
	    return c;
	  }

   // R\

   // CRUD/>

   // read les  		 

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getDetails() {
      return details;
   }

   public void setDetails(String details) {
      this.details = details;
   }

   public String getOrdonnance() {
      return ordonnance;
   }

   public void setOrdonnance(String ordonnance) {
      this.ordonnance = ordonnance;
   }

   public int getIdPatient() {
      return idPatient;
   }

   public void setIdPatient(int id_patient) {
      this.idPatient = id_patient;
   }

   public int getIdRDV() {
      return idRDV;
   }

   public void setIdRDV(int idRdv) {
      this.idRDV = idRdv;
   }
   
   @Override
   public String toString() {
      return "{" +
         " id='" + getId() + "'" +
         ", details='" + getDetails() + "'" +
         ", ordonnance='" + getOrdonnance() + "'" +
         ", idPatient='" + getIdPatient() + "'" +
         ", idRDV='" + getIdRDV() + "'" +
         "}";
   }

}