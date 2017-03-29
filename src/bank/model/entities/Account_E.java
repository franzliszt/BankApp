/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model.entities;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Stian
 */
@Entity
@Table(name = "Accounts")
public class Account_E implements Serializable {
    private int id;
    private double currentAmount;
    private String accountNumber;
    private String accountName;
    private Customer_E owner;
    private Date date;
    
    public Account_E() {}
    
    public Account_E(String accountNumber) {
        this(accountNumber, "Ny Konto", 0, new Date());
    }
    
    public Account_E(String number, double initAmount) {
        this(number, "NY KONTO", initAmount, new Date());
    }
    
    public Account_E(String accountNumber, String accountName, double initAmount, Date date) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.currentAmount = initAmount;
        this.date = date;
    }
    

    
    @Id
    @GeneratedValue(generator = "increment", strategy = IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "AccountId")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "AccountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setCurrentAmount(double amount) {
        currentAmount = amount;
    }
    
    @Column(name = "Amount")
    public double getCurrentAmount() {
        return currentAmount;
    }
    
    public void setOwner(Customer_E owner) {
        this.owner = owner;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_ID", nullable = false)
    public Customer_E getOwner() {
        return owner;
    }
    
    @Temporal(TemporalType.DATE) @NotNull
    @Column(nullable = false, name = "Created", unique = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    @Override
    public String toString() {
        return String.format("%s, %.2f kroner, %s%n", 
                getAccountNumber(), getCurrentAmount(), getAccountName());
    }
}
