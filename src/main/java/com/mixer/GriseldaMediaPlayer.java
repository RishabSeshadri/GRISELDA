package com.mixer;

import javafx.scene.media.MediaPlayer;

public class GriseldaMediaPlayer{

    public enum PlayerStatus{
        PLAYING, PAUSED, REPEATING
    }   
    
    MediaPlayer mPlayer;
    PlayerStatus status;

    public GriseldaMediaPlayer(MediaPlayer player){
        status = PlayerStatus.PAUSED;
        mPlayer = player;
        mPlayer.setOnEndOfMedia(() -> {
            status = PlayerStatus.PAUSED;
            System.out.println(toString());
        });
    }

    public GriseldaMediaPlayer(){
        status = PlayerStatus.PAUSED;
    }

    public PlayerStatus getStatus(){
        return status;
    }

    public void setStatus(PlayerStatus status){
        this.status = status;
    }

    public void setMediaPlayer(MediaPlayer player){
        mPlayer = player;
        mPlayer.setOnEndOfMedia(() -> {
            status = PlayerStatus.PAUSED;
            toString();
        });
        if(status == PlayerStatus.REPEATING){
            repeatOn();
        }
    }

    public MediaPlayer getMediaPlayer(){
        return mPlayer;
    }

    public void play(){
        mPlayer.play();
        status = PlayerStatus.PLAYING;
    }

    public void stop(){
        mPlayer.stop();
        status = PlayerStatus.PAUSED;
    }

    public void pause(){
        mPlayer.pause();
        status = PlayerStatus.PAUSED;
    }

    public void repeatOn(){
        mPlayer.setCycleCount(-1);
        status = PlayerStatus.REPEATING;
    }

    public void repeatOff(){
        mPlayer.setCycleCount(1);
        status = PlayerStatus.PAUSED;
    }

    public void onEndOfMedia(){
        status = PlayerStatus.PAUSED;
        System.out.println(toString());
        
    }

    public String toString(){
        System.out.println("CURRENT STATUS: " + status);
        return "CURRENT STATUS: " + status;
    }

    public void METAMOPRHOSIS(){
        System.out.println("\nPut my glasses on, I cant see these -------\nPut my glasses on, I cant see these -------\nIm in the twilight zone, nowhere near these -------" 
         + "\nIm in the twilight zone, nowhere near these -------\nThey cant understand me, Im talkin hieroglyphics\nThey cant understand me, Im talkin hieroglyphics\nI feel like Morpheus, I feel like Morpheus \nI got my whole gang on some other shit\nMetamorphosis"
         + "\nMetamorphosis, metamorphosis\nMetamorphosis, metamorphosis\nMetamorphosis, metamorphosis \nI had to change my whole swag, Im on some other ---- \nI got me a new -----, she on other ---- \nAnd if that ----- go out bad, she on punishment"
         + "\nWhy the ---- I gotta remind you that I run this ----?\nWhy the ---- I gotta remind you that I run this ----? \nWhy the ---- I gotta remind you that I run this ----? \nI thought Id been told you that I run this ----"
        );
    }

}
