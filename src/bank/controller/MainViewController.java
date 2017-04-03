/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;


import bank.model.DatabaseTransaction;
import bank.model.domains.Customer;
import bank.model.domains.Person;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Stian
 */
public class MainViewController {

    private DatabaseTransaction db;
    private Windows window;
    
    // For register view
    @FXML private TextField firstnameField;
    @FXML private Text invalidFirstname;
    @FXML private TextField lastnameField;
    @FXML private Text invalidLastname;
    @FXML private TextField addressField;
    @FXML private Text invalidAddress;
    @FXML private TextField zipcodeField;
    @FXML private Text invalidZipcode;
    @FXML private TextField cityField;
    @FXML private Text invalidCity;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button registerButton;
    
    // For log in view
    @FXML private TextField usernameLogIn;
    @FXML private PasswordField passwordLogIn;
    @FXML private Button logInButton;
    
    // Tabs
    @FXML private TabPane tabPane;
    @FXML private Tab logInTab;
    @FXML private Tab registerTab;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void initialize() {
        db = new DatabaseTransaction();
        window = new Windows();
        
        // Listener on tabs
        tabPane.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
            if (n == logInTab)
                clearLogInFields();
            if (n == registerTab)
                clearRegisterFields();
        });
    }
    
    /**
     * Clears the input fields in the log in tab.
     */
    private void clearLogInFields() {
        usernameLogIn.clear();
        passwordLogIn.clear();
    }
    
    /**
     * Clears the input fields in the register tab.
     */
    private void clearRegisterFields() {
        firstnameField.clear();
        lastnameField.clear();
        addressField.clear();
        zipcodeField.clear();
        cityField.clear();
        usernameField.clear();
        passwordField.clear();
    }
    
    @FXML
    private void handleSignInButton() {
        System.out.println("log in");
        final String username = usernameLogIn.getText();
        final String password = passwordLogIn.getText();
        
        Person customer = db.checkUserCredentials(username, password);
        if (customer != null)
            try {
                window.openCustomer((Stage) logInButton.getScene().getWindow(), customer);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void handleRegisterButton() {
        // validere all input
        String inputFirstName = firstnameField.getText();
        String inputLastName = lastnameField.getText();
        String inputAddress = addressField.getText();
        String inputZipcode = zipcodeField.getText();
        String inputCity = cityField.getText();
        String inputUsername = usernameField.getText();
        String inputPassword = passwordField.getText();
        
        db.registerCustomer(new Customer(inputFirstName, inputLastName, 
                inputAddress, inputZipcode, inputCity, inputUsername, inputPassword));
        tabPane.getSelectionModel().select(0);
    }
}
