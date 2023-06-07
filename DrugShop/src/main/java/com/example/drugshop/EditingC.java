package com.example.drugshop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class EditingC {


    @FXML
    private Button backbut;

    @FXML
    private TextField dedit;

    @FXML
    private TextField did;

    @FXML
    private Button dloadbut;

    @FXML
    private TextField dname;

    @FXML
    private TextField dprice;

    @FXML
    private Button dsavebut;

    @FXML
    private Button psavebut;

    @FXML
    private TextField pdisease;

    @FXML
    private TextField pamount;

    @FXML
    private TextField pdrugid;

    @FXML
    private TextField pedit;

    @FXML
    private TextField pid;

    @FXML
    private Button ploadbut;

    @FXML
    private TextField pname;

    @FXML
    private TextField precid;

    @FXML
    private TextField psname;
    int dIndex = -1;
    int pIndex = -1;
    public void backbutOnClick(ActionEvent a) throws IOException { //back to menu function
        Help helper = new Help();
        helper.newScene(a, "Main Menu", "Mainmenu.fxml");
    }
    public void pLoad(ActionEvent a) throws IOException {

        for (int k = 0; k < Main.lpatient.size(); k++) {
            if (Objects.equals(Main.lpatient.get(k).PID, Integer.parseInt(pid.getText()))) {
                pid.setText(String.valueOf(Main.lpatient.get(k).PID));
                pname.setText(Main.lpatient.get(k).name);
                psname.setText(Main.lpatient.get(k).surname);
                precid.setText(String.valueOf(Main.lpatient.get(k).recipe.RecID));
                pamount.setText(String.valueOf(Main.lpatient.get(k).recipe.Amount));
                pdisease.setText(Main.lpatient.get(k).recipe.Disease);
                pdrugid.setText(String.valueOf(Main.lpatient.get(k).recipe.drug.DrugID));
                pIndex = k;
                break;
            }
        }
    }
    public void dLoad(ActionEvent a) throws IOException {

        for (int k = 0; k < Main.ldrug.size(); k++) {
            if (Objects.equals(Main.ldrug.get(k).DrugID, Integer.parseInt(did.getText()))) {
                did.setText(String.valueOf(Main.ldrug.get(k).DrugID));
                dname.setText(Main.ldrug.get(k).DrugName);
                dprice.setText(String.valueOf(Main.ldrug.get(k).Price));
                dIndex = k;
                break;
            }
        }
    }
    public void dSave(ActionEvent a) throws IOException {
        Drug tdrug = new Drug();
                tdrug.DrugID = Integer.parseInt(did.getText());
                tdrug.DrugName = dname.getText();
                tdrug.Price = Double.parseDouble(dprice.getText());
                for(int k = 0; k < Main.lpatient.size(); k++){
                    if(Objects.equals(Main.lpatient.get(k).recipe.drug.DrugID, tdrug.DrugID)){
                        Main.lpatient.get(k).recipe.fullPrice = Main.lpatient.get(k).recipe.Amount * tdrug.Price;
                        Main.load.fileOut(Main.lpatient);
                    }
                }
                Main.ldrug.set(dIndex,tdrug);
                Main.loadD.fileOutD(Main.ldrug);
            }
    public void pSave(ActionEvent a) throws IOException {
        Patient tpatient = new Patient();
        tpatient.PID = Integer.parseInt(pid.getText());
        tpatient.name = pname.getText();
        tpatient.surname = psname.getText();
        tpatient.recipe.RecID = Integer.parseInt(precid.getText());
        tpatient.recipe.Amount = Integer.parseInt(pamount.getText());
        tpatient.recipe.Disease = pdisease.getText();
        Integer checker = Integer.parseInt(pdrugid.getText());
        System.out.println("checker" + checker);
        int index = -1;
        for (int i = 0; i < Main.ldrug.size(); i++) {
            if (Objects.equals(Main.ldrug.get(i).DrugID, checker)) {
                index = i;
                break;

            }
        }
        if (index != -1) {
            System.out.println(Main.ldrug.get(index).DrugID);
            tpatient.recipe.drug.DrugID = Main.ldrug.get(index).DrugID;
            tpatient.recipe.drug.DrugName = Main.ldrug.get(index).DrugName;
            tpatient.recipe.drug.Price = Main.ldrug.get(index).Price;
            tpatient.recipe.fullPrice = tpatient.recipe.Amount * tpatient.recipe.drug.Price;
        }
        Main.lpatient.set(pIndex,tpatient);
        Main.load.fileOut(Main.lpatient);
    }
    public void updatePrice(ActionEvent a) throws IOException {

    }
        }
