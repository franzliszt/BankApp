/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;


import bank.model.DatabaseTransaction;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Stian
 */
public class MainViewController implements Initializable {

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
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = new DatabaseTransaction();
        window = new Windows();
    }
    
    @FXML
    private void handleSignInButton() {
        System.out.println("log in");
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
        
        //registerButton.disableProperty().bind(firstnameField.textProperty().isEmpty());
        // hent ny kundes personalia
        // lagre kunden i databasen
    }
    
    
    
    @FXML
    private void logIn() throws IOException {
        //Person person = new Customer("Donald", "Duck", "Adresse", "8008", "Bodø");
        //window.openCustomer((Stage) logInBtn.getScene().getWindow(), person);
        
        // hent og sjekk om data er gyldig for brukeren
       
       //db.registerCustomer(p);
//        System.out.println("XXXXXXXXXXXXXXXXXXX" + p.getFirstname());
//        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        City_E city = new City_E();
//        city.setCity(p.getCity());
//        city.setZip(p.getZip());
//        session.save(city);
//        
//        Persons_E person = new Persons_E();
//        person.setFirstname(p.getFirstname());
//        person.setLastname(p.getLastname());
//        person.setAddress(p.getAddress());
//        //person.setZip(p.getZip());
//        person.setOwner(city);
//        city.getPeople().add(person);
//        session.save(person);
//        
//        Customer_E customer = new Customer_E();
//        customer.setCustomerId(person.getId());
//        session.save(customer);
//        
//        // ny konto
//        Account_E account = new Account_E();
//        account.setOwner(customer);
//        account.setDate(new Date());
//        account.setAccountName("SPARING");
//        account.setCurrentAmount(1000.50);
//        customer.getAccounts().add(account);
//        session.save(account);
//        
//        // ny ansatt
//        Persons_E ny = new Persons_E();
//        ny.setFirstname("Skrue");
//        ny.setLastname("McDuck");
//        ny.setAddress("Andebyveien");
//        ny.setOwner(city);
//        session.save(ny);
//        
//        // ny ansatt
//        Employee_E emp = new Employee_E();
//        emp.setEmployeeId(ny.getId());
//        emp.setHourlySalary(250.50);
//        session.save(emp);
//        
//        session.getTransaction().commit();
//        session.close();    
    }
    
    
    
    
    private void formatDropdown() {
        // hent fra db
    }
}
