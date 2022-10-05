package com.mixer;

public class ButtonHelper {
    public enum ButtonStatus{
        PLAYING, PAUSED
    }   

    ButtonStatus status;
    String btnID;

    public ButtonHelper(String btnID){
        status = ButtonStatus.PAUSED;
        this.btnID = btnID;
    }

    public ButtonStatus getStatus(){
        return status;
    }

    public void setStatus(ButtonStatus status){
        this.status = status;
    }

    public String getBtnID(){
        return btnID;
    }

    public void setBtnID(String btnID){
        this.btnID = btnID;
    }

    public void METAMOPRHOSIS(){
        System.out.println("\nPut my glasses on, I cant see these -------\nPut my glasses on, I cant see these -------\nIm in the twilight zone, nowhere near these -------" 
         + "\nIm in the twilight zone, nowhere near these -------\nThey cant understand me, Im talkin hieroglyphics\nThey cant understand me, Im talkin hieroglyphics\nI feel like Morpheus, I feel like Morpheus \nI got my whole gang on some other shit\nMetamorphosis"
         + "\nMetamorphosis, metamorphosis\nMetamorphosis, metamorphosis\nMetamorphosis, metamorphosis \nI had to change my whole swag, Im on some other ---- \nI got me a new -----, she on other ---- \nAnd if that ----- go out bad, she on punishment"
         + "\nWhy the ---- I gotta remind you that I run this ----?\nWhy the ---- I gotta remind you that I run this ----? \nWhy the ---- I gotta remind you that I run this ----? \nI thought Id been told you that I run this ----"
        );
    }

    public String toString(){
        return "CURRENT STATUS: " + status;
    }
}


