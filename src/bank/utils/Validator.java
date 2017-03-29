/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.utils;

import org.hibernate.Session;

/**
 *
 * @author Stian
 */
public class Validator {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "1234";
    // klassen sjekker brukernavn og passord
    
    public static boolean checkUser(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}
