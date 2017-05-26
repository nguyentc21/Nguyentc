/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyentc
 */
public class Q14 {
    public static void main(String[] args) {
        //Hien thi nhung so nguyen tu 0 den 100
        for(int i=0;i<101;i++){
            if(i%2==0 && i%3==0){
                System.out.print(i+"\t");
            }
        }
    }
}
