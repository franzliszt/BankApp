/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model;

import bank.model.domains.Account;
import bank.model.domains.Customer;
import bank.model.domains.Payment;
import bank.model.domains.Person;
import bank.model.entities.City_E;
import bank.model.entities.Customer_E;
import bank.model.entities.Persons_E;
import bank.model.utils.HibernateUtil;
import java.util.List;
import java.util.stream.Stream;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Stian
 */
public class DatabaseTransaction {
    
    Session session;
    Transaction trx;
    
    public DatabaseTransaction() {
        // init
        session = null;
        trx = null;
    }
    
    public void registerNewCustomer(String firstname, String lastname, 
            String address, String zipcode, String city) {
        // lage objekt
        // sjekk om postnr finnes
        // sjekk om kunden finnes, hvis ja rollback og informer viewt
    }
    
    public void registerCustomer(Person person) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trx = session.beginTransaction();
            
            
            City_E city = new City_E();
            city.setZip(person.getZip());
            city.setCity(person.getCity());
            session.save(city);

            Persons_E foundPerson = new Persons_E();
            foundPerson.setFirstname(person.getFirstname());
            foundPerson.setLastname(person.getLastname());
            foundPerson.setAddress(person.getAddress());
            foundPerson.setUsername(person.getUsername());
            foundPerson.setPassword(person.getPassword());
            foundPerson.setOwner(city);
            city.getPeople().add(foundPerson);
            session.save(foundPerson);
            
            Customer_E customer = new Customer_E();
            customer.setCustomerId(foundPerson.getId());
            session.save(customer);
            
            trx.commit();
            
            getAll().forEach(p -> {
                System.out.println(p.getFirstname());
            });
        } catch (JDBCException e) {
            if (trx != null)
                trx.rollback();
            System.err.println(e);
        } finally {
            session.clear();
            session.close();
        }
    }
    
    private Persons_E searchPerson(Persons_E person) {
        List<Persons_E> list = session.createCriteria(Persons_E.class).list();
        for (Persons_E p : list) {
            if (p.equals(person))
                return p;
        }
        return null;
    }
    
    private City_E searchZip(String zip) {
        List<City_E> list = session.createCriteria(City_E.class).list();
        for (City_E c : list) {
            if (c.getZip().equals(zip))
                return c;
        }
        return null;
    }
    
    private List<Persons_E> getAll() {
        //session = HibernateUtil.getSessionFactory().openSession();
        List<Persons_E> list = session.createCriteria(Persons_E.class).list();
        return list;
    }
    
    public boolean registerAccount(Person customer, Account account) {
        return false;
    }
    
    public boolean registerNewPayment(Person customer, Account fromAccount, 
            Account toAccount, double amount) {
        return false;
    }
    
    public Stream<Person> getAllCustomers() {
        return null;
    }
    
    public Stream<Account> getAllAccounts() {
        return null;
    }
    
    public boolean updateAccount(Person customer, Account account, double amount) {
        return false;
    }
    
    public boolean deleteAccount(Person customer, Account account) {
        return false;
    }
    
    public boolean deleteCustomer(Person customer) {
        return false;
    }
    
    public Stream<Payment> getAllPayments(Account account) {
        return null;
    }
    
    public Stream<Person> getCustomerInfo(Person customer) {
        return null;
    }
}
