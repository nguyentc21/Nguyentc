/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Book implements Serializable{
    private int code;
    private String name;
    private int quantity;
    private float price;

    public Book(int code, String name, int quantity, float price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Book (){
        
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "Code: "+code+"\t\tName: "+name+"\t\tQuantity: "+quantity+"\t\tPrice: "+price;
    }
}
