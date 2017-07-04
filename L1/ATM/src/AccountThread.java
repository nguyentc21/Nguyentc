
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nguyen
 */
public class AccountThread implements Runnable {

    private Thread t;
    private String threadName;
    Account account;

    public AccountThread(String name, Account a) {
        threadName = name;
        account = a;
    }

    @Override
    public void run() {
        //InputStreamReader ir = new InputStreamReader(System.in);
        //BufferedReader br = new BufferedReader(ir);
        //try {
        synchronized (account) {
            System.out.println(threadName + "so du tai khoan: " + account.displayBalance());
            System.out.println(threadName + "Nhap so tien muon chuyen:");
            account.transfer(4000, threadName);
            System.out.println(threadName + "So du tai khoan: " + account.displayBalance());

            //int mTran = Integer.parseInt(br.readLine());
            System.out.println(threadName + "so du tai khoan: " + account.displayBalance());
            System.out.println(threadName + "Nhap so tien muon rut:");
            //int mWith = Integer.parseInt(br.readLine());
            account.withdraw(2000, threadName);
            System.out.println(threadName + "So du tai khoan: " + account.displayBalance());
            //} catch (IOException ex) {
            //    Logger.getLogger(AccountThread.class.getName()).log(Level.SEVERE, null, ex);
            //}
            System.out.println("End " + threadName);
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}
