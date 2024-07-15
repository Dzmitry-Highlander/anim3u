package by.aghanim.anim3u;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Anim3uApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Anim3uApplication.class.getResource("anim3u-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 135);

        stage.setTitle("Anim3u");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}