package com.lifeleft;

public abstract class Motor {

    protected Message message;

    public Motor(Message message){
        this.message = message;
    }

    public abstract String run();
}
