package io.github.tobyFm.markdocfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    @FXML
    private TreeView<String> fileTreeView;

    @FXML
    private AnchorPane fileViewInput;

    @FXML
    private AnchorPane fileViewOutput;

    @FXML
    private WebView htmlOutput;

    @FXML
    private TextArea markdownInput;

    @FXML
    private TabPane tabPane;

    @FXML
    private MFXButton openFile;

    @FXML
    private MFXButton openFolder;

    @FXML
    private MFXButton closeAll;

    // -------------------------------------------
    // Öffnet einzelne Datei
    // -------------------------------------------
    public void openFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("File Explorer");
        // Nimmt nur .md Dateien.
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Markdown Files", "*.md"));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            System.out.println("DEBUG: Der Path von der Datei ist folgender : " + file.getAbsolutePath());
            System.out.println("DEBUG: Der name der Datei ist folgender : " + file.getName());

            String fileName = file.getName();

            // Fügt Datei zu dem TreeView hinzu bzw. zeigt sie an.
            final TreeItem<String> fileList = new TreeItem("/");
            fileList.getChildren().add(new TreeItem<>(fileName));
            fileTreeView.setRoot(fileList);
        } else {
            System.out.println("No file selected");
        }
    }
}
