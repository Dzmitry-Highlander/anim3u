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
    private static final String ERROR_MESSAGE_BLANK_INPUT = "Please, enter anime title!";
    private static final String ERROR_MESSAGE_INVALID_INPUT = "Invalid anime title name!";
    private static final String DONE_M3U8_MESSAGE = "File m3u8 created!";

    @FXML
    private Button closeButton;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField titleTextField;
    @FXML
    private Button createM3U8Button;

    public void createM3U8ButtonOnAction() {
        if (!titleTextField.getText().isBlank()) {
            create(titleTextField.getText());

            messageLabel.setText(DONE_M3U8_MESSAGE);
        } else {
            messageLabel.setText(ERROR_MESSAGE_BLANK_INPUT);
        }
    }

    public void closeButtonOnAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();
    }

    private void create(String title) {
        final IURLService urlService = new URLService();
        final IParserService parserService = new ParserService();

        try {
            parserService.save(urlService.get(title));
        } catch (InvalidInputException e) {
            messageLabel.setText(ERROR_MESSAGE_INVALID_INPUT);
        }
    }
}