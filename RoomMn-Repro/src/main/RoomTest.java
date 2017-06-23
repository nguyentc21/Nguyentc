/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.RoomDAO;
import entity.Room;
import java.util.Scanner;

/**
 *
 * @author nguyentc
 */
public class RoomTest {
    public static void main(String[] args) {
        RoomDAO roomD=new RoomDAO();
        
        
        System.out.println("QUAN LY KHACH SAN.");
        System.out.println("Nhap thong tin cho 4 phong:");
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<4; i++){
            Room r=new Room();
            System.out.println("Thong tin phong thu "+(i+1));
            System.out.println("Room code: ");
            sc=new Scanner(System.in);
            r.setCode(sc.nextLine());
            System.out.println("Price: ");
            r.setPrice(sc.nextInt());
            r.setStatus(true);
            if(roomD.create(r)==true){
                System.out.println("Nhap thanh cong thong tin phong thu "+(i+1)+" !");
            }else{
                System.out.println("Nhap thong tin that bai! Da het phong trong.");
                break;
            }
        }
        
        System.out.println("\nTra phong."
                + "\nNhap code phong muon tra:");
        sc=new Scanner(System.in);
        String code=sc.nextLine();
        if(roomD.update(code) == false){
            System.out.println("Cap nhat that bai! Khong tim thay phong.");
        }else{
            System.out.println("Tra phong thanh cong!");
        }
        
        System.out.println("\nSo luong phong con trong la "+roomD.count());
        
        System.out.println("Tong so tien cac phong da dat la "+roomD.total());
        
        for(Room ro:(roomD.room)){
            System.out.println(ro.toString());
        }
    }
}
