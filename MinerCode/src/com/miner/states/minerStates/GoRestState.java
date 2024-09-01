package com.miner.states.minerStates;

import com.miner.chars.Miner;
import com.miner.states.State;

public class GoRestState implements State<Miner> {

    private static GoRestState instance=null;
    
    @Override
    public void Enter(Miner npc) {

    }

    @Override
    public void Execute(Miner npc) {

    }

    @Override
    public void Exit(Miner npc) {

    }

    public static GoRestState getInstance(){
        if(instance==null){
            instance=new GoRestState();
        }
        return instance;
    }
}
