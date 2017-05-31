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
public class Bank implements BankBus{
    int next=0;
    int max=10;
    int nextAcc=0;
    Account acct[]=new Account[max];
    
    public Bank(){
        for(int i=0; i<max; i++){
            acct[i]=new Account();
        }
    }
    @Override
    public void display(Account a) {
    }

    @Override
    public boolean create(String name, String num, String balance) {
        for(int i=0; i<num.length(); i++){
            if(Character.isLetter(num.charAt(i))){
                return false;
            }
        }
        for(int i=0; i<balance.length(); i++){
            if(Character.isLetter(balance.charAt(i))){
                return false;
            }
        }
        if(Integer.parseInt(balance) < 100){
            return false;
        }else{
            acct[next++]=new Account(name, Integer.parseInt(num), Integer.parseInt(balance));
            nextAcc++;
            return true;
        }
    }

    @Override
    public boolean withdraw(int num, int wd) {
        for(int i=0; i<next; i++){
            if(acct[i].getNum() == num){
                if(acct[i].getBalance() >= wd){
                    acct[i].setBalance(acct[i].getBalance()-wd);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deposit(int num, int dp) {
        for(int i=0; i<next; i++){
            if(acct[i].getNum() == num){
                acct[i].setBalance(acct[i].getBalance()+dp);
            }
        }
        return false;
    }
    
}
