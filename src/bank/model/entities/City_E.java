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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Stian
 */
@Entity
@Table(name = "Cities")
public class City_E implements Serializable {
    
    private String zip;
    private String city;
    private Set<Persons_E> people = new HashSet<>(0);
    
    public City_E() {}

    @Id
    @Column(name = "ZipCode", unique=true, columnDefinition="VARCHAR(4)")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void setPeople(Set<Persons_E> people) {
        this.people = people;
    }
    
    @OneToMany(mappedBy = "owner")
    public Set<Persons_E> getPeople() {
        return people;
    }
}
