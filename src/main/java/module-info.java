module com.brh.pruefungsvorb_2531 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.brh.pruefungsvorb_2531 to javafx.fxml;
    opens controller to javafx.fxml;
    exports com.brh.pruefungsvorb_2531;
}