module com.example.markdocfx {
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires MaterialFX;

    opens io.github.tobyFm.markdocfx to javafx.fxml;
    exports io.github.tobyFm.markdocfx;
}