module ru.hse.jigsaw {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires de.saxsys.mvvmfx;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens ru.hse.jigsaw to de.saxsys.mvvmfx, javafx.fxml;
    opens ru.hse.jigsaw.views to de.saxsys.mvvmfx, javafx.fxml;
    opens ru.hse.jigsaw.viewmodels to de.saxsys.mvvmfx, javafx.fxml;
    exports ru.hse.jigsaw;
    exports ru.hse.jigsaw.models;
    opens ru.hse.jigsaw.models to de.saxsys.mvvmfx, javafx.fxml;
}