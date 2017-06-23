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

    List<Book> book;

    public BookDAO() {
        book = new ArrayList<>();
    }

    @Override
    public boolean add(Book b) {
        for (Book bo : book) {
            if (b.compareTo(bo) == 0) {
                return false;
            }
        }
        book.add(b);
        return true;
    }

    @Override
    public int indexOf(int code) {
        int index = 0;
        for (Book bo : book) {
            if (code == bo.getCode()) {
                return index;
            }
            index++;
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
        int indexMQ = 0, count = 0;
        for (Book bo : book) {
            if (max < bo.getQuantity()) {
                max = bo.getQuantity();
                indexMQ = count;
            }
            count++;
        }
        System.out.println(book.get(indexMQ).toString());
    }

}
