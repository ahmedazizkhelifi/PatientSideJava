package classes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultationTV {
	private int id;
	private int idPatient;
	private String nomPatient;
	private String prenomPatient;
	
	public ConsultationTV(Consultation c) throws SQLException {
		this.setId(c.getId());
		this.idPatient = c.getIdPatient();
		Patient p = Patient.getPatientFromId(this.idPatient);
		this.setNomPatient(p.getNom());
		this.setPrenomPatient(p.getPrenom());
	}
	
	public static List < ConsultationTV > read() throws SQLException {
		ArrayList<Consultation> _consultations = Consultation.read();
		List < ConsultationTV > array = _consultations.stream().map(c -> {
			try {
				return new ConsultationTV(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		return array;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int id) {
		this.idPatient = id;
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
}
