/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model;

import bank.model.domains.Account;
import bank.model.domains.Payment;
import bank.model.domains.Person;
import java.util.List;

/**
 *
 * @author Stian
 */
public interface BankTransaction {
    Account createAccount(Person customer);
    Account createAccount(Person customer, String name);
    Account createAccount(Person customer, String accountName, double initAmount);
    boolean deposit(Person customer, Account toAccount, double amount);
    boolean transfer(Person customer, Account fromAccount, Account toAccount, double amount);
    boolean pay(Person customer, Account fromAccount);
    boolean pay(Person customer, Account fromAccount, Account toAccount);
    double withdraw(Person customer, double amount);
    boolean deleteAccount(Person customer, Account account);
    List<Payment> getPayments(Person customer, Account account);
}
