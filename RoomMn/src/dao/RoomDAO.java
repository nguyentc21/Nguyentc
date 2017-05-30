/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;

/**
 *
 * @author nguyentc
 */
public class RoomDAO implements RoomBus{
    int max=10;
    int index=0;
    public Room room[]=new Room[max] ;
    
    public RoomDAO(){
        for(int i=0; i<max; i++){
            room[i]=new Room();
        }
    }
    
    @Override
    public boolean create(Room r) {
        if(index>9){
            return false;
        }else{
            room[index]=r;
            index++;
        return true;
        }
    }

    @Override
    public boolean update(String code) {
        if(readByCode(code)==-1){
            return false;
        }else{
            Room r=new Room();
            for(int i=(readByCode(code)) ; i<(index-1) ; i++){
                r=room[i];
                room[i]=room[i+1];
                room[i+1]=r;
            }
            room[(index--)-1].setStatus(false);
            return true;
        }
    }

    @Override
    public int readByCode(String code) {
        for(int i=0;i<index;i++){
            if(room[i].getCode().equals(code)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int count() {
        
        return max-index;
    }

    @Override
    public int total() {
        int total=0;
        for(int i=0;i<index;i++){
            total+=room[i].getPrice();
        }
        return total;
    }

    @Override
    public void display(boolean status) {
        
    }
    
}
