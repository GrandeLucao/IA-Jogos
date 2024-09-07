package ghosts;

import pacman.GhostPlayer;

public class Messages {
    private GhostPlayer sender;
    private GhostPlayer recipient;
    private String stringMessage;
    private Object extraInfo;

    public Messages(GhostPlayer sender, GhostPlayer recipient,String stringMessage, Object extraInfo){
        this.sender=sender;
        this.recipient=recipient;
        this.stringMessage=stringMessage;
        this.extraInfo=extraInfo;
    }
    

    public String getStringMessage() {
        return stringMessage;
    }    

}
