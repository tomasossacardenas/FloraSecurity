package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ChoiceBox<String> cbDestino;

    @FXML
    private ChoiceBox<String> cbOrigen;

    @FXML
    private TextArea taRoute;

    public MainController() {

    }

    private boolean checkFields() {
        return true;
    }

    @FXML
    void fastRoute(ActionEvent event) {
        if(checkFields()) {

        }
    }

    @FXML
    void secureRoute(ActionEvent event) {
        if(checkFields()) {

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbDestino.getItems().addAll(
                "Domino's Pizza",
                "Patios de la Flora",
                "PriceSmart",
                "Centro Empresa",
                "Colsubsidio",
                "Olivenza",
                "Santa María de los Vientos",
                "Balcón de las Flores",
                "Cheers",
                "Conjunto Aragón",
                "Harold Montes",
                "Parque de las Flores",
                "Santinis",
                "Torremolinos",
                "BBVA",
                "C&M Consultants"
        );
        cbOrigen.getItems().addAll(
                "Domino's Pizza",
                "Patios de la Flora",
                "PriceSmart",
                "Centro Empresa",
                "Colsubsidio",
                "Olivenza",
                "Santa María de los Vientos",
                "Balcón de las Flores",
                "Cheers",
                "Conjunto Aragón",
                "Harold Montes",
                "Parque de las Flores",
                "Santinis",
                "Torremolinos",
                "BBVA",
                "C&M Consultants"
        );
    }
}