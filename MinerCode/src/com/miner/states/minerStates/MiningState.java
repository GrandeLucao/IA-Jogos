package com.miner.states.minerStates;

import com.miner.chars.*;
import com.miner.states.*;

public class MiningState implements State<Miner> {
    private static MiningState instance=null;
    
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


    public static MiningState getInstance(){
        if(instance==null){
            instance=new MiningState();
        }
        return instance;
    }
}