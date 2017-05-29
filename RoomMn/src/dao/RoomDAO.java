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
    Room room[]=new Room[10] ;
    int count=0;
    
    public RoomDAO(){
        for(int i=0;i<10;i++){
            room[i]=new Room();
        }
    }
    
    @Override
    public boolean create(Room r) {
        if(count>=10){
            return false;
        }else{
            room[count]=r;
            count++;
            return true;
        }
    }

    @Override
    public boolean update(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readByCode(String code) {
        int index;
        for(int i=0;i<count;i++){
            if(room[i].getCode().equals(code)){
                index=i;
                return index;
            }
        }
        return -1;
        
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int total() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
