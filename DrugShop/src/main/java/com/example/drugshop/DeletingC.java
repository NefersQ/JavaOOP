package com.example.drugshop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class DeletingC {

    @FXML
    private Button backbut;

    @FXML
    private Button deldbut;

    @FXML
    private Button delpatbut;

    @FXML
    private TextField deldrug;

    @FXML
    private TextField delpat;
    public void backbutOnClick(ActionEvent a) throws IOException { //back to menu function
        Aux helper = new Aux();
        helper.newScene(a, "Main Menu", "Mainmenu.fxml");
    }
    public void deletepat(ActionEvent a) throws IOException { //function to delelte patient
            for (int k = 0; k < Main.lpatient.size(); k++) {
                System.out.println("cycle phasecheckPID " + k);
                if (Objects.equals(Main.lpatient.get(k).PID, Integer.parseInt(delpat.getText()))) {
                    Main.lpatient.remove(k);
                    Main.load.fileOut(Main.lpatient);
                    break;
                }
            }
        }
    public void deletedrug(ActionEvent a) throws IOException {  //function to delelte drug
            for (int k = 0; k < Main.ldrug.size(); k++) {
                System.out.println("cycle phasecheckPID " + k);
                if (Objects.equals(Main.ldrug.get(k).getDrugID(), Integer.parseInt(deldrug.getText()))) {
                    Main.ldrug.remove(k);
                    Main.loadD.fileOutD(Main.ldrug);
                    break;
                }
            }
        }
    }

