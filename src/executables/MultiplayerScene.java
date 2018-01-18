package executables;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MultiplayerScene {

    private final String defaultAddress = "127.0.0.1";

    @FXML
    private TextField name;
    @FXML
    private TextField server;
    @FXML
    private RadioButton trapper;
    @FXML
    private RadioButton cat;

    private Stage stage;

    public void mouseClicked(MouseEvent e) {

        stage = (Stage) ((Label) e.getSource()).getScene().getWindow();
        String text = ((Label) e.getSource()).getText();
        if(text.equals("Go Back")) goBack();

    }

    public void mouseEntered(MouseEvent e) {
        Scene scene = ((Label) e.getSource()).getScene();
        scene.setCursor(Cursor.HAND);
        Label label = (Label) e.getSource();
        label.setTextFill(Color.DARKGREEN);
    }

    public void mouseExited(MouseEvent e) {
        Scene scene = ((Label) e.getSource()).getScene();
        scene.setCursor(Cursor.DEFAULT);
        Label label = (Label) e.getSource();
        label.setTextFill(Color.BLACK);
    }

    public void enableServerAddress(ActionEvent e) {
        CheckBox checkBox = (CheckBox) e.getSource();
        if(checkBox.isSelected()) server.setEditable(true);
        else {
            server.setText(defaultAddress);
            server.setEditable(false);
        }
    }

    public void goBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root, 600, 600);
            scene.getStylesheets().add(getClass().getResource("MainScene.css").toExternalForm());
            stage.setScene(scene);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


}