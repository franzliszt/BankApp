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
import org.hibernate.Query;
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
    
    public String registerCustomer(Person person) {
        String result = "";
        try {
            
            City_E city = searchZip(person.getZip());
            Persons_E foundPerson = searchPerson(person.getFirstname(), 
                    person.getLastname());
            
            if (foundPerson != null && city != null)
                result = "You are already a registered customer.";
            session = HibernateUtil.getSessionFactory().openSession();
            trx = session.beginTransaction();
            if (city == null) {
                city = new City_E();
                city.setZip(person.getZip());
                city.setCity(person.getCity());
                session.save(city);
            }
            
            if (foundPerson == null) {
                foundPerson = new Persons_E();
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
            }
            
            trx.commit();
        } catch (JDBCException e) {
            if (trx != null)
                trx.rollback();
            System.err.println(e);
        } finally {
            session.clear();
            session.close();
        }
        return result;
    }
    
    private Persons_E searchPerson(String firstname, String lastname) {
        List<Persons_E> list = getAll();
        session = HibernateUtil.getSessionFactory().openSession();
        for (Persons_E p : list) {
            if (p.getFirstname().equals(firstname) && p.getLastname().equals(lastname)) {
                session.close();
                return p;
            }
        }
        session.close();
        return null;
    }
    
    private City_E searchZip(String zip) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<City_E> list = session.createCriteria(City_E.class).list();
        for (City_E c : list) {
            if (c.getZip().equals(zip)) {
                session.close();
                return c;
            }
        }
        session.close();
        return null;
    }
    
    public List<Persons_E> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Persons_E> list = session.createCriteria(Persons_E.class).list();
        session.close();
        return list;
    }
    
    public Person checkUserCredentials(String username, String password) {
        Person customer = null;
        List<Persons_E> list = getAll();
        session = HibernateUtil.getSessionFactory().openSession();
        for (Persons_E entity : list) {
            if (entity.getUsername().equals(username) && 
                    entity.getPassword().equals(password)) {
                customer = new Customer();
                customer.setId(entity.getId());
                customer.setFirstname(entity.getFirstname());
                customer.setLastname(entity.getLastname());
            }
        }
        session.close();
        return customer;
    }
    
    public String findCity(String zip) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<City_E> list = session.createCriteria(City_E.class).list();
        String city = "";
        for (City_E c : list) {
            if (c.getZip().equals(zip)) {
                city = c.getCity();
                break;
            }
        }
        session.clear();
        session.close();
        return city;
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
