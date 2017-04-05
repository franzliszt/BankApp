/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;

import bank.model.domains.Person;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Stian
 */
public class CustomerController {

    private Person customer;
    private Windows windows;
    @FXML private Button payments;
    @FXML private Button newAccountBtn;
    @FXML private TabPane tabPane;
    @FXML private Text today;
    
    
    public void initialize() {
        //tabPane.getTabs().add(new Tab("Tab 1"));
        DateFormat now = new SimpleDateFormat("dd.MM.yyyy");
        today.setText(now.format(new Date()));
        
    }
    

//    @FXML
//    private void test(ActionEvent e) {
//        Label label;
//        FlowPane pane1;
//        Scene scene1;
//        Stage theStage;
//        Stage newStage = new Stage();
//        if (e.getSource() == payments) {
//            pane1 = new FlowPane();
//            pane1.getChildren().add(new Label("TeSt"));
//            theStage = (Stage) payments.getScene().getWindow();
//            newStage.setScene(new Scene(pane1, 200, 100));
//            newStage.initModality(Modality.APPLICATION_MODAL);
//            newStage.setTitle("New Stage");
//            newStage.show();
//        }
//    }
    
    @FXML
    private void newAccount() {
        
    }   

    
    

    void setCustomer(Person customer) {
       this.customer = customer;
    }
    
}
