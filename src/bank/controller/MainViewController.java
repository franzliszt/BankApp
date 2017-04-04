/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;


import bank.model.DatabaseTransaction;
import bank.model.domains.Customer;
import bank.model.domains.Person;
import bank.model.utils.HibernateUtil;
import bank.util.Validation;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    @FXML private Text registeredBefore;
    
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
        db.findCity(null);
        window = new Windows();
        
        addListeners();
        
    }
    
    private void addListeners() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
            if (n == logInTab)
                clearLogInFields();
            if (n == registerTab) {
                clearRegisterFields();
                registeredBefore.setText("");
            } 
        });
        
        zipcodeField.textProperty().addListener((observable, oldVal, newVal) -> {
            cityField.setText(db.findCity(zipcodeField.getText()).toUpperCase());
        });
        
        firstnameField.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                Boolean oldVal, Boolean newVal) -> {
            if (!registeredBefore.getText().equals(""))
                registeredBefore.setText("");
        });
        
        lastnameField.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                Boolean oldVal, Boolean newVal) -> {
            if (!registeredBefore.getText().equals(""))
                registeredBefore.setText("");
        });
        
        addressField.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                Boolean oldVal, Boolean newVal) -> {
            if (!registeredBefore.getText().equals(""))
                registeredBefore.setText("");
        });
        
        zipcodeField.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                Boolean oldVal, Boolean newVal) -> {
            if (!registeredBefore.getText().equals(""))
                registeredBefore.setText("");
        });
        
        cityField.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                Boolean oldVal, Boolean newVal) -> {
            if (!registeredBefore.getText().equals(""))
                registeredBefore.setText("");
        });
        
        usernameField.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                Boolean oldVal, Boolean newVal) -> {
            if (!registeredBefore.getText().equals(""))
                registeredBefore.setText("");
        });
        
        passwordField.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                Boolean oldVal, Boolean newVal) -> {
            if (!registeredBefore.getText().equals(""))
                registeredBefore.setText("");
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
        String username = usernameLogIn.getText();
        String password = passwordLogIn.getText();
        
        Person customer = db.checkUserCredentials(username, password);
        if (customer != null) {
            try {
                db = null;
                window.openCustomer((Stage) logInButton.getScene().getWindow(), customer);
            } catch (IOException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    public void handleRegisterButton() {
        String inputFirstName = firstnameField.getText();
        String inputLastName = lastnameField.getText();
        String inputAddress = addressField.getText();
        String inputZipcode = zipcodeField.getText();
        String inputCity = cityField.getText();
        String inputUsername = usernameField.getText();
        String inputPassword = passwordField.getText();
        
        Validation v = new Validation(inputFirstName, inputLastName, inputAddress,
            inputZipcode, inputCity);
        invalidFirstname.setText(v.validateFirstname());
        invalidLastname.setText(v.validateLastname());
        invalidAddress.setText(v.validateAddress());
        invalidZipcode.setText(v.validateZipcode());
        cityField.setText(v.getCity());
        
        if (v.validateAll()) {
            String result = db.registerCustomer(new Customer(inputFirstName, inputLastName, 
                inputAddress, inputZipcode, inputCity, inputUsername, inputPassword));
            if (result != null) {
                registeredBefore.setText(result);
                clearRegisterFields();
            } else
                tabPane.getSelectionModel().selectFirst();
        }
    }
}
