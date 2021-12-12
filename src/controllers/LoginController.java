package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import application.Main;
import application.SampleController;
import classes.Users;
import classes.Patient;
import classes.CurrentUserData;
import java.sql.Date;


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
    private TextField tfNom;
    
    @FXML
    private TextField tfPrenom;

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

    ToggleGroup toggleGroup = new ToggleGroup();

    
    

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		rbH.setToggleGroup(toggleGroup);
		rbF.setToggleGroup(toggleGroup);
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
	
	public void medecinStage (ActionEvent event, int id) throws IOException {
		CurrentUserData.change(id);
		URL url =getClass().getResource("../fxmls/Medecin/Medecin.fxml");
		root = FXMLLoader.load(url);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		
		System.out.println("what" + CurrentUserData.getRoleId());
		stage.setUserData("lkjlkj");
		stage.show();

	}
	
	public void patientStage (ActionEvent event, int id) throws IOException {
		CurrentUserData.change(id);
		URL url =getClass().getResource("../fxmls/Patient/Patient.fxml");
		root = FXMLLoader.load(url);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setUserData("lkjlkj");
		stage.show();
		
		/*
		URL url =getClass().getResource("../fxmls/Medecin/Medecin.fxml");
		
		FXMLLoader loader = FXMLLoader.load(getClass().getClassLoader().getResource("../fxmls/Medecin/Medecin.fxml"));
		SampleController controller = new SampleController();
	    controller.setBro("vvv");
	    loader.setController(controller);
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
		 */
	}
	
	
	
	 @FXML
		private boolean signUp (ActionEvent event) throws IOException, SQLException {
			event.consume();
			reqName.setVisible(false);
			reqBD.setVisible(false);
			reqAdress.setVisible(false);
			reqTel.setVisible(false);
			//reqRadio.setVisible(false);
			reqUsername1.setVisible(false);
			reqUsername2.setVisible(false);
			
			// add verifs
			if (tfNom.getText().strip() == "") {
				reqName.setVisible(true);
				return false;
			}
			
			if (tfPrenom.getText().strip() == "") {
				reqName.setVisible(true);
				return false;
			}
			
			if (tfBd.getValue() == null) {
				reqBD.setVisible(true);
				return false;
			}
			
			if (tfAdress.getText().strip() == "") {
				reqAdress.setVisible(true);
				return false;
			}
			
			// verif tel
			if (tfTel.getText().strip() == "") {
				reqTel.setVisible(true);
				return false;
			}
			
			if (tfUsername1.getText().strip() == "") {
				reqUsername1.setVisible(true);
				return false;
			}
			
			if (tfPw1.getText().strip() == "") {
				reqUsername2.setVisible(true);
				return false;
			}
			
			//System.out.println("p");
			RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
			String sexe = selectedRadioButton.getText();
			Patient p = new Patient(tfNom.getText(),tfPrenom.getText(), Date.valueOf(tfBd.getValue()), tfTel.getText(), sexe, tfAdress.getText());
			Users u = new Users(tfUsername1.getText(), tfPw1.getText());
			
			if (u.signUp(p)) 
				System.out.println("done");
			else
				System.out.println("nope");
			//Patient p = new Patient("az","az", new Date(12,12,1999), "lkj", "H", "mlkmlk");
			//(String nom, String prenon, Date date_ness, String telf, String sexe,String adresse)
			
			// switch to login
			where(0);
			return true;
	 }
		
	
	 @FXML
	private boolean Login (ActionEvent event) throws IOException, SQLException {
		event.consume();
		reqUsername.setVisible(false);
		reqPw.setVisible(false);
		// error msg visible !!!!!!!!!!!!!!!!!!!!!!
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
		Users user = new Users(tfUsername.getText().strip(), tfPassword.getText().strip());
		if(!user.login())
			return false;
		System.out.println(user.getRole());
		
		if (user.getRole() == 0 ) { // medecin
			medecinStage(event, user.getPersonId());
		} else if (user.getRole() == 1) {
			// secretaire
		}
			else { // 2
				patientStage(event, user.getPersonId());
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
		if(event.getSource() == btnClose) {
			System.exit(0);
		}
	}
	
	 
	 // Debugging
	  @FXML
	    private void printSource(ActionEvent event) {
	        event.consume();
	     //   if (event.getSource() == btnPatients) {
	        	
	    }
}

	

