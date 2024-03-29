package Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; 
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;


public class SampleController implements Initializable {

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
	    private Button btnHideSideBar;

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
	    private Button btnSecretaires;

	    @FXML
	    private Button btnSecretaires1;

	    @FXML
	    private Label lbl1;

	    @FXML
	    private Label lbl2;

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
	    private Tab tabParams;

	    @FXML
	    private Tab tabPatients;

	    @FXML
	    private Tab tabRV;

	    @FXML
	    private Tab tabSecretaires;

	    @FXML
	    private TabPane tabsMedecin;

	    @FXML
	    private VBox vbSideBar;

	    @FXML
	    private VBox vbSideBar1;

	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
			tabsMedecin.getSelectionModel().select(tabSecretaires);
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
			tabsMedecin.getSelectionModel().select(tabParams);
			break;
		}
	}
	
	 @FXML
	private void handleClicks (ActionEvent event) {
		event.consume();
		if (event.getSource() == btnAcceuil) {
			where(0);
		}
		
		if (event.getSource() == btnPatients) {
			where(1);
			lbl1.setText("Donee");	
		}
		
		if (event.getSource() == btnConsultations) {
			where(2);
			lbl2.setText("Donee");	
		}
		
		if (event.getSource() == btnRV) {
			where(3);
		}
		
		if (event.getSource() == btnSecretaires) {
			where(4);
		}
		if (event.getSource() == btnAgenda) {
			where(5);
		}
		if (event.getSource() == btnCompta) {
			where(6);
		}
		if (event.getSource() == btnParam) {
			where(7);
		}
		if (event.getSource() == btnHideSideBar) {
			System.out.println("mmm");
			if(vbSideBar.isVisible()) {
				vbSideBar.setVisible(false);
				tabsMedecin.setTranslateX(-275);
				//tabsMedecin.setPrefWidth(1105);
				
				System.out.println(tabsMedecin.getPrefWidth());
				System.out.println(tabsMedecin.getMaxWidth());
				
				vbSideBar1.setVisible(true);
			}
			else {
				vbSideBar.setVisible(true);
				tabsMedecin.setTranslateX(1);
				vbSideBar1.setVisible(false);
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
