package com.example.supplychain;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HelloController {
    @FXML
    public void helloclick(MouseEvent event )throws IOException{
        System.out.println("Hi is clcked and i am clicking ");
    }
    @FXML

    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}