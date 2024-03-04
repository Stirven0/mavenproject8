module com.mycompany.mavenproject8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.mycompany.mavenproject8 to javafx.fxml;
    exports com.mycompany.mavenproject8;
    requires mysql.connector.j;
    requires org.kordamp.bootstrapfx.core;
    requires com.jfoenix;
    requires java.base;
}
