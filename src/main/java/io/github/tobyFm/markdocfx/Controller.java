package io.github.tobyFm.markdocfx;

import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import io.github.palexdev.materialfx.controls.MFXButton;

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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            System.out.println("DEBUG: Der Path von der Datei ist folgender : " + file.getAbsolutePath());
            System.out.println("DEBUG: Der name der Datei ist folgender : " + file.getName());

            // Fügt Datei zu dem TreeView hinzu bzw. zeigt sie an.
            TreeItem<String> rootItem = new TreeItem<>(file.getName());
            rootItem.setValue(file.getAbsolutePath());
            fileTreeView.setRoot(rootItem);
        } else {
            System.out.println("No file selected");
        }
    }

    // -------------------------------------------
    // Öffnet die Datei im Editor
    // -------------------------------------------
    public void showFile() {
        TreeItem<String> selectedFile = fileTreeView.getSelectionModel().getSelectedItem();

        if (selectedFile != null) {
            String filePath = selectedFile.getValue();
            System.out.println("DEBUG: Selecte File: " + selectedFile.getValue());

            // Prüfe, ob ein Tab mit diesem Namen bereits existiert
            for (Tab tab : tabPane.getTabs()) {
                if (tab.getText().equals(selectedFile.getValue())) {
                    System.out.println("DEBUG: Tab mit dem Namen " + selectedFile.getValue() + " existiert bereits");
                    return;
                }
            }

            try {
                // Lade das Layout aus der FXML-Datei
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/io/github/tobyFm/markdocfx/fileTab.fxml"));
                Parent tabContent = loader.load();

                // -------------------------------------------
                // Erstellt Textarea für die md Datei und
                // rendert den Inhalt aus der Datei
                // -------------------------------------------
                FileTabController fileTabController = loader.getController();
                fileTabController.setFilePath(filePath);

                // Erstellt neuen Tab
                Tab tab = new Tab(selectedFile.getValue());
                tab.setContent(tabContent);

                // Tab zum TabPane hinzufügen
                tabPane.getTabs().add(tab);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
