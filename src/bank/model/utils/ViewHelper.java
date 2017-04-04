/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model.utils;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Stian
 */
public class ViewHelper {

    public static void clear(TextField firstnameField, TextField lastnameField, 
            TextField addressField, TextField zipcodeField, TextField cityField, 
            TextField usernameField, PasswordField passwordField) {
        firstnameField.clear();
        lastnameField.clear();
        addressField.clear();
        zipcodeField.clear();
        cityField.clear();
        usernameField.clear();
        passwordField.clear();
    }

    public static void clear(TextField usernameLogIn, PasswordField passwordLogIn) {
        usernameLogIn.clear();
        passwordLogIn.clear();
    }
    
    
    
}
