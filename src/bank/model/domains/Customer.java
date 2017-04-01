/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model.domains;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stian
 */
public class Customer extends Person {
    
    private int id;
    private List<Account> myAccounts;
    
    public Customer() {
        myAccounts = new ArrayList<>();
    }
    
    public Customer(String firstname, String lastname, String address, 
            String zip, String city, String username, String password) {
        super(firstname, lastname, address, zip, city, username, password);
        myAccounts = new ArrayList<>(); // kan være et Map<Account, List<Payment>> HashMap<>()
    }

    public void addAccount(Account account) {
        myAccounts.add(account);
    }

    public List<Account> getAccounts() {
        return myAccounts;
    }
    
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        myAccounts.forEach(account -> {
            output.append(account.toString());
        });
        return output.toString();
    }
    
}
