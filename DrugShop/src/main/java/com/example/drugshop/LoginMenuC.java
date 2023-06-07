package com.example.drugshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;

import javafx.scene.control.Button;

public class LoginMenuC {

    @FXML
    private Button logbut;
    @FXML
    private Button loginbut;
    @FXML
    private TextField logT;
    @FXML
    private PasswordField passwT;
    public static Boolean Roots = false;
    public Boolean checker= false;

    public void logbutOnClick(ActionEvent a) throws IOException {
        Help helper = new Help();
        Roots = true;
        helper.newScene(a, "Menu", "Mainmenu.fxml");
    }
    public void loginbutOnClick(ActionEvent a) throws IOException {/*THIS IS ONLY FOR DEBUG AND PRESENTATION OF PROGRAM. ALLOWS TO LOGIN WITHOUT LOGIN AND PASSWORD BY CLICKING ON RIGHT TOP ANGLE*/
        for (int k = 0; k < Main.lacc.size(); k++) {
            System.out.println("cycle phasecheckPID " + k);
            if (Objects.equals(Main.lacc.get(k).Login, logT.getText()) && Objects.equals(Main.lacc.get(k).Password, passwT.getText())) {
                if (Main.lacc.get(k).Admin) {
                    Roots = true;
                }
                Help helper = new Help();
                helper.newScene(a, "Menu", "Mainmenu.fxml");
                checker = true;
                break;
            }
        }
            if (!checker){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Mismatch");
                alert.setContentText("Incorrect Login or Password!");
                alert.showAndWait();
        }
    }
}