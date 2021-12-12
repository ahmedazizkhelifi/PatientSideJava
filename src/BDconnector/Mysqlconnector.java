package BDconnector;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import classes.Users;

public class Mysqlconnector {
	
	public static Connection getConnection() {
		 String BDD = "cabinet";
         String url = "jdbc:mysql://localhost:3306/" + BDD; // 8
         String user = "root";
         String passwd = "";
         try {
         	Class.forName("com.mysql.cj.jdbc.Driver");                  
         	Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connecter");
            return conn;
         } catch (Exception e){
             e.printStackTrace();
             System.out.println("Erreur");
             //System.exit(0);
             return null;
         }
         
	}

	public static void main(String[] args) throws SQLException {
       // EventQueue.invokeLater(new Runnable() {
          //  public void run() {
                // Votre fonction Run
                // Vos information de connexion à une base de données
                
				/*
				String BDD = "cabinet";
                String url = "jdbc:mysql://localhost:3306/" + BDD; //3308
                String user = "root";
                String passwd = "";
                // L'essaie de connexion à votre base de donées
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");                  
                	Connection conn = DriverManager.getConnection(url, user, passwd);
                    System.out.println("Connecter");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
                */
                //getConnection();
                //Users u = new Users("admin",0);
                //System.out.println(u.login("admin", "admin"));
         //   }
       // });
    }
}	
