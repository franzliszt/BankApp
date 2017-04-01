/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;

import bank.model.domains.Person;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Stian
 */
class Windows {
    
    private static Person customer; // Kunden som er logget inn
    
    void openCustomer(Stage parent, Person customer) throws IOException {
        Windows.customer = customer;
        
        Stage customerStage = new Stage();
        customerStage.initModality(Modality.NONE);
        customerStage.initOwner(parent);
        customerStage.setResizable(false);
        
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/bank/views/CustomerView.fxml"));
        
        hideParent(parent);
        
        BorderPane root = loader.load();
        CustomerController controller = loader.getController();
        controller.setCustomer(customer);
        customerStage.setScene(new Scene(root, 900, 700));
        customerStage.setTitle("KUNDE");
        customerStage.showAndWait();
        
        showParent(parent);
    }
    
    private void hideParent(Stage parent) {
        parent.hide();
    }
    
    private void showParent(Stage parent) {
        parent.show();
    }
    
    public static Person getLoggedInPerson() {
        return customer;
    }
}
