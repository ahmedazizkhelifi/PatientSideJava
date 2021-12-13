package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Personne;
import BDconnector.Mysqlconnector;

public class Secretaire extends Personne {

   private static Connection conn = Mysqlconnector.getConnection();
   private float salaire;

   Secretaire(int id, String nom, String prenom, Date date_ness, String telf, String sexe, float salaire, String adresse) {
      super(id, nom, prenom, date_ness, telf, sexe, adresse);
      this.salaire = salaire;
   }

   // <CRUD

   // /C
   public void create() throws SQLException {
      String _query = "INSERT INTO secretaire (nom, prenom, date_ness, telf, sexe,salaire ,adresse) VALUES (?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement statement = conn.prepareStatement(_query);
      statement.setString(1, this.getNom());
      statement.setString(2, this.getPrenom());
      statement.setDate(3, this.getDate_ness());
      statement.setString(4, this.getTelf());
      statement.setString(5, this.getSexe());
      statement.setFloat(6, this.getSalaire());
      statement.setString(7, this.getAdresse());
      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
         System.out.println("A new row was inserted successfully!");
         System.out.println(rowsInserted);
         System.out.println("A new row was inserted successfully!");
      }
   }
   // C\

   // R
   public static ArrayList < Secretaire > read() throws SQLException {
      String _query = "SELECT * FROM secretaire";
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(_query);
      //creation du table pour stocker les secretaires 
      ArrayList < Secretaire > listSecretaire = new ArrayList < > ();

      while (result.next()) {
         //importation des donnees d'un secretaire
         int id = result.getInt(1);
         String nom = result.getString(2);
         String prenom = result.getString(3);
         Date date_ness = result.getDate(4);
         String telf = result.getString(5);
         String sexe = result.getString(6);
         float salaire = result.getFloat(7);
         String adresse = result.getString(8);
         //sockage des secretaires dans une liste
         Secretaire p = new Secretaire(id, nom, prenom, date_ness, telf, sexe, salaire, adresse);
         listSecretaire.add(p);
      }
      return listSecretaire;
   }
   // R\

   // U
   public void update() throws SQLException {
      String _query = "UPDATE secretaire SET nom = ?, prenom = ?, telf = ?, sexe = ?, adresse = ? WHERE id = ?";
      PreparedStatement statement = conn.prepareStatement(_query);
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
   // U\

   // D
   public void delete() throws SQLException {
      String sql = "DELETE FROM secretaire WHERE id = ?";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setInt(1, this.getId());
      int rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
         System.out.println("A secretaire was deleted successfully!");
      }
   }
   // D\

   // CRUD/>

   // <Patient
   //C
   public void createPatient(Patient p) throws SQLException {
      p.create();
      System.out.println("[Debug]: Patient created from secretaire " + getId());
      // auto generate patient user avec username et mdp = user id wala patient id
   }

   //R (lister les patients) 
   public ArrayList < Patient > readPatients(Patient p) throws SQLException {
      ArrayList < Patient > listPatients = Patient.readPatients();
      return listPatients;
   }

   //U (modification des donnees personnels du patient )
   public void updatePatient(Patient p) throws SQLException {
      p.update();
      System.out.println("[Debug]: Patient updated from secretaire " + getId());
   }

   //methode delete_patient ( supprimer les patient )

   public void deletePatient(Patient p) throws SQLException {
      p.delete();
      System.out.println("[Debug] Patient deleted from secreatire " + getId());
      // DELETE USER ZEDA
   }
   
// Patient/>
   
   

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