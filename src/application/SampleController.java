package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; 
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class SampleController implements Initializable {

    @FXML
    private Button btnPatients;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Button btnConsultations;

    @FXML
    private Tab tabConsultations;

    @FXML
    private TabPane tabsMedecin;

    @FXML
    private Tab tabPatients;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	 @FXML
	private void handleClicks (ActionEvent event) {
		event.consume();
		if (event.getSource() == btnPatients) {
			lbl1.setText("Donee");
		 	tabsMedecin.getSelectionModel().select(tabPatients);
		}
		if (event.getSource() == btnConsultations) {
			lbl2.setText("Donee");
		 	tabsMedecin.getSelectionModel().select(tabConsultations);
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
