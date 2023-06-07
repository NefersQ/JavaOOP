package com.example.drugshop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;
import java.util.Objects;

public class AddingC {
    @FXML
    private TextField d2id;

    @FXML
    private TextField didbut;

    @FXML
    private TextField diseasebut;

    @FXML
    private TextField dnamebut;

    @FXML
    private TextField amountbut;

    @FXML
    private TextField dpricebut;

    @FXML
    private TextField namebut;

    @FXML
    private TextField pidbut;

    @FXML
    private TextField recidbut;

    @FXML
    private TextField snamebut;
    @FXML
    private Button backbut;
    int sameInput = 0;
    public void backbutOnClick(ActionEvent a) throws IOException {
        Help helper = new Help();
        helper.newScene(a, "Main Menu", "Mainmenu.fxml");
    }
    public void addNewDrug(ActionEvent a) throws IOException {
        Drug tdrug = new Drug();
        if (d2id.getText().isBlank() || dnamebut.getText().isBlank() || dpricebut.getText().isBlank()) {
            sameInput++;
        }else {
            for (int i = 0; i < Main.ldrug.size(); i++) {
                if (Objects.equals(Main.ldrug.get(i).DrugID, Integer.parseInt(d2id.getText()))) {
                    sameInput++;
                }
            }
        }
        if (sameInput == 0) {
            tdrug.DrugID = Integer.parseInt(d2id.getText());
            tdrug.DrugName = dnamebut.getText();
            tdrug.Price =  Double.parseDouble(dpricebut.getText());
            Main.ldrug.add(tdrug);
            Main.loadD.fileOutD(Main.ldrug);
        } else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Adding new drug ERROR");
            alert.setContentText("Same drug ID is used, or not all fields are fullfiled");
            alert.showAndWait();
            sameInput = 0;
        }
    }
    public void addNewPatient(ActionEvent a) throws IOException {
        Patient tpatient = new Patient();
        for (int k = 0; k < Main.lpatient.size(); k++) {
            System.out.println("cycle phasecheckPID " + k);
            if (pidbut.getText().isBlank() || namebut.getText().isBlank() || snamebut.getText().isBlank() || recidbut.getText().isBlank() ||
                    amountbut.getText().isBlank() || diseasebut.getText().isBlank() || didbut.getText().isBlank()) {
                sameInput++;
            }else {
            if (Objects.equals(Main.lpatient.get(k).PID, Integer.parseInt(pidbut.getText())) || Objects.equals(Main.lpatient.get(k).recipe.RecID, Integer.parseInt(recidbut.getText()))
                    ) {
                sameInput++;
            }
            }
        }
                if (sameInput == 0) {
                tpatient.PID = Integer.parseInt(pidbut.getText());
                tpatient.name = namebut.getText();
                tpatient.surname = snamebut.getText();
                tpatient.recipe.RecID = Integer.parseInt(recidbut.getText());
                tpatient.recipe.Amount = Integer.parseInt(amountbut.getText());
                tpatient.recipe.Disease = diseasebut.getText();
                Integer checker = Integer.parseInt(didbut.getText());
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

                Main.lpatient.add(tpatient);
                Main.load.fileOut(Main.lpatient);
            } else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Adding new patient ERROR");
                    alert.setContentText("Same pID,RecID are already used, or not all fields are fullfiled");
                    alert.showAndWait();
                    sameInput = 0;
                }
            }
        }


