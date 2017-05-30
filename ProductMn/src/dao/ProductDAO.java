/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bus.ProductBus;
import entity.Product;

/**
 *
 * @author nguyentc
 */
public class ProductDAO implements ProductBus{
    int len=20;
    int n=0;
    Product p[]=new Product[len];
    public ProductDAO(){
        for(int i=0; i<len; i++){
            p[i]=new Product();
        }
    }
    
    @Override
    public void add(Product pr) {
        p[n++]=pr;
    }

    @Override
    public boolean delete(int code) {
        Product pf=new Product();
        if(code == p[n-1].getCode()){
            n--;
            return true;
        }else{
            for(int i=0; i<(n-1); i++){
                if(p[i].getCode() == code){
                    pf=p[i];
                    p[i]=p[i+1];
                    p[i+1]=pf;
                    n--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void sort() {
        Product pr=new Product();
        for(int i=0; i<(n-1); i++){
            for(int j=i+1; j<n; j++){
                if( p[i].getPrice()*p[i].getQuantity() > p[j].getPrice()*p[j].getQuantity()){
                    pr=p[i];
                    p[i]=p[j];
                    p[j]=p[i];
                }
            }
        }
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
