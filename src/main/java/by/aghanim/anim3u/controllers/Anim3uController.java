package by.aghanim.anim3u.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Anim3uController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}