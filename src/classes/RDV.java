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
	private Date date_RDV;
	private int heure; 
	private int id_patient;
	private int minutes;
	private int done;
	private int idPatient;
	private int idMedecin;
	
	private static Connection conn = Mysqlconnector.getConnection();
	
	public RDV() {
		
	}
	
	public RDV(int id,Date date_RDV,int heure, int minutes, int done ,int idPatient, int idMedecin) {
		this.id=id;
		this.date_RDV=date_RDV;
		this.heure=heure;
		this.minutes = minutes;
		this.setDone(done);
		this.setIdPatient(idPatient);
		this.setIdMedecin(idMedecin);
	}
	

	
	public ArrayList<RDV> getRDVs(int queryWho, int id) throws SQLException {
		String query = "";
		if (queryWho == -1)
			query = "SELECT * FROM rdv";
		else if (queryWho == 0) {
			query = "SELECT * FROM rdv " + "WHERE idMedecin = " + id;
		}else if (queryWho == 1) {
			query = "SELECT * FROM rdv " + "WHERE idPatient = " + id;
		}
		PreparedStatement statement = conn.prepareStatement(query);
		ResultSet resultat = statement.executeQuery();
		ArrayList<RDV> RDVs =  new ArrayList<RDV>();
		while (resultat.next()) {
			int _id = resultat.getInt(1);
			Date _date = resultat.getDate("quand");
			int _heure = resultat.getInt("heure"); 
			int _minute = resultat.getInt("minute"); 
			int _idPatient = resultat.getInt("idPatient");
			int _idMedecin = resultat.getInt("idMedecin");
			int _done = resultat.getInt("done");
			RDV rdv =new RDV(_id,_date,_heure,_minute,_done,_idPatient,_idMedecin);
			RDVs.add(rdv);
		}
		return RDVs;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate_RDV() {
		return date_RDV;
	}
	public void setDate_RDV(Date date_RDV) {
		this.date_RDV = date_RDV;
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

	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public int getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	} 
	
	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", date_RDV='" + getDate_RDV() + "'" +
			", heure='" + getHeure() + "'" +
			", minutes='" + getMinute() + "'" +
			", done='" + getDone() + "'" +
			", idPatient='" + getIdPatient() + "'" +
			", idMedecin='" + getIdMedecin() + "'" +
			"}";
	}
}
