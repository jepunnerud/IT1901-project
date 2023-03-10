module script.ui {
  requires com.fasterxml.jackson.databind;

  requires java.sql;
  requires javafx.controls;
  requires javafx.fxml;
  requires java.net.http;
  requires script.core.main;
  requires script.data;
  requires MaterialFX;

  opens ui to javafx.graphics, javafx.fxml;
}