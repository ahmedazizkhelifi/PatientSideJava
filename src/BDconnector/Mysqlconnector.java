package BDconnector;


import java.sql.Connection;
import java.sql.DriverManager;

public class Mysqlconnector {

	public static void main(String[] args) {
       // EventQueue.invokeLater(new Runnable() {
          //  public void run() {
                // Votre fonction Run
                // Vos information de connexion � une base de donn�es
                String BDD = "cabinet";
                String url = "jdbc:mysql://localhost:3308/" + BDD;
                String user = "root";
                String passwd = "";
                // L'essaie de connexion � votre base de don�es
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");                  
                	Connection conn = DriverManager.getConnection(url, user, passwd);
                    System.out.println("Connecter");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
         //   }
       // });
    }
}	
