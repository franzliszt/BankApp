/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;


import bank.model.DatabaseTransaction;
import bank.model.domains.Customer;
import bank.model.domains.Person;
import bank.model.utils.ViewHelper;
import bank.util.Validation;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @FXML private Text errorLogIn;
    
    // Tabs
    @FXML private TabPane tabPane;
    @FXML private Tab logInTab;
    @FXML private Tab registerTab;
    
    
    public void initialize() {
        db = new DatabaseTransaction();
        db.findCity(null);
        window = new Windows();
        Listener l = new Listener();
        
    }
    
    private class Listener {
        
        public Listener() {
            addListeners();
        }
        
        private void addListeners() {
            tabPane.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
                if (n == logInTab) {
                    clearLogInFields();
                }
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
            
            usernameLogIn.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                    Boolean oldVal, Boolean newVal) -> {
                errorLogIn.setText("");
            });
            
            passwordLogIn.focusedProperty().addListener((ObservableValue<? extends Boolean> a, 
                    Boolean oldVal, Boolean newVal) -> {
                errorLogIn.setText("");
            });
        }
    } // private inner class
    
    
    @FXML
    private void handleSignInButton() {
        String username = usernameLogIn.getText();
        String password = passwordLogIn.getText();
        Person customer = db.checkUserCredentials(username, password);
        if (customer != null) {
            try {
                window.openCustomer((Stage) logInButton.getScene().getWindow(), customer);
                clearLogInFields();
                clearRegisterFields();
            } catch (IOException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
            errorLogIn.setText("Not a valid input.");
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
    
    private void clearRegisterFields() {
            ViewHelper.clear(firstnameField, lastnameField, addressField, 
                                zipcodeField, cityField, usernameField, passwordField);
    }

    private void clearLogInFields() {
            ViewHelper.clear(usernameLogIn, passwordLogIn, errorLogIn);
    }
}
