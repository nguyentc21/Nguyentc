
import static java.lang.Math.sqrt;
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
public class Q16 {
    public static void main(String[] args) {
        System.out.println("Nhap 1 so bat ky:");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Q16 q=new Q16();
        if(q.check(num)==true){
            System.out.println("So vua nhap la so nguyen to.");
        }else{
            System.out.println("So vua nhap khong phai la so nguyen to.");
        }

    }
    public boolean check(int num){
        for(int i=2;i<=sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
