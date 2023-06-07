package com.example.drugshop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Objects;

public class AccountsMenuC {

    @FXML
    private TableView<Accounts> accountsT;

    @FXML
    private CheckBox addC;

    @FXML
    private Button addbut;

    @FXML
    private TextField addlog;

    @FXML
    private TextField addpassword;

    @FXML
    private TableColumn<Accounts, Boolean> adminT;

    @FXML
    private Button backbut;

    @FXML
    private Button delbut;

    @FXML
    private TextField dellog;

    @FXML
    private CheckBox editC;

    @FXML
    private Button editbut;

    @FXML
    private TextField editlog;

    @FXML
    private TextField editpassword;

    @FXML
    private Button loadbut;

    @FXML
    private TableColumn<Accounts, String> loginT;

    @FXML
    private TableColumn<Accounts, String> passwordT;
    int sameInput = 0;
    int aIndex = -1;

    public void backbutOnClick(ActionEvent a) throws IOException { //back to menu function
        Aux helper = new Aux();
        helper.newScene(a, "Main Menu", "Mainmenu.fxml");
    }
    public void editLoad(ActionEvent a) throws IOException { //function to load account from edit text field

        for (int k = 0; k < Main.lacc.size(); k++) {
            System.out.println("cycle phasecheckPID " + k);
            if (Objects.equals(Main.lacc.get(k).Login, editlog.getText())) {
                editpassword.setText(Main.lacc.get(k).Password);
                editC.setSelected(Main.lacc.get(k).Admin);
                aIndex = k;
                break;
            }
        }
    }
    public void editSave(ActionEvent a) throws IOException { //function to save account from edit text field
        Accounts tacc = new Accounts();
        System.out.println("cycle phasecheckPID " + aIndex);
        tacc.Login = (editlog.getText());
        tacc.Password = editpassword.getText();
        tacc.Admin = editC.isSelected();
        Main.lacc.set(aIndex,tacc);
        Main.loadA.fileOutA(Main.lacc);
        ObservableList<Accounts> list = FXCollections.observableList(Main.lacc);
        accountsT.setItems(list);
    }
    public void deleteAccount(ActionEvent a) throws IOException { //function to delete account by login
        for (int k = 0; k < Main.lacc.size(); k++) {
            System.out.println("cycle phasecheckPID " + k);
            if (Objects.equals(Main.lacc.get(k).getLogin(), dellog.getText())) {
                Main.lacc.remove(k);
                Main.loadA.fileOutA(Main.lacc);
                ObservableList<Accounts> list = FXCollections.observableList(Main.lacc);
                accountsT.setItems(list);
                break;
            }
        }
    }
    public void addNewAccount(ActionEvent a) throws IOException { //add new account function
        Accounts tacc = new Accounts();
        if (addlog.getText().isBlank() || addpassword.getText().isBlank()) {
            sameInput++;
        }else {
            for (int i = 0; i < Main.lacc.size(); i++) {
                if (Objects.equals(Main.lacc.get(i).Login, addlog.getText())) {
                    sameInput++;
                }
            }
        }
        if (sameInput == 0) {
            tacc.Login = (addlog.getText());
            tacc.Password = addpassword.getText();
            tacc.Admin = (addC.isSelected());
            Main.lacc.add(tacc);
            Main.loadA.fileOutA(Main.lacc);
            ObservableList<Accounts> list = FXCollections.observableList(Main.lacc);
            accountsT.setItems(list);
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Adding new drug ERROR");
            alert.setContentText("Same drug ID is used, or not all fields are fullfiled");
            alert.showAndWait();
            sameInput = 0;
        }
    }
    @FXML
    void initialize() {
        loginT.setCellValueFactory(new PropertyValueFactory<Accounts,String>("Login"));
        passwordT.setCellValueFactory(new PropertyValueFactory<Accounts,String>("Password"));
        adminT.setCellValueFactory(new PropertyValueFactory<Accounts,Boolean>("Admin"));
        ObservableList<Accounts> list = FXCollections.observableList(Main.lacc);
        accountsT.setItems(list);
    }
}
