/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import dao.ProductDAO;
import entity.Product;
import java.util.Scanner;

/**
 *
 * @author nguyentc
 */
public class ProductMn {
    public static void main(String[] args) {
        ProductDAO prD=new ProductDAO();
        
        System.out.println("Them thong tin cho 3 san pham.");
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<3; i++){
            System.out.println("San pham thu "+(i+1)+" :");
            Product pr=new Product();
            System.out.println("Ma san pham: ");
            pr.setCode(sc.nextInt());
            System.out.println("Ten san pham: ");
            sc=new Scanner(System.in);
            pr.setName(sc.nextLine());
            System.out.println("Gia: ");
            pr.setPrice(sc.nextInt());
            System.out.println("So luong: ");
            pr.setQuantity(sc.nextInt());
            prD.add(pr);
        }
        
        System.out.println("Xoa san pham.");
        System.out.println("Nhap ma san pham muon xoa:");
        int code=sc.nextInt();
        if(prD.delete(code)){
            System.out.println("Xoa thanh cong!");
        }else{
            System.out.println("Loi! Khong tim thay san pham co ma la "+code);
        }
        
        prD.sort();
        
    }
}
