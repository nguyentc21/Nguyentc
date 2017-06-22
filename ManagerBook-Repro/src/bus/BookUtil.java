/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import entity.Book;

/**
 *
 * @author nguye
 */
public interface BookUtil {
    public boolean add(Book b);
    public int indexOf(int code);
    public float getCost(String sName);
    public void readByAll();
    public void readByMaxQty();
}
