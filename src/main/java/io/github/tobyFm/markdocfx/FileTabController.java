package io.github.tobyFm.markdocfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTabController {

    @FXML
    private AnchorPane fileViewInput;

    @FXML
    private AnchorPane fileViewOutput;

    @FXML
    private WebView htmlOutput;

    @FXML
    private TextArea markdownInput;

    private String FilePath;

    // -------------------------------------------
    // Setzt den FilePath von der ausgewählten Datei
    // und übergibt sie, damit die Datei bzw. der Inhalt
    // ermittelt werden kann.
    // -------------------------------------------
    public void setFilePath(String filePath) {
        this.FilePath = filePath;
        loadFileContent(filePath);
    }

    private void loadFileContent(String filePath) {
        File file = new File(filePath);
        StringBuilder content = new StringBuilder();

        // ließt Datei
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            // Setzt Inhalt
            markdownInput.setText(content.toString());
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
