/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author nguyen
 */
public class Employee implements Serializable, Comparable<Employee>{

    private int code;
    private String name;
    private int age;
    private float salary;
    private Account account;

    public Employee() {
    }

    public Employee(int code, String name, int age, float salary) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return this.code + "," + this.name + "," + this.age + "," + this.salary;
    }

    @Override
    public int compareTo(Employee o) {
        int valueName = this.name.compareTo(o.name);
        int valueCode = this.code - o.code;
        if (valueName == 0) {
            return valueCode;
        } else {
            return valueName;
        }
    }
}
