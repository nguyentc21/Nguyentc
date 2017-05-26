
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
public class Q3 {
    public static void main(String[] args) {
        System.out.println("Chuyen tu do C(Celsius) sang do F(Fahrenheit)");
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap do C:");
        int c=sc.nextInt();
        int f=(c*9/5+32);
        System.out.println("Do F la:"+f);
    }
}
