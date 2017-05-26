
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
public class Q11 {
    public static void main(String[] args) {
        System.out.println("Nhap 1 so tu 1 den 7:");
        Scanner sc=new Scanner(System.in);
        int date=sc.nextInt();
        switch(date){
            case 1:
                System.out.println("Ngay thu hai");
                break;
            case 2:
                System.out.println("Ngay thu ba");
                break;
            case 3:
                System.out.println("Ngay thu tu");
                break;
            case 4:
                System.out.println("Ngay thu nam");
                break;
            case 5:
                System.out.println("Ngay thu sau");
                break;
            case 6:
                System.out.println("Ngay thu bay");
                break;
            case 7:
                System.out.println("Ngay chu nhat");
                break;
            default:
                break;
        }
    }
}
