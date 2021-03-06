package dto;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyentc
 */
public class Book extends Magezine implements Serializable{
    private int quanty;
    private int price;
    
    public Book(){}

    public Book(int quanty, int price) {
        this.quanty = quanty;
        this.price = price;
    }

    public Book(int quanty, int price, int code, String name) {
        super(code, name);
        this.quanty = quanty;
        this.price = price;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    @Override
    public String toString(){
        return "Code: "+this.getCode()+"\t\tName: "+this.getName()+"\t\tPrice: "+price+"\t\tQuanty: "+quanty;
    }
}
