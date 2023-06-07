package com.example.drugshop;

import com.example.drugshop.Main;

import java.io.*;
import java.util.List;

public class FileWork<T> { //class which contains functions for loading/saving lists in file
    public void fileOut(T t) { //function to load patient list in file

        try {

            FileOutputStream fileOut = new FileOutputStream("data.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(t);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Object fileIn() { //function to load patient list in RAM

        try {

            FileInputStream fileIn = new FileInputStream("data.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object list = objectIn.readObject();

            objectIn.close();
            return list;

        } catch (Exception ex) {
            System.out.println("Data file not found, creating the new one!");

            return null;
        }
    }
    public void fileOutD(T t) { //function to load drug list in file


        try {

            FileOutputStream fileOut = new FileOutputStream("dataD.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(t);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Object fileInD() { //function to load drug list in RAM

        try {

            FileInputStream fileIn = new FileInputStream("dataD.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object list = objectIn.readObject();

            objectIn.close();
            return list;

        } catch (Exception ex) {
            System.out.println("Data file not found, creating the new one!");

            return null;
        }
    }
    public void fileOutA(T t) { //function to load accounts list in file

        try {

            FileOutputStream fileOutA = new FileOutputStream("dataA.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOutA);
            objectOut.writeObject(t);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Object fileInA() { //function to load account list in RAM

        try {

            FileInputStream fileInA = new FileInputStream("dataA.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileInA);

            Object list = objectIn.readObject();

            objectIn.close();
            return list;

        } catch (Exception ex) {
            System.out.println("Data file not found, creating the new one!");

            return null;
        }
    }
}
