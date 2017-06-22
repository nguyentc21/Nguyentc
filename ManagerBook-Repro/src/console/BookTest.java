/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import dao.BookDAO;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class BookTest {

    int checkInt(String s) {
        try {
            int num = Integer.parseInt(s);
            return num;
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
            return -1;
        }
    }

    float checkFloat(String s) {
        try {
            float num = Float.parseFloat(s);
            return num;
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        BookDAO bookD = new BookDAO();
        Scanner sc = new Scanner(System.in);
        BookTest bookT = new BookTest();

        System.out.println("Add 4 books to Library.");
        for (int i = 0; i < 4; i++) {
            Book bA = new Book();
            System.out.println("Book " + (i + 1));
            do {
                System.out.println("Code:");
                int codeA = bookT.checkInt(sc.nextLine());
                if (codeA > 0) {
                    bA.setCode(codeA);
                    break;
                } else {
                    System.out.println("Error! Input code is not valiable!");
                }
            } while (true);
            System.out.println("Name");
            sc = new Scanner(System.in);
            bA.setName(sc.nextLine());
            do {
                System.out.println("Quantity:");
                int quantA = bookT.checkInt(sc.nextLine());
                if (quantA > 0) {
                    bA.setQuantity(quantA);
                    break;
                } else {
                    System.out.println("Error! Input quantity is not valiable!");
                }
            } while (true);
            do {
                System.out.println("Price:");
                float priceA = bookT.checkFloat(sc.nextLine());
                if (priceA > 0) {
                    bA.setPrice(priceA);
                    break;
                } else {
                    System.out.println("Error! Input price is not valiable!");
                }
            } while (true);
            if (bookD.add(bA)) {
                System.out.println("Add Book success!");
            } else {
                System.out.println("Add Book fail.");
            }
        }

        System.out.println("Enter a string from keyboard:");
        sc = new Scanner(System.in);
        String sName = sc.nextLine();
        System.out.println("Total cost of all books that names started with this string is "
                + bookD.getCost(sName));

        System.out.println("The book has maximum of quantity:");
        bookD.readByMaxQty();

        System.out.println("All books in library:");
        bookD.readByAll();

    }
}
