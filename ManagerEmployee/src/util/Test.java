/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.AccountDAO;
import dao.EmployeeDAO;
import dto.Account;
import dto.Employee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyen
 */
public class Test {

    Integer checkInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    Float checkFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("EMPLOYEE MANAGEMENT APPLICATION."
                    + "\n=========================================");
            System.out.println("1-Login."
                    + "\n2-Exit.");
            System.out.println("Input your choice: ");
            InputStreamReader isr = null;
            BufferedReader br = null;
            int choiceAcc =0;
            Test test = new Test();
            try {
                isr = new InputStreamReader(System.in);
                br = new BufferedReader(isr);
                choiceAcc = Integer.parseInt(br.readLine());
                switch (choiceAcc) {
                    case 1:
                        AccountDAO accDAO = new AccountDAO();
                        System.out.println("LOGIN ACCOUNT.");
                        Account acc = new Account();
                        System.out.println("Username:");
                        try {
                            acc.setUserName(br.readLine());
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        System.out.println("Password:");
                        try {
                            acc.setPassword(br.readLine());
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        if (accDAO.loginAcc(acc) == null) {
                            System.out.println("Your Username or Password was entered incorrectly.");
                        } else {
                            System.out.println(accDAO.loginAcc(acc).toStringNonPass());
                            System.out.println("LOGIN SUCCESS!"
                                    + "\n===================");
                            EmployeeDAO empDAO = new EmployeeDAO();
                            EmployeeMenu:
                            while (true) {
                                System.out.println("1-Add a employee."
                                        + "\n2-View list employees."
                                        + "\n3-Update employee information."
                                        + "\n4-Delete employee."
                                        + "\n5-Save file."
                                        + "\n6-Logout."
                                        + "\n7-Exit.");
                                System.out.println("Input your choice:");
                                int choiceEm = test.checkInt(br.readLine());
                                switch (choiceEm) {
                                    case 1:
                                        System.out.println("ADD A EMPLOYEE."
                                                + "\n===============");
                                        Employee emp = new Employee();
                                        while (true) {
                                            System.out.println("Input code:");
                                            Integer code = test.checkInt(br.readLine());
                                            if (code == null || code == 0) {
                                                System.out.println("Error! The entered code is not validated");
                                            } else {
                                                emp.setCode(code);
                                                break;
                                            }
                                        }
                                        System.out.println("Input name:");
                                        emp.setName(br.readLine());
                                        while (true) {
                                            System.out.println("Input age:");
                                            Integer age = test.checkInt(br.readLine());
                                            if (age == null || age <= 0) {
                                                System.out.println("Error! The entered age is not validated");
                                            } else {
                                                emp.setAge(age);
                                                break;
                                            }
                                        }
                                        while (true) {
                                            System.out.println("Input salary:");
                                            Float salary = test.checkFloat(br.readLine());
                                            if (salary == null || salary <= 0) {
                                                System.out.println("Error! The entered salary is not validated");
                                            } else {
                                                emp.setSalary(salary);
                                                break;
                                            }
                                        }
                                        if (empDAO.addEmp(emp) == null) {
                                            System.out.println("Error! The entered code is already exist!");
                                        } else {
                                            System.out.println(emp.toString()
                                                    + "\nAdd employee success!");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("LIST EMPLOYEES."
                                                + "\n===============");
                                        for(Employee em: empDAO.readListEmp()){
                                            System.out.println(em.toString());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("UPDATE EMPLOYEE INFORMATION.");
                                        Employee empUp = new Employee();
                                        while (true) {
                                            System.out.println("Input code:");
                                            Integer code = test.checkInt(br.readLine());
                                            if (code == null) {
                                                System.out.println("Error! The entered code is not validated");
                                            } else if (empDAO.indexOf(code) < 0) {
                                                System.out.println("Did not find this code in list employees!");
                                                break;
                                            } else {
                                                empUp.setCode(code);
                                                break;
                                            }
                                        }
                                        if (empUp.getCode() == 0) {
                                            break;
                                        } else {
                                            System.out.println("Input new name:");
                                            empUp.setName(br.readLine());
                                            while (true) {
                                                System.out.println("Input new age:");
                                                Integer age = test.checkInt(br.readLine());
                                                if (age == null || age <= 0) {
                                                    System.out.println("Error! The entered age is not validated");
                                                } else {
                                                    empUp.setAge(age);
                                                    break;
                                                }
                                            }
                                            while (true) {
                                                System.out.println("Input new salary:");
                                                Float salary = test.checkFloat(br.readLine());
                                                if (salary == null || salary <= 0) {
                                                    System.out.println("Error! The entered salary is not validated");
                                                } else {
                                                    empUp.setSalary(salary);
                                                    break;
                                                }
                                            }
                                            if (empDAO.updateEmp(empUp) == null) {
                                                System.out.println("Error! Update failed!");
                                            } else {
                                                System.out.println(empUp.toString()
                                                        + "Update success!");
                                            }
                                        }
                                    case 4:
                                        System.out.println("DELETE EMPLOYEE."
                                                + "\n=============");
                                        System.out.println("Input the code of employee to delete:");
                                        Integer code = test.checkInt(br.readLine());
                                        if (code == null || code == 0) {
                                            System.out.println("Error! The entered code is not validated");
                                        } else if (empDAO.indexOf(code) < 0) {
                                            System.out.println("Did not find this code in list employees!");
                                        } else {
                                            System.out.println(empDAO.getEmp(empDAO.indexOf(code)));
                                            System.out.println("You want to delete this employee: (Y or N)");
                                            while (true) {
                                                String choiceYN = br.readLine();
                                                if (choiceYN.equals("y") || choiceYN.equals("Y")) {
                                                    if (empDAO.deleteEmp(code)) {
                                                        System.out.println("Delete success!");
                                                    } else {
                                                        System.out.println("Error! Delete failed!");
                                                    }
                                                    break;
                                                } else if (choiceYN.equals("n") || choiceYN.equals("N")) {
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    case 5:
                                        ProcessFile pro = new ProcessFile();
                                        System.out.println("SAVE TO FILE."
                                                + "\n===============");
                                        if (pro.saveEmp(empDAO.readListEmp())) {
                                            System.out.println("File saved!");
                                        } else {
                                            System.out.println("Error! Cannot save this file!");
                                        }
                                        break;
                                    case 6:
                                        break EmployeeMenu;
                                    case 7:
                                        System.exit(0);
                                    default:
                                        break;
                                }
                            }
                        }
                        break;

                    case 2:
                        System.exit(0);
                    default:
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            } 
        }
    }
}
