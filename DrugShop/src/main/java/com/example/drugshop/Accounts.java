package com.example.drugshop;
import java.io.Serializable;

public class Accounts implements Serializable { //Creating patient main class
    public String Login;
    public String Password;
    public boolean Admin;

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public boolean getAdmin() {
        return Admin;
    }
}