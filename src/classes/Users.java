package classes;

import BDconnector.Mysqlconnector;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users {

   private String salt = "PatientSIDE";
   private static Connection conn = Mysqlconnector.getConnection();

   private int userId = -1;
   private String username;
   private String password;
   private int role = -1;
   private int roleId = -1;

   public Users(String username, String password) {
      this.username = username;
      this.password = password;
   }

   // <CRUD

   // C

   public void create(int id_role, int role) throws SQLException {

      String query = "INSERT INTO users (username, password, id_role, role) VALUES (?,?,?,?)";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, this.username);
      statement.setString(2, getSecurePassword(this.getPassword(), this.getSalt()));
      statement.setInt(3, id_role);
      statement.setInt(4, role);

      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
         System.out.println("A new row was inserted successfully!");
         System.out.println(rowsInserted);
         System.out.println("A new row was inserted successfully!");
      }
   }

   // C\

   // R
   // Pas de READ pour Users
   // R\

   // U
   public void update() throws SQLException {
      String query = "UPDATE users SET username = ?, password = ?, WHERE id = ?";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, this.getUsername());
      statement.setString(2, getSecurePassword(this.getPassword(), this.getSalt()));
      statement.setInt(3, this.getId());
      int rowsUpdated = statement.executeUpdate();
      if (rowsUpdated > 0) {
         System.out.println("An existing user was updated successfully!");
      }
   }
   // U\

   // D
   public void delete() throws SQLException {
      //requete a executer( supprimer le user de l'ID i)
      String sql = "DELETE FROM users WHERE id = ?";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setInt(1, this.getId());
      int rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
         System.out.println("A user was deleted successfully!");
      }
   }
   // D\

   // CRUD/>

   // <Functions

   public boolean signUp(Patient p) throws SQLException {
      // verifier si username exist

      if (usernameExist()) {
         System.out.println("user exist");
         return false;
      }
      // create patient
      createPatient(p);
      int maxId = Patient.getMaxPatientId();
      // create user
      this.create(maxId, 2);

      return true;

   }

   public boolean usernameExist() throws SQLException {
      String query = "SELECT count(username) FROM users WHERE username= ?";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, this.username);
      ResultSet resultat = statement.executeQuery();
      if (resultat.next()) {
         System.out.println(resultat.getInt(1));
         if (resultat.getInt(1) == 0)
            return false;
         else
            return true;
      }
      return false;
   }

   public boolean login() throws SQLException {
      if (!usernameExist()) {
         System.out.println("not exist");
         return false;
      } else {
         System.out.println("exist");
      }
      String _hashedPw = getSecurePassword(this.getPassword(), this.getSalt());
      //System.out.println("_hashedPw= " + _hashedPw);
      String query = "SELECT * FROM users WHERE username = ? and password = ?";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, this.getUsername());
      statement.setString(2, _hashedPw);

      ResultSet result = statement.executeQuery();
      boolean _validate = false;
      if (result.next()) {
         //System.out.println(result.getString(1)); // id
         this.setId(result.getInt(1));
         this.setRole(result.getInt(4));
         this.setRoleId(result.getInt(5));
         // System.out.println(result.getString(2)); // username
         // System.out.println(result.getString(3)); // pw
         _validate = true;
      }

      return _validate;
      //ArrayList<Users> users;

   }

   public boolean verifyPassword(String entredPw, String hashedPw) throws NoSuchAlgorithmException, NoSuchProviderException {
      //String securePassword = getSecurePassword(passwordToHash, getSalt());
      String generatedPassowrdToVerify = getSecurePassword(entredPw, this.getSalt());
      if (generatedPassowrdToVerify.equals(hashedPw))
         return true;
      else
         return false;
   }

   public static String getSecurePassword(String passwordToHash, String salt) {
      String generatedPassword = null;
      try {
         // Create MessageDigest instance for SHA-512
         MessageDigest md = MessageDigest.getInstance("SHA-512");

         // Add password bytes to digest
         md.update(salt.getBytes());

         // Get the hash's bytes
         byte[] bytes = md.digest(passwordToHash.getBytes());

         // This bytes[] has bytes in decimal format;
         // Convert it to hexadecimal format
         StringBuilder sb = new StringBuilder();

         for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
               .substring(1));
         }

         // Get complete hashed password in hex format
         generatedPassword = sb.toString();
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }
      return generatedPassword;

   }

   public static void createPatient(Patient p) throws SQLException {
      p.create();
   }

   // Functions/>

   // 

   // <getSet 

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }

   public String getSalt() {
      return this.salt;
   }

   public void setId(int id) {
      this.userId = id;
   }

   public void setRole(int role) {
      this.role = role;
   }

   public int getRole() {
      return this.role;
   }

   public void setRoleId(int id) {
      this.roleId = id;
   }

   public int getRoleId() {
      return this.roleId;
   }

   public int getId() {
      return this.userId;
   }

   // getSet/> 

}