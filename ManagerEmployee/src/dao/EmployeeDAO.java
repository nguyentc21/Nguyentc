/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Employee;
import java.util.Collections;
import java.util.LinkedList;
import util.ProcessFile;

/**
 *
 * @author nguyen
 */
public class EmployeeDAO {

    LinkedList<Employee> employee = null;

    public EmployeeDAO() {
        ProcessFile pro = new ProcessFile();
        LinkedList<String> list = pro.load("Employee.txt");
        int len = list.size() / 4;
        employee = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int j=i*4;
            Employee em = new Employee();
            try {
                em.setCode(Integer.parseInt(list.get(j)));
                em.setName(list.get(j+1));
                em.setAge(Integer.parseInt(list.get(j+2)));
                em.setSalary(Float.parseFloat(list.get(j+3)));
                employee.addLast(em);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Employee addEmp(Employee e) {
        if (indexOf(e.getCode()) >= 0) {
            return null;
        } else {
            employee.addLast(e);
            return employee.getLast();
        }
    }

    public void sortByName() {
        Collections.sort(employee);
    }

    public LinkedList<Employee> readListEmp() {
        if (employee.size() == 0) {
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
        int index = indexOf(e.getCode());
        if (index >= 0) {
            employee.remove(index);
            employee.add(index, e);
            return employee.get(index);
        } else {
            return null;
        }
    }

    public boolean deleteEmp(int code) {
        int index = indexOf(code);
        if (index >= 0) {
            employee.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public int indexOf(int code) {
        if (employee.size() == 0) {
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
