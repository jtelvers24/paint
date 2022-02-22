package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<Room>();

    public void addRoom(double length, double width, double height){
        Room newRoom = new Room(width, length, height);

       this.roomList.add(newRoom);
    }

    public String toString(){

        double area = 0;
        for (Room room : this.roomList){
            area += room.getArea();
        }
        return  String.valueOf(area);
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}


