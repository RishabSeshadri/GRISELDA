package com.mixer;

public class RunnableOnPaused implements Runnable{

    ButtonHelper btnH;
    String btnHID;

    public RunnableOnPaused(ButtonHelper btnH){
        this.btnH = btnH;
        btnHID = btnH.getBtnID();
    }
    
    public void run(){
        if(btnHID == "audio1"){
            PrimaryController.audio1H.setStatus(ButtonHelper.ButtonStatus.PAUSED);
        } else if(btnHID == "audio2"){
            PrimaryController.audio2H.setStatus(ButtonHelper.ButtonStatus.PAUSED);
        } else if(btnHID == "audio3"){
            PrimaryController.audio3H.setStatus(ButtonHelper.ButtonStatus.PAUSED);
        } else {
            PrimaryController.audio4H.setStatus(ButtonHelper.ButtonStatus.PAUSED);
        }
        
        System.out.println(btnHID);

    }
}