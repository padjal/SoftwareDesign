module ru.hse.hw.hw5_addressbook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens ru.hse.hw.hw5_addressbook to javafx.fxml;
    exports ru.hse.hw.hw5_addressbook;
}