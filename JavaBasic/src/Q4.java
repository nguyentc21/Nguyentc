
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
public class Q4 {
    public static void main(String[] args) {
        System.out.println("Doi gia tri 2 so cho nhau.");
        System.out.println("Nhap so a:");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println("Nhap so b:");
        int b=sc.nextInt();
        int c=a;
        a=b;
        b=c;
        System.out.println("a = "+a+"   b = "+b);
    }
}
