package hu.unideb.inf.controller;

import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.modell.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private Label label6;
    @FXML private Label label3;
    @FXML private Label label5;
    @FXML private Label label2;
    @FXML private Label label4;
    @FXML private Label label1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML public void loadData() {
        Student student = new Student();
        label1.setText(student.getLastName());
        label4.setText(student.getFirstName());
        label2.setText("Debreceni");
        label5.setText("Egyetem");
        label3.setText("Mérnök");
        label6.setText("Informatikus");
    }

    @FXML public void handleClearDataAction() {
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
    }    
}
