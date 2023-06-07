package com.example.drugshop;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class MainmenuC {
    @FXML
    private Button addbut;

    @FXML
    private TableColumn<Drug, String> dnameT;

    @FXML
    private TableView<Drug> drugT;

    @FXML
    private TableColumn<Drug, Integer> ddrugidT;

    @FXML
    private TableColumn<Drug, Integer> priceT;


    @FXML
    private TableColumn<Patient, Double> amountT;

    @FXML
    private Button delbut;

    @FXML
    private TableColumn<Patient, String> diseaseT;

    @FXML
    private TableColumn<Patient, Integer> drugidT;

    @FXML
    private Button editbut;

    @FXML
    private Button exitbut;

    @FXML
    private Button accountbut;

    @FXML
    private TableColumn<Patient, String> nameT;

    @FXML
    private TableView<Patient> patientT;

    @FXML
    private TableColumn<Patient, Integer> pidT;

    @FXML
    private TableColumn<Patient, Integer> recidT;

    @FXML
    private TableColumn<Patient, String> surnameT;

    @FXML
    private TableColumn<Patient, String> dnamePT;

    @FXML
    private TableColumn<Patient, Double> pricePT;


    public void addbutOnClick(ActionEvent a) throws IOException { //open adding menu
        Help helper = new Help();
        helper.newScene(a, "Adding", "Adding.fxml");
    }
    public void accountsOnClick(ActionEvent a) throws IOException { //open accounts menu
        if(LoginMenuC.Roots) {
            Help helper = new Help();
            helper.newScene(a, "Accounts", "AccountsMenu.fxml");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Mismatch");
            alert.setContentText("You have no roots to open this menu!");
            alert.showAndWait();
        }
    }
    public void delbutOnClick(ActionEvent a) throws IOException { //open deleting menu
        Help helper = new Help();
        helper.newScene(a, "Deleting", "Deleting.fxml");
    }
    public void editbutOnClick(ActionEvent a) throws IOException { //open editing menu
        Help helper = new Help();
        helper.newScene(a, "Editing", "Editing.fxml");
    }

    public void exitbutOnClick(ActionEvent a) throws IOException { //open exit menu
        Platform.exit();
    }

    @FXML
    void initialize() { //table initialisation
        ObservableList<Patient> list = FXCollections.observableList(Main.lpatient);
        patientT.setItems(list);
        ObservableList<Drug> listD = FXCollections.observableList(Main.ldrug);
        drugT.setItems(listD);
        pidT.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("PID"));
        nameT.setCellValueFactory(new PropertyValueFactory<Patient,String>("name"));
        surnameT.setCellValueFactory(new PropertyValueFactory<Patient,String>("surname"));
        recidT.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("RecID"));
        amountT.setCellValueFactory(new PropertyValueFactory<Patient,Double>("Amount"));
        diseaseT.setCellValueFactory(new PropertyValueFactory<Patient,String>("Disease"));
        drugidT.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("DrugID"));
        dnamePT.setCellValueFactory(new PropertyValueFactory<Patient,String>("DrugName"));
        pricePT.setCellValueFactory(new PropertyValueFactory<Patient,Double>("fullPrice"));

        ddrugidT.setCellValueFactory(new PropertyValueFactory<Drug,Integer>("DrugID"));
        dnameT.setCellValueFactory(new PropertyValueFactory<Drug,String>("DrugName"));
        priceT.setCellValueFactory(new PropertyValueFactory<Drug,Integer>("Price"));
    }
}
