
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
public class Q5 {
    public static void main(String[] args) {
        System.out.println("Kiem tra so chan");
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap 1 so bat ky: ");
        int numA=sc.nextInt();
        if(numA%2==0){
            System.out.println(numA+" la so chan.");
        }else{
            System.out.println(numA+" la so le.");
        }
    }
}
