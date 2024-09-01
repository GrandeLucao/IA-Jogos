package com.miner.states;

public class StateMachine<NPC> {
    private NPC myOwner;
    private State<NPC> currentState;
    private State<NPC> previousState;
    private State<NPC> globalState;


    public StateMachine(NPC owner){
        myOwner=owner;
        currentState=null;
        previousState=null;
        globalState=null;
    }


    public void update(){
        if(globalState!=null){
            globalState.Execute(myOwner);
        }

        if(currentState!=null){
            currentState.Execute(myOwner);
        }
    }

    public void changeState(State<NPC> newState){
        previousState=currentState;
        currentState.Exit(myOwner);
        currentState=newState;
        currentState.Enter(myOwner);
    }

    public void goBackState(){
        changeState(previousState);
    }




    public State<NPC> getCurrentState() {
        return currentState;
    }
    public void setCurrentState(State<NPC> currentState) {
        this.currentState = currentState;
    }

    public State<NPC> getPreviousState() {
        return previousState;
    }
    public void setPreviousState(State<NPC> previousState) {
        this.previousState = previousState;
    }

    public State<NPC> getGlobalState() {
        return globalState;
    }
    public void setGlobalState(State<NPC> globalState) {
        this.globalState = globalState;
    }
    

}
