
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
public class UsingBook {
    public static void main(String[] args) {
        BookDAO bookD=new BookDAO();
        int choice=0;
        
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("CHUONG TRINH QUAN LY SACH."
                    + "\n1-Them Sach moi."
                    + "\n2-Hien thi danh sach Sach."
                    + "\n3-Giam gia Sach."
                    + "\n4-Tong gia Sach."
                    + "\n5-Tim Sach co gia lon nhat."
                    + "\n6-Tim Sach theo ma."
                    + "\n7-Thoat chuong trinh"
                    + "\nNhap tu 1 den 7 de chon chuc nang:");
            choice=sc.nextInt();
            
            switch(choice){
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;    
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
