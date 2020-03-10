package com.example.kotlininaction;

public class House {

    private final String color;
    private boolean isEmpty;

    public House(String color, boolean isEmpty){
        this.color = color;
        this.isEmpty = isEmpty;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty){
        this.isEmpty = isEmpty;
    }

}
