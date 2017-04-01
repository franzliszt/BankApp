/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;

import bank.model.Bank;
import bank.model.BankTransaction;
import bank.model.domains.Person;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Stian
 */
public class NewAccountController {
    
    
    private BankTransaction bank;
    @FXML private ComboBox<String> accountCombo;
    @FXML TextField accountName;
    
    public void initialize() {
        bank = new Bank();
    }
    
    public void setCustomer(Person customer) {
         System.out.println(customer.getFirstname());
     }

     @FXML
     private void createAccount() {
         //String accountNameCombo = accountCombo.getSelectionModel().getSelectedItem();
         String name = accountName.getText();
         if (name != null) {
             test(name);
         }
     }
     
     private void test(String name) {
         System.out.println(Windows.getLoggedInPerson().getFirstname());
     }
}
