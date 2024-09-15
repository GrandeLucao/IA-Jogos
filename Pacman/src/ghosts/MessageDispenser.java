package ghosts;

import pacman.GhostPlayer;

public class MessageDispenser {    
    private static MessageDispenser instance=null;

    public void DispatchMessage(GhostPlayer sender, GhostPlayer recipient,String stringMessage, Object extraInfo){
        Messages message=new Messages(sender, recipient, stringMessage, extraInfo);
        deliverMessage(recipient, message);
    }

    public void deliverMessage(GhostPlayer recipient, Messages message){
        if(!recipient.treatMessage(message));{
            //System.out.println("Error");
        }
    }


    public static MessageDispenser getInstance(){
        if(instance==null){
            instance=new MessageDispenser();
        }
        return instance;
    }

}
