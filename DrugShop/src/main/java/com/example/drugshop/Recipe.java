package com.example.drugshop;

import java.io.Serializable;

public class Recipe implements Serializable { //Creating recipe inner class
    public Integer RecID;
    public Integer Amount;
    public Double fullPrice;
    public String Disease;
    Drug drug = new Drug();

    //getters for recipe
    public Integer getRecID() {
        return RecID;
    }

    public Integer getAmount() {
        return Amount;
    }

    public String getDisease() {
        return Disease;
    }

    public Drug getDrug() {
        return drug;
    }
}