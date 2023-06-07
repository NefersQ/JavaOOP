package com.example.drugshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static FileWork<List<Patient>> load;
    public static List<Patient> lpatient; //patient temporary list where we store all the patients after loading and saving
    public static FileWork<List<Drug>> loadD;
    public static List<Drug> ldrug; //drug temporary list where we store all the drugs after loading and saving
    public static FileWork<List<Accounts>> loadA;
    public static List<Accounts> lacc; //accounts temporary list where we store all the accounts after loading and saving

    @Override
    public void start(Stage stage) throws IOException {
        loadingA();
        loadingD();
        loading();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Drug Shop");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void loading() { //function to load all the patient data to list from file
        load = new FileWork<>();
        lpatient = (List<Patient>) load.fileIn();
        if (lpatient == null) {
            lpatient = new ArrayList<>();
        }
    }
    public static void loadingD() { //function to load all the drug data to list from file
        loadD = new FileWork<>();
        ldrug = (List<Drug>) loadD.fileInD();

        if(ldrug==null){
            ldrug = new ArrayList<>();
        }
    }
    public static void loadingA() { //function to load all the accounts data to list from file
        loadA = new FileWork<>();
        lacc = (List<Accounts>) loadA.fileInA();

        if(lacc==null){
            lacc = new ArrayList<>();
        }
    }

}
