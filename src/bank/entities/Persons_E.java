/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Stian
 */
@Entity
@Table(name = "Persons")
public class Persons_E implements Serializable {
    
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private City_E owner;
    
    public Persons_E() {}
    
    public Persons_E(String firstname, String lastname, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    @Id
    @GeneratedValue(generator = "increment", strategy = IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "PersonID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "FirstName")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "LastName")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setOwner(City_E owner) {
        this.owner = owner;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ZipCode", nullable = false)
    public City_E getOwner() {
        return owner;
    }
}
