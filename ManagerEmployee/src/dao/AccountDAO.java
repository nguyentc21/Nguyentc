/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.util.ArrayList;
import java.util.List;
import util.ProcessFile;

/**
 *
 * @author nguyen
 */
public class AccountDAO {

    List<Account> account = null;

    public AccountDAO() {
        ProcessFile pro = new ProcessFile();
        List<String> list = pro.load("Account.txt");
        int len = list.size() / 4;
        account = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int j = i * 4;
            try {
                Account acc = new Account();
                acc.setUserName(list.get(j));
                acc.setPassword(list.get(j + 1));
                acc.setDescription(list.get(j + 2));
                acc.setRollName(Integer.parseInt(list.get(j + 3)));
                account.add(acc);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            } 
        }
    }

    public Account addAcc(Account ac) {
        return ac;
    }

    public boolean readAll() {
        return false;
    }

    public Account getAcc(int index) {
        if (index >= 0 && index < account.size()) {
            return account.get(index);
        } else {
            return null;
        }
    }

    public Account updateAcc(Account ac) {
        return ac;
    }

    public boolean deleteAcc() {
        return false;
    }

    public Account loginAcc(Account ac) {
        for (Account a : account) {
            if (ac.compareTo(a) == 0) {
                return a;
            }
        }
        return null;
    }
}
