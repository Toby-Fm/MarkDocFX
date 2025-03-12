package io.github.tobyFm.markdocfx;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class Controller {

    @FXML
    private TreeView<?> fileTreeView;

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

}
