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

    public static void main(String[] args) {
        BookDAO bookD = new BookDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Add 4 books to Library.");
        for (int i = 0; i < 2; i++) {
            Book bA = new Book();
            System.out.println("Book" + (i + 1));
            do {
                System.out.println("Code");
                int codeA = sc.nextInt();
                if (codeA < 0) {
                    System.out.println("Code is not validated!");
                } else {
                    break;
                }
            } while (true);
            System.out.println("Name");
            sc = new Scanner(System.in);
            String nameA = sc.nextLine();
            do {
                System.out.println("Quantity");
                int codeA = sc.nextInt();
                if (codeA < 0) {
                    System.out.println("Quantity is not validated!");
                } else {
                    break;
                }
            } while (true);
            do {
                System.out.println("Price");
                int codeA = sc.nextInt();
                if (codeA < 0) {
                    System.out.println("Price is not validated!");
                } else {
                    break;
                }
            } while (true);
            bookD.add(bA);
        }
        
        System.out.println("Enter a string from keyboard:");
        sc=new Scanner(System.in);
        String sName=sc.nextLine();
        System.out.println("Total cost of all books that names started with this string is "
        +bookD.getCost(sName));
        
        
        bookD.readByMaxQty();
        
        bookD.readByAll();

    }
}
