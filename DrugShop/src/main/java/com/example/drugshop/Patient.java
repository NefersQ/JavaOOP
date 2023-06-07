package com.example.drugshop;

import java.io.Serializable;

public class Patient implements Serializable { //Creating patient main class
    public Integer PID;
    public String name;
    public String surname;
    Recipe recipe = new Recipe();

    //getters for patient
    public Integer getPID() {
        return PID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getRecID() {
        return recipe.RecID;
    }

    public Integer getAmount() {
        return recipe.Amount;
    }
    public Double getFullPrice() {
        return recipe.fullPrice;
    }

    public String getDisease() {
        return recipe.Disease;
    }
    public Integer getDrugID() {
        return recipe.drug.DrugID;
    }

    public String getDrugName() {
        return recipe.drug.DrugName;
    }

    public Double getPrice() {
        return recipe.drug.Price;
    }

}
