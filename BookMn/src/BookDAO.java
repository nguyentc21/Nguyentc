/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyentc
 */
public class BookDAO {
    int max;
    int len;
    Book book[]=new Book[max];
    
    public BookDAO(){
        len=0;
        for(int i=0; i<(max=10); i++){
            book[i]=new Book();
        }
    }
    
    public boolean create(Book b){
        if((max-len)<1){
            return false;
        }else{
            for(int i=0; i<len; i++){
                if(book[i].getCode() == b.getCode()){
                    return false;
                }
            }
            book[len++]=b;
            return true;
        }
    }
    
    public boolean discount(int code, int prDc){
        for(int i=0; i<len; i++){
            if(book[i].getCode() == code){
                if((book[i].getPrice()/3) >= prDc){
                    book[i].setPrice(book[i].getPrice()-prDc);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    
    public Book[] display(){
        Book b[]=new Book[len];
            for(int i=0; i<len; i++){
                b[i]=book[i];
            }
        return b;
    }
    
    public int totalPrice(){
        int total=0;
        for(int i=0; i<len; i++){
            total+=book[i].getPrice();
        }
        return total;
    }
    
    public int maxPrice(){
        int max=0;
        for(int i=0; i<len; i++){
            if(book[i].getPrice() > max){
                max=book[i].getPrice();
            }
        }
        return max;
    }
    
    public Book find(int code){
        Book bookf=new Book();
        for(int i=0; i<len; i++){
            if(book[i].getCode() == code){
                bookf=book[i];
                return bookf;
            }
        }
        return bookf;
    }
}

