/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bus.BookUtil;
import entity.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class BookDAO implements BookUtil {

    int n;
    List<Book> book = new ArrayList<>();

    public BookDAO() {
        n = 0;
    }

    @Override
    public boolean add(Book b) {
        for (Book bo : book) {
            if (b.compareTo(bo) == 0) {
                return false;
            }
        }
        book.add(b);
        n++;
        return true;
    }

    @Override
    public int indexOf(int code) {
        for (int i = 0; i < n; i++) {
            if (code == book.get(i).getCode()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public float getCost(String sName) {
        float total = 0;
        for (Book bo : book) {
            /*if(book[i].getName().substring(0, (sName.length()-1)).equals(sName)){
                total+=(book[i].getQuantity()*book[i].getPrice());
            }*/
            if (bo.getName().indexOf(sName) == 0) {
                total += (bo.getQuantity() * bo.getPrice());
            }
        }
        return total;
    }

    @Override
    public void readByAll() {
        for (Book bo : book) {
            System.out.println(bo.toString());
        }
    }

    @Override
    public void readByMaxQty() {
        int max = 0;
        int indexMQ = 0;
        for (int i=0; i<n;i++) {
            if (max < book.get(i).getQuantity()) {
                max = book.get(i).getQuantity();
                indexMQ = i;
            }
        }
        System.out.println(book.get(indexMQ).toString());
    }

}
