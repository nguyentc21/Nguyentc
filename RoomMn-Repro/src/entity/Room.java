/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author nguyentc
 */
public class Room implements Serializable, Comparable<Room>{
    private String code;
    private int price;
    private boolean status;

    public Room(String code, int price, boolean status) {
        this.code = code;
        this.price = price;
        this.status = status;
    }
    public Room(){
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int compareTo(Room o) {
        int value=this.getCode().compareTo(o.getCode());
        return value;
    }
    @Override
    public String toString(){
        return "Room={ Code: "+code+"  Price: "+price+"  Status: "+status+" }";
    }
  
}
