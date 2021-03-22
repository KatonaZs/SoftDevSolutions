package hu.unideb.inf.java.fx.example.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.java.jpa.example.domain.Person;
import hu.unideb.inf.java.jpa.example.repository.PersonRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

@Component
public class FXController implements Initializable {
    @Autowired
    private PersonRepository personRepo;
    
    @FXML
    private Label label;
    @FXML
    private Label label6;
    @FXML
    private Label label3;
    @FXML
    private Label label5;
    @FXML
    private Label label2;
    @FXML
    private Label label4;
    @FXML
    private Label label1;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    public void loadData() {
        Person person = personRepo.findByFullName("Katona Zsombor");
        System.out.println(person);
        label1.setText(person.getFullName());
        label2.setText(person.getLastUpdate().toString());
    }

    @FXML
    public void handleClearDataAction() {
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
    }

}
