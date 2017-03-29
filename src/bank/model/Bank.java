/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model;


import bank.domains.Account;
import bank.domains.Customer;
import bank.domains.Person;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Stian Reistad Røgeberg
 */
public class Bank {
    
    private static int counter = 0; // number of customers
    private static final int INIT_AMOUNT = 0;
    private final List<Person> employees;
    private final List<Person> customers;
    private final Map<Person, List<Account>> accounts;
    
    
    public Bank() {
        counter++;
        employees = new ArrayList<>();
        customers = new ArrayList<>();
        accounts = new TreeMap<>();
    }
    
    public void registerCustomer(Person customer) {
        
    }
    
    // initial deposit value is zero
    public Account createAccount(Customer customer) {
        return createAccount(customer, INIT_AMOUNT);
    }
    
    public Account createAccount(Customer customer, double initAmount) {
        Account account = new Account(generateAccountNumber().toString(), initAmount);
        customer.addAccount(account);
        accounts.put(customer, customer.getAccounts());
        return account;
    }
    
    public boolean deposit(Person customer, Account fromAccount, double amount) {
        // validering skjer lenger opp kontroller
        
        return false;
    }
    
    private Integer generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        return random.nextInt(12) + 1;
    }
    
    public void deleteAccount(Person customer, String accountNumber) {
        
    }
}
