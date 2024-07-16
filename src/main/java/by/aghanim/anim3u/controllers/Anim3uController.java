package by.aghanim.anim3u.controllers;

import by.aghanim.anim3u.exceptions.InvalidInputException;
import by.aghanim.anim3u.service.api.IParserService;
import by.aghanim.anim3u.service.api.IURLService;
import by.aghanim.anim3u.service.impl.ParserService;
import by.aghanim.anim3u.service.impl.URLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Anim3uController {
    private static final String ERROR_MESSAGE_BLANK_INPUT = "Please, enter title";
    private static final String ERROR_MESSAGE_INVALID_INPUT = "You probably entered an invalid character";

    @FXML
    private Label createMessageLabel;
    @FXML
    private TextField titleTextField;
    @FXML
    private Button createButton;

    public void createButtonOnAction() {
        if (!titleTextField.getText().isBlank()) {
            create(titleTextField.getText());
        } else {
            createMessageLabel.setText(ERROR_MESSAGE_BLANK_INPUT);
        }
    }

    private void create(String title) {
        final IURLService urlService = new URLService();
        final IParserService parserService = new ParserService();

        try {
            Stage stage = (Stage) createButton.getScene().getWindow();

            parserService.save(urlService.get(title));

            stage.close();
        } catch (InvalidInputException e) {
            createMessageLabel.setText(ERROR_MESSAGE_INVALID_INPUT);
        }
    }
}