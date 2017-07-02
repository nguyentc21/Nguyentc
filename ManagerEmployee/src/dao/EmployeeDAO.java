/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.ProcessFile;

/**
 *
 * @author nguyen
 */
public class EmployeeDAO {

    List<Employee> employee = null;
    Account account;

    public EmployeeDAO(Account a) {
        account = a;
        ProcessFile pro = new ProcessFile();
        List<String> list = pro.load("Employee.txt");
        int len = list.size() / 4;
        employee = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int j = i * 4;
            Employee em = new Employee();
            try {
                em.setCode(Integer.parseInt(list.get(j)));
                em.setName(list.get(j + 1));
                em.setAge(Integer.parseInt(list.get(j + 2)));
                em.setSalary(Float.parseFloat(list.get(j + 3)));
                employee.add(em);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Employee addEmp(Employee e) {
        if (account.getRollName() != 1) {
            return null;
        } else {
            if (indexOf(e.getCode()) >= 0) {
                return null;
            } else {
                employee.add(e);
                return employee.get(employee.size() - 1);
            }
        }
    }

    public void sortByName() {
        Collections.sort(employee);
    }

    public List<Employee> readListEmp() {
        if (employee.isEmpty()) {
            return null;
        } else {
            sortByName();
            return employee;
        }
    }

    public String getEmp(int index) {
        if (index >= 0 && index < employee.size()) {
            return employee.get(index).toString();
        } else {
            return null;
        }
    }

    public Employee updateEmp(Employee e) {
        if (account.getRollName() != 1) {
            return null;
        } else {
            int index = indexOf(e.getCode());
            if (index >= 0) {
                employee.remove(index);
                employee.add(index, e);
                return employee.get(index);
            } else {
                return null;
            }
        }
    }

    public boolean deleteEmp(int code) {
        if (account.getRollName() != 1) {
            return false;
        } else {
            int index = indexOf(code);
            if (index >= 0) {
                employee.remove(index);
                return true;
            } else {
                return false;
            }
        }
    }

    public int indexOf(int code) {
        if (employee.isEmpty()) {
            return -1;
        } else {
            int index = 0;
            for (Employee e : employee) {
                if (code == e.getCode()) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
}
