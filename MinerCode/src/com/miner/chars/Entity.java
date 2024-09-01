package com.miner.chars;

import com.miner.states.StateMachine;

public abstract class Entity {

    private String name;

    protected StateMachine<?> stateMach;

    public Entity(String name){
        this.name=name;
        EntityManager.getInstance().newEntityRegister(this);
    }

    public String getName(){
        return name;
    }

    public abstract void update();

    public abstract StateMachine<?> getStateMachine();

    public boolean treatMessage(Messages message){
        return getStateMachine().treatMessage(message);
    }

}
