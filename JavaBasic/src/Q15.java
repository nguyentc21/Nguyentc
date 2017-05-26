
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
public class Q15 {
    public static void main(String[] args) {
        System.out.println("Nhap mot so bat ky, hien thi ra giai thua:");
        Scanner sc=new Scanner(System.in);
        int numA=sc.nextInt();
        int g=1;
        for(int i=1;i<=numA;i++){
            g=g*i;
        }
        System.out.println(numA+" giai thua bang: "+g);
    }
}
