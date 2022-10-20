package com.mixer;

import java.io.File;
import java.io.IOException;

import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class PrimaryController {

    @FXML
    Button audio1, audio2, audio3, audio4;
    public static ButtonHelper audio1H = new ButtonHelper("audio1"), audio2H = new ButtonHelper("audio2"), audio3H = new ButtonHelper("audio3"), audio4H = new ButtonHelper("audio4");

    @FXML
    VBox bgd;

    @FXML
    TextField inputFilenameW, inputFilenameA, inputFilenameS, inputFilenameD;

    boolean oneTime = true;

    
    GriseldaMediaPlayer mediaPlayer = new GriseldaMediaPlayer();
    
    //ADD DISPLAY THE FILE THAT IS OPENED ON THE BUTTON NAME
    //ADD ALLOW SELECTION OF TIME
    //ADD TIMER COUNTDOWN
    //FIGURE OUT AUDIO OUTPUT
    //RESEARCH STATE MACHINES AND THREADS TO FIND OUT HOW TO PLAY ONE AUDIO AT TIME

    // Move the code that was here, to play the file, inside the if statement so the
    // application doesn't crash if the user doesn't select a file to play.

    FileChooser fileChooser = new FileChooser();

    public PrimaryController() {
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
    }
    
    @FXML
    public void backgroundKeyDetected(){
        bgd.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                System.out.println(audio1.getId());
                File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio1.getText() + ".wav");

                if(!gottenFile.exists()){
                    System.out.println("FILE DNI FOR W KEY! CREATE FILE FIRST L");
                    return;
                }

                MediaPlayer mediaPlayer = new MediaPlayer(new Media(gottenFile.toURI().toString()));
                mediaPlayer.play();
            } else if (event.getCode() == KeyCode.A) {
                System.out.println(audio2.getId());
                File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio2.getText() + ".wav");

                if(!gottenFile.exists()){
                    System.out.println("FILE DNI FOR A KEY! CREATE FILE FIRST L");
                    return;
                }

                MediaPlayer mediaPlayer = new MediaPlayer(new Media(gottenFile.toURI().toString()));
                mediaPlayer.play();
            } else if (event.getCode() == KeyCode.S) {
                System.out.println(audio3.getId());
                File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio3.getText() + ".wav");

                if(!gottenFile.exists()){
                    System.out.println("FILE DNI FOR S KEY! CREATE FILE FIRST L");
                    return;
                }

                MediaPlayer mediaPlayer = new MediaPlayer(new Media(gottenFile.toURI().toString()));
                mediaPlayer.play();
            } else if (event.getCode() == KeyCode.D) {
                System.out.println(audio4.getId());
                File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio4.getText() + ".wav");

                if(!gottenFile.exists()){
                    System.out.println("FILE DNI FOR D KEY! CREATE FILE FIRST L");
                    return;
                }

                MediaPlayer mediaPlayer = new MediaPlayer(new Media(gottenFile.toURI().toString()));
                mediaPlayer.play();
            } else if (event.getCode() == KeyCode.M){
                System.out.println(mediaPlayer.toString());
            }
        });
    }
    @FXML
    private void printOutAudio1() throws IOException{

        System.out.println(audio1.getId());
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio1.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR W KEY! CREATE FILE FIRST L");
            return;
        }
        if(oneTime){
            mediaPlayer.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayer.play();
        } else if(mediaPlayer.getStatus() == GriseldaMediaPlayer.PlayerStatus.PLAYING){
            System.out.println("WAS PLAYING. PAUSING.");
            mediaPlayer.stop();
            mediaPlayer.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayer.play();
        } else {
            mediaPlayer.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayer.play();
        }
        oneTime = false;
    }

    @FXML
    private void printOutAudio2() throws IOException{
        System.out.println(audio2.getId());
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio2.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR A KEY! CREATE FILE FIRST L");
            return;
        }

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(gottenFile.toURI().toString()));
        mediaPlayer.play();
    }

    @FXML
    private void printOutAudio3() throws IOException{
        System.out.println(audio3.getId());
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio3.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR D KEY! CREATE FILE FIRST L");
            return;
        }

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(gottenFile.toURI().toString()));
        mediaPlayer.play();
    }

    @FXML
    private void printOutAudio4() throws IOException{
        System.out.println(audio4.getId());
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio4.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR Dx KEY! CREATE FILE FIRST L");
            return;
        }

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(gottenFile.toURI().toString()));
        mediaPlayer.play();
    }
    @FXML
    private void onEnterClickedW(){
        onEnterClicked(1);
        audio1.setText(inputFilenameW.getText());
    }

    @FXML
    private void onEnterClickedA(){
        onEnterClicked(2);
        audio2.setText(inputFilenameA.getText());
    }
    @FXML
    private void onEnterClickedS(){
        onEnterClicked(3);
        audio3.setText(inputFilenameS.getText());
    }
    @FXML
    private void onEnterClickedD(){
        onEnterClicked(4);
        audio4.setText(inputFilenameD.getText());
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


        long recordTime = 5000;
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
