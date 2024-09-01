package com.miner.states.minerStates;

import com.miner.chars.Miner;
import com.miner.states.State;

public class GoBankState implements State<Miner> {

    private static GoBankState instance=null;
    
    @Override
    public void Enter(Miner npc) {

    }

    @Override
    public void Execute(Miner npc) {

    }

    @Override
    public void Exit(Miner npc) {

    }

    public static GoBankState getInstance(){
        if(instance==null){
            instance=new GoBankState();
        }
        return instance;
    }
}