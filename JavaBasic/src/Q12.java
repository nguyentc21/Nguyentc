
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyentc
 */
public class Q12 {
    public static void main(String[] args) {
        System.out.println("Nhap so a:");
        Scanner sc=new Scanner(System.in);
        float numA=sc.nextFloat();
        System.out.println("Nhap so b:");
        float numB=sc.nextFloat();
        System.out.println("Nhap phep toan(+,-,*,/):");
        sc=new Scanner(System.in);
        String s=sc.nextLine();  
        char p=s.charAt(0);
        System.out.println(" "+p);
                switch(p){
            case '+':
                System.out.println("a + b = "+(numA+numB));
                break;
            case '-':
                System.out.println("a - b = "+(numA-numB));
                break;
            case '*':
                System.out.println("a * b = "+(numA*numB));
                break;
            case '/':
                System.out.println("a / b = "+(numA/numB));
                break;
            default:
                System.out.println("Nhap sai phep toan.");
                break;
        }
    }
}
