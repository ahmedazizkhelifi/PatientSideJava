package controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


import classes.CurrentUserData;
import classes.Patient;



public class PatientController implements Initializable{
	

		@FXML
	    private Button btnAcceuil;

	    @FXML
	    private Button btnAcceuil1;

	    @FXML
	    private Button btnAgenda;

	    @FXML
	    private Button btnAgenda1;

	    @FXML
	    private Button btnConsultations;

	    @FXML
	    private Button btnConsultations1;

	    @FXML
	    private Button btnHide;

	    @FXML
	    private Button btnLogout;

	    @FXML
	    private Button btnParam;

	    @FXML
	    private Button btnParam1;

	    @FXML
	    private Button btnProfile;

	    @FXML
	    private Button btnProfile1;

	    @FXML
	    private Button btnRV;

	    @FXML
	    private Button btnRV1;

	    @FXML
	    private Label lblUserId;

	    @FXML
	    private Label lblWhere;

	    @FXML
	    private Tab tabAcceuil;

	    @FXML
	    private Tab tabAgenda;

	    @FXML
	    private Tab tabConsultations;

	    @FXML
	    private Tab tabHistoriqueConsultations;

	    @FXML
	    private Tab tabHistoriqueRV;

	    @FXML
	    private Tab tabParam;

	    @FXML
	    private Tab tabProfile;

	    @FXML
	    private Tab tabRV;

	    @FXML
	    private TabPane tabsConsultations;

	    @FXML
	    private TabPane tabsPatient;

	    @FXML
	    private TabPane tabsRV;

	    @FXML
	    private TextArea tfAdresse;

	    @FXML
	    private TextField tfNom;

	    @FXML
	    private TextArea tfNotes;

	    @FXML
	    private TextField tfPrenom;

	    @FXML
	    private TextField tfSexe;

	    @FXML
	    private TextField tfTel;

	    @FXML
	    private TableView<?> tvConsultations;

	    @FXML
	    private TableView<?> tvRV;

	    @FXML
	    private ImageView userImg1;

	    @FXML
	    private VBox vbSB;

	    @FXML
	    private VBox vbSB1;
	    
	    private Patient p = new Patient();
	    
	    //super(id, nom, prenon, date_ness, telf, sexe, adresse);

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Pat Id:" +CurrentUserData.getRoleId());	
		try {
			p = Patient.getPatientFromId(CurrentUserData.getRoleId());
			System.out.println(p.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblUserId.setText(Integer.toString(p.getId()));
		tfNom.setText(p.getNom().toUpperCase());
		tfPrenom.setText(p.getPrenom());
		tfTel.setText(p.getTelf());
		tfSexe.setText(p.getSexe());
		tfAdresse.setText(p.getAdresse());
	}
    private void where(int here) {
		switch(here) {
		case 0:
			lblWhere.setText("Acceuil");
			tabsPatient.getSelectionModel().select(tabAcceuil);
			break;
		case 1:
			lblWhere.setText("Profile");
			tabsPatient.getSelectionModel().select(tabProfile);
			break;
		case 2:
			lblWhere.setText("Consultations");
			tabsPatient.getSelectionModel().select(tabConsultations);
			break;
		case 3:
			lblWhere.setText("Rendez-vous");
			tabsPatient.getSelectionModel().select(tabRV);
			break;
		case 4:
			lblWhere.setText("Agenda");
			tabsPatient.getSelectionModel().select(tabAgenda);
			break;
		case 5:
			lblWhere.setText("Paramètres");
			tabsPatient.getSelectionModel().select(tabParam);
			break;
		}
	}
    
    @FXML
    void handleClicks(ActionEvent event) {
    	if (event.getSource() == btnAcceuil || event.getSource() == btnAcceuil1) {
			where(0);
		}
		
		if (event.getSource() == btnProfile || event.getSource() == btnProfile1) {
			where(1);
			
		}
		
		if (event.getSource() == btnConsultations || event.getSource() == btnConsultations1) {
			where(2);
			
		}
		
		if (event.getSource() == btnRV || event.getSource() == btnRV1) {
			where(3);
		}
		
		if (event.getSource() == btnAgenda || event.getSource() == btnAgenda1) {
			where(4);
		}
		if (event.getSource() == btnParam || event.getSource() == btnParam1) {
			where(5);
		}
    }

    @FXML
    void logOut(ActionEvent event) {

    }

}
