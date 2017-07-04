/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyen
 */
public class Account {

    int num;
    int balance;

    Account(int n, int b) {
        num = n;
        balance = b;
    }

    int displayBalance() {
        return balance;
    }

    void transfer(int m, String s) {
        if (m <= balance) {
            balance -= m;
        } else {
            System.out.println(s + "Het tien chuyen!");
        }
    }

    void withdraw(int m, String s) {
        if (m <= balance) {
            balance -= m;
        } else {
            System.out.println(s + "Het tien rut!");
        }
    }
}
