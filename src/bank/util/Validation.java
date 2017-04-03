/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.util;

import bank.model.DatabaseTransaction;

/**
 *
 * @author Stian
 */
public class Validation {
    
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String zipcode;
    private final String city;

    public Validation(String firstname, String lastname, String address, 
            String zipcode, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }
    
    public String validateFirstname() {
        if (!firstname.matches("[A-ZÆØÅa-zæøå \'-]{2,20}"))
            return "Invalide first name";
        return "";
    }
    
    public String validateLastname() {
        if (!lastname.matches("[A-ZÆØÅa-zæøå \'-]{2,30}"))
            return "Invalid last name";
        return "";
    }
    
    public String validateAddress() {
        if (!address.matches("[a-zæøåA-ZÆØÅ0-9 \'-.]{2,40}"))
            return "Invalid address";
        return "";
    }
    
    public String validateZipcode() {
        if (!zipcode.matches("\\d{4}"))
            return "Invalid zip code";
        return "";
    }
    
    public String getCity() {
        DatabaseTransaction db = new DatabaseTransaction();
        String foundCity = db.findCity(zipcode);
        return foundCity != null ? foundCity : "";
    }
    
    public boolean validateAll() {
        return (validateFirstname().equals("")) && 
                (validateLastname().equals("")) && 
                (validateAddress().equals("")) &&
                (validateZipcode().equals(""));
    }
}
