/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import util.DBConnect;
import util.ProcessFile;

/**
 *
 * @author nguyen
 */
public class AccountDAO {

    List<Account> account = null;
    final private String SQLCREATE = "INSERT INTO ACCOUNT VALUES(?,?,?,?)";
    final private String SQLREADALL = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ?";
    Connection con = null;

    public AccountDAO() {
//        ProcessFile pro = new ProcessFile();
//        List<String> list = pro.load("Account.txt");
//        int len = list.size() / 4;
//        account = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            int j = i * 4;
//            try {
//                Account acc = new Account();
//                acc.setUserName(list.get(j));
//                acc.setPassword(list.get(j + 1));
//                acc.setDescription(list.get(j + 2));
//                acc.setRollName(Integer.parseInt(list.get(j + 3)));
//                account.add(acc);
//            } catch (NumberFormatException ex) {
//                System.out.println(ex.getMessage());
//            } 
//        }
        con = new DBConnect("DBConnect").getCon();
    }

    public Account addAcc(Account ac) {
        try {
            PreparedStatement ps = con.prepareStatement(SQLCREATE);
            ps.setString(0, ac.getUserName());
            ps.setString(1, ac.getPassword());
            ps.setString(2, ac.getDescription());
            ps.setInt(3, ac.getRollName());
            int execute = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        try {
            PreparedStatement pst = con.prepareStatement(SQLREADALL);
            pst.setString(1, ac.getUserName());
            pst.setString(2, ac.getPassword());
            Account acc = new Account();
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    acc.setUserName(rs.getString(1));
                    acc.setDescription(rs.getString(3));
                    acc.setRollName(rs.getInt(4));
                }
            }
            if(acc.getUserName() == null){
                return null;
            }else
                return acc;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
//        
//        for (Account a : account) {
//            if (ac.compareTo(a) == 0) {
//                return a;
//            }
//        }
//        return null;
    }
}
