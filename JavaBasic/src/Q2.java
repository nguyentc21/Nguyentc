
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
public class Q2 {
    public static void main(String[] args) {
        int numA, numB;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap 2 so A va B.");
        System.out.println("Nhap A:");
        numA = sc.nextInt();
        System.out.println("Nhap B: ");
        numB = sc.nextInt();
        System.out.println("Tong cua A va B la: "+(numA+numB));
    }
}
