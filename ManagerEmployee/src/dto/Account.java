package dto;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nguyen
 */
public class Account implements Serializable, Comparable<Account> {

    private String userName, password, description;

    public Account() {
    }

    public Account(String userName, String password, String description) {
        this.userName = userName;
        this.password = password;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.userName + "," + this.password + "," + this.description;
    }

    public String toStringNonPass() {
        return this.userName + "," + this.description;
    }

    @Override
    public int compareTo(Account o) {
        int valueUser = this.userName.compareTo(o.userName);
        int valuePass = this.password.compareTo(o.password);
        if (valueUser == 0) {
            return valuePass;
        } else {
            return valueUser;
        }
    }

}
