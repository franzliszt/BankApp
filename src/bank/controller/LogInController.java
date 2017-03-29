/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.controller;

import bank.domains.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import bank.domains.Person;
import bank.entities.Account_E;
import bank.entities.City_E;
import bank.entities.Customer_E;
import bank.entities.Employee_E;
import bank.entities.Persons_E;
import bank.utils.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Stian
 */
public class LogInController implements Initializable {

    @FXML private TextField username;
    @FXML private PasswordField passwordField;
    
    
    
    @FXML
    private void logIn() {
        // hent og sjekk om data er gyldig for brukeren
        Person p = new Customer("Donald", "Duck", "Adresse", "3471", "Slemmestad");
        System.out.println("XXXXXXXXXXXXXXXXXXX" + p.getFirstname());
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        City_E city = new City_E();
        city.setCity(p.getCity());
        city.setZip(p.getZip());
        session.save(city);
        
        Persons_E person = new Persons_E();
        person.setFirstname(p.getFirstname());
        person.setLastname(p.getLastname());
        person.setAddress(p.getAddress());
        //person.setZip(p.getZip());
        person.setOwner(city);
        city.getPeople().add(person);
        session.save(person);
        
        Customer_E customer = new Customer_E();
        customer.setCustomerId(person.getId());
        session.save(customer);
        
        // ny konto
        Account_E account = new Account_E();
        account.setOwner(customer);
        account.setDate(new Date());
        account.setAccountName("SPARING");
        account.setCurrentAmount(1000.50);
        customer.getAccounts().add(account);
        session.save(account);
        
        // ny ansatt
        Persons_E ny = new Persons_E();
        ny.setFirstname("Skrue");
        ny.setLastname("McDuck");
        ny.setAddress("Andebyveien");
        ny.setOwner(city);
        session.save(ny);
        
        // ny ansatt
        Employee_E emp = new Employee_E();
        emp.setEmployeeId(ny.getId());
        emp.setHourlySalary(250.50);
        session.save(emp);
        
        session.getTransaction().commit();
        session.close();    
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
