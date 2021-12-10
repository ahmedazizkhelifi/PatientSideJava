package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; 
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import application.Main;


public class LoginController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private Button btnClose;

    @FXML
    private Button btnGo2;

    @FXML
    private Button btnSigin;

    @FXML
    private Button btnTo1;

    @FXML
    private RadioButton rbF;

    @FXML
    private RadioButton rbH;

    @FXML
    private ImageView reqAdress;

    @FXML
    private ImageView reqBD;

    @FXML
    private ImageView reqName;

    @FXML
    private ImageView reqPw;

    @FXML
    private ImageView reqRadio;

    @FXML
    private ImageView reqTel;

    @FXML
    private ImageView reqUsername;

    @FXML
    private ImageView reqUsername1;

    @FXML
    private ImageView reqUsername2;

    @FXML
    private Tab tabLogin;

    @FXML
    private Tab tabSignup;

    @FXML
    private TabPane tabs;

    @FXML
    private TextField tfAdress;

    @FXML
    private DatePicker tfBd;

    @FXML
    private TextField tfName;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private PasswordField tfPw1;

    @FXML
    private TextField tfTel;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfUsername1;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private void where(int here) {
		switch(here) {
		case 0:
			tabs.getSelectionModel().select(tabLogin);
			break;
		case 1:
			tabs.getSelectionModel().select(tabSignup);
			break;
		}
		
	}
	
	public void Medecin (ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Medecin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		System.out.println(stage);
		stage.show();
	}
	
	 @FXML
	private boolean Login (ActionEvent event) throws IOException {
		event.consume();
		reqUsername.setVisible(false);
		reqPw.setVisible(false);
		// error msg visible
		if (tfUsername.getText().strip() == "") {
			reqUsername.setVisible(true);
			return false;
		}
		if(tfPassword.getText().strip() == "") {
				reqPw.setVisible(true);
				return false;
		}
		
		// check db if username !exite or mdp ghalet >> msgerror visible = true
		// if user exist: check role
		int role = 0;
		if (role == 0 ) { // medecin
			Medecin(event);
		}
		return false;
	}

	
	 @FXML
	private void handleClicks (ActionEvent event) {
		event.consume();
		if (event.getSource() == btnTo1) {
			where(0);
		}
		if (event.getSource() == btnGo2) {
			where(1);
		}
		
	}
	
	 
	 // Debugging
	  @FXML
	    private void printSource(ActionEvent event) {
	        event.consume();
	     //   if (event.getSource() == btnPatients) {
	        	
	    }
}

	

