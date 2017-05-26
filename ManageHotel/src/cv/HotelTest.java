package cv;


import dao.Hotel;
import dto.Room;
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
public class HotelTest {
    public static void main(String[] args) {
        int choice=0;
        Hotel hot=new Hotel();
        
        Scanner sc= new Scanner(System.in);
        while(true){
                System.out.println("CHUONG TRINH QUAN LY KHACH SAN."
                        + "\n1: Dat phong."
                        + "\n2: Hien thi danh sach cac phong da dat."
                        + "\n3: Tim kiem theo ma phong."
                        + "\nNhap tu 1 den 3 de chon chuc nang: ");
                choice = sc.nextInt();
            switch(choice){
                case 1:
                    Room roomTem=new Room();
                    System.out.println("Dat phong."
                            + "\nNhap ma dang ki: ");
                    roomTem.setId(sc.nextInt());
                    System.out.println("Nhap ten khach: ");
                    sc=new Scanner(System.in);
                    roomTem.setName(sc.nextLine());
                    System.out.println("Nhap ma phong: ");
                    roomTem.setCode(sc.nextInt());
                    if(hot.book(roomTem)==false){
                        System.out.println("Loi, phong da day hoac du lieu nhap vao sai.");
                    }else{
                        System.out.println("Dat phong thanh cong.");
                    }
                    break;
                case 2:
                    System.out.println("Danh sach cac phong da dat:");
                    for(Room r: (hot.display())){
                        System.out.println(r.toString());
                    }
                    break;
                case 3:
                    System.out.println("Tim kiem thong tin phong."
                            + "\nNhap ma phong can tim:");
                    int code=sc.nextInt();
                    if(hot.find(code).getCode()==0){
                        System.out.println("Khong tim thay ma phong nay.");
                    }else{
                        System.out.println(hot.find(code).toString());
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
