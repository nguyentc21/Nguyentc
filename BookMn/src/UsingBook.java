
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
                    Book b=new Book();
                    System.out.println("THEM SACH MOI.");
                    System.out.println("Dien thong tin sach:"
                            + "\nMa Sach");
                    b.setCode(sc.nextInt());
                    System.out.println("Ten sach:");
                    sc=new Scanner(System.in);
                    b.setName(sc.nextLine());
                    System.out.println("Gia:");
                    b.setPrice(sc.nextInt());
                    System.out.println("So luong");
                    b.setQuanty(sc.nextInt());
                    if(bookD.create(b)){
                        System.out.println("Them Sach moi thanh cong!");
                    }else{
                        System.out.println("Loi! Trung ma Sach hoac kho da day.");
                    }
                    break;
                case 2:
                    System.out.println("DANH SACH SACH HIEN CO:");
                    for(Book bo:(bookD.display())){
                        System.out.println(bo.toString());
                    }
                    break;
                case 3:
                    System.out.println("GIAM GIA SACH.");
                    System.out.println("Nhap ma sach:");
                    int code=sc.nextInt();
                    System.out.println("Nhap so tien giam:");
                    int moneyDc=sc.nextInt();
                    if(bookD.discount(code, moneyDc)){
                        System.out.println("Cap nhap gia thanh cong!");
                    }else{
                        System.out.println("Loi! Khong tim thay Sach hoac so tien giam qua lon.");
                    }
                    break;    
                case 4:
                    System.out.println("HIEN THI TONG GIA CAC SACH CO.");
                    System.out.println("Tong gia cac Sach: "+bookD.totalPrice());
                    break;
                case 5:
                    System.out.println("HIEN THI GIA SACH LON NHAT.");
                    System.out.println("Gia Sach lon nhat hien co: "+bookD.maxPrice());
                    break;
                case 6:
                    System.out.println("TIM SACH THEO MA.");
                    System.out.println("Nhap ma Sach can tim:");
                    int codeF=sc.nextInt();
                    if(bookD.find(codeF).getCode() == 0){
                        System.out.println("Loi! Khong tim thay Sach nay.");
                    }else{
                        System.out.println(bookD.find(codeF).toString());
                    }
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
