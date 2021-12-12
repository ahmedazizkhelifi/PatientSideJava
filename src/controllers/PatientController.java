package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class PatientController {

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
    private Label lblWhere;

    @FXML
    private Tab tabAcceuil;

    @FXML
    private Tab tabAgenda;

    @FXML
    private Tab tabConsultations;

    @FXML
    private Tab tabParam;

    @FXML
    private Tab tabProfile;

    @FXML
    private Tab tabRV;

    @FXML
    private TabPane tabsMedecin;

    @FXML
    private VBox vbSB;

    @FXML
    private VBox vbSB1;

    
    private void where(int here) {
		switch(here) {
		case 0:
			lblWhere.setText("Acceuil");
			tabsMedecin.getSelectionModel().select(tabAcceuil);
			break;
		case 1:
			lblWhere.setText("Profile");
			tabsMedecin.getSelectionModel().select(tabProfile);
			break;
		case 2:
			lblWhere.setText("Consultations");
			tabsMedecin.getSelectionModel().select(tabConsultations);
			break;
		case 3:
			lblWhere.setText("Rendez-vous");
			tabsMedecin.getSelectionModel().select(tabRV);
			break;
		case 4:
			lblWhere.setText("Agenda");
			tabsMedecin.getSelectionModel().select(tabAgenda);
			break;
		case 5:
			lblWhere.setText("Paramètres");
			tabsMedecin.getSelectionModel().select(tabParam);
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
