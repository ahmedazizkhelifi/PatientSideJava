package classes;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RDVTV {
	private int id;
	private Date quand;
	private String temps;
	private int idPatient;
	private String nomPatient;
	private String prenomPatient;
	
	public RDVTV(RDV rdv) throws SQLException {
		this.id = rdv.getId();
		this.quand = rdv.getQuand();
		this.temps = Integer.toString(rdv.getHeure()) + ":" + Integer.toString(rdv.getMinute());
		this.idPatient = rdv.getIdPatient();
		Patient p = Patient.getPatientFromId(this.idPatient);
		this.nomPatient = p.getNom();
		this.prenomPatient = p.getPrenom();
		
	}
	
	public static List < RDVTV > read() throws SQLException {
		ArrayList<RDV> _patients = RDV.read(false, -1, false);
		List < RDVTV > array = _patients.stream().map(r -> {
			try {
				return new RDVTV(r);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		return array;
	}
	
	
	
	
	public String getTemps() {
		return temps;
	}
	public void setTemps(String temps) {
		this.temps = temps;
	}
	public String getNomPatient() {
		return nomPatient;
	}
	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	public String getPrenomPatient() {
		return prenomPatient;
	}
	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}




	public int getIdPatient() {
		return idPatient;
	}




	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}




	public Date getQuand() {
		return quand;
	}




	public void setQuand(Date quand) {
		this.quand = quand;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", nom='" + getNomPatient() + "'" +
			", prenom='" + getPrenomPatient() + "'" +
			
			"}";
	}
	
	
}
