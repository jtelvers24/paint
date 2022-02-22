package edu.wctc;

import java.io.*;
import java.util.Scanner;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;


public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args) {
        char response = ' ';
        do {
            printMenu();
            response = keyboard.next().charAt(0);
            if(response == 'a'){
                CreateRoom();
            }else if (response == 'b'){
                if (paintCalculator.getRoomList().isEmpty()){
                    System.out.println("No rooms yet");

                }else{
                for (Room x : paintCalculator.getRoomList()){
                    System.out.println("Room with Area: " + x.getArea());
                }
            }}else if(response == 'c') {

             readFile();
            }else if(response == 'd'){
                writeFile();
            }
        } while (response != 'e');

    }
    private static void  printMenu(){
        System.out.println("a. Add Room");
        System.out.println("b. View Rooms");
        System.out.println("c. Read Rooms From File");
        System.out.println("d. Write Rooms to file");
        System.out.println("e. Exit Program");
    }

    private static double promptForDimension(String dimensionName){
        System.out.println("Enter " + dimensionName);
        double dimensionvalue = Double.parseDouble(keyboard.next());
        return dimensionvalue;
    }

    private static void CreateRoom(){

        double length = promptForDimension("Length");
        double width = promptForDimension("Width");
        double height = promptForDimension("Height");
        paintCalculator.addRoom(length,width,height);
    }

    private static void writeFile(){
        try (
                FileOutputStream fos = new FileOutputStream("rooms.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintCalculator);
        } catch (IOException e) {
            System.out.println("Could Not Write File");
        }
    }
    private static void readFile(){
        try (
                FileInputStream fis = new FileInputStream("rooms.obj");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            paintCalculator  = (PaintCalculator) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could Not Read File");
        }
    }
}
