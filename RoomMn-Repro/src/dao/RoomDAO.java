/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyentc
 */
public class RoomDAO implements RoomBus {

    public List<Room> room;
    int max=10;

    public RoomDAO() {
        room = new ArrayList<>(max);
    }

    @Override
    public boolean create(Room r) {
        if (room.size() > 9) {
            return false;
        } else {
            for(Room ro: room){
                if(ro.compareTo(r)==0){
                    return false;
                }
            }
            room.add(r);
            return true;
        }
    }

    @Override
    public boolean update(String code) {
        int value = readByCode(code);
        if (value == -1) {
            return false;
        } else {

            Room r = new Room();
            room.get(value).setStatus(false);
            for (int i = value; i < (room.size()-1); i++) {
                r = room.get(i);
                room.set(i, room.get(i + 1));
                room.set(i + 1, r);
            }

            return true;
        }
    }

    @Override
    public int readByCode(String code) {
        int value = 0;
        for (Room r : room) {
            if (r.getCode().equals(code)) {
                return value;
            }
            value++;
        }
        return -1;
    }

    @Override
    public int count() {

        return max - room.size();
    }

    @Override
    public int total() {
        int total = 0;
        for(Room ro:room){
            total+=ro.getPrice();
        }
        return total;
    }

    @Override
    public void display(boolean status) {
        for(Room ro:room){
            System.out.println(ro.toString());
        }
    }

}
