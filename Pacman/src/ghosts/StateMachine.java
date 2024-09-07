package ghosts;

public class StateMachine<GhostPlayer> {
    private GhostPlayer myOwner;
    private States<GhostPlayer> currentState;

    public StateMachine(GhostPlayer owner){
        myOwner=owner;
        currentState=null;
    }
    
    public void update(){
        if(currentState!=null){
            currentState.Move(myOwner);
        }
    }

    public void changeState(States<GhostPlayer> newState){
        currentState.Exit(myOwner);
        currentState=newState;
        currentState.Enter(myOwner);
    }
    

    public States<GhostPlayer> getCurrentState() {
        return currentState;
    }

    public void setCurrentState(States<GhostPlayer> currentState) {
        this.currentState = currentState;
    }

    public boolean treatMessage(Messages message){
        if(currentState.onGetMessage(myOwner, message)){
            return true;
        }
        return false;
    }

    

}
