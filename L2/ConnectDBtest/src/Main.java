
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Main {

    int checkInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            System.out.println("Input value must be integer type!");
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    double checkDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            System.out.println("Input value must be double type!");
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    public static void main(String[] args) {

        while (true) {
            InputStreamReader ir = null;
            BufferedReader br = null;
            System.out.println("MENU"
                    + "\n========"
                    + "\n1.Add"
                    + "\n2.View"
                    + "\n3.Update"
                    + "\n4.Delete");
            Main main = new Main();

            try {
                ir = new InputStreamReader(System.in);
                br = new BufferedReader(ir);
                int choice = main.checkInt(br.readLine());
                if (choice != -1) {
                    EmployeeDao dao = new EmployeeDao();
                    switch (choice) {
                        case 1:
                            System.out.println("ADD"
                                    + "\n========");
                            EmployeeDto emp = new EmployeeDto();
                            System.out.println("Enter code:");
                            emp.setCode(br.readLine());
                            System.out.println("Enter name:");
                            emp.setName(br.readLine());
                            while (true) {
                                System.out.println("Enter age:");
                                int age = main.checkInt(br.readLine());
                                if (age > 0) {
                                    emp.setAge(age);
                                    break;
                                } else {
                                    System.out.println("Your value entered is not valid!");
                                }
                            }
                            while (true) {
                                System.out.println("Enter salary:");
                                double sal = main.checkDouble(br.readLine());
                                if (sal > 0) {
                                    emp.setSalary(sal);
                                    break;
                                } else {
                                    System.out.println("Your value entered is not valid!");
                                }
                            }
                            if (dao.add(emp) == null) {
                                System.out.println("Can not add employee!");
                            } else {
                                System.out.println("Add success!");
                            }

                            break;

                        case 2:
                            System.out.println("VIEW"
                                    + "\n=========");
                            if (dao.view() == null) {
                                System.out.println("Error!Can not found any employee!");
                            } else {
                                for (EmployeeDto e : dao.view()) {
                                    System.out.println(e.toString());
                                }
                            }
                            break;
                        case 3:
                            System.out.println("UPDATE"
                                    + "\n========");
                            EmployeeDto e = new EmployeeDto();
                            System.out.println("Enter code:");
                            e.setCode(br.readLine());
                            if (!dao.getEmp(e.getCode())) {
                                System.out.println("Can not found any employee!");
                            } else {
                                System.out.println("Enter new name:");
                                e.setName(br.readLine());
                                while (true) {
                                    System.out.println("Enter new age:");
                                    int age = main.checkInt(br.readLine());
                                    if (age > 0) {
                                        e.setAge(age);
                                        break;
                                    } else {
                                        System.out.println("Your value entered is not valid!");
                                    }
                                }
                                while (true) {
                                    System.out.println("Enter new salary:");
                                    double sal = main.checkDouble(br.readLine());
                                    if (sal > 0) {
                                        e.setSalary(sal);
                                        break;
                                    } else {
                                        System.out.println("Your value entered is not valid!");
                                    }
                                }
                                if (dao.update(e) == null) {
                                    System.out.println("Error!Can not update this employee!");
                                } else {
                                    System.out.println("Update Success!");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("DELETE"
                                    + "\n=========");
                            System.out.println("Enter code");
                            String code = br.readLine();
                            if (!dao.delete(code)) {
                                System.out.println("Error!Can not delete this employee!");

                            } else {
                                System.out.println("Delete success!");
                            }
                            break;
                        default:
                            System.exit(0);
                    }
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
