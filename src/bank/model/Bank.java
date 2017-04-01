/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model;

import bank.model.domains.Account;
import bank.model.domains.Payment;
import bank.model.domains.Person;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Stian Reistad Røgeberg
 */
public class Bank implements BankTransaction {

    private static int counter = 0; // number of customers
    private static final int INIT_AMOUNT = 0;
    private static final String ACCOUNT_NAME = "Brukskonto";
    private final List<Person> employees;
    private final List<Person> customers;
    private final Map<Person, List<Account>> accounts;

    public Bank() {
        counter++;
        
        employees = new ArrayList<>();
        customers = new ArrayList<>();
        accounts = new TreeMap<>();
    }

    @Override
    public Account createAccount(Person customer) {
        return createAccount(customer, ACCOUNT_NAME, INIT_AMOUNT);
    }
    
    @Override
    public Account createAccount(Person customer, String name) {
        return createAccount(customer, name, INIT_AMOUNT);
    }

    @Override
    public Account createAccount(Person customer, String accountName, double initAmount) {
        // lagre i database
        Account account = new Account();
        account.setOwner(customer);
        account.setAccountName(accountName);
        account.setCurrentAmount(initAmount);
        account.setAccountNumber(generateAccountNumber());
        return account;
    }

    @Override
    public boolean deposit(Person customer, Account toAccount, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transfer(Person customer, Account fromAccount, Account toAccount, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean pay(Person customer, Account fromAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean pay(Person customer, Account fromAccount, Account toAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double withdraw(Person customer, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAccount(Person customer, Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payment> getPayments(Person customer, Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        Integer number = (1 + random.nextInt(11));
        return number.toString();
    }
    
}
