
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
public class Q10 {
    public static void main(String[] args) {
        int hour;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap gio tu 0 den 24:");
        hour=sc.nextInt();
        if(hour<0 || hour>24){
            System.out.println("Nhap sai.");
        }else{
            if(hour>12){
                System.out.println("Gio vua nhap la: "+(hour-12)+" PM");
            }else{
                System.out.println("Gio vua nhap la: "+hour+" AM");
            }
        }
    }
}
