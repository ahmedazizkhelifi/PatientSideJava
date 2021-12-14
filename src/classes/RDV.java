package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BDconnector.Mysqlconnector;

public class RDV {
   private int id;
   private Date quand;
   private int heure;
   private int minutes;
   private int idPatient;
   private boolean done;
   private Date creaDate;
   private boolean isOnline;
   // creaDate, isOnline

   private static Connection conn = Mysqlconnector.getConnection();

   public RDV() {

   }

   public RDV(int id, Date quand, int heure, int minutes, boolean done, int idPatient, Date creaDate, boolean isOnline) {
      this.id = id;
      this.setQuand(quand);
      this.heure = heure;
      this.minutes = minutes;
      this.setDone(done);
      this.setIdPatient(idPatient);
      this.creaDate = creaDate;
      this.isOnline = isOnline;
   }

   // <CRUD

   // C

   public void create() throws SQLException {
      String _query = "INSERT INTO RDV (quand, heure, minute, idPatient, done, creaDate, isOnline) VALUES (?, ?, ?, ?, ?, CURDATE(), ?)";
      PreparedStatement statement = conn.prepareStatement(_query);
      statement.setDate(1, this.getQuand());
      statement.setInt(2, this.getHeure());
      statement.setInt(3, this.getMinute());
      statement.setInt(4, this.getIdPatient());
      statement.setBoolean(5, this.getDone());
      statement.setBoolean(6, this.isOnline());
      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
         System.out.println("A new row was inserted successfully!");
      }
   }

   // C\

   // R
   public static ArrayList < RDV > read(boolean isPatient, int idPatient, boolean demande) throws SQLException {
      String _query = "";
      if (isPatient)
         _query = "SELECT * FROM rdv " + "WHERE idPatient = " + idPatient;
      else
         _query = "SELECT * FROM rdv";
      PreparedStatement statement = conn.prepareStatement(_query);
      ResultSet resultat = statement.executeQuery();
      ArrayList < RDV > RDVs = new ArrayList < RDV > ();
      while (resultat.next()) {
    	  boolean _isOnline = resultat.getBoolean("isOnline");
    	  if (demande) {
    		  if (_isOnline) { // est demande
        		  continue;
        	  }
    	  }
    	 
         int _id = resultat.getInt(1);
         Date _quand = resultat.getDate("quand");
         int _heure = resultat.getInt("heure");
         int _minute = resultat.getInt("minute");
         int _idPatient = resultat.getInt("idPatient");
         boolean _done = resultat.getBoolean("done");
         Date _creaDate = resultat.getDate("creaDate");

         RDV rdv = new RDV(_id, _quand, _heure, _minute, _done, _idPatient, _creaDate, _isOnline);
         RDVs.add(rdv);
      }

      return RDVs;
   }
   // R\

   // U
   public void update() throws SQLException {
      String query = "UPDATE RDV SET quand = ?, heure = ?, minute = ?, done=?, idPatient = ?, isOnline = ? WHERE id = ?";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setDate(1, this.getQuand());
      statement.setInt(2, this.getHeure());
      statement.setInt(3, this.getMinute());
      statement.setBoolean(4, this.getDone());
      statement.setInt(5, this.getIdPatient());
      statement.setBoolean(6, this.isOnline());
      statement.setInt(7, this.getId());
      int rowsUpdated = statement.executeUpdate();
      if (rowsUpdated > 0) {
         System.out.println("An existing RDV was updated successfully!");
      }
   }
   // U\

   // D
   public void delete() throws SQLException {
      //requete a executer( supprimer la RDV de l'ID i)
      String sql = "DELETE FROM RDV WHERE id = ?";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setInt(1, this.getId());
      int rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
         System.out.println("A RDV was deleted successfully!");
      }
   }
   // D\

   // CRUD/>

   // <getSet 
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }

   public int getHeure() {
      return heure;
   }
   public void setHeure(int heure) {
      this.heure = heure;
   }

   public int getMinute() {
      return minutes;
   }

   public void setMinutes(int minutes) {
      this.minutes = minutes;
   }

   public boolean getDone() {
      return done;
   }

   public void setDone(boolean done) {
      this.done = done;
   }

   public int getIdPatient() {
      return idPatient;
   }

   public void setIdPatient(int idPatient) {
      this.idPatient = idPatient;
   }

   @Override
   public String toString() {
      return "{" +
         " id='" + getId() + "'" +
         ", quand='" + getQuand() + "'" +
         ", heure='" + getHeure() + "'" +
         ", minutes='" + getMinute() + "'" +
         ", done='" + getDone() + "'" +
         ", idPatient='" + getIdPatient() + "'" +
         ", creaDate='" + getCreaDate() + "'" +
         ", isOnline='" + isOnline() + "'" +
         "}";
   }

   public Date getCreaDate() {
      return creaDate;
   }

   public void setCreaDate(Date creaDate) {
      this.creaDate = creaDate;
   }

   public boolean isOnline() {
      return isOnline;
   }

   public void setOnline(boolean isOnline) {
      this.isOnline = isOnline;
   }

   public Date getQuand() {
      return quand;
   }

   public void setQuand(Date quand) {
      this.quand = quand;
   }

   // getSet/>
}