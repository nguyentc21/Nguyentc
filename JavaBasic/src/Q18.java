
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
public class Q18 {
    public static void main(String[] args) {
        System.out.println("Nhap mot so nguyen bat ky.");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Q18 q=new Q18();
        if(q.check(num)==true){
            System.out.println("So vua nhap la mot so Hoan hao");
        }else{
            System.out.println("So vua nhap khong phai la mot so Hoan hao");
        }
        
    }
    public boolean check(int num){
        int tong=0;
        for(int i=1;i<=num/2;i++){
            if(num%i==0){
                tong=tong+i;
            }
        }
        if (tong==num){
            return true;
        }else{
            return false;
        }
    }
}
