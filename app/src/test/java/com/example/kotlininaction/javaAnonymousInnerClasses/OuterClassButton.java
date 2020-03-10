package com.example.kotlininaction.javaAnonymousInnerClasses;

import java.util.ArrayList;
import java.util.List;

public class OuterClassButton {

    List<ButtonClickListener> listeners = new ArrayList<>();

    public void click(){
        for(ButtonClickListener listener : listeners){
            listener.buttonClicked(new ClickEvent());
        }
    }

    public void addOnButtonClickListener(ButtonClickListener listener){
        listeners.add(listener);
    }

    interface ButtonClickListener{
        void buttonClicked(ClickEvent e);
    }
}