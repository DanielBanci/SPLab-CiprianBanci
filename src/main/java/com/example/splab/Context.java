package com.example.splab;

public class Context {
    private int displayWidth;

    public Context(){
        this.displayWidth = 80;
    }

    public Context(int displayWidth){
        this.displayWidth = displayWidth;
    }

    public int getDisplayWidth(){
        return displayWidth;
    }
}
