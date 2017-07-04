/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyen
 */
public class AccountTest {

    public static void main(String[] args) {
        Account acc1 = new Account(101, 5000);
        Account acc2 = new Account(102, 10000);
        AccountThread t1 = new AccountThread("Thread-1", acc2);
        AccountThread t2 = new AccountThread("Thread-2", acc2);
        
        t1.start();
        t2.start();
        
    }
}
