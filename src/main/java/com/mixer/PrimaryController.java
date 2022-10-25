package com.mixer;

import java.io.File;
import java.io.IOException;

import javafx.scene.media.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.awt.MouseInfo;

public class PrimaryController {

    /**
     * TO DO: 
     * MAKE LESS UGLY CODE
     * MAKE LESS UGLY APP
     * ADD CLIPPING/TRIMMING FUNCTIONALITY
     * 
     */


    @FXML
    Button audio1, audio2, audio3, audio4, timerBtn, fileChooserWBtn, fileChooserABtn, fileChooserSBtn, fileChooserDBtn;

    @FXML
    ToggleButton toggleRepeatW, toggleRepeatA, toggleRepeatS, toggleRepeatD;

    @FXML
    Text timerCounter;

    @FXML
    VBox bgd;

    @FXML
    TextField inputFilenameW, inputFilenameA, inputFilenameS, inputFilenameD, inputRecTime;
    GriseldaMediaPlayer mediaPlayerW = new GriseldaMediaPlayer(), mediaPlayerA = new GriseldaMediaPlayer(),
    mediaPlayerS = new GriseldaMediaPlayer(), mediaPlayerD = new GriseldaMediaPlayer();
    
    FileChooser fileChooser = new FileChooser();

    public PrimaryController() {
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Audio Files", "*.wav"));
    }
    
    @FXML
    public void backgroundKeyDetected(){
        bgd.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                playAudioW();
            } else if (event.getCode() == KeyCode.A) {
                playAudioA();
            } else if (event.getCode() == KeyCode.S) {
                playAudioS();
            } else if (event.getCode() == KeyCode.D) {
                playAudioD();
            } else if(event.getCode() == KeyCode.M){
                System.out.println("(" + MouseInfo.getPointerInfo().getLocation().x + 
              ", " + 
              MouseInfo.getPointerInfo().getLocation().y + ")");
            }
        });
    }

    @FXML
    private void setRepeatingWFXML(){
        if(mediaPlayerW.getMediaPlayer() == null){
            toggleRepeatW.setText("W: Not repeating");
            toggleRepeatW.setSelected(false);
            System.out.println("No selected audio to repeat for W!");
        } else {
            if(!toggleRepeatW.isSelected()){
                mediaPlayerW.repeatOff();
                toggleRepeatW.setText("W: Not repeating");
            } else {
                mediaPlayerW.repeatOn();
                toggleRepeatW.setText("W: Repeating");
            }
        }
    }
        

    @FXML
    private void setRepeatingAFXML(){
        if(mediaPlayerA.getMediaPlayer() == null){
            toggleRepeatA.setText("A: Not repeating");
            toggleRepeatA.setSelected(false);
            System.out.println("No selected audio to repeat for A!");
        } else {
            if(toggleRepeatA.isSelected()){
                mediaPlayerA.repeatOff();
                toggleRepeatA.setText("A: Not repeating");
            } else {
                mediaPlayerA.repeatOn();
                toggleRepeatA.setText("A: Repeating");
            }
        }
        
    }

    @FXML
    private void setRepeatingSFXML(){
        if(mediaPlayerS.getMediaPlayer() == null){
            toggleRepeatS.setText("S: Not repeating");
            toggleRepeatS.setSelected(false);
            System.out.println("No selected audio to repeat for S!");
        } else {
            if(toggleRepeatS.isSelected()){
                mediaPlayerS.repeatOff();
                toggleRepeatS.setText("S: Not repeating");
            } else {
                mediaPlayerS.repeatOn();
                toggleRepeatS.setText("S: Repeating");
                
            }
        }
    }

    @FXML
    private void setRepeatingDFXML(){
        if(mediaPlayerD.getMediaPlayer() == null){
            toggleRepeatD.setText("D: Not repeating");
            toggleRepeatD.setSelected(false);
            System.out.println("No selected audio to repeat for D!");
        } else {
            if(toggleRepeatD.isSelected()){
                mediaPlayerD.repeatOff();
                toggleRepeatD.setText("D: Not repeating");
            } else {
                mediaPlayerD.repeatOn();
                toggleRepeatD.setText("D: Repeating");
            }
        }
    }
 
    @FXML
    private void playAudioWFXML() throws IOException{
        playAudioW();
    }

    @FXML
    private void playAudioAFXML() throws IOException{
        playAudioA();
    }
    @FXML
    private void playAudioSFXML() throws IOException{
        playAudioS();
    }

    @FXML
    private void playAudioDFXML() throws IOException{
        playAudioD();
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

        try {
            Long.parseLong(inputRecTime.getText()); 
        } catch (NumberFormatException ex){
            System.out.println("VALID TIME NEEDED");
            return;
        }

        long recordTime = Long.parseLong(inputRecTime.getText()) * 1000;
        File wavFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + inputFilename.getText() + ".wav");

        final SoundManipulator recorder = new SoundManipulator();

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

        TimeTracker tt = new TimeTracker();
        
        Thread t1 = new Thread(() -> {
            stopper.start();
            recorder.start(wavFile);
        });
        
        Thread t2 = new Thread(() -> {
            tt.startTime();
            while(!recorder.getIsFinished()){
                int x = ((int)recordTime / 1000) - (int)tt.time();
                timerCounter.setText("" + x);
            }
        });
        t1.start();
        t2.start();
    }

    @FXML
    private void onFileChooserClickedW(){
        File wavFile = fileChooser.showSaveDialog(fileChooserWBtn.getScene().getWindow());
        String fileName = wavFile.getName().substring(0, wavFile.getName().length() - 4);

        audio1.setText(fileName);
        inputFilenameW.setText(fileName);
    }
    
    @FXML
    private void onFileChooserClickedA(){
        File wavFile = fileChooser.showSaveDialog(fileChooserWBtn.getScene().getWindow());
        String fileName = wavFile.getName().substring(0, wavFile.getName().length() - 4);

        audio2.setText(fileName);
        inputFilenameA.setText(fileName);
    }

    @FXML
    private void onFileChooserClickedS(){
        File wavFile = fileChooser.showSaveDialog(fileChooserWBtn.getScene().getWindow());
        String fileName = wavFile.getName().substring(0, wavFile.getName().length() - 4);

        audio3.setText(fileName);
        inputFilenameS.setText(fileName);
    }

    @FXML
    private void onFileChooserClickedD(){
        File wavFile = fileChooser.showSaveDialog(fileChooserWBtn.getScene().getWindow());
        String fileName = wavFile.getName().substring(0, wavFile.getName().length() - 5);

        audio4.setText(fileName);
        inputFilenameD.setText(fileName);
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

    private void playAudioW(){
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio1.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR W KEY! CREATE FILE FIRST");
            return;
        }

        if(mediaPlayerW.getMediaPlayer() == null || mediaPlayerW.getStatus() == GriseldaMediaPlayer.PlayerStatus.PAUSED){
            mediaPlayerW.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerW.play();
        } else if(mediaPlayerW.getStatus() == GriseldaMediaPlayer.PlayerStatus.PLAYING){
            System.out.println("REPLAYING...");
            mediaPlayerW.stop();
            mediaPlayerW.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerW.play();
        } else {
            mediaPlayerW.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerW.play();
        }
    }

    private void playAudioA(){
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio2.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR A KEY! CREATE FILE FIRST");
            return;
        }

        if(mediaPlayerA.getMediaPlayer() == null || mediaPlayerA.getStatus() == GriseldaMediaPlayer.PlayerStatus.PAUSED){
            mediaPlayerA.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerA.play();
        } else if(mediaPlayerA.getStatus() == GriseldaMediaPlayer.PlayerStatus.PLAYING){
            System.out.println("REPLAYING...");
            mediaPlayerA.stop();
            mediaPlayerA.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerA.play();
        } else {
            mediaPlayerA.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerA.play();
        }
    }
    private void playAudioS(){
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio3.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR D KEY! CREATE FILE FIRST");
            return;
        }

        if(mediaPlayerS.getMediaPlayer() == null || mediaPlayerS.getStatus() == GriseldaMediaPlayer.PlayerStatus.PAUSED){
            mediaPlayerS.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerS.play();
        } else if(mediaPlayerW.getStatus() == GriseldaMediaPlayer.PlayerStatus.PLAYING){
            System.out.println("REPLAYING...");
            mediaPlayerS.stop();
            mediaPlayerS.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerS.play();
        } else {
            mediaPlayerS.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerS.play();
        }
    }
    
    private void playAudioD(){
        File gottenFile = new File("C:/Users/risha/Desktop/Other/Programming/GRISELDA/griselda/saves/" + audio4.getText() + ".wav");

        if(!gottenFile.exists()){
            System.out.println("FILE DNI FOR D KEY! CREATE FILE FIRST");
            return;
        }

        if(mediaPlayerD.getMediaPlayer() == null || mediaPlayerD.getStatus() == GriseldaMediaPlayer.PlayerStatus.PAUSED){
            mediaPlayerD.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerD.play();
        } else if(mediaPlayerD.getStatus() == GriseldaMediaPlayer.PlayerStatus.PLAYING){
            System.out.println("REPLAYING...");
            mediaPlayerD.stop();
            mediaPlayerD.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerD.play();
        } else {
            mediaPlayerD.setMediaPlayer(new MediaPlayer(new Media(gottenFile.toURI().toString())));
            mediaPlayerD.play();
        }
    }
}