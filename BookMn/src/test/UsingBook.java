package test;

import dao.BookDAO;
import dto.Book;
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

    int checkNum(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            System.out.println("Error! Message: " + nfe.getMessage() + ""
                    + "\nNhap lai: ");
            return -1;
        }
    }

    public static void main(String[] args) {
        BookDAO bookD = new BookDAO();
        UsingBook uB = new UsingBook();
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("CHUONG TRINH QUAN LY SACH."
                    + "\n1-Them Sach moi."
                    + "\n2-Hien thi danh sach Sach."
                    + "\n3-Giam gia Sach."
                    + "\n4-Tong gia Sach."
                    + "\n5-Tim Sach co gia lon nhat."
                    + "\n6-Tim Sach theo ma."
                    + "\n7-Thoat chuong trinh"
                    + "\nNhap tu 1 den 7 de chon chuc nang:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Book b = new Book();
                    System.out.println("THEM SACH MOI.");
                    System.out.println("Dien thong tin sach:"
                            + "\nMa Sach");
                    /*int check;
                    
                    do{
                        sc=new Scanner(System.in);
                        String code=sc.nextLine();
                        check = bookD.checkNum(code);
                        if(check ==-1){
                            System.out.println("Error! ");
                        }
                    }while(check ==-1);
                     */
                    do {
                        sc = new Scanner(System.in);
                        String code = sc.nextLine();
                        int num = uB.checkNum(code);
                        if (num != -1) {
                            if (num > 0) {
                                b.setCode(num);
                                break;
                            } else {
                                System.out.println("Error! Ma sach phai la so nguyen duong."
                                        + "\nNhap lai:");
                            }
                        }
                    } while (true);

                    System.out.println("Ten sach:");
                    sc = new Scanner(System.in);
                    b.setName(sc.nextLine());

                    System.out.println("Gia:");
                    do {
                        sc = new Scanner(System.in);
                        String price = sc.nextLine();
                        int num = uB.checkNum(price);
                        if (num != -1) {
                            if (num > 0) {
                                b.setPrice(num);
                                break;
                            } else {
                                System.out.println("Error! Gia sach phai la so nguyen duong."
                                        + "\nNhap lai:");
                            }
                        }
                    } while (true);

                    System.out.println("So luong");
                    do {
                        sc = new Scanner(System.in);
                        String quanty = sc.nextLine();
                        int num = uB.checkNum(quanty);
                        if (num != -1) {
                            if (num > 0) {
                                b.setQuanty(num);
                                break;
                            } else {
                                System.out.println("Error! So luong sach phai la so nguyen duong."
                                        + "\nNhap lai:");
                            }
                        }
                    } while (true);

                    if (bookD.create(b)) {
                        System.out.println("Them Sach moi thanh cong!");
                    } else {
                        System.out.println("Loi! Trung ma Sach hoac kho da day.");
                    }
                    break;
                case 2:
                    System.out.println("DANH SACH SACH HIEN CO:");
                    for (Book bo : (bookD.display())) {
                        System.out.println(bo.toString());
                    }
                    break;
                case 3:
                    System.out.println("GIAM GIA SACH.");
                    System.out.println("Nhap ma sach:");
                    int codeD;
                    String sCodeD;
                    do {
                        sc = new Scanner(System.in);
                        sCodeD = sc.nextLine();
                        codeD = uB.checkNum(sCodeD);
                    } while (codeD == -1);

                    System.out.println("Nhap so tien giam:");
                    int moneyDc;
                    do {
                        sc = new Scanner(System.in);
                        String sMoney = sc.nextLine();
                        moneyDc = uB.checkNum(sMoney);
                        if (moneyDc != -1) {
                            if (moneyDc > 0) {
                                break;
                            } else {
                                System.out.println("Error! So tien phai la nguyen duong."
                                        + "\nNhap lai:");
                            }
                        }
                    } while (true);
                    if (bookD.discount(codeD, moneyDc)) {
                        System.out.println("Cap nhap gia thanh cong!");
                    } else {
                        System.out.println("Loi! Khong tim thay Sach hoac so tien giam qua lon.");
                    }
                    break;
                case 4:
                    System.out.println("HIEN THI TONG GIA CAC SACH CO.");
                    System.out.println("Tong gia cac Sach: " + bookD.totalPrice());
                    break;
                case 5:
                    System.out.println("HIEN THI GIA SACH LON NHAT.");
                    System.out.println("Gia Sach lon nhat hien co: " + bookD.maxPrice());
                    break;
                case 6:
                    System.out.println("TIM SACH THEO MA.");
                    System.out.println("Nhap ma Sach can tim:");
                    int codeF;
                    do {
                        sc = new Scanner(System.in);
                        String sCodeF = sc.nextLine();
                        codeF = uB.checkNum(sCodeF);
                        if (codeF != -1) {
                            if (codeF > 0) {
                                break;
                            } else {
                                System.out.println("Error! Ma sach phai la so nguyen duong."
                                        + "\nNhap lai:");
                            }
                        }
                    }while(true);
                    
                    
                    if (bookD.find(codeF).getCode() == 0) {
                        System.out.println("Loi! Khong tim thay Sach nay.");
                    } else {
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
