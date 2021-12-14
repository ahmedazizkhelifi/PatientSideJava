package controllers;

import classes.CurrentUserData;
import classes.Patient;
import classes.RDVTV;
import classes.Secretaire;
import classes.Users;
import classes.Consultation;
import classes.ConsultationTV;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MedecinController implements Initializable {

   private Stage stage;
   private Scene scene;
   private Parent root;
   
   @FXML
   private Button __btnAddPatient;

   @FXML
   private Label __lblUserAccount;

   @FXML
   private AnchorPane __pnlLogin;

   @FXML
   private RadioButton __rbF;

   @FXML
   private RadioButton __rbH;

   @FXML
   private TextField __tfAdress;

   @FXML
   private DatePicker __tfBd;

   @FXML
   private TextField __tfNom;

   @FXML
   private TextField __tfPrenom;

   @FXML
   private TextField __tfTel;

   @FXML
   private Label _lblIdConsulta;

   @FXML
   private AnchorPane _pnlHider;

   @FXML
   private TextArea _tfConsultaDetails;

   @FXML
   private TextArea _tfConsultaOrdonnance;

   @FXML
   private TextField _tfConsultaPatientName;

   
   @FXML
   private Button btnAcceuil;

   @FXML
   private Button btnAcceuil1;

   @FXML
   private Button btnAddConsulta;

   @FXML
   private Button btnAddPatient;

   @FXML
   private Button btnAddRV;

   @FXML
   private Button btnAddSec;

   @FXML
   private Button btnAgenda;

   @FXML
   private Button btnAgenda1;

   @FXML
   private Button btnCompta;

   @FXML
   private Button btnCompta1;

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
   private Button btnPatients;

   @FXML
   private Button btnPatients1;

   @FXML
   private Button btnRV;

   @FXML
   private Button btnRV1;

   @FXML
   private Button btnSecretaire;

   @FXML
   private Button btnSecretaires1;

   @FXML
   private ComboBox < ? > cbPatient;

   @FXML
   private ComboBox < ? > cbRV;

   @FXML
   private ComboBox < ? > cbSearchConsulta;

   @FXML
   private ComboBox < ? > cbSec;

   @FXML
   private Label lblWhere;

   @FXML
   private AnchorPane pnlMainHider;

   @FXML
   private Tab tabAcceuil;

   @FXML
   private Tab tabAddConsulta;

   @FXML
   private Tab tabAddRV;

   @FXML
   private Tab tabAddSec;

   @FXML
   private Tab tabCompta;

   @FXML
   private Tab tabConsultaDetails;

   @FXML
   private Tab tabConsultations;

   @FXML
   private Tab tabMainAgenda;

   @FXML
   private Tab tabMainConsultations;

   @FXML
   private Tab tabMainPatients;

   @FXML
   private Tab tabMainRV;

   @FXML
   private Tab tabMainSec;

   @FXML
   private Tab tabParam;

   @FXML
   private Tab tabPatients;

   @FXML
   private Tab tabProfilPatient;

   @FXML
   private Tab tabRV;

   @FXML
   private Tab tabRVDetails;

   @FXML
   private Tab tabSec;

   @FXML
   private Tab tabSecProfil;

   @FXML
   private TabPane tabsMedecin;

   @FXML
   private TableColumn < ConsultationTV , Integer > tcConsultaId;

   @FXML
   private TableColumn < ConsultationTV , Integer > tcConsultaIdPatient;

   @FXML
   private TableColumn < ConsultationTV , String > tcConsultaNomPatient;

   @FXML
   private TableColumn < ConsultationTV , String > tcConsultaPrenomPatient;

   @FXML
   private TableColumn < Patient, Date > tcPatientBD;

   @FXML
   private TableColumn < Patient, Integer > tcPatientId;

   @FXML
   private TableColumn < Patient, String > tcPatientNom;

   @FXML
   private TableColumn < Patient, String > tcPatientPrenom;

   @FXML
   private TableColumn < Patient, String > tcPatientSexe;

   @FXML
   private TableColumn < Patient, String > tcPatientTelf;

   @FXML
   private TableColumn < RDVTV, Integer > tcRVId;

   @FXML
   private TableColumn < RDVTV, Integer > tcRVIdPatient;

   @FXML
   private TableColumn < RDVTV, String > tcRVNomPatient;

   @FXML
   private TableColumn < RDVTV, String > tcRVPrenomPatient;

   @FXML
   private TableColumn < RDVTV, Date > tcRVQuand;

   @FXML
   private TableColumn < RDVTV, String > tcRVTemps;

   @FXML
   private TableColumn < Secretaire , Date > tcSecBD;

   @FXML
   private TableColumn < Secretaire , Integer > tcSecId;

   @FXML
   private TableColumn < Secretaire , String > tcSecNom;

   @FXML
   private TableColumn < Secretaire , String > tcSecPrenom;

   @FXML
   private TableColumn < Secretaire , Float > tcSecSalaire;

   @FXML
   private TableColumn < Secretaire , String > tcSecSexe;

   @FXML
   private TableColumn < Secretaire , String > tcSecTelf;

   @FXML
   private TextField tfSearchConsulta;

   @FXML
   private TextField tfSearchPatient;

   @FXML
   private TextField tfSearchRV;

   @FXML
   private TextField tfSearchSec;

   @FXML
   private TabPane tpConsulta;

   @FXML
   private TabPane tpPatients1;

   @FXML
   private TabPane tpRV;

   @FXML
   private TabPane tpSec;

   @FXML
   private TableView < ConsultationTV > tvConsulta;

   @FXML
   private TableView < Patient > tvPatients;

   @FXML
   private TableView < RDVTV > tvRV;

   @FXML
   private TableView < Secretaire > tvSec;

   @FXML
   private VBox vbSB;

   @FXML
   private VBox vbSB1;

   ToggleGroup toggleGroup = new ToggleGroup();
   
   private void initTv() throws SQLException {
      // Patient

      ArrayList < Patient > _patients = Patient.readPatients();
      tcPatientId.setCellValueFactory(new PropertyValueFactory < Patient, Integer > ("id"));
      tcPatientNom.setCellValueFactory(new PropertyValueFactory < Patient, String > ("nom"));
      tcPatientPrenom.setCellValueFactory(new PropertyValueFactory < Patient, String > ("prenom"));
      tcPatientBD.setCellValueFactory(new PropertyValueFactory < Patient, Date > ("date_ness"));
      tcPatientTelf.setCellValueFactory(new PropertyValueFactory < Patient, String > ("telf"));
      tcPatientSexe.setCellValueFactory(new PropertyValueFactory < Patient, String > ("sexe"));
      ObservableList < Patient > patients = FXCollections.observableArrayList(_patients);
      tvPatients.setItems(patients);

      // RDV
      List < RDVTV > _rdvtv = RDVTV.read();
      tcRVId.setCellValueFactory(new PropertyValueFactory < RDVTV, Integer > ("id"));
      tcRVQuand.setCellValueFactory(new PropertyValueFactory < RDVTV, Date > ("quand"));
      tcRVTemps.setCellValueFactory(new PropertyValueFactory < RDVTV, String > ("temps"));
      tcRVIdPatient.setCellValueFactory(new PropertyValueFactory < RDVTV, Integer > ("idPatient"));
      tcRVNomPatient.setCellValueFactory(new PropertyValueFactory < RDVTV, String > ("nomPatient"));
      tcRVPrenomPatient.setCellValueFactory(new PropertyValueFactory < RDVTV, String > ("prenomPatient"));
      ObservableList < RDVTV > rdvtv = FXCollections.observableList(_rdvtv);
      tvRV.setItems(rdvtv);
      
      // Secretaire
      
      ArrayList < Secretaire > _secretaires = Secretaire.read();
      tcSecId.setCellValueFactory(new PropertyValueFactory < Secretaire, Integer > ("id"));
      tcSecNom.setCellValueFactory(new PropertyValueFactory < Secretaire, String > ("nom"));
      tcSecPrenom.setCellValueFactory(new PropertyValueFactory < Secretaire, String > ("prenom"));
      tcSecBD.setCellValueFactory(new PropertyValueFactory < Secretaire, Date > ("date_ness"));
      tcSecTelf.setCellValueFactory(new PropertyValueFactory < Secretaire, String > ("telf"));
      tcSecSexe.setCellValueFactory(new PropertyValueFactory < Secretaire, String > ("sexe"));
      tcSecSalaire.setCellValueFactory(new PropertyValueFactory < Secretaire, Float > ("adresse"));
      ObservableList < Secretaire > secretaires = FXCollections.observableArrayList(_secretaires);
      tvSec.setItems(secretaires);

      // Consultations
      List < ConsultationTV > _consultationTV = ConsultationTV.read();
      tcConsultaId.setCellValueFactory(new PropertyValueFactory < ConsultationTV, Integer > ("id"));
      tcConsultaIdPatient.setCellValueFactory(new PropertyValueFactory < ConsultationTV, Integer > ("idPatient"));
      tcConsultaNomPatient.setCellValueFactory(new PropertyValueFactory < ConsultationTV, String > ("nomPatient"));
      tcConsultaPrenomPatient.setCellValueFactory(new PropertyValueFactory < ConsultationTV, String > ("prenomPatient"));
      
      ObservableList < ConsultationTV > consultationTV = FXCollections.observableList(_consultationTV);
      tvConsulta.setItems(consultationTV);
      
   }

   public void logOut(ActionEvent event) throws IOException {
      root = FXMLLoader.load(getClass().getResource("../fxmls/Login/Login.fxml"));
      stage = (Stage)((Node) event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      System.out.println(stage);
      stage.show();
   }

   @FXML
   private void receiveData(ActionEvent event) {
      System.out.println(event.getSource());
      // Step 1
      Node node = (Node) event.getSource();
      Stage stage = (Stage) node.getScene().getWindow();
      // Step 2
      String str = (String) stage.getUserData();
      // Step 3
      System.out.println("str" + str);
   }

   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      try {
         initTv();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      _pnlHider.setVisible(true);
      pnlMainHider.setVisible(false);
      __rbH.setToggleGroup(toggleGroup);
      __rbF.setToggleGroup(toggleGroup);
   }
   
   @FXML
   void cellDoubleClicked(MouseEvent event) throws SQLException {

	   
	   if (event.getSource() == tvConsulta) {
           Consultation c = Consultation.readFromId(tvConsulta.getSelectionModel().getSelectedItem().getId());
           _lblIdConsulta.setText(Integer.toString(c.getId()));
           _tfConsultaDetails.setText(c.getDetails());
           _tfConsultaOrdonnance.setText(c.getOrdonnance());
           Patient p = Patient.getPatientFromId(c.getIdPatient());
           _tfConsultaPatientName.setText(p.getFullName());
           doubleClickNavigation( tpConsulta, event);
           
	   }
	   
	   if (event.getSource() == tvPatients) {
		   doubleClickNavigation(tpConsulta, event);
	   }
	   
	   if (event.getSource() == tvRV) {
		   doubleClickNavigation(tpConsulta, event);
	   }
	   
	   if (event.getSource() == tvSec) {
		   doubleClickNavigation(tpConsulta, event);
	   }
   }

   private void doubleClickNavigation(TabPane tp, MouseEvent event) {
	         if (event.getClickCount() == 2) {
	            tp.getSelectionModel().select(1);
	         }
	     
   }
   
   private void resetSecondaryNavigation() {
	   pnlMainHider.setVisible(false);
	   tpPatients1.getSelectionModel().select(0);
	   tpConsulta.getSelectionModel().select(0);
	   tpRV.getSelectionModel().select(0);
	   tpSec.getSelectionModel().select(0);
   }

   private void where(int here) {
      switch (here) {
      case 0:
         lblWhere.setText("Acceuil");
         tabsMedecin.getSelectionModel().select(tabAcceuil);
         resetSecondaryNavigation();
         break;
      case 1:
         lblWhere.setText("Patients");
         resetSecondaryNavigation();
         tabsMedecin.getSelectionModel().select(tabMainPatients);
         pnlMainHider.setVisible(true);

         break;
      case 2:
         lblWhere.setText("Consultations");
         resetSecondaryNavigation();
         tabsMedecin.getSelectionModel().select(tabMainConsultations);
         tpConsulta.getSelectionModel().select(0);
         pnlMainHider.setVisible(true);
         break;
      case 3:
         lblWhere.setText("Rendez-vous");
         resetSecondaryNavigation();
         tabsMedecin.getSelectionModel().select(tabMainRV);
         pnlMainHider.setVisible(true);
         break;
      case 4:
         lblWhere.setText("Secretaires");
         resetSecondaryNavigation();
         tabsMedecin.getSelectionModel().select(tabMainSec);
         pnlMainHider.setVisible(true);
         break;
      case 5:
         lblWhere.setText("Agenda");
         resetSecondaryNavigation();
         tabsMedecin.getSelectionModel().select(tabMainAgenda);
         break;
      case 6:
         lblWhere.setText("Comptabilité");
         tabsMedecin.getSelectionModel().select(tabCompta);
         resetSecondaryNavigation();
         break;
      case 7:
         lblWhere.setText("Paramètres");
         tabsMedecin.getSelectionModel().select(tabParam);
         resetSecondaryNavigation();
         break;
      }
   }

   @FXML
   private void handleClicks(ActionEvent event) throws SQLException {
      event.consume();
      if (event.getSource() == btnAcceuil || event.getSource() == btnAcceuil1) {
         where(0);
      }

      if (event.getSource() == btnPatients || event.getSource() == btnPatients1) {
         where(1);

      }

      if (event.getSource() == btnConsultations || event.getSource() == btnConsultations1) {
         where(2);

      }

      if (event.getSource() == btnRV || event.getSource() == btnRV1) {
         where(3);
      }

      if (event.getSource() == btnSecretaire || event.getSource() == btnSecretaires1) {
         where(4);
      }
      if (event.getSource() == btnAgenda || event.getSource() == btnAgenda1) {
         where(5);
      }
      if (event.getSource() == btnCompta || event.getSource() == btnCompta1) {
         where(6);
      }
      if (event.getSource() == btnParam || event.getSource() == btnParam1) {
         where(7);
      }
      
      if(event.getSource() == btnAddRV) {
    	  tpRV.getSelectionModel().select(2);
      }
      
      if(event.getSource() == btnAddSec) {
    	  tpSec.getSelectionModel().select(2);
      }
      
      if(event.getSource() == btnAddPatient) {
    	  resetAjouterPat();
    	  // w faregh l contenu taa lokhrin
    	  tpPatients1.getSelectionModel().select(2);
      }
      
      if(event.getSource() == btnAddConsulta) {
    	  tpConsulta.getSelectionModel().select(2);
      }
      
      if (event.getSource() == __btnAddPatient) {
    	  RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
			String sexe = selectedRadioButton.getText();
			Patient p = new Patient(__tfNom.getText(), __tfPrenom.getText(), Date.valueOf(__tfBd.getValue()), __tfTel.getText(), sexe, __tfAdress.getText());
			String _str = Integer.toString(Patient.getMaxPatientId());
			Users u = new Users(_str, _str);
			if (u.signUp(p)) {
				System.out.println("user: " + _str);
				__pnlLogin.setVisible(true);
				__lblUserAccount.setText(_str);
			}
				
			else
				System.out.println("nope");
				
      }
      
      
      if (event.getSource() == btnHide) {
         System.out.println("mmm");
         if (vbSB.isVisible()) {
            vbSB.setVisible(false);
            tabsMedecin.setTranslateX(-265);
            //tabsMedecin.setPrefWidth(1105);
            System.out.println(tabsMedecin.getPrefWidth());
            System.out.println(tabsMedecin.getMaxWidth());

            vbSB1.setVisible(true);
         } else {
            vbSB.setVisible(true);
            tabsMedecin.setTranslateX(1);
            vbSB1.setVisible(false);
         }

      }
   }
   
   private void resetAjouterPat() {
	   __tfPrenom.setText("");
	   __tfNom.setText("");
	   __tfAdress.setText("");
	   __tfTel.setText("");
	   __pnlLogin.setVisible(false);
   }

   // Debugging
   @FXML
   private void printSource(ActionEvent event) {
      event.consume();
      if (event.getSource() == btnPatients) {
         System.out.println("mkllmkmlk");

      } else if (event.getSource() == btnConsultations) {
         System.out.println(event.getSource().toString());
         tabsMedecin.getSelectionModel().select(1);
      }
   }

   @FXML
   void handleSearch(ActionEvent event) {

   }
}