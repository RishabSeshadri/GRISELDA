package com.mixer;

public class RunnableOnPlaying implements Runnable{

    ButtonHelper btnH;
    String btnHID;

    public RunnableOnPlaying(ButtonHelper btnH){
        this.btnH = btnH;
        btnHID = btnH.getBtnID();
    }
    
    public void run(){
        if(btnHID == "audio1"){
            PrimaryController.audio1H.setStatus(ButtonHelper.ButtonStatus.PLAYING);
        } else if(btnHID == "audio2"){
            PrimaryController.audio2H.setStatus(ButtonHelper.ButtonStatus.PLAYING);
        } else if(btnHID == "audio3"){
            PrimaryController.audio3H.setStatus(ButtonHelper.ButtonStatus.PLAYING);
        } else {
            PrimaryController.audio4H.setStatus(ButtonHelper.ButtonStatus.PLAYING);
        }
        
        System.out.println(btnHID);

    }
}