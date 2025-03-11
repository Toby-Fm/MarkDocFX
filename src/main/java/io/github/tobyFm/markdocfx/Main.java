package io.github.tobyFm.markdocfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("elements.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("bootstrapfx.css")).toExternalForm());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        // APP Icon setzen
        String iconPath = "/io/github/tobyFm/markdocfx/assets/MarkDokFX_app_icon2.png";
        Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPath)));
        stage.getIcons().add(appIcon);

        stage.getIcons().add(appIcon);
        stage.setTitle("MarkDocFX");
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}