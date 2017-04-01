/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model.domains;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Stian
 */
public class Account {

    private int id;
    private double currentAmount;
    private String accountNumber;
    private String accountName;
    private Person owner;
    private Date date;
    
    public Account() { }
    
    public Account(String number, double initAmount) {
        this(number, "NY KONTO", initAmount, new Date());
    }
    
    public Account(String accountNumber, String accountName, double initAmount, Date date) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.currentAmount = initAmount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat();
        
        return String.format("%s %.2f kr, %s%nCreated %s%n", getAccountNumber(), 
                getCurrentAmount(), getAccountName(), df.format(getDate()));
    }
}
