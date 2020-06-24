package com.lifeleft;

public class Message {

    public boolean statutOp;
    public String info;
    public String operationName;
    public String tokenApp;
    public String tokenUser;
    public String appVersion;
    public String operationVersion;

    public Message(boolean statutOp, String info, String operationName, String tokenApp, String tokenUser, String appVersion, String operationVersion){
        this.statutOp = statutOp;
        this.info = info;
        this.operationName = operationName;
        this.tokenApp = tokenApp;
        this.tokenUser = tokenUser;
        this.appVersion = appVersion;
        this.operationName = operationName;
    }
}
