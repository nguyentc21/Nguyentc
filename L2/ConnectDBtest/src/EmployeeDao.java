
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class EmployeeDao {

    Connection con;
    final String SQLADD = "INSERT INTO EMPLOYEE VALUES (?,?,?,?)";
    final String SQLREADALL = "SELECT * FROM EMPLOYEE";
    final String SQLUPDATE = "UPDATE EMPLOYEE SET NAME = ?, AGE = ?, SALARY = ? WHERE CODE = ?";
    final String SQLDELETE = "DELETE FROM EMPLOYEE WHERE CODE = ?";
    final String SQLSELECT = "SELECT * FROM EMPLOYEE WHERE CODE = ?";

    public EmployeeDao() {
        con = new DBConnect().getCon();
    }

    public EmployeeDto add(EmployeeDto e) {
        try {
            PreparedStatement pst = con.prepareStatement(SQLADD);
            pst.setString(1, e.getCode());
            pst.setString(2, e.getName());
            pst.setInt(3, e.getAge());
            pst.setDouble(4, e.getSalary());
            int i = pst.executeUpdate();
            if (i != 0) {
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<EmployeeDto> view() {
        List<EmployeeDto> list = null;
        Statement st;
        try {
            list = new ArrayList<>();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    EmployeeDto e = new EmployeeDto();
                    e.setCode(rs.getString(1));
                    e.setName(rs.getString(2));
                    e.setAge(rs.getInt(3));
                    e.setSalary(rs.getDouble(4));
                    list.add(e);
                }
            }
            if (!list.isEmpty()) {
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public EmployeeDto update(EmployeeDto e) {
        try {
            PreparedStatement pst = con.prepareStatement(SQLUPDATE);
            pst.setString(1, e.getName());
            pst.setInt(2, e.getAge());
            pst.setDouble(3, e.getSalary());
            pst.setString(4, e.getCode());
            int i = pst.executeUpdate();
            if (i != 0) {
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(String code) {
        try {
            PreparedStatement pst = con.prepareStatement(SQLDELETE);
            pst.setString(1, code);
            int i = pst.executeUpdate();
            if (i != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean getEmp(String code){
        try {
            PreparedStatement pst = con.prepareStatement(SQLSELECT);
            pst.setString(1, code);
            ResultSet rs = pst.executeQuery();
            if(rs!=null){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
