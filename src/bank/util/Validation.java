/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.util;

/**
 *
 * @author Stian
 */
public class Validation {
    public static boolean validateFirstname(String firstname) {
        return firstname.matches("[A-ZÆØÅa-zæøå]*[\\s]{1}[a-zæøåA-ZÆØÅ]");
    }
    
    public static boolean validateZipcod(String zip) {
        return zip.matches("\\d{4}");
    }
}
