package com.mixer;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class PrimaryController {
    @FXML
    Button audio1, audio2, audio3, audio4;
    @FXML
    VBox penith;


    @FXML
    public void initialize(){
        penith.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                System.out.println(audio1.getId());
            } else if (event.getCode() == KeyCode.A) {
                System.out.println(audio2.getId());
            } else if (event.getCode() == KeyCode.S) {
                System.out.println(audio3.getId());
            } else if (event.getCode() == KeyCode.D) {
                System.out.println(audio4.getId());
            }
        });
    }
    @FXML
    private void printOutAudio1() throws IOException{
        System.out.println(audio1.getId());
    }

    @FXML
    private void printOutAudio2() throws IOException{
        System.out.println(audio2.getId());
    }

    @FXML
    private void printOutAudio3() throws IOException{
        System.out.println(audio3.getId());
    }

    @FXML
    private void printOutAudio4() throws IOException{
        System.out.println(audio4.getId());
    }
}
