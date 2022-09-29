package com.mixer;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class PrimaryController {
    
    //ADD DISPLAY THE FILE THAT IS OPENED ON THE BUTTON NAME
    //ADD ALLOW SELECTION OF TIME

    @FXML
    Button audio1, audio2, audio3, audio4;
    @FXML
    VBox bgd;

    @FXML
    TextField inputFilenameW, inputFilenameA, inputFilenameS, inputFilenameD;

    @FXML
    public void backgroundKeyDetected(){
        bgd.setOnKeyPressed(event -> {
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
    @FXML
    private void onEnterClickedW(){
        onEnterClicked(1);
    }

    @FXML
    private void onEnterClickedA(){
        onEnterClicked(2);
    }
    @FXML
    private void onEnterClickedS(){
        onEnterClicked(3);
    }
    @FXML
    private void onEnterClickedD(){
        onEnterClicked(4);
    }

    @FXML
    private void onEnterClicked(int audioNum){
        TextField inputFilename;

        switch(audioNum){
            case 1:
                inputFilename = inputFilenameW;
                break;
            case 2:
                inputFilename = inputFilenameA;
                break;
            case 3:
                inputFilename = inputFilenameS;
                break;
            case 4:
                inputFilename = inputFilenameD;
                break;
            default:
                inputFilename = inputFilenameW;
        }


        long recordTime = 15000;
        File wavFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + inputFilename.getText() + ".wav");

        final SoundManipulator recorder = new SoundManipulator();

        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(recordTime);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });

        stopper.start();

        // start recording
        recorder.start(wavFile);
    }
}
