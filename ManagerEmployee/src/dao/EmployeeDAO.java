/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnect;
import util.ProcessFile;

/**
 *
 * @author nguyen
 */
public class EmployeeDAO {

    List<Employee> employee = null;
    Account account;
    final private String SQLCREATE = "INSERT INTO EMPLOYEE VALUES(?,?,?,?)";
    final private String SQLREADALL = "SELECT * FROM EMPLOYEE";
    final private String SQLUPDATE = "UPDATE EMPLOYEE SET NAME = ?, AGE = ?, SALARY = ? WHERE CODE = ?";
    final private String SQLDELETE = "DELETE FROM EMPLOYEE WHERE CODE = ?";
    final private String SQLGET = "SELECT CODE, NAME, AGE, SALARY FROM EMPLOYEE WHERE CODE = ?";
    Connection con = null;

    public EmployeeDAO() {

//        ProcessFile pro = new ProcessFile();
//        List<String> list = pro.load("Employee.txt");
//        int len = list.size() / 4;
//        employee = new ArrayList<>();
//
//        for (int i = 0; i < len; i++) {
//            int j = i * 4;
//            Employee em = new Employee();
//            try {
//                em.setCode(Integer.parseInt(list.get(j)));
//                em.setName(list.get(j + 1));
//                em.setAge(Integer.parseInt(list.get(j + 2)));
//                em.setSalary(Float.parseFloat(list.get(j + 3)));
//                employee.add(em);
//            } catch (NumberFormatException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
        con = new DBConnect("DBConnectDerby").getCon();
    }

    public Employee addEmp(Employee e) {
//        if (account.getRollName() != 1) {
//            return null;
//        } else {
//            if (indexOf(e.getCode()) >= 0) {
//                return null;
//            } else {
//                employee.add(e);
//                return employee.get(employee.size() - 1);
//            }
//        }

        try {
            PreparedStatement pst = con.prepareStatement(SQLCREATE);
            pst.setInt(1, e.getCode());
            pst.setString(2, e.getName());
            pst.setInt(3, e.getAge());
            pst.setFloat(4, e.getSalary());
            int execute = pst.executeUpdate();
            if (execute == 0) {
                return null;
            } else {
                return e;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public void sortByName() {
//        Collections.sort(employee);
//    }
    public List<Employee> readListEmp() {

        //        if (employee.isEmpty()) {
//            return null;
//        } else {
//            sortByName();
//            return employee;
//        }
        employee = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setCode(rs.getInt("code"));
                    emp.setName(rs.getString("name"));
                    emp.setAge(rs.getInt("age"));
                    emp.setSalary(rs.getFloat("salary"));
                    employee.add(emp);
                }
            }

            if (employee.isEmpty()) {
                return null;
            } else {
                return employee;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Employee getEmp(int index) {

        //        if (index >= 0 && index < employee.size()) {
//            return employee.get(index).toString();
//        } else {
//            return null;
//        }
        Employee emp = new Employee();
        try {
            PreparedStatement pst = con.prepareStatement(SQLGET);
            pst.setInt(1, index);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    emp.setCode(rs.getInt(1));
                    emp.setName(rs.getString(2));
                    emp.setAge(rs.getInt(3));
                    emp.setSalary(rs.getFloat(4));
                }
            }
            if (emp.getCode() == 0) {
                return null;
            } else {
                return emp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Employee updateEmp(Employee e) {
//        if (account.getRollName() != 1) {
//            return null;
//        } else {
//            int index = indexOf(e.getCode());
//            if (index >= 0) {
//                employee.remove(index);
//                employee.add(index, e);
//                return employee.get(index);
//            } else {
//                return null;
//            }
//        }

        try {
            PreparedStatement pst = con.prepareStatement(SQLUPDATE);
            pst.setString(1, e.getName());
            pst.setInt(2, e.getAge());
            pst.setFloat(3, e.getSalary());
            pst.setInt(4, e.getCode());
            int i = pst.executeUpdate();
            if (i == 0) {
                return null;
            } else {
                return e;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public boolean deleteEmp(int code) {

        //        if (account.getRollName() != 1) {
//            return false;
//        } else {
//            int index = indexOf(code);
//            if (index >= 0) {
//                employee.remove(index);
//                return true;
//            } else {
//                return false;
//            }
//        }
        try {
            PreparedStatement pst = con.prepareStatement(SQLDELETE);
            pst.setInt(1, code);
            int i = pst.executeUpdate();
            if (i == 0) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

//    public int indexOf(int code) {
//        if (employee.isEmpty()) {
//            return -1;
//        } else {
//            int index = 0;
//            for (Employee e : employee) {
//                if (code == e.getCode()) {
//                    return index;
//                }
//                index++;
//            }
//        }
//        return -1;
//    }
}
