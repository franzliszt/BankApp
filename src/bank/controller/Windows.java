/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;

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
    
    void openCustomer(Stage parent) throws IOException {
        Stage customer = new Stage();
        customer.initModality(Modality.NONE);
        customer.initOwner(parent);
        customer.setResizable(false);
        
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/bank/views/CustomerView.fxml"));
        
        hideParent(parent);
        
        BorderPane root = loader.load();
        CustomerController controller = loader.getController();
        customer.setScene(new Scene(root, 900, 700));
        customer.setTitle("KUNDE");
        customer.showAndWait();
        
        showParent(parent);
    }
    
    private void hideParent(Stage parent) {
        parent.hide();
    }
    
    private void showParent(Stage parent) {
        parent.show();
    }
}
