module net.badmidi.ecms {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens net.badmidi.ecms to javafx.fxml;
    exports net.badmidi.ecms;
}