package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList;

    public Room(double width, double length, double height) {
        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);
        this.wallList = new ArrayList<Wall>();
        this.wallList.add(wall1);
        this.wallList.add(wall2);
        this.wallList.add(wall3);
        this.wallList.add(wall4);
    }

    public double getArea(){
        double area = 0;
        for (Wall wall : this.wallList){
            area += wall.getarea();
        }
        return area;
    }

    public String toString(){
            return String.valueOf(this.getArea());
    }


}
