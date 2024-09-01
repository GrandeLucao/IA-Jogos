package com.miner.chars;

public class MessageDispenser {    
    private static MessageDispenser instance=null;

    public void DispatchMessage(Entity sender, Entity recipient,String stringMessage, Object extraInfo){
        Messages message=new Messages(sender, recipient, stringMessage, extraInfo);
        deliverMessage(recipient, message);
    }

    public void deliverMessage(Entity recipient, Messages message){
        if(!recipient.treatMessage(message));{
            System.out.println("Error");
        }
    }


    public static MessageDispenser getInstance(){
        if(instance==null){
            instance=new MessageDispenser();
        }
        return instance;
    }

}
