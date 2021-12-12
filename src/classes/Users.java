package classes;

import BDconnector.Mysqlconnector;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users {
	
		private String salt = "PatientSIDE";
		private Connection conn = Mysqlconnector.getConnection();
		
		private static int lastId;
		private int userId = -1;
		private String username;
		private String password;
		private int role = -1;
		private int personId = -1;
		
		public Users(String username, String password) {
			this.username = username;
			this.password = password;
		}
		
		
		//private String userHashedPw;
		// get set 
		
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
		
		public void setPersonId(int id) {
			this.personId = id;
		}
		
		public int getPersonId() {
			return this.personId;
		}
		
		
		
		public int getId() {
			return this.userId;
		}
	
		
		public boolean login() throws SQLException {
			String _hashedPw = getSecurePassword(this.getPassword(), this.getSalt());
			//System.out.println("_hashedPw= " + _hashedPw);
			String query = "SELECT * FROM users WHERE username = ? and password = ?";//WHERE username = ? and password = ?";
			PreparedStatement statement = this.conn.prepareStatement(query);
			statement.setString(1, this.getUsername());
			statement.setString(2, _hashedPw);
			
			ResultSet result = statement.executeQuery();
			boolean _validate = false;
			if (result.next()) {
				//System.out.println(result.getString(1)); // id
				this.setId(result.getInt(1));
				this.setRole(result.getInt(4));
				this.setPersonId(result.getInt(5));
				// System.out.println(result.getString(2)); // username
				// System.out.println(result.getString(3)); // pw
				_validate = true;
			}
			
			return _validate;
			//ArrayList<Users> users;
			
			
		}
		
	 public boolean verifyPassword(String entredPw, String hashedPw) throws NoSuchAlgorithmException, NoSuchProviderException 
	    {
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
	 
	 /*
	 // Add salt
	    private static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException 
	    {
	        // Always use a SecureRandom generator
	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

	        // Create array for salt
	        byte[] salt = new byte[16];

	        // Get a random salt
	        sr.nextBytes(salt);

	        // return salt
	        return salt.toString();
	    }
	    */
}
