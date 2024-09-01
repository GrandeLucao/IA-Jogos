package com.miner.states.minerStates;

import com.miner.chars.Miner;
import com.miner.states.State;

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

    public static GoDrinkState getInstance(){
        if(instance==null){
            instance=new GoDrinkState();
        }
        return instance;
    }
}