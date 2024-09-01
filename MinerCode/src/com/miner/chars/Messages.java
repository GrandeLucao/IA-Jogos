package com.miner.chars;

public class Messages {
    private Entity sender;
    private Entity recipient;
    private String stringMessage;
    private Object extraInfo;

    public Messages(Entity sender, Entity recipient,String stringMessage, Object extraInfo){
        this.sender=sender;
        this.recipient=recipient;
        this.stringMessage=stringMessage;
        this.extraInfo=extraInfo;
    }
    

    public String getStringMessage() {
        return stringMessage;
    }    

}
