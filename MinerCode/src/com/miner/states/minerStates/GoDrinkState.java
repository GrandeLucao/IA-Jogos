package com.miner.states.minerStates;


import com.miner.chars.*;
import com.miner.states.*;

public class GoDrinkState implements State<Miner> {

    private static GoDrinkState instance=null;
    
    @Override
    public void Enter(Miner npc) {

    }

    @Override
    public void Execute(Miner npc) {

    }

    @Override
    public void Exit(Miner npc) {

    }

    @Override
    public boolean onGetMessage(Miner npc, Messages message) {
        throw new UnsupportedOperationException("Error");
    }

    public static GoDrinkState getInstance(){
        if(instance==null){
            instance=new GoDrinkState();
        }
        return instance;
    }
}