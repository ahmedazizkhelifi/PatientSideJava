package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import classes.CurrentUserData;
import classes.Patient;
import classes.RDV;
import classes.Users;


public class PatientController implements Initializable{
	
	
	
	 @FXML
	    private AnchorPane pnlRVHider;

    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnAcceuil1;

    @FXML
    private Button btnMAJProfile;

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
    private Button btnSaveNotes;
    
    @FXML
    private Button btnReqRV;

    @FXML
    private Button btnSendRVReq;

    @FXML
    private DatePicker dpReqRVDate;

    @FXML
    private Label lblUserId;

    
    @FXML
    private Label lblMajNotes;
    
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
    private Tab tabReqRV;

    @FXML
    private TabPane tabsConsultations;

    @FXML
    private TabPane tabsPatient;

    @FXML
    private TabPane tabsRV;

    @FXML
    private TableColumn<?, ?> tcConsultaDate;

    @FXML
    private TableColumn<?, ?> tcConsultaId;

    @FXML
    private TableColumn<?, ?> tcConsultaRealise;

    @FXML
    private TableColumn<RDV, Date> tcRVDate;

    @FXML
    private TableColumn<RDV, Integer> tcRVDone;

    @FXML
    private TableColumn<RDV, Integer> tcRVId;

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
    private TableView<RDV> tvRV;

    @FXML
    private ImageView userImg1;

    @FXML
    private VBox vbSB;

    @FXML
    private VBox vbSB1;
    
    @FXML
    private TextField tfReqRVHeure;

    @FXML
    private TextField tfReqRVMin;

    @FXML
    private TextArea tfReqRVNotes;
	    
    @FXML
    private Label lblMAJDone;
    
    @FXML
    private Button btnWoo;
    @FXML
    private Button   __btnDel;
  
    private Patient p = new Patient();
	    
    private Stage stage;
	private Scene scene;
	private Parent root;
	    
	    

	private void initProfile() throws SQLException {
		lblUserId.setText(Integer.toString(p.getId()));
		tfNom.setText(p.getNom().toUpperCase());
		tfPrenom.setText(p.getPrenom());
		tfTel.setText(p.getTelf());
		tfSexe.setText(p.getSexe());
		tfAdresse.setText(p.getAdresse());
		tfNotes.setText(p.getNotes());
	}
	
	
	public void logOut(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../fxmls/Login/Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		System.out.println(stage);
		stage.show();
	}
	
	private void initTV() throws SQLException{
		RDV rdv = new RDV();
		ArrayList<RDV> _RDVs = rdv.read(true, p.getId(), false);
		System.out.println(_RDVs);
		
		tcRVId.setCellValueFactory(new PropertyValueFactory<RDV, Integer>("id"));
		tcRVDate.setCellValueFactory(new PropertyValueFactory<RDV, Date>("quand"));
		tcRVDone.setCellValueFactory(new PropertyValueFactory<RDV, Integer>("done"));
		ObservableList<RDV> RDVs = FXCollections.observableArrayList(_RDVs);

		tvRV.setItems(RDVs);
	}
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	initVisible();
		try {
			p = Patient.getPatientFromId(CurrentUserData.getRoleId());
			System.out.println(p.toString());
			initProfile();
			initTV();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @FXML
    void cellDoubleClicked(MouseEvent event) {
    	if (event.getSource() == tvConsultations) {
    		if (event.getClickCount() == 2) {
        		//System.out.println(tvConsultations.getSelectionModel().getSelectedItem().getClass().getName());                   
        	}
    	}
    	
    	if (event.getSource() == tvRV) {
    		if (event.getClickCount() == 2) {
    			tabRVDetails(tvRV.getSelectionModel().getSelectedItem());
    			System.out.println(tvRV.getSelectionModel().getSelectedItem().getId());                 
        	}
    	}
    	
    }
    	
 
    private void where(int here) {
    	initVisible();
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
			tabsRV.getSelectionModel().select(tabHistoriqueRV);
			break;
		case 4:
			lblWhere.setText("Agenda");
			tabsPatient.getSelectionModel().select(tabAgenda);
			break;
		case 5:
			lblWhere.setText("Paramètres");
			tabsPatient.getSelectionModel().select(tabParam);
			break;
		case 31:
			lblWhere.setText("Rendez-vous/Demande");
			tabsRV.getSelectionModel().select(tabReqRV);
			break;
		}
	}
    
    void initVisible() {
    	lblMAJDone.setVisible(false);
    	lblMajNotes.setVisible(false);
    }
    
    @FXML
    void MAJProfile(ActionEvent event) throws SQLException {
    	if (event.getSource() == btnMAJProfile) {
    		p.setNom(tfNom.getText());
        	p.setPrenom(tfPrenom.getText());
        	p.setTelf(tfTel.getText());
        	p.setTelf(tfSexe.getText());
        	p.setAdresse(tfAdresse.getText());
        	p.update();
        	lblMAJDone.setVisible(true);
    	}
    	
    	if (event.getSource() == btnSaveNotes) {
    		p.updateNotes(tfNotes.getText());
    		lblMajNotes.setVisible(true);
    	}
    }
    
    void tabRVDetails(RDV rdv) {
    	
    	tabsRV.getSelectionModel().select(2);
    	
    }

    
    @FXML
    void handleClicks(ActionEvent event) throws SQLException {
    	
    	// side bar
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
		
		
		// RV
		if(event.getSource() == btnReqRV) {
			where(31);
		}
		
		if (event.getSource() == btnSendRVReq) {
			RDV r = new RDV(-1,  Date.valueOf(dpReqRVDate.getValue()), Integer.parseInt(tfReqRVHeure.getText()), Integer.parseInt(tfReqRVMin.getText()), false, p.getId(), new Date(1999,1,2), true);
			r.create();
		}
		
		
    }

    @FXML
    void fnAfficher(ActionEvent event) {
    	System.out.println("lkjlkj");
    }
    

    @FXML
    void deeel(ActionEvent event) throws SQLException {
    	p.delete();
    	int i = Users.getUserFromPatientId(p.getId());
    	Users.delete(i);
    	
    }

}
