module com.example.drugshop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.drugshop to javafx.fxml;
    exports com.example.drugshop;
}