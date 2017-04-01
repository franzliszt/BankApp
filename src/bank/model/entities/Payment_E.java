/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model.entities;

import bank.model.domains.Account;
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
@Table(name = "Transactions")
public class Payment_E implements Serializable {
    
    private int id;
    private double amount;
    private String toAccountNumber;
    private Date date;
    
    public Payment_E(){}

    @Id
    @GeneratedValue(generator = "increment", strategy = IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "PaymentID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "ToAccount")
    public String getToAccount() {
        return toAccountNumber;
    }

    public void setToAccount(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    @Temporal(TemporalType.DATE) @NotNull
    @Column(nullable = false, name = "Date", unique = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
 }
