package controllers;

import classes.CurrentUserData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import application.Main;


public class MedecinController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void logOut(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../fxmls/Login/Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		System.out.println(stage);
		stage.show();
	}

	
	
    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnAcceuil1;

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
    private Label lblWhere;

    @FXML
    private Tab tabAcceuil;

    @FXML
    private Tab tabAgenda;

    @FXML
    private Tab tabCompta;

    @FXML
    private Tab tabConsultations;

    @FXML
    private Tab tabParam;

    @FXML
    private Tab tabPatients;

    @FXML
    private Tab tabRV;

    @FXML
    private Tab tabSec;
    
    @FXML
    private TabPane tabsMedecin;

    @FXML
    private VBox vbSB;

    @FXML
    private VBox vbSB1;

    
    
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
		System.out.println("Med Id:" +CurrentUserData.getRoleId());
	}
	
	private void where(int here) {
		switch(here) {
		case 0:
			lblWhere.setText("Acceuil");
			tabsMedecin.getSelectionModel().select(tabAcceuil);
			break;
		case 1:
			lblWhere.setText("Patients");
			tabsMedecin.getSelectionModel().select(tabPatients);
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
			lblWhere.setText("Secretaires");
			tabsMedecin.getSelectionModel().select(tabSec);
			break;
		case 5:
			lblWhere.setText("Agenda");
			tabsMedecin.getSelectionModel().select(tabAgenda);
			break;
		case 6:
			lblWhere.setText("Comptabilité");
			tabsMedecin.getSelectionModel().select(tabCompta);
			break;
		case 7:
			lblWhere.setText("Paramètres");
			tabsMedecin.getSelectionModel().select(tabParam);
			
			break;
		}
	}
	

	
	 @FXML
	private void handleClicks (ActionEvent event) {
		event.consume();
		if (event.getSource() == btnAcceuil || event.getSource() == btnAcceuil1) {
			receiveData(event);
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
		if (event.getSource() == btnHide) {
			System.out.println("mmm");
			if(vbSB.isVisible()) {
				vbSB.setVisible(false);
				tabsMedecin.setTranslateX(-265);
				//tabsMedecin.setPrefWidth(1105);
				System.out.println(tabsMedecin.getPrefWidth());
				System.out.println(tabsMedecin.getMaxWidth());
				
				vbSB1.setVisible(true);
			}
			else {
				vbSB.setVisible(true);
				tabsMedecin.setTranslateX(1);
				vbSB1.setVisible(false);
			}
			
			
			
		}
	}
	
	 
	 // Debugging
	  @FXML
	    private void printSource(ActionEvent event) {
	        event.consume();
	        if (event.getSource() == btnPatients) {
	        	System.out.println("mkllmkmlk");
	       
	        }
	        else if (event.getSource() == btnConsultations) {
	        	System.out.println(event.getSource().toString());
	        	tabsMedecin.getSelectionModel().select(1);
	        }
	    }
}

	
/*
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class SampleController {

    @FXML
    private Button btnPatients;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Button ptnConsultations;

    @FXML
    private Tab tabConsultations;

    @FXML
    private TabPane tabMed;

    @FXML
    private Tab tabPatients;

}

*/
