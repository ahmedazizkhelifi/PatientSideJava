package classes;

import java.sql.Date;

public class RDV {
	private int id;
	private Date date_RDV;
	private int heure; 
	private int id_patient;
	public RDV(int id,Date date_RDV,int heure,int p) {
		this.id=id;
		this.date_RDV=date_RDV;
		this.heure=heure;
		this.setId_patient(p);
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




	public int getId_patient() {
		return id_patient;
	}




	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	} 
	

}
