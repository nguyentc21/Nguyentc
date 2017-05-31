/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import account.Account;

/**
 *
 * @author nguyentc
 */
public interface BankBus {
    void display(Account a);
    boolean create(String name, String num, String balance);
    boolean withdraw(int num, int wd);
    boolean deposit(int num, int dp);
}
