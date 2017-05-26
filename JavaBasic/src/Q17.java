
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
public class Q17 {
    public static void main(String[] args) {
        System.out.println("Nhap 1 so nguyen bat ki:");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Q17 q=new Q17();
        if(q.check(num)==true){
            System.out.println("So vua nhap la so Chinh phuong.");
        }else{
            System.out.println("So vua nhap khong phai la so Chinh phuong.");
        }
    }
    public boolean check(int num){
        if(num<=0){
            return false;
        }else{
            int i=1;
            while(i*i<=num){
                if(i*i==num){
                    return true;
                }else{
                    i++;
                }
            }
            return false;
        }
    }
}
