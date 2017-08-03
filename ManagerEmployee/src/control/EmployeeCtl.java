/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EmployeeDAO;
import dto.Employee;
import java.util.List;

/**
 *
 * @author nguyen
 */
public class EmployeeCtl {

    EmployeeDAO dao = new EmployeeDAO();

    public Employee addEmp(Employee e) {
        return dao.addEmp(e);
    }

    public List<Employee> readListEmp() {
        return dao.readListEmp();
    }

    public Employee getEmp(int index) {
        return dao.getEmp(index);
    }

    public Employee updateEmp(Employee e) {
        return dao.updateEmp(e);
    }

    public boolean deleteEmp(int code) {
        return dao.deleteEmp(code);
    }

}
