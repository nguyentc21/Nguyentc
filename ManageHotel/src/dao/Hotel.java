package dao;


import dto.Room;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyentc
 */
public class Hotel {
    int capacity=10, roomOcc=0;
    Room res[]=new Room[capacity];
    
    public Hotel() {
        for (int i = 0; i < 10; i++) {
            res[i] = new Room();
        }
    }
    //Hien thi thong tin cua phong da dat la item
    public Room[] display(){
        Room roomItem[]=new Room[roomOcc];
        for(int i = 0 ; i < roomOcc ; i++){
            roomItem[i]=res[i];
        }
        return roomItem;
    }
    //Dang ki phong.
    public boolean book(Room r){
        int num=capacity-roomOcc;
        if(num<1){
            return false;
        }else{
            for(int i=0;i<roomOcc;i++){
                if(r.getCode()==res[i].getCode() || r.getId()==res[i].getId()){
                    return false;
                }
            }
            res[roomOcc]=r;
            roomOcc++;
            return true;
        }
    }
    //Hien thi thong tin phong theo ma
    public Room find(int code){
        Room roomF=new Room();
        for(int i=0;i<capacity;i++){
            if(code==res[i].getCode()){
                roomF=res[i];
                break;
            }
        }
        return roomF;
    }   
}
