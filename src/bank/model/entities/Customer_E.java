/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Stian
 */
@Entity
@Table(name = "Customers")
public class Customer_E implements Serializable {
    
    private int id;
    private int customerId;
    private Set<Account_E> accounts = new HashSet<>(0);

    public Customer_E() {}

    @Id
    @GeneratedValue(generator = "increment", strategy = IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "owner")
    public Set<Account_E> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account_E> accounts) {
        this.accounts = accounts;
    }
    
    @Column(name = "CustomerID")
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
}
