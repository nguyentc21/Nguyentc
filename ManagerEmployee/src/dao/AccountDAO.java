/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.util.LinkedList;
import util.ProcessFile;

/**
 *
 * @author nguyen
 */
public class AccountDAO {

    LinkedList<Account> account = null;

    public AccountDAO() {
        ProcessFile pro = new ProcessFile();
        LinkedList<String> list = pro.load("Account.txt");
        int len = list.size() / 3;
        account = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int j = i*3;
            Account acc = new Account();
            acc.setUserName(list.get(j));
            acc.setPassword(list.get(j+1));
            acc.setDescription(list.get(j+2));
            account.addLast(acc);
        }
    }
    public Account addAcc(Account ac){
        return ac;
    }
    public boolean readAll(){
        return false;
    }
    public Account getAcc(int index){
        if(index>=0 && index < account.size()){
            return account.get(index);
        }else{
            return null;
        }
    }
    public Account updateAcc(Account ac){
        return ac;
    }
    public boolean deleteAcc(){
        return false;
    }
    public Account loginAcc(Account ac){
        for(Account a: account){
            if(ac.compareTo(a)==0){
                return a;
            }
        }
        return null;
    }
}
