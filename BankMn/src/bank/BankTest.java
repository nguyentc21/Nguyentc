/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import bus.Bank;
import java.util.Scanner;

/**
 *
 * @author nguyentc
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank=new Bank();
        int choice=0;
        Scanner sc=new Scanner(System.in);
        
        while(true){
            System.out.println("QUAN LY TAI KHOAN NGAN HANG."
                + "\n1-Tao tai khoan moi."
                + "\n2-Rut tien."
                + "\n3-Gui tien."
                + "\n4-Thoat.");
            System.out.println("Nhap chuc nang tu 1 den 4: ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    outer:
                    System.out.println("TAO TAI KHOAN MOI.");
                    System.out.println("Nhap ten: ");
                    sc=new Scanner(System.in);
                    String name=sc.nextLine();
                    System.out.println("Nhap so tai khoan: ");
                    sc=new Scanner(System.in);
                    String num=sc.nextLine();
                    System.out.println("Nhap so tien: ");
                    sc=new Scanner(System.in);
                    String balance=sc.nextLine();
                    if(bank.create(name, num, balance)){
                        System.out.println("Tao tai khoan moi thanh cong!");
                    }else{
                        System.out.println("Loi! Du lieu nhap vao sai hoac da qua so luong tai khoan luu tru.");
                    }
                    break;
                case 2:
                    System.out.println("RUT TIEN.");
                    System.out.println("Nhap so tai khoan:");
                    int numWd = sc.nextInt();
                    System.out.println("Nhap so tien muon rut:");
                    int wd=sc.nextInt();
                    if(bank.withdraw(numWd, wd)){
                        System.out.println("Rut tien thanh cong!");
                    }else{
                        System.out.println("Loi! Khong tim thay tai khoan hoac so du tai khoan khong du.");
                    }
                    break;
                case 3:
                    System.out.println("GUI TIEN.");
                    System.out.println("Nhap so tai khoan:");
                    int numDp=sc.nextInt();
                    System.out.println("Nhap so tien muon gui:");
                    int dp=sc.nextInt();
                    if(bank.deposit(numDp, dp)){
                        System.out.println("Gui tien thanh cong.");
                    }else{
                        System.out.println("Loi! Tai khoan khong dung, ve menu de tao tai khoan moi.");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
