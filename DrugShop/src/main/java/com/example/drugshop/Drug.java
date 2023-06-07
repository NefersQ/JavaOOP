package com.example.drugshop;


import java.io.Serializable;

public class Drug implements Serializable { //Creating drug class
    public Integer DrugID;
    public String DrugName;
    public Double Price;

    //getters for drugs
    public Integer getDrugID() {
        return DrugID;
    }

    public String getDrugName() {
        return DrugName;
    }

    public Double getPrice() {
        return Price;
    }
}