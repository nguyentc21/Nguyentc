/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import entity.Product;

/**
 *
 * @author nguyentc
 */
public interface ProductBus {
    public void add(Product pr);
    public boolean delete(int code);
    public void sort();
    public void display();
}
