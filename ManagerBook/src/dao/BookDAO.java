/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bus.BookUtil;
import entity.Book;

/**
 *
 * @author nguye
 */
public class BookDAO implements BookUtil {

    int n;
    int max = 50;
    Book[] book = new Book[max];

    public BookDAO() {
        n = 0;
        for (int i = 0; i < 10; i++) {
            book[i] = new Book();
        }
    }

    @Override
    public boolean add(Book b) {
        if (n < max) {
            /*for (int i = 0; i < n; i++) {
                if(b.getCode()==book[i].getCode()){
                    return false;
                }
            }*/
            book[n] = b;
            n++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int indexOf(int code) {
        for (int i = 0; i < n; i++) {
            if (code == book[i].getCode()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public float getCost(String sName) {
        float total = 0;
        for (int i = 0; i < n; i++) {
            /*if(book[i].getName().substring(0, (sName.length()-1)).equals(sName)){
                total+=(book[i].getQuantity()*book[i].getPrice());
            }*/
            if (book[i].getName().indexOf(sName) == 0) {
                total += (book[i].getQuantity() * book[i].getPrice());
            }
        }
        return total;
    }

    @Override
    public void readByAll() {
        for (int i = 0; i < n; i++) {
            System.out.println(book[i].toString());
        }
    }

    @Override
    public void readByMaxQty() {
        int max = 0;
        int indexMQ = 0;
        for (int i = 0; i < n; i++) {
            if (max < book[i].getQuantity()) {
                max = book[i].getQuantity();
                indexMQ = i;
            }
        }
        System.out.println(book[indexMQ].toString());
    }

}
