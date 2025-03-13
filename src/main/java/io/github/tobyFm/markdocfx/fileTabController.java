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

    public void setFilePath(String filePath) {
        this.FilePath = filePath;
        loadFileContent(filePath);
    }

    private void loadFileContent(String filePath) {
        File file = new File(filePath);
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            markdownInput.setText(content.toString());
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
