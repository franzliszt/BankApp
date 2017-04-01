/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model.domains;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Stian
 */
public class Payment {
    
    private int paymentId;
    private double amount;
    private Account fromAccount;
    private Account toAccount;
    private Date date;
    
    public Payment(double amount, Account from, Account to, Date date) {
        this.amount = amount;
        fromAccount = from;
        toAccount = to;
        this.date = date;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        
        return String.format("From %s to %s, %.2f kr. Date: %s.%n",
                getFromAccount().getAccountNumber(), 
                getToAccount().getAccountNumber(),
                getAmount(), sdf.format(getDate()));
    }
}
